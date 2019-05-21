package com.example.myapplication2;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import DTO.Pelicula;
import DTO.Usuario;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private Usuario usuario;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new pushPeliculaFragment()).commit();
                    return true;
                case R.id.navigation_dashboard:
                    Bundle envio = new Bundle();
                    envio.putSerializable("usuario",usuario);
                    listaPeliculasFragment listaPeliculasFragment = new listaPeliculasFragment();
                    listaPeliculasFragment.setArguments(envio);
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,listaPeliculasFragment).commit();
                    return true;
                case R.id.navigation_notifications:

                    Bundle envio2 = new Bundle();
                    envio2.putSerializable("usuario",usuario);
                    PersonalizadaFragment personalizadaFragment = new PersonalizadaFragment();
                    personalizadaFragment.setArguments(envio2);
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,personalizadaFragment).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Bundle usuarioEnviado = getIntent().getExtras();
        if(usuarioEnviado != null){
            this.usuario = (Usuario) usuarioEnviado.getSerializable("usuario");
        }

    }

}
