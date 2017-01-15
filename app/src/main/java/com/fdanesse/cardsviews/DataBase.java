package com.fdanesse.cardsviews;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by flavio on 14/01/17.
 */
public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + Constants.MASCOTAS_TABLE_NAME + " (" +
                Constants.MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constants.MASCOTA_NAME + " TEXT, " +
                Constants.MASCOTA_PHOTO + " INTEGER" +
                ")";
        sqLiteDatabase.execSQL(query);

        query = "CREATE TABLE " + Constants.LIKES_TABLE_NAME + "(" +
                Constants.LIKES_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constants.FOREIGN_KEY + " INTEGER, " +
                Constants.MASCOTA_LIKES + " INTEGER, " +

                "FOREIGN KEY" + "(" + Constants.FOREIGN_KEY + ") " +
                "REFERENCES " + Constants.MASCOTAS_TABLE_NAME + "(" + Constants.MASCOTA_ID + ") " +
                ")";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Constants.MASCOTAS_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Constants.LIKES_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> getMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        String query = "SELECT * FROM " + Constants.MASCOTAS_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery(query, null); //null = posibles filtros
        while (cur.moveToNext()){
            mascotas.add(new Mascota(cur.getInt(0), cur.getString(1), cur.getInt(2)));
        }
        db.close();
        return mascotas;
    }

    public void set_new_item(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Constants.MASCOTAS_TABLE_NAME, null, contentValues);
        db.close();
    }

    public void set_new_like(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Constants.LIKES_TABLE_NAME, null, contentValues);
        db.close();
    }

    public int getLikes(int id){
        int likes = 0;
        String query = "SELECT COUNT(" + Constants.MASCOTA_LIKES + ")"+
                " FROM " + Constants.LIKES_TABLE_NAME +
                " WHERE " + Constants.FOREIGN_KEY + "=" + id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery(query, null);
        if (cur.moveToNext()){
            likes = cur.getInt(0);
        }
        db.close();
        return likes;
    }
}
