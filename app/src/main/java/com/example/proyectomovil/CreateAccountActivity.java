package com.example.proyectomovil;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText idUsuario;
    private EditText nombre;
    private EditText programa;
    private EditText materia;
    private EditText usuario;
    private EditText contrasena;
    private Button unete;
   // private List<usuarios> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        idUsuario = (EditText)findViewById(R.id.cedula);
        nombre = (EditText)findViewById(R.id.name);
        programa = (EditText)findViewById(R.id.programa);
        materia = (EditText)findViewById(R.id.materia);
        usuario = (EditText)findViewById(R.id.usuario);
        contrasena = (EditText)findViewById(R.id.contrasena);
        unete = (Button)findViewById(R.id.joinUp);

        //----------- (Botón) Insertar los datos de la persona ----------------------
        unete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!idUsuario.getText().toString().trim().equalsIgnoreCase("")||
                        !nombre.getText().toString().trim().equalsIgnoreCase("")||
                        !programa.getText().toString().trim().equalsIgnoreCase("")||
                        !materia.getText().toString().trim().equalsIgnoreCase("")||
                        !usuario.getText().toString().trim().equalsIgnoreCase("")||
                        !contrasena.getText().toString().trim().equalsIgnoreCase(""))

                    new Insertar (CreateAccountActivity.this).execute();
                else
                    Toast.makeText(CreateAccountActivity.this, "Falta información por llenar", Toast.LENGTH_LONG).show();
            }
        });

    }

    //----------------- Función INSERTAR --------------------------------------

    class Insertar extends AsyncTask<String,String,String>{

        private Activity context;

        Insertar(Activity context){this.context=context;}
        @Override
        protected String doInBackground(String... strings) {
            if(insertar())
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "Usuario insertado con éxito", Toast.LENGTH_LONG).show();
                    }
                });
            else
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "Usuario no insertado con éxito", Toast.LENGTH_LONG).show();
                    }
                });
            return null;
        }
    }

    //------------------ Insertar los datos en el servidor --------------------
    private boolean insertar(){
        HttpClient httpclient;
        List<NameValuePair> nameValuePairs;
        HttpPost httppost;
        httpclient=new DefaultHttpClient();
        httppost= new HttpPost("http://172.16.9.81/insert.php"); // Url del Servidor
        nameValuePairs = new ArrayList<NameValuePair>(6);
        nameValuePairs.add(new BasicNameValuePair("idUsuario",idUsuario.getText().toString().trim()));
        nameValuePairs.add(new BasicNameValuePair("nombre",nombre.getText().toString().trim()));
        nameValuePairs.add(new BasicNameValuePair("programa",programa.getText().toString().trim()));
        nameValuePairs.add(new BasicNameValuePair("materia",materia.getText().toString().trim()));
        nameValuePairs.add(new BasicNameValuePair("usuario",usuario.getText().toString().trim()));
        nameValuePairs.add(new BasicNameValuePair("contrasena",contrasena.getText().toString().trim()));

        try{
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            httpclient.execute(httppost);
            return true;
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        } catch (ClientProtocolException e){
            e.printStackTrace();;
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

}
