package com.prueba.mascotas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Intel on 23/12/2016.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {


    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        activity = (Activity) parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota   = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.nombreMascota.setText(mascota.getNombre());
        mascotaViewHolder.cantidadMegusta.setText(String.valueOf(mascota.getMegusta()));

        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity , "Hola", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(activity , Mascotas_Favoritas.class);
                activity.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView nombreMascota;
        private TextView  cantidadMegusta;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imFoto);
            nombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            cantidadMegusta = (TextView) itemView.findViewById(R.id.tvCantidadLike);
            btnLike = (ImageButton)itemView.findViewById(R.id.ibFotoLike);
        }

    }
}
