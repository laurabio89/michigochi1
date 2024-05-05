package com.example.michigochi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class usuario extends AppCompatActivity {

    private Button buttonIniciarSesion;
    private Button buttonRegistrarse;
    private EditText editTextNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        // Obtener referencias de los elementos
        buttonIniciarSesion = findViewById(R.id.buttonIniciarSesion);
        buttonRegistrarse = findViewById(R.id.buttonRegistrarse);
        editTextNombre = findViewById(R.id.editTextNombre);

        // Configurar listener para el botón de iniciar sesión
        buttonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el nombre de usuario ingresado
                String nombreUsuario = editTextNombre.getText().toString();

                // Iniciar la actividad bienvenido y pasar el nombre de usuario como extra en el Intent
                Intent intent = new Intent(usuario.this, bienvenido.class);
                intent.putExtra("nombreUsuario", nombreUsuario);
                startActivity(intent);
            }
        });

        // Configurar listener para el botón de registrarse
        buttonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(usuario.this, Registrarse.class);
                startActivity(intent);
            }
        });
    }
}
