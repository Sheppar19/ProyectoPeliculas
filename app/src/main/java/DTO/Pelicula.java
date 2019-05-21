package DTO;

import java.io.Serializable;

public class Pelicula implements Serializable {
    private String nombre;
    private String autor;
    private String sinopsis;
    private Integer puntuacion;
    private String id;
    private String fecha;
    private PuntajeGeneral puntajeGeneral;

    public Pelicula() {
    }

    public Pelicula(String nombre, String autor, String sinopsis, Integer puntuacion, String fecha) {
        this.nombre = nombre;
        this.autor = autor;
        this.sinopsis = sinopsis;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
    }

    public Pelicula(String nombre, String autor, String sinopsis, String fecha, PuntajeGeneral puntajeGeneral) {
        this.nombre = nombre;
        this.autor = autor;
        this.sinopsis = sinopsis;
        this.puntuacion = puntuacion;
        this.id = id;
        this.fecha = fecha;
        puntajeGeneral.setPuntacionAutor(3);
        puntajeGeneral.setPuntacionPelicula(3);
        puntajeGeneral.setPuntuacionSinopsis(3);
        this.puntajeGeneral = puntajeGeneral;
    }

    public Pelicula(String nombre, String autor, String sinopsis, Integer puntuacion) {
        this.nombre = nombre;
        this.autor = autor;
        this.sinopsis = sinopsis;
        this.puntuacion = puntuacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public PuntajeGeneral getPuntuacion() {
        return puntajeGeneral;
    }

    public void setPuntuacion(PuntajeGeneral puntajeGeneral) {
        this.puntajeGeneral = puntajeGeneral;
    }
}
