package com.example.proyectomovil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("InlinedApi")
public class novedadesEstudiantes extends Fragment {

    private TextView text;
    private TextView text2;
    private TextView text3;
    private double longitud;
    private double lactitud;


    private static final String mURL = Constants.URL + "getNov.php";
    RecyclerView recyclerView;
    NovedadAdapter novedadAdapter;
    List<Novedad> novedadList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_novedades_estudiantes, container, false);


        loadStudent();
        return v;
    }

    private void loadStudent() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, mURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject novedad = array.getJSONObject(i);
                                longitud = Double.parseDouble(novedad.getString("longitud"));
                                lactitud = Double.parseDouble(novedad.getString("longitud"));
                                novedadList.add(new Novedad(novedad.getString("cambioSalon"), novedad.getString("cancelacionClase"),
                                        novedad.getString("recordatorio"), novedad.getString("salidaCampo"), longitud, lactitud));

                            }

                            novedadAdapter = new NovedadAdapter(getActivity(), novedadList);
                            recyclerView.setAdapter(novedadAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(getContext()).add(stringRequest);


    }
}