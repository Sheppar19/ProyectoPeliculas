package DAO;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import DTO.Pelicula;

public class DAO {
    public DatabaseReference databaseReference;

    public DAO() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    public void setPelicula(Pelicula pelicula){
        this.databaseReference.child("Peliculas").child(pelicula.getId()).setValue(pelicula);
    }



}
