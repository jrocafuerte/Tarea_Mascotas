package com.prueba.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        ImageButton boton = (ImageButton) findViewById(R.id.ibActionView);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , Mascotas_Favoritas.class);
                startActivity(i);
            }
        });
        setSupportActionBar(miActionBar) ;

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascota);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarLista();
        inicializaAdaptador();
    }

    public void inicializarLista(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(5,"Mascota 1",R.drawable.img1,R.drawable.dog_bone_50));
        mascotas.add(new Mascota(2,"Mascota 2",R.drawable.img2,R.drawable.dog_bone_50));
        mascotas.add(new Mascota(10,"Mascota 3",R.drawable.img3,R.drawable.dog_bone_50));
        mascotas.add(new Mascota(4,"Mascota 4",R.drawable.img4,R.drawable.dog_bone_50));
        mascotas.add(new Mascota(6,"Mascota 5",R.drawable.img5,R.drawable.dog_bone_50));

    }

    public void inicializaAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }
}
