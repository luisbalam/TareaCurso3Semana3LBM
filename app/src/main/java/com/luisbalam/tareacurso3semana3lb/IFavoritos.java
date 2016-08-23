package com.luisbalam.tareacurso3semana3lb;

import java.util.ArrayList;

/**
 * Created by luisadrian on 8/22/16.
 */
public interface IFavoritos {

    //Metodos del activity favoritos
    public ImagenesPetagramAdapter crearAdaptador(ArrayList<ImagenesPetagram> imagenesMascotasFavoritos);
    public void inicializarAdaptador(ImagenesPetagramAdapter imagenesPetagramAdapter);
    public void inicializarLayoutManager();

}
