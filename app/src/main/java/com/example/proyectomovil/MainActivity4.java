package com.example.proyectomovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.StringTokenizer;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener{

    private  Button scanBtn, guardar, eliminar, ver;
    private EditText nombreTxt, telefonoTxt, emailTxt, codigoTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        scanBtn = (Button)findViewById(R.id.buton1);
        nombreTxt = (EditText)findViewById(R.id.scan_nombre);
        codigoTxt = (EditText)findViewById(R.id.scan_codigo);

        scanBtn.setOnClickListener(this);

    }

    public  void onActivityResult(int requestCode, int resultCode, Intent intent){
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,intent);

        if(scanningResult != null){
            String scanContent = scanningResult.getContents();
            StringTokenizer t = new StringTokenizer(scanContent,"*");
            final String nombre = t.nextToken();
            final String telefono = t.nextToken();

            nombreTxt.setText(""+nombre);
            codigoTxt.setText(""+telefono);

        }else{
            Toast toast = Toast.makeText(getApplicationContext(),"No se han recibido datos del escaneo", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onClick(View v){
        if(v.getId()==R.id.buton1){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }
}
