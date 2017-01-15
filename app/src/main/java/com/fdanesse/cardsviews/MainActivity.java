package com.fdanesse.cardsviews;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar mitoolbar;
    private ImageButton actionbutton;
    private RecyclerView recyclerView;
    private Adapter recyclerAdapter;

    private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    private SharedPreferences.Editor conf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mitoolbar = (Toolbar) findViewById(R.id.mitoolbar);
        setSupportActionBar(mitoolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(false);

        actionbutton = (ImageButton) findViewById(R.id.action);

        recyclerView = (RecyclerView) findViewById(R.id.ListadeMascotas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        DataBase db = new DataBase(this, Constants.BASENAME, Constants.BASEVER);
        mascotas = db.getMascotas();
        if (mascotas.size() < 1){
            initial_insert_data_in_database(db); //Solo para datos iniciales
            mascotas = db.getMascotas();
        }

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerAdapter = new Adapter(mascotas);
        recyclerView.setAdapter(recyclerAdapter);

        FloatingActionButton camara = (FloatingActionButton) findViewById(R.id.Camara);
        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Mascotas: " + recyclerAdapter.getItemCount() + " " +
                        recyclerAdapter.toString(),
                        Snackbar.LENGTH_LONG).setAction("Accion", null).show();
            }
        });

        actionbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initial_insert_data_in_database(DataBase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.MASCOTA_NAME, "Cacique");
        contentValues.put(Constants.MASCOTA_PHOTO, R.drawable.p01);
        db.set_new_item(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constants.MASCOTA_NAME, "Pancho");
        contentValues.put(Constants.MASCOTA_PHOTO, R.drawable.p02);
        db.set_new_item(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constants.MASCOTA_NAME, "Sara");
        contentValues.put(Constants.MASCOTA_PHOTO, R.drawable.p03);
        db.set_new_item(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constants.MASCOTA_NAME, "Marta");
        contentValues.put(Constants.MASCOTA_PHOTO, R.drawable.p04);
        db.set_new_item(contentValues);
    }
}
