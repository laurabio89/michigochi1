package com.example.michigochi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class nombremichi extends AppCompatActivity {

    private TextInputEditText editornombre;
    private Button empezar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombremichi);

        editornombre = findViewById(R.id.editornombre);
        empezar = findViewById(R.id.empezar);

        // Verificar si hay un nombre guardado en SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MiPref", Context.MODE_PRIVATE);
        String nombreGuardado = sharedPreferences.getString("nombre", "");
        if (!nombreGuardado.isEmpty()) {
            // Si hay un nombre guardado, abrir la actividad donde se muestra el nombre
            Intent intent = new Intent(this, juegoprincipal.class);
            startActivity(intent);
            finish();
        }

        empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editornombre.getText().toString().trim();
                if (!nombre.isEmpty()) {
                    // Guardar el nombre en SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("nombre", nombre);
                    editor.apply();

                    Intent intent = new Intent(nombremichi.this, juegoprincipal.class);
                    intent.putExtra("nombre", nombre);
                    startActivity(intent);
                } else {
                    Toast.makeText(nombremichi.this, "Por favor ingresa un nombre", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Botón "Done" en la barra de poner nombre al michi
        editornombre.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // Ocultar el teclado virtual
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editornombre.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });
    }
}