package com.example.proyectomovil;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button bEntrar;
    private Button bIngresar;
    private EditText txtusuario;
    private EditText contrasena;
    private String user;
    private String pass;
    private String rol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtusuario = (EditText)findViewById(R.id.usuario);
        contrasena = (EditText)findViewById(R.id.contrasena);
        bEntrar = (Button)findViewById(R.id.entrar);
        bIngresar=(Button)findViewById(R.id.login);

        //FUNCIÓN, LUEGO DEL LOGGIN QUE ENVIARÁ
        bEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, perfilActivity.class);
                    startActivity(intent);
            }
        });

        bIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              new Consultar(MainActivity.this).execute();

            }
        });


    }


    public void goCreateAccount(View view){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);

    }


    //-------------------AsyncTask para consultar usuario---------------------------------------------------------------------------------------------
    class Consultar extends AsyncTask<String, String, String> {
        private Activity context;

        Consultar(Activity context) {
            this.context = context;
        }

        protected String doInBackground(String... params) {
            try {
                final rol usuario = consultar();
                if (usuario != null) {
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                                user=usuario.getUsuario();
                                pass=usuario.getContrasena();
                                rol=usuario.getRol();
                                Log.d("hola",user);

                        }
                    });
                } else
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, "usuario no encontrado", Toast.LENGTH_LONG).show();
                        }
                    });
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }



    private rol consultar() throws JSONException {

        String url = Constants.URL + "getLogin.php";

        List<NameValuePair> nameValuePairs;
        nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("usuario", txtusuario.getText().toString().trim()));
        nameValuePairs.add(new BasicNameValuePair("contraseña", contrasena.getText().toString().trim()));


        String json = APIHandler.POSTRESPONSE(url, nameValuePairs);
        if (json != null) {
            JSONObject object = new JSONObject(json);
            JSONArray json_array = object.optJSONArray("login");
            if (json_array.length() > 0) {
                rol usuario = new rol(json_array.getJSONObject(0));
                return usuario;
            }
            return null;
        }
        return null;
    }

}

