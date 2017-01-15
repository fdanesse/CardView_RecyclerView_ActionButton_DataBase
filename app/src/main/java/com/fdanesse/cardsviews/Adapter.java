package com.fdanesse.cardsviews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by flavio on 10/01/17.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder>{

    private ArrayList<Mascota> mascotas;
    private static MainActivity parent;

    public Adapter(ArrayList<Mascota> lista, MainActivity parent){
        this.mascotas = lista;
        this.parent = parent;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mycardview,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder mascotaHolder, int position) {
        Mascota listItem = mascotas.get(position);
        mascotaHolder.id = listItem.getId();
        mascotaHolder.foto.setImageResource(listItem.getFoto());
        mascotaHolder.nombre.setText(listItem.getNombre());
        mascotaHolder.raiting.setText(Integer.toString(parent.get_likes(mascotaHolder.id)));
    }

    @Override
    public int getItemCount() {return mascotas.size();}

    public static class MyHolder extends RecyclerView.ViewHolder {

        int id;
        TextView nombre;
        ImageView foto;
        TextView raiting;
        ImageButton hueso1;

        public MyHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            foto = (ImageView) itemView.findViewById(R.id.ImageViewMascota);
            raiting = (TextView) itemView.findViewById(R.id.raiting);
            hueso1 = (ImageButton) itemView.findViewById(R.id.hueso1);

            hueso1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    parent.add_like(id);
                    raiting.setText(Integer.toString(parent.get_likes(id)));
                }
            });
        }
    }
}