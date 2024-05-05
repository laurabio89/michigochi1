package com.example.michigochi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class comedor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comedor);

        // Iniciar la animación de comer
        ImageView imagencomedor = findViewById(R.id.imagencomedor);
        imagencomedor.setBackgroundResource(R.drawable.michicomiendoanimacion);
        AnimationDrawable michicomiendoanimacion = (AnimationDrawable) imagencomedor.getBackground();
        michicomiendoanimacion.start();

        // Detener la animación después de 3 segundos
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                michicomiendoanimacion.stop();
                // Reiniciar la animación original
                ImageView imagencomedor = findViewById(R.id.imagencomedor);
                imagencomedor.setBackgroundResource(R.drawable.michicomiendoanimacion);
                AnimationDrawable michicomiendoanimacion = (AnimationDrawable) imagencomedor.getBackground();
                michicomiendoanimacion.start();

                // Finalizar la actividad actual
                finish();
            }
        }, 11000); // 3000 milisegundos = 3 segundos
    }
}