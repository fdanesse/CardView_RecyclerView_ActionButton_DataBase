package com.fdanesse.cardsviews.general;

/**
 * Created by flavio on 14/01/17.
 */
public class Constants {

    public static final String BASENAME = "Mascotas_db";
    public static final int BASEVER = 1;

    /* Nombre de Tabla */
    public static final String MASCOTAS_TABLE_NAME = "Mascotas_tabla";
    /* Campos de la Tabla */
    public static final String MASCOTA_ID = "id";
    public static final String MASCOTA_NAME = "name";
    public static final String MASCOTA_PHOTO = "photo";

    /* Nombre de Tabla */
    public static final String LIKES_TABLE_NAME = "Mascotas_likes";
    /* Campos de la Tabla */
    public static final String LIKES_MASCOTA_ID = "id";
    public static final String FOREIGN_KEY = "id_mascota";
    public static final String MASCOTA_LIKES = "likes";
}
