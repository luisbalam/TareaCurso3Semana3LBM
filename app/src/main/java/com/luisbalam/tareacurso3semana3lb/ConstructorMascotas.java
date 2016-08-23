package com.luisbalam.tareacurso3semana3lb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by luisadrian on 8/22/16.
 */
public class ConstructorMascotas {
    Context contexto;

    public ConstructorMascotas(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<ImagenesPetagram> consultarBaseDatos(){
        AuxiliarBaseDatos auxBaseDatos=new AuxiliarBaseDatos(contexto);
        crearMascotaPetagram();
        return auxBaseDatos.recuperarMascotasMainFragment();
    }

    public ArrayList<ImagenesPetagram> consultarBaseDatosFavoritos(){
        AuxiliarBaseDatos baseDatos=new AuxiliarBaseDatos(contexto);
        return baseDatos.mascotasRaiting();
    }

    public void crearMascotaPetagram(){
        ContentValues contentValues=new ContentValues();
        AuxiliarBaseDatos auxiliarBaseDatos=new AuxiliarBaseDatos(contexto);

        contentValues.put(ConstantesBaseDatos.NOMBRE_MASCOTA,"Bruno");
        contentValues.put(ConstantesBaseDatos.IMAGEN_MASCOTA,R.drawable.pug9patch);
        contentValues.put(ConstantesBaseDatos.LIKES_MASCOTA,0);

        auxiliarBaseDatos.agregarMascota(contentValues);

        ContentValues contentValues1=new ContentValues();

        contentValues1.put(ConstantesBaseDatos.NOMBRE_MASCOTA,"El pulgas");
        contentValues1.put(ConstantesBaseDatos.IMAGEN_MASCOTA,R.drawable.pulgoso9patch);
        contentValues1.put(ConstantesBaseDatos.LIKES_MASCOTA,0);

        auxiliarBaseDatos.agregarMascota(contentValues1);

        ContentValues contentValues2=new ContentValues();

        contentValues2.put(ConstantesBaseDatos.NOMBRE_MASCOTA,"Zanahorias");
        contentValues2.put(ConstantesBaseDatos.IMAGEN_MASCOTA,R.drawable.conejito9patch);
        contentValues2.put(ConstantesBaseDatos.LIKES_MASCOTA,0);

        auxiliarBaseDatos.agregarMascota(contentValues2);

        ContentValues contentValues3=new ContentValues();

        contentValues3.put(ConstantesBaseDatos.NOMBRE_MASCOTA,"El larguirucho");
        contentValues3.put(ConstantesBaseDatos.IMAGEN_MASCOTA,R.drawable.salchicha9path);
        contentValues3.put(ConstantesBaseDatos.LIKES_MASCOTA,0);

        auxiliarBaseDatos.agregarMascota(contentValues3);

        ContentValues contentValues4=new ContentValues();

        contentValues4.put(ConstantesBaseDatos.NOMBRE_MASCOTA,"Wiskas");
        contentValues4.put(ConstantesBaseDatos.IMAGEN_MASCOTA,R.drawable.gato9patch);
        contentValues4.put(ConstantesBaseDatos.LIKES_MASCOTA,0);

        auxiliarBaseDatos.agregarMascota(contentValues4);

        ContentValues contentValues5=new ContentValues();

        contentValues5.put(ConstantesBaseDatos.NOMBRE_MASCOTA,"Rambito");
        contentValues5.put(ConstantesBaseDatos.IMAGEN_MASCOTA,R.drawable.perritodurmiendo9patch);
        contentValues5.put(ConstantesBaseDatos.LIKES_MASCOTA,0);

        auxiliarBaseDatos.agregarMascota(contentValues5);

        ContentValues contentValues6=new ContentValues();

        contentValues6.put(ConstantesBaseDatos.NOMBRE_MASCOTA,"El tristón");
        contentValues6.put(ConstantesBaseDatos.IMAGEN_MASCOTA,R.drawable.perrotriste9patch);
        contentValues6.put(ConstantesBaseDatos.LIKES_MASCOTA,0);

        auxiliarBaseDatos.agregarMascota(contentValues6);

        ContentValues contentValues7=new ContentValues();

        contentValues7.put(ConstantesBaseDatos.NOMBRE_MASCOTA,"Wiskas Jr");
        contentValues7.put(ConstantesBaseDatos.IMAGEN_MASCOTA,R.drawable.gatito9patch);
        contentValues7.put(ConstantesBaseDatos.LIKES_MASCOTA,0);

        auxiliarBaseDatos.agregarMascota(contentValues7);

    }

    public void registrarMascotaLike(ImagenesPetagram mascotaLike){
        ContentValues contentValues=new ContentValues();
        AuxiliarBaseDatos auxBaseDatos=new AuxiliarBaseDatos(contexto);

        contentValues.put(ConstantesBaseDatos.ID_RECUPERADO,mascotaLike.getId());
        contentValues.put(ConstantesBaseDatos.NOMBRE_MASCOTA2,mascotaLike.getNombre());
        contentValues.put(ConstantesBaseDatos.IMAGEN_MASCOTA2,mascotaLike.getImagen());
        contentValues.put(ConstantesBaseDatos.LIKES_MASCOTA2,1);

        auxBaseDatos.agregarMascotaLike(contentValues);
    }

    public int mostrarLikesMascota(ImagenesPetagram mascotasLike){
        AuxiliarBaseDatos auxiliarBaseDatos=new AuxiliarBaseDatos(contexto);
        return auxiliarBaseDatos.mostrarLikesMascotas(mascotasLike);
    }

}
