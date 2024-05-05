package com.example.michigochi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class eligetumichi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligetumichi);

        ImageButton michi1, michi2;
        michi1 = (ImageButton) findViewById(R.id.michi1);
        michi2 = (ImageButton) findViewById(R.id.michi2);

        michi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(eligetumichi.this, nombremichi.class);
                startActivity(i);
            }
        });

    }
}