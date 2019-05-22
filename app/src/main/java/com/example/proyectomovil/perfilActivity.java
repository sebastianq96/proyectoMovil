package com.example.proyectomovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class perfilActivity extends AppCompatActivity {

    private Button buttonAdministrador, buttonDocente, buttonEstudiante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        buttonAdministrador = (Button)findViewById(R.id.buttonAdministrador);
        buttonDocente = (Button)findViewById(R.id.buttonDocente);
        buttonEstudiante = (Button)findViewById(R.id.buttonEstudiante);

//        buttonAdministrador.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1 = new Intent(perfilActivity.this, MainActivity2.class);
//                startActivity(intent1);
//            }
//        });
//
//        buttonDocente.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2 = new Intent(perfilActivity.this, MainActivity2.class);
//                startActivity(intent2);
//            }
//        });

        buttonEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(perfilActivity.this, MainActivity2.class);
                startActivity(intent3);
            }
        });

    }
}
