package com.example.proyectomovil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppComponentFactory;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressLint("InlinedApi")
public class descripcionEstudiantes extends Fragment {

    private TextView text;
    private TextView text2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_descripcion_estudiantes, container, false);

        text2 = (TextView) v.findViewById(R.id.label2);
        text = (TextView) v.findViewById(R.id.label);
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
                final Cursos clases = consultar();
                if (clases != null)
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            text.setText(clases.getnombreCurso());
                            text2.setText(clases.getDescripcion());
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

    private Cursos consultar() throws JSONException {

        String url = Constants.URL + "getCurso.php";

        List<NameValuePair> nameValuePairs;
        nameValuePairs = new ArrayList<NameValuePair>(1);
        nameValuePairs.add(new BasicNameValuePair("usuario", "sebastianq"));

        String json = APIHandler.POSTRESPONSE(url, nameValuePairs);
        if (json != null) {
            JSONObject object = new JSONObject(json);
            JSONArray json_array = object.optJSONArray("clases");
            if (json_array.length() > 0) {
                Cursos clases = new Cursos(json_array.getJSONObject(0));
                return clases;
            }
            return null;
        }
        return null;
    }
}

