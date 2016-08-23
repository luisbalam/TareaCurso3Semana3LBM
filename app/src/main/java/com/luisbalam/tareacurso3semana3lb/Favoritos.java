package com.luisbalam.tareacurso3semana3lb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity implements IFavoritos {
    Toolbar toolbarFavoritos;
    RecyclerView recyclerFavoritos;
    ArrayList<ImagenesPetagram> datosMascotasFavoritos;
    ImageButton ibEstrella;
    FavoritosPresentador favoritosPresentador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoritos);
        toolbarFavoritos= (Toolbar) findViewById(R.id.toolbarFavoritos);
        setSupportActionBar(toolbarFavoritos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ibEstrella=(ImageButton) findViewById(R.id.ibEstrella);
        ibEstrella.setVisibility(View.INVISIBLE);
        recyclerFavoritos= (RecyclerView) findViewById(R.id.recyclerFavoritos);

        favoritosPresentador=new FavoritosPresentador(this,this);

        //asigDatos();
    }

    /*public void asigDatos (){
        datosMascotasFavoritos = new ArrayList<ImagenesPetagram>();
        datosMascotasFavoritos.add(new ImagenesPetagram("Bruno",R.drawable.pug9patch,19));
        datosMascotasFavoritos.add(new ImagenesPetagram("El pulgas",R.drawable.pulgoso9patch,12));
        datosMascotasFavoritos.add(new ImagenesPetagram("El largirucho",R.drawable.salchicha9path,10));
        datosMascotasFavoritos.add(new ImagenesPetagram("Rambito",R.drawable.perritodurmiendo9patch,15));
        datosMascotasFavoritos.add(new ImagenesPetagram("Wiskas Jr",R.drawable.gatito9patch,13));
    }*/

    @Override
    public ImagenesPetagramAdapter crearAdaptador(ArrayList<ImagenesPetagram> imagenesMascotasFavoritos) {
        ImagenesPetagramAdapter adaptadorMascotas = new ImagenesPetagramAdapter(imagenesMascotasFavoritos,this);
        return adaptadorMascotas;
    }

    @Override
    public void inicializarAdaptador(ImagenesPetagramAdapter imagenesPetagramAdapter) {
        recyclerFavoritos.setAdapter(imagenesPetagramAdapter);
    }

    @Override
    public void inicializarLayoutManager() {
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerFavoritos.setLayoutManager(llm);
    }
}
