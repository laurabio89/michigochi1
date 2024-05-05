package com.example.michigochi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class bano extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bano);

        // Iniciar la animación de baño
        ImageView imagenburbuja = findViewById(R.id.imagenburbuja);
        imagenburbuja.setBackgroundResource(R.drawable.burbujas);
        AnimationDrawable burbujas = (AnimationDrawable) imagenburbuja.getBackground();
        burbujas.start();

        // Detener la animación después de 3 segundos
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                burbujas.stop();
                // Reiniciar la animación original
                ImageView imagenburbuja = findViewById(R.id.imagenburbuja);
                imagenburbuja.setBackgroundResource(R.drawable.burbujas);
                AnimationDrawable burbujas = (AnimationDrawable) imagenburbuja.getBackground();
                burbujas.start();

                // Finalizar la actividad actual
                finish();
            }
        }, 5000); // 11000 milisegundos = 11 segundos
    }
}
