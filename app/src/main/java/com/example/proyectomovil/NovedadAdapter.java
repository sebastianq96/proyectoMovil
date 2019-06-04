package com.example.proyectomovil;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NovedadAdapter extends RecyclerView.Adapter<NovedadAdapter.NovedadesViewHolder> {

    private Context mCtx;
    private List<Novedad> NovedadList;

    public NovedadAdapter(Context mCtx, List<Novedad> novedadList) {
        this.mCtx = mCtx;
        NovedadList = novedadList;
    }

    @NonNull
    @Override
    public NovedadAdapter.NovedadesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater= LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.list_loyoutnov, null);
        return new NovedadAdapter.NovedadesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NovedadAdapter.NovedadesViewHolder novedadesViewHolder, int i) {
        Novedad novedad= NovedadList.get(i);
        novedadesViewHolder.txtCambioSalon.setText(novedad.getCambioSalon());
        novedadesViewHolder.txtCancelacionClase.setText(novedad.getCancelacionClase());
        novedadesViewHolder.txtRecordatorio.setText(novedad.getRecordatorio());
        novedadesViewHolder.txtSalidaCampo.setText(novedad.getSalidaCampo());
        novedadesViewHolder.txtLongitud.setText(String.valueOf(novedad.getLongitud()));
        novedadesViewHolder.txtLactitud.setText(String.valueOf(novedad.getLactitud()));
        novedadesViewHolder.img.setImageDrawable(mCtx.getResources().getDrawable(R.drawable.novedadesgenerales));
    }

    @Override
    public int getItemCount() {
        return NovedadList.size();
    }

    class NovedadesViewHolder extends RecyclerView.ViewHolder {
        TextView txtCambioSalon, txtCancelacionClase, txtRecordatorio, txtSalidaCampo, txtLongitud, txtLactitud;
        ImageView img;


        public NovedadesViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCambioSalon=itemView.findViewById(R.id.txtCambioSalon);
            txtCancelacionClase=itemView.findViewById(R.id.txtCancelacionClase);
            txtRecordatorio=itemView.findViewById(R.id.txtRecordatorio);
            txtSalidaCampo=itemView.findViewById(R.id.txtSalidaCampo);
            txtLongitud=itemView.findViewById(R.id.txtLongitud);
            txtLactitud=itemView.findViewById(R.id.txtLactitud);
            img=itemView.findViewById(R.id.imageView);
        }
    }
}
