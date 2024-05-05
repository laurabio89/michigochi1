package com.example.michigochi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class bienvenido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

        // Recuperar el nombre de usuario del Intent
        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");

        // Mostrar el nombre de usuario en el TextView_below
        TextView textViewUsuarioRegistrado = findViewById(R.id.textView_below);
        textViewUsuarioRegistrado.setText("Te has Registrado como " + nombreUsuario);

        // Obtener referencia del botón "Empezar"
        Button buttonEmpezar = findViewById(R.id.buttonEmpezar);

        // Configurar el OnClickListener para el botón "Empezar"
        buttonEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad eligetumichi
                Intent intent = new Intent(bienvenido.this, eligetumichi.class);
                startActivity(intent);
            }
        });
    }
}
