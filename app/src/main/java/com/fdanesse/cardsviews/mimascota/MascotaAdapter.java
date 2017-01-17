package com.fdanesse.cardsviews.mimascota;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fdanesse.cardsviews.R;
import com.fdanesse.cardsviews.general.Mascota;

import java.util.ArrayList;

/**
 * Created by flavio on 17/01/17.
 */
public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MyHolder>{

    private ArrayList<Mascota> mascotas;
    private static FragmentMiMascota fragment_mi_mascota = null;

    public MascotaAdapter(ArrayList<Mascota> lista, FragmentMiMascota fragment_mi_mascota){
        this.mascotas = lista;
        this.fragment_mi_mascota = fragment_mi_mascota;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mi_mascota,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder mascotaHolder, int position) {
        Mascota listItem = mascotas.get(position);
        mascotaHolder.id = listItem.getId();
        mascotaHolder.foto.setImageResource(listItem.getFoto());
        mascotaHolder.raiting.setText(String.valueOf(fragment_mi_mascota.get_likes(mascotaHolder.id)));
    }

    @Override
    public int getItemCount() {return mascotas.size();}

    public static class MyHolder extends RecyclerView.ViewHolder {

        int id;
        ImageView foto;
        TextView raiting;

        public MyHolder(View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.ImageViewMascota);
            raiting = (TextView) itemView.findViewById(R.id.raiting);
        }
    }
}
