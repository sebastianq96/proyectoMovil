package com.example.proyectomovil;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button buttonDocente, buttonEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonDocente = (Button) findViewById(R.id.buttonDocente);
        buttonEstudiante = (Button) findViewById(R.id.buttonEstudiante);

//
        buttonDocente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, perfilActivity.class);
                startActivity(intent2);

            }
        });

        buttonEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, PerfilEstudiante.class);
                startActivity(intent3);
            }
        });

    }
}

