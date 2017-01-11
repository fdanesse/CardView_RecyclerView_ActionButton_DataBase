package com.fdanesse.cardsviews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by flavio on 10/01/17.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder>{

    private ArrayList<Mascota> mascotas;

    public Adapter(ArrayList<Mascota> lista){
        this.mascotas = lista;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mycardview,parent,false);
        MyHolder mascota = new MyHolder(v);
        return mascota;
    }

    @Override
    public void onBindViewHolder(MyHolder mascotaHolder, int position) {
        Mascota listItem = mascotas.get(position);
        mascotaHolder.foto.setImageResource(listItem.getFoto());
        mascotaHolder.nombre.setText(listItem.getNombre());
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class MyHolder extends RecyclerView.ViewHolder {

        TextView nombre;
        ImageView foto;

        public MyHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.TextViewNombre);
            foto = (ImageView) itemView.findViewById(R.id.ImageViewMascota);
        }
    }
}