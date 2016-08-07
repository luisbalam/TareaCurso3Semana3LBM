package com.luisbalam.tareacurso3semana3lb;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbarMain;
    RecyclerView recyclerMain;
    ArrayList <ImagenesPetagram> datosMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbarMain= (Toolbar) findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbarMain);
        recyclerMain= (RecyclerView) findViewById(R.id.recyclerMain);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerMain.setLayoutManager(llm);
        asigDatos();
        crearAdaptador();
        //
    }
    public void asigDatos (){
        datosMascotas = new ArrayList<ImagenesPetagram>();
        datosMascotas.add(new ImagenesPetagram("Bruno",R.drawable.pug9patch,19));
        datosMascotas.add(new ImagenesPetagram("El pulgas",R.drawable.pulgoso9patch,12));
        datosMascotas.add(new ImagenesPetagram("Zanahorias",R.drawable.conejito9patch,7));
        datosMascotas.add(new ImagenesPetagram("El largirucho",R.drawable.salchicha9path,10));
        datosMascotas.add(new ImagenesPetagram("Wiskas",R.drawable.gato9patch,8));
        datosMascotas.add(new ImagenesPetagram("Rambito",R.drawable.perritodurmiendo9patch,15));
        datosMascotas.add(new ImagenesPetagram("El tristón",R.drawable.perrotriste9patch,5));
        datosMascotas.add(new ImagenesPetagram("Wiskas Jr",R.drawable.gatito9patch,13));
    }

    public void crearAdaptador () {
        ImagenesPetagramAdapter adaptadorMascotas = new ImagenesPetagramAdapter(datosMascotas);
        recyclerMain.setAdapter(adaptadorMascotas);
    }

    public void irFavoritos(View v){
        Intent irMascotasFavoritos=new Intent(MainActivity.this,Favoritos.class);
        startActivity(irMascotasFavoritos);

    }


}
