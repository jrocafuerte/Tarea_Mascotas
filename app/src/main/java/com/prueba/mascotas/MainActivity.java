package com.prueba.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascota);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarLista();
        inicializaAdaptador();


    }

    public void inicializarLista(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(5,"Mascota 1",R.drawable.img1));
        mascotas.add(new Mascota(2,"Mascota 2",R.drawable.img2));
        mascotas.add(new Mascota(10,"Mascota 3",R.drawable.img3));
        mascotas.add(new Mascota(4,"Mascota 4",R.drawable.img4));
        mascotas.add(new Mascota(6,"Mascota 5",R.drawable.img5));

    }

    public void inicializaAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

/* public void inicializaAdaptador() {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        listaContactos.setAdapter(adaptador);
        Log.d(TAG, "Mensaje de depuración");
    }

    public void inicializarLista() {
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.img1, "User 1 ", "0986131385", "notiene@notiene.com"));
        contactos.add(new Contacto(R.drawable.img2, "User 2 ", "0912345567", "notiene@gmail.com"));
        contactos.add(new Contacto(R.drawable.img1, "User 3 ", "0989546213", "notiene@hotmail.com"));
        contactos.add(new Contacto(R.drawable.img2, "User 4 ", "0900124567", "notiene@yahoo.com"));
    } */
}
