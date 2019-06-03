package com.example.proyectomovil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;




public class estudiantes extends Fragment {


    private  static final String mURL=Constants.URL +"getESt.php";
    RecyclerView recyclerView;
    StudentAdapter studentAdapter;
    List<Students>studentList;
    int cedula;
    String programa;
    String usuario;
    String nombre ;
    String rol;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_estudiantes, container, false);



        studentList = new ArrayList<>();
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


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
                                JSONObject student = array.getJSONObject(i);
                                cedula = Integer.parseInt(student.getString("cedula"));
                                studentList.add(new Students(cedula, student.getString("nombre"), student.getString("rol"),
                                        student.getString("usuario"), student.getString("programa")));


                                Log.d("nombre", String.valueOf(cedula));
                            }

                            studentAdapter = new StudentAdapter(getActivity(), studentList);
                            recyclerView.setAdapter(studentAdapter);
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


