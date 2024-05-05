package com.example.michigochi;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class juegoprincipal extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegoprincipal);

        // Iniciar la animación
        ImageView imageView2 = findViewById(R.id.imageView2);
        imageView2.setBackgroundResource(R.drawable.animacion);
        AnimationDrawable animacion = (AnimationDrawable) imageView2.getBackground();
        animacion.start();

        // Obtener el texto pasado en el Intent
        String nombre = getIntent().getStringExtra("nombre");

        // Mostrar el nombre en el TextView
        TextView nombreelegido = findViewById(R.id.nombreelegido);
        nombreelegido.setText("-" + nombre);

        // Configurar el OnClickListener para el botón botonmimo
        ImageButton botonMimo = findViewById(R.id.botonmimo);
        botonMimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la animación de mimo
                ImageView imageView2 = findViewById(R.id.imageView2);
                imageView2.setBackgroundResource(R.drawable.animacionmimo);
                AnimationDrawable animacionmimo = (AnimationDrawable) imageView2.getBackground();
                animacionmimo.start();

                // Detener la animación después de 3 segundos
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        animacionmimo.stop();
                        // Reiniciar la animación original
                        imageView2.setBackgroundResource(R.drawable.animacion);
                        AnimationDrawable animacion = (AnimationDrawable) imageView2.getBackground();
                        animacion.start();
                    }
                }, 3000); // 3000 milisegundos = 3 segundos
            }
        });

        // Configurar OnClickListener para el botón de comida (imageButton2)
        ImageButton imageButton2 = findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad del comedor
                Intent i = new Intent(juegoprincipal.this, comedor.class);
                startActivity(i);
            }
        });

        // Configurar OnClickListener para el botón de baño (imagenburbuja)
        ImageButton imagenburbuja = findViewById(R.id.imagenburbuja);
        imagenburbuja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad del baño
                Intent i = new Intent(juegoprincipal.this, bano.class);
                startActivity(i);
            }
        });

        // Configurar OnClickListener para el botón imageButton4
        ImageButton imageButton4 = findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad del juego
                Intent i = new Intent(juegoprincipal.this, MainActivity.class);
                startActivity(i);
            }
        });

        // Iniciar música
        mediaPlayer = MediaPlayer.create(this, R.raw.musica);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Detener música y liberar recursos cuando la actividad se destruye
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}