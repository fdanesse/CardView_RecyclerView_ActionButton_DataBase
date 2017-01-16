package com.fdanesse.cardsviews.general;

/**
 * Created by flavio on 10/01/17.
 */
public class Mascota {

    private int id;
    private int foto;
    private String nombre;

    public Mascota(int id, String nombre, int foto){
        this.id = id;
        this.foto = foto;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFoto() {
        return foto;
    }

    public int getId() {
        return id;
    }
}
