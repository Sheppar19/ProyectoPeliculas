package com.example.myapplication2;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import DAO.DAO;
import DTO.Calificacion;
import DTO.Pelicula;


public class pushPeliculaFragment extends Fragment {
    public DAO dao;
    public Pelicula pelicula;
    public Button btnAceptar;
    public EditText nombre,autor,puntuacion,sinopsis;
    public TextView fecha;
    public int mes,dia,año;
    public Calendar calendar;
    public DatePickerDialog.OnDateSetListener dateSetListener;
    public Calificacion calificacion;
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
         btnAceptar = view.findViewById(R.id.btnAceptar);
         fecha = view.findViewById(R.id.editFecha);
         fecha.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 calendar = Calendar.getInstance();
                 mes = calendar.get(Calendar.MONTH);
                 dia = calendar.get(Calendar.DAY_OF_MONTH);
                 año = calendar.get(Calendar.YEAR);

                 DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),android.R.style.Theme_Holo_Light_Dialog,
                         dateSetListener,año,mes,dia);
                 datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                 datePickerDialog.show();
             }
         });
         dateSetListener = new DatePickerDialog.OnDateSetListener() {
             @Override
             public void onDateSet(DatePicker datePicker, int año, int mes , int dia) {
                 mes = mes +1;
                 fecha.setText(dia+"/"+mes+"/"+año);

             }
         };

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    calificacion = new Calificacion(Integer.parseInt(puntuacion.getText().toString()),Integer.parseInt(puntuacion.getText().toString()),
                            Integer.parseInt(puntuacion.getText().toString()));
                    pelicula = new Pelicula(nombre.getText().toString(),autor.getText().toString(),
                            sinopsis.getText().toString(),
                            fecha.getText().toString(), calificacion);
                    dao.setPelicula(pelicula);
                }catch (Exception e){
                    Toast.makeText(getContext(),"Fecha invalida",Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;

    }

}
