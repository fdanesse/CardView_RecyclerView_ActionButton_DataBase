package com.fdanesse.cardsviews;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fdanesse.cardsviews.db.DataBase;
import com.fdanesse.cardsviews.general.Constants;
import com.fdanesse.cardsviews.general.Mascota;

import java.util.ArrayList;

/**
 * Created by flavio on 17/01/17.
 */
public class FragmentMain extends Fragment {

    private RecyclerView recyclerView;
    private MainAdapter recyclerAdapter;

    private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    private DataBase db;

    public FragmentMain() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = (RecyclerView) layout.findViewById(R.id.ListadeMascotas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        db = new DataBase(getActivity(), Constants.BASENAME, Constants.BASEVER);
        mascotas = db.getMascotas();
        if (mascotas.size() < 1){
            initial_insert_data_in_database(db); //Solo para datos iniciales
            mascotas = db.getMascotas();
        }

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerAdapter = new MainAdapter(mascotas, this);
        recyclerView.setAdapter(recyclerAdapter);

        return layout;
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
