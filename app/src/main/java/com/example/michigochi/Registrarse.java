package com.example.michigochi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registrarse extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextContraseña;
    private Button buttonRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        // Obtener referencias de los EditText y Button
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextContraseña = findViewById(R.id.editTextContraseña);
        buttonRegistrar = findViewById(R.id.buttonRegistrar);

        // Agregar listener al botón Registrar
        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener nombre y contraseña ingresados
                String nombre = editTextNombre.getText().toString();
                String contraseña = editTextContraseña.getText().toString();

                // Insertar usuario en la base de datos
                DatabaseHelper dbHelper = new DatabaseHelper(Registrarse.this);
                boolean insertado = dbHelper.addUser(nombre, contraseña);

                // Mostrar mensaje según el resultado de la inserción
                if (insertado) {
                    // Usuario registrado con éxito
                    finish(); // Finalizar la actividad de registro
                } else {
                    // Error al registrar usuario
                }
            }
        });
    }
}