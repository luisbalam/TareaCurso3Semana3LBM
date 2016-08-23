package com.luisbalam.tareacurso3semana3lb;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbarMain;
    RecyclerView recyclerMain;
    ArrayList <Fragment> fragments;
    TabLayout miTab;
    ViewPager viewPagerPetagram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbarMain= (Toolbar) findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbarMain);

        miTab=(TabLayout) findViewById(R.id.miTab);
        viewPagerPetagram=(ViewPager) findViewById(R.id.viewPagerPetagram);

        crearArrayListFragments();
        inicializarAdaptadorFragments();

    }

    public void crearArrayListFragments(){
        fragments= new ArrayList<Fragment>();
        fragments.add(new MainFragment());
        fragments.add(new MiPerfil());
    }

    public void inicializarAdaptadorFragments(){
        viewPagerPetagram.setAdapter(new AdaptadorFragments(getSupportFragmentManager(), fragments));
        miTab.setupWithViewPager(viewPagerPetagram);

        miTab.getTabAt(0).setIcon(R.drawable.huesoblanco9patch);
        miTab.getTabAt(1).setIcon(R.drawable.huesoblanco9patch);

    }

    public void irFavoritos(View v){
        Intent irMascotasFavoritos=new Intent(MainActivity.this,Favoritos.class);
        startActivity(irMascotasFavoritos);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.opcionContacto:
                Intent irContacto=new Intent(MainActivity.this,Contacto.class);
                startActivity(irContacto);
                break;

            case R.id.opcionAcercaDe:
                Intent irAcercaDe=new Intent(MainActivity.this,AcercaDe.class);
                startActivity(irAcercaDe);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
