package com.example.proyectomovil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("InlinedApi")
public class MainActivity3 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private ImageView img;
    private TextView tx1;
    private TextView tx2;
    private TextView tx3;
    private TextView tx4;
    String usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        img=(ImageView)findViewById(R.id.imageView5);
        img.setImageResource(R.drawable.profesor);
        tx1=(TextView)findViewById(R.id.textView2);
        tx2=(TextView)findViewById(R.id.textView3);
        tx3=(TextView)findViewById(R.id.textView4);
        tx4=(TextView)findViewById(R.id.textView5);

        new Consultar(this).execute();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.nav_descripcionDoc) {
            fragmentManager.beginTransaction().replace(R.id.contenedor,new descripcionDocente()).commit();
            img.setVisibility(View.INVISIBLE);
            tx1.setVisibility(View.INVISIBLE);
            tx2.setVisibility(View.INVISIBLE);
            tx3.setVisibility(View.INVISIBLE);
            tx4.setVisibility(View.INVISIBLE);
        } else if (id == R.id.nav_estudiantes) {
            fragmentManager.beginTransaction().replace(R.id.contenedor,new estudiantes()).commit();
            img.setVisibility(View.INVISIBLE);
            tx1.setVisibility(View.INVISIBLE);
            tx2.setVisibility(View.INVISIBLE);
            tx3.setVisibility(View.INVISIBLE);
            tx4.setVisibility(View.INVISIBLE);
        } else if (id == R.id.nav_salidasDeCampoDoc) {
            fragmentManager.beginTransaction().replace(R.id.contenedor,new salidasCampoDocentes()).commit();
            img.setVisibility(View.INVISIBLE);
            tx1.setVisibility(View.INVISIBLE);
            tx2.setVisibility(View.INVISIBLE);
            tx3.setVisibility(View.INVISIBLE);
            tx4.setVisibility(View.INVISIBLE);
        } else if (id == R.id.nav_novedadesDoc) {
            Intent intent3 = new Intent(MainActivity3.this, nuevaNovedadDoc.class);
            startActivity(intent3);
            img.setVisibility(View.INVISIBLE);
            tx1.setVisibility(View.INVISIBLE);
            tx2.setVisibility(View.INVISIBLE);
            tx3.setVisibility(View.INVISIBLE);
            tx4.setVisibility(View.INVISIBLE);
        } else if (id == R.id.nav_novedadesGen) {
            fragmentManager.beginTransaction().replace(R.id.contenedor,new novedadesGenerales()).commit();
            img.setVisibility(View.INVISIBLE);
            tx1.setVisibility(View.INVISIBLE);
            tx2.setVisibility(View.INVISIBLE);
            tx3.setVisibility(View.INVISIBLE);
            tx4.setVisibility(View.INVISIBLE);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //-------------------AsyncTask para consultar cursos---------------------------------------------------------------------------------------------
    class Consultar extends AsyncTask<String, String, String> {
        private Activity context;

        Consultar(Activity context) {
            this.context = context;
        }

        protected String doInBackground(String... params) {
            try {
                final rol docente = consultar();
                if (docente != null)
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            tx1.setText(docente.getNombre());
                            tx2.setText("Programa: "+docente.getPrograma());
                            tx3.setText("Cedula: "+docente.getCedula());
                            tx4.setText("Usuario: "+ docente.getUsuario());
                        }
                    });
                else
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, "clase no encontrado", Toast.LENGTH_LONG).show();
                        }
                    });
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private rol consultar() throws JSONException {

        String url = Constants.URL + "getDocente.php";
        usuario = getIntent().getStringExtra("usuario");
        //Log.d("userioooo",usuario);
        List<NameValuePair> nameValuePairs;
        nameValuePairs = new ArrayList<NameValuePair>(1);
        nameValuePairs.add(new BasicNameValuePair("usuario", usuario));

        String json = APIHandler.POSTRESPONSE(url, nameValuePairs);
        if (json != null) {
            JSONObject object = new JSONObject(json);
            JSONArray json_array = object.optJSONArray("profesor");
            if (json_array.length() > 0) {
                rol profesor = new rol(json_array.getJSONObject(0));
                return profesor;
            }
            return null;
        }
        return null;
    }
}

