package com.example.ctrlpc;

public class Articulos {

    private String titulo;
    private String descripcion;
    private String imagen;

    public Articulos(String titulo, String descripcion, String imagen) {

        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen() {
        return imagen;
    }
}
