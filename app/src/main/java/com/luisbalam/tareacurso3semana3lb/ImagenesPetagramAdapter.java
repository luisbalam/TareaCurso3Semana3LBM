package com.luisbalam.tareacurso3semana3lb;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by luisbalam on 06/08/16.
 */
public class ImagenesPetagramAdapter extends RecyclerView.Adapter<ImagenesPetagramAdapter.ImagenesPetagramViewHolder> {
    ArrayList <ImagenesPetagram> alDatosMascotas;

    public ImagenesPetagramAdapter(ArrayList<ImagenesPetagram> alDatosMascotas) {
        this.alDatosMascotas = alDatosMascotas;
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
    }

    @Override
    public int getItemCount() {
        return alDatosMascotas.size();
    }

    public static class ImagenesPetagramViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMascota;
        TextView tvNombreMascota, tvNumLikes;

        public ImagenesPetagramViewHolder(View itemView) {
            super(itemView);
            ivMascota = (ImageView) itemView.findViewById(R.id.ivMascota);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvNumLikes = (TextView) itemView.findViewById(R.id.tvNumLikes);

        }
    }
}
