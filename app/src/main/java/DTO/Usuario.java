package DTO;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
    private String email;
    private String contraseña;
    private String id;
    private ArrayList<String> idPeliculas;

    public Usuario(String email, String contraseña) {
        this.email = email;
        this.contraseña = contraseña;
        this.idPeliculas = new ArrayList<>();
        this.idPeliculas.add("nada");
    }

    public Usuario(String email, String contraseña, String id) {
        this.email = email;
        this.contraseña = contraseña;
        this.id = id;
    }

    public Usuario() {
    }
    public void agregarIdPelicula(String id){
        this.idPeliculas.add(id);

    }
    public ArrayList<String> getIdPeliculas() {
        return idPeliculas;
    }

    public void setIdPeliculas(ArrayList<String> idPeliculas) {
        this.idPeliculas = idPeliculas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
