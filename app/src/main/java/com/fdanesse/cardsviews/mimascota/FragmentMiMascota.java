package com.fdanesse.cardsviews.mimascota;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fdanesse.cardsviews.R;
import com.fdanesse.cardsviews.general.Mascota;

import java.util.ArrayList;

/**
 * Created by flavio on 17/01/17.
 */
public class FragmentMiMascota extends Fragment {

    private RecyclerView recyclerView;
    private MascotaAdapter recyclerAdapter;
    private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

    public FragmentMiMascota() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_mi_mascota, container, false);

        recyclerView = (RecyclerView) layout.findViewById(R.id.ListadeMascotas);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mascotas.add(new Mascota(100, "Primera", R.drawable.m100));
        mascotas.add(new Mascota(101, "Primera", R.drawable.m101));
        mascotas.add(new Mascota(102, "Primera", R.drawable.m102));
        mascotas.add(new Mascota(103, "Primera", R.drawable.m103));
        mascotas.add(new Mascota(104, "Primera", R.drawable.m104));
        mascotas.add(new Mascota(105, "Primera", R.drawable.m105));

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerAdapter = new MascotaAdapter(mascotas, this);
        recyclerView.setAdapter(recyclerAdapter);

        return layout;
    }

    public int get_likes(int id){
        int likes = 0;
        switch (id){
            case 100:
                likes = 2;
                break;
            case 101:
                likes = 1;
                break;
            case 102:
                likes = 5;
                break;
            case 103:
                likes = 1;
                break;
            case 104:
                likes = 0;
                break;
            case 105:
                likes = 3;
                break;
        }
        return likes;
    }
}
