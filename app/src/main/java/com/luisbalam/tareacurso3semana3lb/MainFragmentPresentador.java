package com.luisbalam.tareacurso3semana3lb;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by luisadrian on 8/22/16.
 */
public class MainFragmentPresentador implements IMainFragmentPresentador {
    IMainFragment interfaceIMainFragment;
    ArrayList<ImagenesPetagram> mascotas;
    Context contexto;

    public MainFragmentPresentador(IMainFragment interfaceIMainFragment, Context contexto) {
        this.interfaceIMainFragment=interfaceIMainFragment;
        this.contexto=contexto;
        recibirDatosMascotas();
    }

    @Override
    public void recibirDatosMascotas() {
        ConstructorMascotas constructorMascotas=new ConstructorMascotas(contexto);
        mascotas=constructorMascotas.consultarBaseDatos();
        mostrarDatosRecyclerView();
    }

    @Override
    public void mostrarDatosRecyclerView() {
        interfaceIMainFragment.inicializarAdaptador(interfaceIMainFragment.crearAdaptador(mascotas));
        interfaceIMainFragment.inicializarLayoutManager();
    }

}
