package com.luisbalam.tareacurso3semana3lb;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Contacto extends AppCompatActivity {

    Toolbar toolBarContacto;
    ImageButton ibEstrella;
    private TextInputEditText editTextNombre;
    private TextInputEditText editTextCorreo;
    private TextInputEditText editTextMensaje;
    private Button botonEnviarMensajeContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        toolBarContacto=(Toolbar) findViewById(R.id.toolBarContacto);
        setSupportActionBar(toolBarContacto);

        ibEstrella=(ImageButton) findViewById(R.id.ibEstrella);
        ibEstrella.setVisibility(View.INVISIBLE);

        editTextNombre=(TextInputEditText) findViewById(R.id.editTextNombre);
        editTextCorreo=(TextInputEditText) findViewById(R.id.editTextCorreo);
        editTextMensaje=(TextInputEditText) findViewById(R.id.editTextMensaje);
        botonEnviarMensajeContacto=(Button) findViewById(R.id.botonEnviarMensajeContacto);

    }

    private void enviarComentario(){
        String nombre=editTextNombre.getText().toString().trim();
        String correo=editTextCorreo.getText().toString().trim();
        String mensaje=editTextMensaje.getText().toString().trim();

        ProcesoEnviar enviarEsteComentario=new ProcesoEnviar(this,correo,nombre,mensaje);

        enviarEsteComentario.execute();
    }

    public void presionarEnviar(View v){
        enviarComentario();
    }

}
