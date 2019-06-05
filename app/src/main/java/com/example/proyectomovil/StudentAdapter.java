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

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private Context mCtx;
    private List<Students> StudentList;

    public StudentAdapter(Context mCtx, List<Students> studentList) {
        this.mCtx = mCtx;
        StudentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater= LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.list_loyout, null);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int i) {
        Students student= StudentList.get(i);
        studentViewHolder.txtNombre.setText(student.getNombre());
        studentViewHolder.txtCedula.setText(String.valueOf(student.getCedula()));
        studentViewHolder.txtPrograma.setText(student.getPrograma());
        studentViewHolder.txtRol.setText(student.getRol());
        studentViewHolder.txtUsuario.setText(student.getUsuario());
        studentViewHolder.img.setImageDrawable(mCtx.getResources().getDrawable(R.drawable.ic_student));
    }

    @Override
    public int getItemCount() {
        return StudentList.size();
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