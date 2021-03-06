package com.luisbalam.tareacurso3semana3lb;

/**
 * Created by luisbalam on 06/08/16.
 */
public class ImagenesPetagram {
    int id;
    String nombre;
    int imagen;
    int likesUsuarios;

    public ImagenesPetagram(String nombre, int imagen, int likesUsuarios) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.likesUsuarios = likesUsuarios;
    }

    public ImagenesPetagram(int likesUsuarios, int imagen){
        this.imagen = imagen;
        this.likesUsuarios = likesUsuarios;
    }

    public ImagenesPetagram(){
        //constructor vacio
    }

    public String getNombre() {
        return nombre;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getLikesUsuarios() {
        return likesUsuarios;
    }

    public void setLikesUsuarios(int likesUsuarios) {
        this.likesUsuarios = likesUsuarios;
    }
}
