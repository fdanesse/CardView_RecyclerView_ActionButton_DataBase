package com.fdanesse.cardsviews;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter recyclerAdapter;

    private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.ListadeMascotas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerAdapter = new Adapter(mascotas);
        recyclerView.setAdapter(recyclerAdapter);

        mascotas.add(new Mascota(R.drawable.p01, "Cacique"));
        mascotas.add(new Mascota(R.drawable.p02, "Pancho"));
        mascotas.add(new Mascota(R.drawable.p03, "Sara"));
        mascotas.add(new Mascota(R.drawable.p04, "Marta"));

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
}
