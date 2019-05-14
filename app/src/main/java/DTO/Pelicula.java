package DTO;

public class Pelicula {
    private String nombre;
    private String autor;
    private String sinopsis;
    private Integer puntuacion;
    private String id;

    public Pelicula() {
    }

    public Pelicula(String nombre, String autor, String sinopsis, Integer puntuacion, String id) {
        this.nombre = nombre;
        this.autor = autor;
        this.sinopsis = sinopsis;
        this.puntuacion = puntuacion;
        this.id = id;
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

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }
}
