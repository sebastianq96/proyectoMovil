package com.example.proyectomovil;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringTokenizer;

public class salidasCampoEstudiantes extends Fragment {

    private Button boton;
    private TextView tx1;
    private TextView tx2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_salidas_campo_estudiantes, container, false);
        boton=(Button)v.findViewById(R.id.button);
        tx1=(TextView)v.findViewById(R.id.textView7);
        tx2=(TextView)v.findViewById(R.id.textView6);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.button){
                    IntentIntegrator scanIntegrator= new IntentIntegrator(getActivity());
                    scanIntegrator.initiateScan();
                }
            }
        });
        return v;
    }

    public  void onActivityResult(int requestCode, int resultCode, Intent intent){
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,intent);

        if(scanningResult != null){
            String scanContent = scanningResult.getContents();
            StringTokenizer t = new StringTokenizer(scanContent,"*");
            final String nombre = t.nextToken();
            final String telefono = t.nextToken();
            final String email = t.nextToken();

            tx1.setText(""+nombre);
            tx2.setText(""+telefono);

        }else{
            Toast toast = Toast.makeText(getContext(),"No se han recibido datos del escaneo", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}
