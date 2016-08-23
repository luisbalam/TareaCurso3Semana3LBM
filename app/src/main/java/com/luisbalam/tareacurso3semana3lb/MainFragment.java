package com.luisbalam.tareacurso3semana3lb;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements IMainFragment {


    public MainFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerMain;
    ArrayList<ImagenesPetagram> datosMascotas;
    MainFragmentPresentador mainFragmentPresentador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_main, container, false);

        recyclerMain= (RecyclerView) v.findViewById(R.id.recyclerMain);

        mainFragmentPresentador=new MainFragmentPresentador(this,getContext());

        //asigDatos();
        //crearAdaptador();

        return v;
    }

    /*public void asigDatos (){
        datosMascotas = new ArrayList<ImagenesPetagram>();
        datosMascotas.add(new ImagenesPetagram("Bruno",R.drawable.pug9patch,19));
        datosMascotas.add(new ImagenesPetagram("El pulgas",R.drawable.pulgoso9patch,12));
        datosMascotas.add(new ImagenesPetagram("Zanahorias",R.drawable.conejito9patch,7));
        datosMascotas.add(new ImagenesPetagram("El largirucho",R.drawable.salchicha9path,10));
        datosMascotas.add(new ImagenesPetagram("Wiskas",R.drawable.gato9patch,8));
        datosMascotas.add(new ImagenesPetagram("Rambito",R.drawable.perritodurmiendo9patch,15));
        datosMascotas.add(new ImagenesPetagram("El tristón",R.drawable.perrotriste9patch,5));
        datosMascotas.add(new ImagenesPetagram("Wiskas Jr",R.drawable.gatito9patch,13));
    }*/

    public ImagenesPetagramAdapter crearAdaptador (ArrayList<ImagenesPetagram> imagenesMascotas) {
        ImagenesPetagramAdapter adaptadorMascotas = new ImagenesPetagramAdapter(imagenesMascotas,getActivity());
        return adaptadorMascotas;
    }

    @Override
    public void inicializarAdaptador(ImagenesPetagramAdapter imagenesPetagramAdapter) {
        recyclerMain.setAdapter(imagenesPetagramAdapter);
    }

    @Override
    public void inicializarLayoutManager() {
        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerMain.setLayoutManager(llm);

    }

}
