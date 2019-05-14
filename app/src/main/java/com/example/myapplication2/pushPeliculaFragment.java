package com.example.myapplication2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import DAO.DAO;
import DTO.Pelicula;


public class pushPeliculaFragment extends Fragment {
    public DAO dao;
    public Pelicula pelicula;
    public Button btnAceptar;
    public EditText nombre,autor,puntuacion,sinopsis,id;
    public pushPeliculaFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao = new DAO();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_push_pelicula, container, false);
         nombre = view.findViewById(R.id.editNombre);
         autor = view.findViewById(R.id.editAutor);
         sinopsis = view.findViewById(R.id.editSinopsis);
         puntuacion = view.findViewById(R.id.editPuntuacion);
         id = view.findViewById(R.id.editId);
         btnAceptar = view.findViewById(R.id.btnAceptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pelicula = new Pelicula(nombre.getText().toString(),autor.getText().toString(),
                        sinopsis.getText().toString(),Integer.parseInt(puntuacion.getText().toString()),
                        id.getText().toString());
                dao.setPelicula(pelicula);
            }
        });
        return view;

    }

}
