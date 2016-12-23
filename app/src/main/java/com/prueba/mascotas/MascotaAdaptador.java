package com.prueba.mascotas;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
        mascotaViewHolder.cantidadMegusta.setText(mascota.getMegusta());



         /* contactoViewHolder.imgFoto.setImageResource(contact.getFoto());
        contactoViewHolder.nombreContacto.setText(contact.getNombre());
        contactoViewHolder.telefonoContacto.setText(contact.getTelefono());

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(activity , contact.getNombre(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(activity, detalleContacto.class);
                i.putExtra(activity.getResources().getString(R.string.pnombre),contact.getNombre());
                i.putExtra(activity.getResources().getString(R.string.ptelefono),contact.getTelefono());
                i.putExtra(activity.getResources().getString(R.string.pemail),contact.getEmail());
                i.putExtra(activity.getResources().getString(R.string.pfoto),contact.getFoto());
                activity.startActivity(i);

            }
        });

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a "+contact.getNombre(),Toast.LENGTH_SHORT).show();
            }
        }); */
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
