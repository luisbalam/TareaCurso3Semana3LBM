package com.luisbalam.tareacurso3semana3lb;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by luisbalam on 14/08/16.
 */
public class MiPerfilAdaptador extends RecyclerView.Adapter<MiPerfilAdaptador.MiPerfilViewHolder> {

    ArrayList<ImagenesPetagram> fotosMiMascota;
    Activity activity;

    public MiPerfilAdaptador(ArrayList<ImagenesPetagram> fotosMiMascota,Activity activity) {
        this.fotosMiMascota = fotosMiMascota;
        this.activity=activity;
    }


    @Override
    public MiPerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.micardview_perfil,parent,false);
        return new MiPerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MiPerfilViewHolder holder, int position) {
        ImagenesPetagram fotosMiMascotaPetagram=fotosMiMascota.get(position);
        holder.ivItemRecyclerMiMascotaPetagram.setImageResource(fotosMiMascotaPetagram.getImagen());
        holder.tvNumeroLikesMiMascota.setText(fotosMiMascotaPetagram.getLikesUsuarios()+"");
    }

    @Override
    public int getItemCount() {
        return fotosMiMascota.size();
    }

    public static class MiPerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivItemRecyclerMiMascotaPetagram;
        private TextView tvNumeroLikesMiMascota;

        public MiPerfilViewHolder(View itemView) {
            super(itemView);
            ivItemRecyclerMiMascotaPetagram=(ImageView) itemView.findViewById(R.id.ivItemRecyclerMiMascotaPetagram);
            tvNumeroLikesMiMascota=(TextView) itemView.findViewById(R.id.tvNumeroLikesMiMascota);
        }
    }

}
