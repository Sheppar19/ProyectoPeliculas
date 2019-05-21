package DTO;

import java.io.Serializable;

public class Calificacion implements Serializable {
    private int puntacionAutor;
    private int puntuacionSinopsis;
    private int puntacionPelicula;
    private String id;
    private String idUsuario;
    private String idPelicula;

    public Calificacion(int puntacionAutor, int puntuacionSinopsis, int puntacionPelicula, String id, String idUsuario, String idPelicula) {
        this.puntacionAutor = puntacionAutor;
        this.puntuacionSinopsis = puntuacionSinopsis;
        this.puntacionPelicula = puntacionPelicula;
        this.id = id;
        this.idUsuario = idUsuario;
        this.idPelicula = idPelicula;
    }

    public Calificacion(int puntacionAutor, int puntuacionSinopsis, int puntacionPelicula) {
        this.puntacionAutor = puntacionAutor;
        this.puntuacionSinopsis = puntuacionSinopsis;
        this.puntacionPelicula = puntacionPelicula;
    }

    public Calificacion() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(String idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getPuntacionAutor() {
        return puntacionAutor;
    }

    public void setPuntacionAutor(int puntacionAutor) {
        this.puntacionAutor = puntacionAutor;
    }

    public int getPuntuacionSinopsis() {
        return puntuacionSinopsis;
    }

    public void setPuntuacionSinopsis(int puntuacionSinopsis) {
        this.puntuacionSinopsis = puntuacionSinopsis;
    }

    public int getPuntacionPelicula() {
        return puntacionPelicula;
    }

    public void setPuntacionPelicula(int puntacionPelicula) {
        this.puntacionPelicula = puntacionPelicula;
    }
}
