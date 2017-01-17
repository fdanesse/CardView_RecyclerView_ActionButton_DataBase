package com.fdanesse.cardsviews.detalle;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.fdanesse.cardsviews.general.Constants;
import com.fdanesse.cardsviews.general.Mascota;
import com.fdanesse.cardsviews.R;
import com.fdanesse.cardsviews.db.DataBase;

import java.util.ArrayList;

public class DetalleActivity extends AppCompatActivity {

    private Toolbar mitoolbar;
    private RecyclerView recyclerView;
    private DetalleAdapter recyclerAdapter;

    private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    private DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        mitoolbar = (Toolbar) findViewById(R.id.generic_toolbar);
        setSupportActionBar(mitoolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setDisplayUseLogoEnabled(false);

        recyclerView = (RecyclerView) findViewById(R.id.ListadeMascotas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        db = new DataBase(this, Constants.BASENAME, Constants.BASEVER);
        mascotas = db.getUltimosLikes(5);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerAdapter = new DetalleAdapter(mascotas, this);
        recyclerView.setAdapter(recyclerAdapter);
    }

    public void add_like(int id){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.FOREIGN_KEY, id);
        contentValues.put(Constants.MASCOTA_LIKES, 1);
        db.set_new_like(contentValues);
    }

    public int get_likes(int id){
        return db.getLikes(id);
    }
}
