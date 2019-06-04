package com.example.proyectomovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class PerfilEstudiante extends AppCompatActivity {

    private Button bIngresar;
    private EditText txtusuario;
    private EditText contrasena;
    private String user;
    private String pass;
    private String rol;

    JsonRequest jrq;
    RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_estudiante);
        txtusuario = (EditText) findViewById(R.id.usuario);
        contrasena = (EditText) findViewById(R.id.contrasena);
        bIngresar = (Button) findViewById(R.id.login);

        rq = Volley.newRequestQueue(this);

    //FUNCIÓN, LUEGO DEL LOGGIN QUE ENVIARÁ

        bIngresar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            iniciarSesionProfe();
        }
    });
}

    private void iniciarSesionProfe() {
        StringRequest request = new StringRequest(Request.Method.POST, Constants.URL + "sesion2.php"
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.contains("1")) {
                    Intent intent = new Intent( getApplicationContext(), MainActivity2.class);
                    intent.putExtra("usuario", txtusuario.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Error en contraseña o nombre de usuario", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", txtusuario.getText().toString());
                params.put("password", contrasena.getText().toString());
                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);
    }

}