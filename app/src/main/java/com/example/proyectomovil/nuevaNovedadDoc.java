package com.example.novedades;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class nuevaNovedadDoc extends AppCompatActivity {

    private EditText id_curso, estadoClase, cambioClase, novedad;
    private Button btnInsertar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_novedad_doc);

        id_curso=(EditText)findViewById(R.id.txtCurso);
        estadoClase=(EditText)findViewById(R.id.txtClase);
        cambioClase=(EditText)findViewById(R.id.txtCambioSalon);
        novedad=(EditText)findViewById(R.id.txtNovedades);
        btnInsertar=(Button)findViewById(R.id.btnEnviar);

        btnInsertar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(!id_curso.getText().toString().trim().equalsIgnoreCase("")||
                        !estadoClase.getText().toString().trim().equalsIgnoreCase("")||
                        !cambioClase.getText().toString().trim().equalsIgnoreCase("")||
                        !novedad.getText().toString().trim().equalsIgnoreCase(""))
                    new nuevaNovedadDoc.Insertar(nuevaNovedadDoc.this).execute();
                else
                    Toast.makeText(nuevaNovedadDoc.this, "Hay información por rellenar", Toast.LENGTH_LONG).show();
            }

        });
    }

    class Insertar extends AsyncTask<String,String,String> {

        private Activity context;

        Insertar(Activity context){
            this.context=context;
        }
        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            if(insertar())
                context.runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        Toast.makeText(context, "Novedad insertada con éxito", Toast.LENGTH_LONG).show();
                        id_curso.setText("");
                        estadoClase.setText("");
                        cambioClase.setText("");
                        novedad.setText("");
                    }
                });
            else
                context.runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        Toast.makeText(context, "Novedad no insertada con éxito", Toast.LENGTH_LONG).show();
                    }
                });
            return null;
        }
    }

    private boolean insertar(){
        HttpClient httpclient;
        List<NameValuePair> nameValuePairs;
        HttpPost httppost;
        httpclient=new DefaultHttpClient();
        httppost= new HttpPost("http://192.168.0.34/insert.php"); // Url del Servidor
        //Añadimos nuestros datos
        nameValuePairs = new ArrayList<NameValuePair>(4);
        nameValuePairs.add(new BasicNameValuePair("id_curso",id_curso.getText().toString().trim()));
        nameValuePairs.add(new BasicNameValuePair("estadoClase",estadoClase.getText().toString().trim()));
        nameValuePairs.add(new BasicNameValuePair("cambioClase",cambioClase.getText().toString().trim()));
        nameValuePairs.add(new BasicNameValuePair("novedad",novedad.getText().toString().trim()));
        try {
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            httpclient.execute(httppost);
            return true;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
}
