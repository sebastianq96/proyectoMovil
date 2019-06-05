package com.example.proyectomovil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class novedadesGenerales extends Fragment {

    private  static final String mURL=Constants.URL +"getNov.php";
    RecyclerView recyclerView;
    NovedadAdapter novedadAdapter;
    List<Novedad> novedadList;
    String cambioSalon, cancelacionClase, recordatorio, salidaCampo;
    double longitud, lactitud;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_novedades_generales, container, false);

        novedadList = new ArrayList<>();
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        loadNovedad();
        return v;
    }

    private void loadNovedad() {
        Log.d("entro", "entro");
        StringRequest stringRequest = new StringRequest(Request.Method.GET, mURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject novedad = array.getJSONObject(i);
                                //cedula = Integer.parseInt(novedad.getString("longitud"));
                                longitud = Double.parseDouble(novedad.getString("longitud"));
                                lactitud =  Double.parseDouble(novedad.getString("lactitud"));
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


