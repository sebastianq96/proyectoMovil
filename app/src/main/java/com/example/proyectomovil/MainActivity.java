package com.example.proyectomovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bEntrar = (Button)findViewById(R.id.entrar);

        //FUNCIÓN, LUEGO DEL LOGGIN QUE ENVIARÁ
        bEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String log, pass;
                log = textUsuario.getText().toString();
                pass = textContrasena.getText().toString();

                if(log.equals("admin") && pass.equals("12345")){
                 */   //Pasar a siguiente interfaz
                    Intent intent = new Intent(MainActivity.this, perfilActivity.class);
                    startActivity(intent);
                /*}
                else {
                    textUsuario.setText("");
                    textContrasena.setText("");
                }*/
            }
        });
    }


    public void goCreateAccount(View view){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);

    }
}
