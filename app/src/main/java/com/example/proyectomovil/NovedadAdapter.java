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

public class NovedadAdapter extends RecyclerView.Adapter<NovedadAdapter.StudentViewHolder> {

    private Context mCtx;
    private List<Novedad> novedadList;

    public NovedadAdapter(Context mCtx, List<Novedad> novedadList) {
        this.mCtx = mCtx;
        novedadList = novedadList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater= LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.list_loyout_n, null);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int i) {
        Novedad novedad= novedadList.get(i);
        studentViewHolder.txtNombre.setText(novedad.getCambioSalon());
        studentViewHolder.txtCedula.setText(String.valueOf(novedad.getLactitud()));
        studentViewHolder.txtCedula.setText(String.valueOf(novedad.getLongitud()));
        studentViewHolder.txtPrograma.setText(novedad.getRecordatorio());
        studentViewHolder.txtRol.setText(novedad.getCancelacionClase());
        studentViewHolder.txtUsuario.setText(novedad.getSalidaCampo());
        studentViewHolder.img.setImageDrawable(mCtx.getResources().getDrawable(R.drawable.novedades));
    }

    @Override
    public int getItemCount() {
        return novedadList.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView txtCedula, txtNombre, txtPrograma, txtUsuario,txtRol;
        ImageView img;


        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCedula=itemView.findViewById(R.id.textViewCedula);
            txtNombre=itemView.findViewById(R.id.textViewNombre);
            txtRol=itemView.findViewById(R.id.textViewRol);
            txtPrograma=itemView.findViewById(R.id.textViewPrograma);
            txtUsuario=itemView.findViewById(R.id.textViewUsuario);
            img=itemView.findViewById(R.id.imageView);
        }
    }
}



