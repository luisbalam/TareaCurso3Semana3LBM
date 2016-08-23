package com.luisbalam.tareacurso3semana3lb;

import java.util.ArrayList;

/**
 * Created by luisadrian on 8/22/16.
 */
public interface IMainFragment {

    //Metodos del fragment principal
    public ImagenesPetagramAdapter crearAdaptador(ArrayList<ImagenesPetagram> imagenesMascotas);
    public void inicializarAdaptador(ImagenesPetagramAdapter imagenesPetagramAdapter);
    public void inicializarLayoutManager();

}
