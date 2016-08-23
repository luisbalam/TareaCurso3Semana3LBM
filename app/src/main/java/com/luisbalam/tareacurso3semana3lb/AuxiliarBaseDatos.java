package com.luisbalam.tareacurso3semana3lb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by luisadrian on 8/22/16.
 */
public class AuxiliarBaseDatos extends SQLiteOpenHelper {
    Context contexto;

    public AuxiliarBaseDatos(Context contexto) {
        super(contexto, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.VERSION);
        this.contexto=contexto;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryTablaGeneral="CREATE TABLE "+ConstantesBaseDatos.TABLE_NAME+"("+
                                    ConstantesBaseDatos.ID_MASCOTA+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                    ConstantesBaseDatos.NOMBRE_MASCOTA+" TEXT, "+
                                    ConstantesBaseDatos.IMAGEN_MASCOTA+" INTEGER, "+
                                    ConstantesBaseDatos.LIKES_MASCOTA+" INTEGER"+")";

        String queryTablaRaiting="CREATE TABLE "+ConstantesBaseDatos.TABLE_NAME2+"("+
                                    ConstantesBaseDatos.ID_MASCOTA2+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                    ConstantesBaseDatos.ID_RECUPERADO+" INTEGER, "+
                                    ConstantesBaseDatos.NOMBRE_MASCOTA2+" TEXT, "+
                                    ConstantesBaseDatos.IMAGEN_MASCOTA2+" INTEGER, "+
                                    ConstantesBaseDatos.LIKES_MASCOTA2+" INTEGER, "+
                                    "FOREIGN KEY ("+ConstantesBaseDatos.ID_RECUPERADO+")"+
                                    "REFERENCES "+ConstantesBaseDatos.TABLE_NAME+"("+ConstantesBaseDatos.ID_MASCOTA+")"+")";

        sqLiteDatabase.execSQL(queryTablaGeneral);
        sqLiteDatabase.execSQL(queryTablaRaiting);

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST "+ConstantesBaseDatos.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST "+ConstantesBaseDatos.TABLE_NAME2);

        onCreate(sqLiteDatabase);
    }

    public ArrayList<ImagenesPetagram> recuperarMascotasMainFragment(){
        ArrayList<ImagenesPetagram> mascotasRecuperadas=new ArrayList<ImagenesPetagram>();

        String queryRecuperar="SELECT * FROM "+ConstantesBaseDatos.TABLE_NAME;
        SQLiteDatabase baseDatos=this.getWritableDatabase();
        Cursor ejecutarQueryRecuperar=baseDatos.rawQuery(queryRecuperar,null);

        while(ejecutarQueryRecuperar.moveToNext()){
            ImagenesPetagram mascotaRecuperar=new ImagenesPetagram();

            mascotaRecuperar.setId(ejecutarQueryRecuperar.getInt(0));
            mascotaRecuperar.setNombre(ejecutarQueryRecuperar.getString(1));
            mascotaRecuperar.setImagen(ejecutarQueryRecuperar.getInt(2));
            mascotaRecuperar.setLikesUsuarios(ejecutarQueryRecuperar.getInt(3));

            String queryVerificarLikes="SELECT COUNT ("+ConstantesBaseDatos.LIKES_MASCOTA2+") as likes"+
                                        " FROM "+ConstantesBaseDatos.TABLE_NAME2+" WHERE "+
                                        ConstantesBaseDatos.ID_RECUPERADO+"="+mascotaRecuperar.getId();
            Cursor ejecutarVerificacion=baseDatos.rawQuery(queryVerificarLikes,null);

            if(ejecutarVerificacion.moveToNext()){
                mascotaRecuperar.setLikesUsuarios(ejecutarVerificacion.getInt(0));
            }else{
                mascotaRecuperar.setLikesUsuarios(0);
            }

            mascotasRecuperadas.add(mascotaRecuperar);
        }
        baseDatos.close();
        return mascotasRecuperadas;
    }

    public void agregarMascota(ContentValues mascotaAgregada){
        SQLiteDatabase baseDatos=this.getWritableDatabase();
        baseDatos.insert(ConstantesBaseDatos.TABLE_NAME,null,mascotaAgregada);
        baseDatos.close();
    }

    public void agregarMascotaLike(ContentValues mascotaLike){
        SQLiteDatabase baseDatos=this.getWritableDatabase();
        baseDatos.insert(ConstantesBaseDatos.TABLE_NAME2,null,mascotaLike);
        baseDatos.close();
    }

    public ArrayList<ImagenesPetagram> mascotasRaiting(){
        ArrayList<ImagenesPetagram> mascotasRaiting=new ArrayList<ImagenesPetagram>();

        String queryRecuperarMascotasTop5="SELECT * FROM "+ConstantesBaseDatos.TABLE_NAME2+" ORDER BY "+ConstantesBaseDatos.ID_MASCOTA2+" DESC LIMIT 5";
        SQLiteDatabase baseDatos=this.getWritableDatabase();
        Cursor ejecutarQueryRaiting=baseDatos.rawQuery(queryRecuperarMascotasTop5,null);

        while(ejecutarQueryRaiting.moveToNext()){
            ImagenesPetagram mascotaFavorita=new ImagenesPetagram();

            mascotaFavorita.setId(ejecutarQueryRaiting.getInt(0));
            mascotaFavorita.setNombre(ejecutarQueryRaiting.getString(2));
            mascotaFavorita.setImagen(ejecutarQueryRaiting.getInt(3));
            mascotaFavorita.setLikesUsuarios(ejecutarQueryRaiting.getInt(4));

            mascotasRaiting.add(mascotaFavorita);
        }
        baseDatos.close();
        return mascotasRaiting;
    }

    public int mostrarLikesMascotas(ImagenesPetagram mascotaLike){
        int likes=0;

        String queryMostrarLikes="SELECT COUNT ("+ConstantesBaseDatos.LIKES_MASCOTA2+") "+
                                    "FROM "+ConstantesBaseDatos.TABLE_NAME2+" WHERE "+
                                    ConstantesBaseDatos.ID_RECUPERADO+"="+mascotaLike.getId();
        SQLiteDatabase baseDatos=this.getWritableDatabase();
        Cursor ejecutarQueryMostrar=baseDatos.rawQuery(queryMostrarLikes,null);

        if(ejecutarQueryMostrar.moveToNext()){
            likes=ejecutarQueryMostrar.getInt(0);
        }

        baseDatos.close();
        return likes;
    }

}
