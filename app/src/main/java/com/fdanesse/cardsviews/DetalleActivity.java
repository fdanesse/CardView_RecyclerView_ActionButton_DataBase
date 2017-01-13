package com.fdanesse.cardsviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class DetalleActivity extends AppCompatActivity {

    private Toolbar mitoolbar;
    private RecyclerView recyclerView;
    private Adapter recyclerAdapter;

    private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        mitoolbar = (Toolbar) findViewById(R.id.toolbar_detalle);
        setSupportActionBar(mitoolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setDisplayUseLogoEnabled(false);

        recyclerView = (RecyclerView) findViewById(R.id.ListadeMascotas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerAdapter = new Adapter(mascotas);
        recyclerView.setAdapter(recyclerAdapter);

    }
}
