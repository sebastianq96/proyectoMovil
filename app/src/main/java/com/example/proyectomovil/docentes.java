package com.example.proyectomovil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class docentes extends Fragment {

        private TextView text;
        private TextView text2;
        private TextView text3;
        private TextView text4;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View v = inflater.inflate(R.layout.fragment_docentes, container, false);

            text2 = (TextView) v.findViewById(R.id.labeld2);
            text = (TextView) v.findViewById(R.id.labeld);
            text3 = (TextView) v.findViewById(R.id.labeld3);
            text4 = (TextView) v.findViewById(R.id.labeld4);
            new Consultar(getActivity()).execute();
            return v;
        }

        //-------------------AsyncTask para consultar cursos---------------------------------------------------------------------------------------------
        class Consultar extends AsyncTask<String, String, String> {
            private Activity context;

            Consultar(Activity context) {
                this.context = context;
            }

            protected String doInBackground(String... params) {
                try {
                    final rol profesor = consultar();
                    if (profesor != null)
                        context.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                text.setText(profesor.getNombre());
                                text2.setText("Programa: "+profesor.getPrograma());
                                text3.setText("Cedula: "+profesor.getCedula());
                                text4.setText("Usuario: "+ profesor.getUsuario());
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

            List<NameValuePair> nameValuePairs;
            nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("rol", "profesor"));

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

