package com.fdanesse.cardsviews;

import android.content.ContentValues;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.fdanesse.cardsviews.acercade.AcercadeActivity;
import com.fdanesse.cardsviews.contacto.ContactoActivity;
import com.fdanesse.cardsviews.db.DataBase;
import com.fdanesse.cardsviews.detalle.DetalleActivity;
import com.fdanesse.cardsviews.general.Constants;
import com.fdanesse.cardsviews.general.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar mitoolbar;
    private RecyclerView recyclerView;
    private MainAdapter recyclerAdapter;

    private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    private DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mitoolbar = (Toolbar) findViewById(R.id.mitoolbar);
        setSupportActionBar(mitoolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(false);

        recyclerView = (RecyclerView) findViewById(R.id.ListadeMascotas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        db = new DataBase(this, Constants.BASENAME, Constants.BASEVER);
        mascotas = db.getMascotas();
        if (mascotas.size() < 1){
            initial_insert_data_in_database(db); //Solo para datos iniciales
            mascotas = db.getMascotas();
        }

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerAdapter = new MainAdapter(mascotas, this);
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
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.actionstar:
                intent = new Intent(MainActivity.this, DetalleActivity.class);
                startActivity(intent);
                break;
            case R.id.Contacto:
                intent = new Intent(MainActivity.this, ContactoActivity.class);
                startActivity(intent);
                break;
            case R.id.AcercaDe:
                intent = new Intent(MainActivity.this, AcercadeActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
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

        contentValues = new ContentValues();
        contentValues.put(Constants.MASCOTA_NAME, "Ramon");
        contentValues.put(Constants.MASCOTA_PHOTO, R.drawable.p05);
        db.set_new_item(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constants.MASCOTA_NAME, "Sancho");
        contentValues.put(Constants.MASCOTA_PHOTO, R.drawable.p06);
        db.set_new_item(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constants.MASCOTA_NAME, "Matilde");
        contentValues.put(Constants.MASCOTA_PHOTO, R.drawable.p07);
        db.set_new_item(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constants.MASCOTA_NAME, "Viqui");
        contentValues.put(Constants.MASCOTA_PHOTO, R.drawable.p08);
        db.set_new_item(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constants.MASCOTA_NAME, "Satan");
        contentValues.put(Constants.MASCOTA_PHOTO, R.drawable.p09);
        db.set_new_item(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constants.MASCOTA_NAME, "Elisa");
        contentValues.put(Constants.MASCOTA_PHOTO, R.drawable.p10);
        db.set_new_item(contentValues);
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
