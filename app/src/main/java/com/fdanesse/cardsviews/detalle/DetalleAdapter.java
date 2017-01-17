package com.fdanesse.cardsviews.detalle;

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
 * Created by flavio on 15/01/17.
 */
public class DetalleAdapter extends RecyclerView.Adapter<DetalleAdapter.MyHolder> {

    private ArrayList<Mascota> mascotas;
    private static DetalleActivity detalleActivity = null;

    public DetalleAdapter(ArrayList<Mascota> lista, DetalleActivity detalleActivity) {
        this.mascotas = lista;
        this.detalleActivity = detalleActivity;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_detalle, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder mascotaHolder, int position) {
        Mascota listItem = mascotas.get(position);
        mascotaHolder.id = listItem.getId();
        mascotaHolder.foto.setImageResource(listItem.getFoto());
        mascotaHolder.nombre.setText(listItem.getNombre());
        mascotaHolder.raiting.setText(String.valueOf(detalleActivity.get_likes(mascotaHolder.id)));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        int id;
        TextView nombre;
        ImageView foto;
        TextView raiting;

        public MyHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            foto = (ImageView) itemView.findViewById(R.id.ImageViewMascota);
            raiting = (TextView) itemView.findViewById(R.id.raiting);
        }
    }
}
