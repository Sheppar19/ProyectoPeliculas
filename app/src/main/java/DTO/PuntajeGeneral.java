package DTO;

import java.io.Serializable;

public class PuntajeGeneral implements Serializable {
    private Integer puntacionAutor;
    private Integer puntuacionSinopsis;
    private Integer puntacionPelicula;
    private String id;
    private String idUsuario;
    private String idPelicula;

    public PuntajeGeneral(int puntacionAutor, int puntuacionSinopsis, int puntacionPelicula) {
        this.puntacionAutor = puntacionAutor;
        this.puntuacionSinopsis = puntuacionSinopsis;
        this.puntacionPelicula = puntacionPelicula;
    }

    public PuntajeGeneral() {
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

    public Integer getPuntacionAutor() {
        return puntacionAutor;
    }

    public void setPuntacionAutor(Integer puntacionAutor) {
        this.puntacionAutor = puntacionAutor;
    }

    public Integer getPuntuacionSinopsis() {
        return puntuacionSinopsis;
    }

    public void setPuntuacionSinopsis(Integer puntuacionSinopsis) {
        this.puntuacionSinopsis = puntuacionSinopsis;
    }

    public Integer getPuntacionPelicula() {
        return puntacionPelicula;
    }

    public void setPuntacionPelicula(Integer puntacionPelicula) {
        this.puntacionPelicula = puntacionPelicula;
    }
}
