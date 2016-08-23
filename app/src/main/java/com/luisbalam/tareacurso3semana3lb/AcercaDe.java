package com.luisbalam.tareacurso3semana3lb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class AcercaDe extends AppCompatActivity {

    Toolbar toolBarAcercaDe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        toolBarAcercaDe=(Toolbar) findViewById(R.id.toolBarAcercaDe);
        setSupportActionBar(toolBarAcercaDe);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
