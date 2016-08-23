package com.luisbalam.tareacurso3semana3lb;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by luisadrian on 8/22/16.
 */
public class FavoritosPresentador implements IFavoritosPresentador {
    ArrayList<ImagenesPetagram> mascotasFavoritas;
    IFavoritos interfaceFavoritos;
    Context contexto;

    public FavoritosPresentador(IFavoritos interfaceFavoritos, Context contexto) {
        this.interfaceFavoritos=interfaceFavoritos;
        this.contexto = contexto;
        recibirDatosMascotasFavoritas();
    }

    @Override
    public void recibirDatosMascotasFavoritas() {
        ConstructorMascotas constructorMascotas=new ConstructorMascotas(contexto);
        mascotasFavoritas=constructorMascotas.consultarBaseDatosFavoritos();
        mostrarDatosRecyclerView();
    }

    @Override
    public void mostrarDatosRecyclerView() {
        interfaceFavoritos.inicializarAdaptador(interfaceFavoritos.crearAdaptador(mascotasFavoritas));
        interfaceFavoritos.inicializarLayoutManager();
    }
}
