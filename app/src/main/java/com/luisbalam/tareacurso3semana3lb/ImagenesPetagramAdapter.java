package com.luisbalam.tareacurso3semana3lb;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by luisbalam on 06/08/16.
 */
public class ImagenesPetagramAdapter extends RecyclerView.Adapter<ImagenesPetagramAdapter.ImagenesPetagramViewHolder> {
    ArrayList <ImagenesPetagram> alDatosMascotas;
    Activity activity;

    public ImagenesPetagramAdapter(ArrayList<ImagenesPetagram> alDatosMascotas, Activity activity) {
        this.alDatosMascotas = alDatosMascotas;
        this.activity=activity;
    }

    @Override
    public ImagenesPetagramViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.micardview,parent,false);
        return new ImagenesPetagramViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ImagenesPetagramViewHolder holder, int position) {
        final ImagenesPetagram ipMascotas = alDatosMascotas.get(position);
        holder.ivMascota.setImageResource(ipMascotas.getImagen());
        holder.tvNombreMascota.setText(ipMascotas.getNombre());
        holder.tvNumLikes.setText(ipMascotas.getLikesUsuarios()+"");


            holder.ivHuesoBlanco.setOnClickListener(new ImageButton.OnClickListener() {
                public void onClick(View v) {
                    if(activity.getClass()==MainActivity.class) {
                    Toast.makeText(activity, "Diste like a " + ipMascotas.getNombre(), Toast.LENGTH_LONG).show();
                    ConstructorMascotas contructorMascotas = new ConstructorMascotas(activity);
                    contructorMascotas.registrarMascotaLike(ipMascotas);
                    holder.tvNumLikes.setText(""+contructorMascotas.mostrarLikesMascota(ipMascotas));
                    }
                }
            });

    }

    @Override
    public int getItemCount() {
        return alDatosMascotas.size();
    }

    public static class ImagenesPetagramViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMascota;
        TextView tvNombreMascota, tvNumLikes;
        ImageButton ivHuesoBlanco;

        public ImagenesPetagramViewHolder(View itemView) {
            super(itemView);
            ivMascota = (ImageView) itemView.findViewById(R.id.ivMascota);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvNumLikes = (TextView) itemView.findViewById(R.id.tvNumLikes);
            ivHuesoBlanco = (ImageButton) itemView.findViewById(R.id.ivHuesoBlanco);
        }
    }
}
