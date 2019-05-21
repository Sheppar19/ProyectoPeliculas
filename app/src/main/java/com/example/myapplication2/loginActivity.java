package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;

import DAO.DAO;
import DTO.Usuario;

public class loginActivity extends AppCompatActivity {

    public EditText email,contraseña;
    public DAO dao;
    public Button btnaceptar,btncrear;
    public ArrayList<Usuario> usuarios;
    private Pattern CONTRASENA_PATTERN = Pattern.compile("([a-z]|[A-Z]|[0-9]){4,}");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dao = new DAO();
        usuarios = new ArrayList<>();
        dao.getUsuarios(dao,usuarios);
        email = findViewById(R.id.LoginUsuarioeditText);
        contraseña = findViewById(R.id.LoginContraseñaeditText);
        btncrear = findViewById(R.id.LoginCrearButton);
        btnaceptar = findViewById(R.id.LoginAceptarButton);
        btnaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarEmailLogin() && validarContraseña() && dao.comprobarDatosUsuario(usuarios,email.getText().toString(),
                        contraseña.getText().toString())){
                    Intent enviar = new Intent(getApplicationContext(),MainActivity.class);
                    Bundle bundle = new Bundle();
                   Usuario usuario = dao.getUsuario(usuarios,email.getText().toString(),
                           contraseña.getText().toString());

                    bundle.putSerializable("usuario",usuario);
                    enviar.putExtras(bundle);
                    startActivity(enviar);
                }else{
                    contraseña.setText("");
                    email.setText("");
                    Toast.makeText(getApplicationContext(),"Usuario/Contraseña Invalidos",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btncrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarEmail() && validarContraseña()){
                Usuario usuario = new Usuario(email.getText().toString(),contraseña.getText().toString());
                dao.setUsuario(usuario);
                Toast.makeText(getApplicationContext(),"Usuario: "+email+" Se creo correctamente",Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    private boolean validarEmail(){
        String email = this.email.getText().toString().trim();
        if(email.isEmpty()){
            this.email.setError("Email no puede estar vacio");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            this.email.setError("Profavor ingresa un email valido");
            return false;
        }else if(dao.comprobarExistenciaUsuario(usuarios,email) && usuarios.size() > 0){
            this.email.setError("email en uso");
            return false;
        }else{
            this.email.setError(null);
            return true;
        }
    }
    private boolean validarEmailLogin(){
        String email = this.email.getText().toString().trim();
        if(email.isEmpty()){
            this.email.setError("Email no puede estar vacio");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            this.email.setError("Profavor ingresa un email valido");
            return false;
        }else{
            this.email.setError(null);
            return true;
        }
    }
    private boolean validarContraseña(){
        String contraseña = this.contraseña.getText().toString().trim();
        if(contraseña.isEmpty()){
            this.contraseña.setError("la contraseña no puede estar vacia");
            return false;
        }else if(!CONTRASENA_PATTERN.matcher(contraseña).matches()){
            this.contraseña.setError("contraseña invalida");
            return false;
      }else{
            this.contraseña.setError(null);
            return true;
        }
    }

}

