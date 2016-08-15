package com.luisbalam.tareacurso3semana3lb;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MiPerfil extends Fragment {


    public MiPerfil() {
        // Required empty public constructor
    }

    private RecyclerView recyclerViewMiMascota;
    ArrayList<ImagenesPetagram> fotosMiMascota;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_mi_perfil,container,false);

        recyclerViewMiMascota=(RecyclerView) v.findViewById(R.id.recyclerViewMiMascota);
        GridLayoutManager recyclerMiMascota=new GridLayoutManager(getActivity(),3);
        recyclerViewMiMascota.setLayoutManager(recyclerMiMascota);

        datosMiMascotaPetagram();
        inicializarAdaptadorMiMascota();

        return v;
    }

    public void datosMiMascotaPetagram(){
        fotosMiMascota=new ArrayList<ImagenesPetagram>();
        fotosMiMascota.add(new ImagenesPetagram(12,R.drawable.pug9patch));
        fotosMiMascota.add(new ImagenesPetagram(21,R.drawable.pug9patch));
        fotosMiMascota.add(new ImagenesPetagram(10,R.drawable.pug9patch));
        fotosMiMascota.add(new ImagenesPetagram(4,R.drawable.pug9patch));
        fotosMiMascota.add(new ImagenesPetagram(6,R.drawable.pug9patch));
        fotosMiMascota.add(new ImagenesPetagram(7,R.drawable.pug9patch));
        fotosMiMascota.add(new ImagenesPetagram(15,R.drawable.pug9patch));
        fotosMiMascota.add(new ImagenesPetagram(17,R.drawable.pug9patch));
        fotosMiMascota.add(new ImagenesPetagram(3,R.drawable.pug9patch));
    }

    public void inicializarAdaptadorMiMascota(){
        MiPerfilAdaptador miMascotaAdaptador=new MiPerfilAdaptador(fotosMiMascota,getActivity());
        recyclerViewMiMascota.setAdapter(miMascotaAdaptador);
    }

}
