package com.example.proyectomovil;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
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

public class MainActivity2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private ImageView img;
    private TextView tx1;
    private TextView tx2;
    private TextView tx3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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
        tx1=(TextView)findViewById(R.id.textView2);
        tx2=(TextView)findViewById(R.id.textView3);
        tx3=(TextView)findViewById(R.id.textView4);
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
        getMenuInflater().inflate(R.menu.main_activity2, menu);
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

        if (id == R.id.nav_descripcionEst) {
            fragmentManager.beginTransaction().replace(R.id.contenedor,new descripcionEstudiantes()).commit();
            img.setVisibility(View.INVISIBLE);
            tx1.setVisibility(View.INVISIBLE);
            tx2.setVisibility(View.INVISIBLE);
            tx3.setVisibility(View.INVISIBLE);

        } else if (id == R.id.nav_docentes) {
            fragmentManager.beginTransaction().replace(R.id.contenedor,new docentes()).commit();
            img.setVisibility(View.INVISIBLE);
            tx1.setVisibility(View.INVISIBLE);
            tx2.setVisibility(View.INVISIBLE);
            tx3.setVisibility(View.INVISIBLE);

        } else if (id == R.id.nav_novedadesEst) {
            fragmentManager.beginTransaction().replace(R.id.contenedor,new novedadesEstudiantes()).commit();
            img.setVisibility(View.INVISIBLE);
            tx1.setVisibility(View.INVISIBLE);
            tx2.setVisibility(View.INVISIBLE);
            tx3.setVisibility(View.INVISIBLE);

        } else if (id == R.id.nav_salidasDeCampoEst) {
            fragmentManager.beginTransaction().replace(R.id.contenedor,new salidasCampoEstudiantes()).commit();
            img.setVisibility(View.INVISIBLE);
            tx1.setVisibility(View.INVISIBLE);
            tx2.setVisibility(View.INVISIBLE);
            tx3.setVisibility(View.INVISIBLE);

        } else if (id == R.id.nav_eventosEst) {
            fragmentManager.beginTransaction().replace(R.id.contenedor,new eventoExterno()).commit();
            img.setVisibility(View.INVISIBLE);
            tx1.setVisibility(View.INVISIBLE);
            tx2.setVisibility(View.INVISIBLE);
            tx3.setVisibility(View.INVISIBLE);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
