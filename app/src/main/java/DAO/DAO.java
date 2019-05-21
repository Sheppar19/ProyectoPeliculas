package DAO;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.TimeZone;

import DTO.Pelicula;
import DTO.CalificacionGeneral;
import DTO.Usuario;

public class DAO {
    public DatabaseReference databaseReference;

    public DAO() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    public void setPelicula(Pelicula pelicula) {
        String key = databaseReference.child("Peliculas").child("posts").push().getKey();
        pelicula.setId(key);
        this.databaseReference.child("Peliculas").child(pelicula.getId()).setValue(pelicula);
    }

    public void setUsuario(Usuario usuario) {

        String key = databaseReference.child("Usuarios").child("posts").push().getKey();
        usuario.setId(key);
        this.databaseReference.child("Usuarios").child(usuario.getId()).setValue(usuario);
    }

    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }

    public void getUsuarios(final DAO dao, final ArrayList<Usuario> usuarios){
        dao.databaseReference.child("Usuarios").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                usuarios.clear();
                for (final DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    dao.databaseReference.child("Usuarios").child(dataSnapshot1.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Usuario usuario = dataSnapshot1.getValue(Usuario.class);
                            usuarios.add(usuario);

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
    }

    public boolean comprobarExistenciaUsuario(ArrayList<Usuario> usuarios,String email){
        boolean encontrado = false;
        for(int i = 0; i<usuarios.size();i++){
            if (usuarios.get(i).getEmail().equals(email)) {
                encontrado = true;
            }
        }
        return encontrado;
    }
    public boolean comprobarDatosUsuario(ArrayList<Usuario> usuarios,String email,String contraseña){
        boolean encontrado = false;
        for(int i = 0; i<usuarios.size();i++){
            if (usuarios.get(i).getEmail().equals(email) && usuarios.get(i).getContraseña().equals(contraseña)) {
                encontrado = true;
            }
        }
        return encontrado;
    }
    public Usuario getUsuario(ArrayList<Usuario> usuarios,String email,String contraseña){
        Usuario encontrado = null;
        for(int i = 0; i<usuarios.size();i++){
            if (usuarios.get(i).getEmail().equals(email) && usuarios.get(i).getContraseña().equals(contraseña)) {
                encontrado = usuarios.get(i);
            }
        }
        return encontrado;
    }
    public ArrayList<Pelicula> getPeliculas(final DAO dao, final ArrayList<Pelicula> peliculaArrayList, final Adaptador adaptador, final FragmentActivity context){
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
                                Calendar  calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Bogota"));
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                Date fechaPelicula = simpleDateFormat.parse(pelicula.getFecha());
                                Date fechaActual = simpleDateFormat.parse(calendar.get(Calendar.DAY_OF_MONTH)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+
                                        calendar.get(Calendar.YEAR));
                                if(fechaActual.compareTo(fechaPelicula) >= 0) {
                                    peliculaArrayList.add(pelicula);
                                }

                            } catch (Exception e){
                                Log.e("error","Error");
                                Toast.makeText(context.getApplicationContext(),"Fecha invalida",Toast.LENGTH_SHORT).show();
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
    public void updateUsuario(Usuario usuario,DAO dao) {
        dao.getDatabaseReference().child("Usuarios").child(usuario.getId()).setValue(usuario);


    }
    public ArrayList<Pelicula> getPeliculasPersonalizadas(final DAO dao, final ArrayList<Pelicula> peliculaArrayList, final Adaptador adaptador,
                                                          final Usuario usuario){
        dao.databaseReference.child("Peliculas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                peliculaArrayList.clear();
                for (final DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    dao.databaseReference.child("Peliculas").child(dataSnapshot1.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Pelicula pelicula = dataSnapshot1.getValue(Pelicula.class);

                                    if(usuario.getIdPeliculas().contains(pelicula.getId())) {
                                        peliculaArrayList.add(pelicula);
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

    public void setPuntaje(CalificacionGeneral puntaje) {
        String key = databaseReference.child("Puntaje").child("posts").push().getKey();
        puntaje.setId(key);
        this.databaseReference.child("Puntaje").child(puntaje.getId()).setValue(puntaje);
    }
    public void updatePuntaje(CalificacionGeneral calificacionGeneral, DAO dao) {
        dao.getDatabaseReference().child("Puntaje").child(calificacionGeneral.getId()).setValue(calificacionGeneral);
    }



}



