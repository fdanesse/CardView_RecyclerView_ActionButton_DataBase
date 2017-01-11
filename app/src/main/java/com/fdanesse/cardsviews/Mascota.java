package com.fdanesse.cardsviews;

/**
 * Created by flavio on 10/01/17.
 */
public class Mascota {

    private int foto;
    private String nombre;

    public Mascota(int foto, String nombre){
        this.foto = foto;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
