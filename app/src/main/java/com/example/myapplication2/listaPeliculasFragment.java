package com.example.myapplication2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import DAO.Adaptador;
import DAO.DAO;
import DTO.Pelicula;
import DTO.Usuario;


public class listaPeliculasFragment extends Fragment {
    private RecyclerView recyclerView;
    private DAO dao;
    private ArrayList<Pelicula> peliculaArrayList;
    private Adaptador adaptador;
    private Usuario usuario;
    public listaPeliculasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            usuario = (Usuario) getArguments().getSerializable("usuario");
        }
        dao = new DAO();
        peliculaArrayList = new ArrayList<>();
        adaptador = new Adaptador();
        dao.getPeliculas(dao,peliculaArrayList,adaptador,this.getActivity());
        adaptador.setListaPeliculas(peliculaArrayList);
        adaptador.setUsuario(usuario,dao,getActivity());

        DAO dao2 = new DAO();
        Adaptador adaptador2 = new Adaptador();
        ArrayList<Pelicula> peliculasPersonalizada = new ArrayList<>();
        dao.getPeliculasPersonalizadas(dao2,peliculasPersonalizada,adaptador2,usuario);
        adaptador2.setListaPeliculas(peliculasPersonalizada);
        adaptador2.setUsuario(usuario,dao2,getActivity());
        Log.e("asfaf",""+peliculasPersonalizada.size());
        //adaptador = new Adaptador( getPeliculas(dao,peliculaArrayList));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_lista_peliculas, container, false);
      recyclerView = view.findViewById(R.id.listaPelicula);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle envio = new Bundle();
                envio.putSerializable("Pelicula",peliculaArrayList.get(recyclerView.getChildAdapterPosition(view)));
                 DetallePeliculaFragment detallePeliculaFragment = new DetallePeliculaFragment();
                detallePeliculaFragment.setArguments(envio);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,detallePeliculaFragment).commit();
                 }
        });
        recyclerView.setAdapter(adaptador);


      return view;
    }
   /* public ArrayList<Pelicula> getPeliculas(final DAO dao,final ArrayList<Pelicula> peliculaArrayList){

        dao.databaseReference.child("Peliculas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                peliculaArrayList.clear();
                for (final DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    dao.databaseReference.child("Peliculas").child(dataSnapshot1.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Pelicula pelicula = dataSnapshot1.getValue(Pelicula.class);

                            try {
                                Calendar  calendar = GregorianCalendar.getInstance();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                Date fechaPelicula = simpleDateFormat.parse(pelicula.getFecha());
                                Date fechaActual = calendar.getTime();
                            if(fechaPelicula.before(fechaActual)) {
                                peliculaArrayList.add(pelicula);
                            }

                            } catch (Exception e){
                                Log.e("error","Error");
                            }
                            adaptador.notifyDataSetChanged();

                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }

        });
        return peliculaArrayList;
    }
    **/

}
