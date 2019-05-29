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
public class novedadesEstudiantes extends Fragment {

    private TextView text;
    private TextView text2;
    private TextView text3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_novedades_estudiantes, container, false);

        text2 = (TextView) v.findViewById(R.id.Lbn);
        text = (TextView) v.findViewById(R.id.Lbn2);
        text3 = (TextView) v.findViewById(R.id.Lbn3);
        new Consultar(getActivity()).execute();
        return v;
    }
    //-------------------AsyncTask para consultar Novedades---------------------------------------------------------------------------------------------
    class Consultar extends AsyncTask<String, String, String> {
        private Activity context;

        Consultar(Activity context) {
            this.context = context;
        }

        protected String doInBackground(String... params) {
            try {
                final Novedades novedades = consultar();
                if (novedades != null)
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            text.setText(novedades.getRecordatorio());
                            text2.setText(novedades.getCambioSalon());
                            text3.setText(novedades.getCancelacionClase());
                        }
                    });
                else
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, "Pago no encontrado", Toast.LENGTH_LONG).show();
                        }
                    });
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private Novedades consultar() throws JSONException {

        String url = Constants.URL + "getNovedades.php";

        List<NameValuePair> nameValuePairs;
        nameValuePairs = new ArrayList<NameValuePair>(1);
        nameValuePairs.add(new BasicNameValuePair("id_novedades", "jhordanres"));

        String json = APIHandler.POSTRESPONSE(url, nameValuePairs);
        if (json != null) {
            JSONObject object = new JSONObject(json);
            JSONArray json_array = object.optJSONArray("novedades");
            if (json_array.length() > 0) {
                Novedades novedades = new Novedades(json_array.getJSONObject(0));
                return novedades;
            }
            return null;
        }
        return null;
    }

}