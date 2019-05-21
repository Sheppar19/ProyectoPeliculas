package com.example.myapplication2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import DAO.DAO;
import DTO.Calificacion;
import DTO.Pelicula;
import DTO.Usuario;


public class DetallePeliculaFragment extends Fragment {

    public Pelicula pelicula;
    public TextView txtTitulo,txtSinopsis,txtAutor;
    public CheckBox estrella1,estrella2,estrella3,estrella4,estrella5,aestrella1,aestrella2,aestrella3,aestrella4,aestrella5,
            sestrella1,sestrella2,sestrella3,sestrella4,sestrella5,pestrella1,pestrella2,pestrella3,pestrella4,pestrella5;
    public DAO dao;
    public Calificacion calificacion;
    public Usuario usuario;
    static   ArrayList<Calificacion> calificacionArrayList = new ArrayList<>();
    public ArrayList<Usuario> usuarios;
    public DetallePeliculaFragment() {
        // Required empty public constructor}

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao = new DAO();
        if(getArguments()!=null){
            pelicula = (Pelicula) getArguments().getSerializable("Pelicula");
            usuario = (Usuario) getArguments().getSerializable("usuario");
        }


        calificacion = new Calificacion();
        calificacion.setIdPelicula(pelicula.getId());
        calificacion.setIdUsuario(usuario.getId());
        String hola;
       dao.setPuntaje(calificacion);
        dao.databaseReference.child("Calificacion").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (final DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    dao.databaseReference.child("Calificacion").child(dataSnapshot1.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Calificacion calificacion = dataSnapshot1.getValue(Calificacion.class);
                            calificacionArrayList.add(calificacion);
                            Log.e("calificacion",""+calificacionArrayList.size());

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

        Log.e("calificacion2",""+calificacionArrayList.size());
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_detalle_pelicula, container, false);
        txtTitulo = view.findViewById(R.id.DetalleTituloTxtView);
        txtAutor = view.findViewById(R.id.DetalleAutorTxtView);
        txtSinopsis = view.findViewById(R.id.DetalleSinopsisTxtView);
        estrella1 = view.findViewById(R.id.Destrella1);
        estrella2 = view.findViewById(R.id.Destrella2);
        estrella3 = view.findViewById(R.id.Destrella3);
        estrella4 = view.findViewById(R.id.Destrella4);
        estrella5 = view.findViewById(R.id.Destrella5);

        aestrella1 = view.findViewById(R.id.DCAestrella1);
        aestrella2 = view.findViewById(R.id.DCAestrella2);
        aestrella3 = view.findViewById(R.id.DCAestrella3);
        aestrella4 = view.findViewById(R.id.DCAestrella4);
        aestrella5 = view.findViewById(R.id.DCAestrella5);

        sestrella1 = view.findViewById(R.id.DCSestrella1);
        sestrella2 = view.findViewById(R.id.DCSestrella2);
        sestrella3 = view.findViewById(R.id.DCSestrella3);
        sestrella4 = view.findViewById(R.id.DCSestrella4);
        sestrella5 = view.findViewById(R.id.DCSAestrella5);

        pestrella1 = view.findViewById(R.id.DCPestrella1);
        pestrella2 = view.findViewById(R.id.DCPestrella2);
        pestrella3 = view.findViewById(R.id.DCPestrella3);
        pestrella4 = view.findViewById(R.id.DCPestrella4);
        pestrella5 = view.findViewById(R.id.DCPestrella5);
        aestrella1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descalificarAutor();
                calificacionAutor(1);

            }
        });
        aestrella2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descalificarAutor();
                calificacionAutor(2);
            }
        });
        aestrella3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descalificarAutor();
                calificacionAutor(3);
            }
        });
        aestrella4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descalificarAutor();
                calificacionAutor(4);
            }
        });
        aestrella5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descalificarAutor();
                calificacionAutor(5);
            }
        });

        sestrella1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descalificarSinopsis();
                calificacionSinopsis(1);
            }
        });
        sestrella2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descalificarSinopsis();
                calificacionSinopsis(2);
            }
        });
        sestrella3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descalificarSinopsis();
                calificacionSinopsis(3);
            }
        });
        sestrella4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descalificarSinopsis();
                calificacionSinopsis(4);
            }
        });
        sestrella5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descalificarSinopsis();
                calificacionSinopsis(5);
            }
        });


        pestrella1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descalificarPelicula();
                calificacionPelicula(1);
            }
        });
        pestrella2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descalificarPelicula();
                calificacionPelicula(2);
            }
        });
        pestrella3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descalificarPelicula();
                calificacionPelicula(3);
            }
        });
        pestrella4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descalificarPelicula();
                calificacionPelicula(4);
            }
        });
        pestrella5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descalificarPelicula();
                calificacionPelicula(5);
            }
        });

        estrella1.setEnabled(false);
        estrella2.setEnabled(false);
        estrella3.setEnabled(false);
        estrella4.setEnabled(false);
        estrella5.setEnabled(false);
        txtTitulo.setText(pelicula.getNombre());
        txtAutor.setText(pelicula.getAutor());
        txtSinopsis.setText(pelicula.getSinopsis());
        calificacionActual();
        return view;
    }

    public void calificacionActual(){
        switch(pelicula.getPuntuacion().getPuntacionAutor()){
            case 1:
                estrella1.setChecked(true);
                break;
            case 2:
                estrella1.setChecked(true);
                estrella2.setChecked(true);
                break;
            case 3:
                estrella1.setChecked(true);
                estrella2.setChecked(true);
                estrella3.setChecked(true);
                break;
            case 4:
                estrella1.setChecked(true);
                estrella2.setChecked(true);
                estrella3.setChecked(true);
                estrella4.setChecked(true);
                break;
            case 5:
                estrella1.setChecked(true);
                estrella2.setChecked(true);
                estrella3.setChecked(true);
                estrella4.setChecked(true);
                estrella5.setChecked(true);
                break;
            default:
                estrella1.setChecked(false);
                estrella2.setChecked(false);
                estrella3.setChecked(false);
                estrella4.setChecked(false);
                estrella5.setChecked(false);
        }
    }
    public void calificacionAutor(int puntos){
        if(puntos >= 1 && puntos <=5){
            calificacion.setPuntacionAutor(puntos);
            dao.updatePuntaje(calificacion,dao);
        }
        switch(puntos){
            case 1:
                aestrella1.setChecked(true);
                break;
            case 2:
                aestrella1.setChecked(true);
                aestrella2.setChecked(true);
                break;
            case 3:
                aestrella1.setChecked(true);
                aestrella2.setChecked(true);
                aestrella3.setChecked(true);
                break;
            case 4:
                aestrella1.setChecked(true);
                aestrella2.setChecked(true);
                aestrella3.setChecked(true);
                aestrella4.setChecked(true);
                break;
            case 5:
                aestrella1.setChecked(true);
                aestrella2.setChecked(true);
                aestrella3.setChecked(true);
                aestrella4.setChecked(true);
                aestrella5.setChecked(true);
                break;
            default:
                aestrella1.setChecked(false);
                aestrella2.setChecked(false);
                aestrella3.setChecked(false);
                aestrella4.setChecked(false);
                aestrella5.setChecked(false);
        }
    }
    public void calificacionSinopsis(int puntos){
        if(puntos >= 1 && puntos <=5){
            calificacion.setPuntuacionSinopsis(puntos);
            dao.updatePuntaje(calificacion,dao);
        }
        switch(puntos){
            case 1:
                sestrella1.setChecked(true);
                break;
            case 2:
                sestrella1.setChecked(true);
                sestrella2.setChecked(true);
                break;
            case 3:
                sestrella1.setChecked(true);
                sestrella2.setChecked(true);
                sestrella3.setChecked(true);
                break;
            case 4:
                sestrella1.setChecked(true);
                sestrella2.setChecked(true);
                sestrella3.setChecked(true);
                sestrella4.setChecked(true);
                break;
            case 5:
                sestrella1.setChecked(true);
                sestrella2.setChecked(true);
                sestrella3.setChecked(true);
                sestrella4.setChecked(true);
                sestrella5.setChecked(true);
                break;
            default:
                sestrella1.setChecked(false);
                sestrella2.setChecked(false);
                sestrella3.setChecked(false);
                sestrella4.setChecked(false);
                sestrella5.setChecked(false);
        }
    }
    public void calificacionPelicula(int puntos){
        if(puntos >= 1 && puntos <=5){
            calificacion.setPuntacionPelicula(puntos);
            dao.updatePuntaje(calificacion,dao);
        }
        switch(puntos){
            case 1:
                pestrella1.setChecked(true);
                break;
            case 2:
                pestrella1.setChecked(true);
                pestrella2.setChecked(true);
                break;
            case 3:
                pestrella1.setChecked(true);
                pestrella2.setChecked(true);
                pestrella3.setChecked(true);
                break;
            case 4:
                pestrella1.setChecked(true);
                pestrella2.setChecked(true);
                pestrella3.setChecked(true);
                pestrella4.setChecked(true);
                break;
            case 5:
                pestrella1.setChecked(true);
                pestrella2.setChecked(true);
                pestrella3.setChecked(true);
                pestrella4.setChecked(true);
                pestrella5.setChecked(true);
                break;
            default:
                pestrella1.setChecked(false);
                pestrella2.setChecked(false);
                pestrella3.setChecked(false);
                pestrella4.setChecked(false);
                pestrella5.setChecked(false);
        }
    }
    public void descalificarAutor(){
                aestrella1.setChecked(false);
                aestrella2.setChecked(false);
                aestrella3.setChecked(false);
                aestrella4.setChecked(false);
                aestrella5.setChecked(false);
        }
    public void descalificarSinopsis(){
        sestrella1.setChecked(false);
        sestrella2.setChecked(false);
        sestrella3.setChecked(false);
        sestrella4.setChecked(false);
        sestrella5.setChecked(false);
    }
    public void descalificarPelicula(){
        pestrella1.setChecked(false);
        pestrella2.setChecked(false);
        pestrella3.setChecked(false);
        pestrella4.setChecked(false);
        pestrella5.setChecked(false);
    }



}
