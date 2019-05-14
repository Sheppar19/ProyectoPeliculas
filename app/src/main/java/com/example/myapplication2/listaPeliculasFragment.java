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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.io.Console;
import java.util.ArrayList;

import DAO.Adaptador;
import DAO.DAO;
import DTO.Pelicula;


public class listaPeliculasFragment extends Fragment {
    private RecyclerView recyclerView;
    private DAO dao;
    private ArrayList<Pelicula> peliculaArrayList;
    private Adaptador adaptador;
    public listaPeliculasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao = new DAO();
        peliculaArrayList = new ArrayList<>();
        adaptador = new Adaptador( getPeliculas(dao,peliculaArrayList));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_lista_peliculas, container, false);
      recyclerView = view.findViewById(R.id.listaPelicula);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptador);


      return view;
    }
    public ArrayList<Pelicula> getPeliculas(final DAO dao,final ArrayList<Pelicula> peliculaArrayList){

        dao.databaseReference.child("Peliculas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                peliculaArrayList.clear();
                for (final DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    dao.databaseReference.child("Peliculas").child(dataSnapshot1.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Pelicula pelicula = dataSnapshot1.getValue(Pelicula.class);
                            peliculaArrayList.add(pelicula);
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

}
