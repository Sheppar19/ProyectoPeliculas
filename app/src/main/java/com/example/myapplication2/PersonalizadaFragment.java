package com.example.myapplication2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import DAO.Adaptador;
import DAO.DAO;
import DTO.Pelicula;
import DTO.Usuario;

public class PersonalizadaFragment extends Fragment {
    private RecyclerView recyclerView;
    private DAO dao;
    private ArrayList<Pelicula> peliculaArrayList;
    private Adaptador adaptador;
    private Usuario usuario;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            usuario = (Usuario) getArguments().getSerializable("usuario");
        }
        dao = new DAO();
        peliculaArrayList = new ArrayList<>();
        adaptador = new Adaptador();
        dao.getPeliculasPersonalizadas(dao,peliculaArrayList,adaptador,usuario);
        adaptador.setListaPeliculas(peliculaArrayList);
        adaptador.setUsuario(usuario,dao,getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personalizada, container, false);
        recyclerView = view.findViewById(R.id.listaPeliculasPersonalizadas);
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

}
