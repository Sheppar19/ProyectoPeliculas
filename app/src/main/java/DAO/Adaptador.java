package DAO;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.myapplication2.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import DTO.Pelicula;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderDatos> implements
        View.OnClickListener{
    private ArrayList<Pelicula> listaPeliculas;

    public Adaptador(ArrayList<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    @NonNull
    @Override
    public Adaptador.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.pelicula,null,false);
                ViewHolderDatos  holder = new ViewHolderDatos(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolderDatos holder, int i) {
        holder.nombre.setText("Titulo: "+listaPeliculas.get(i).getNombre());
        holder.autor.setText("Autor: "+listaPeliculas.get(i).getAutor());
        holder.sinopsis.setText("Sinopsis: "+listaPeliculas.get(i).getSinopsis());

        switch(listaPeliculas.get(i).getPuntuacion()){
            case 1:
                holder.estrella1.setChecked(true);
                break;
            case 2:
                holder.estrella1.setChecked(true);
                holder.estrella2.setChecked(true);
                break;
            case 3:
                holder.estrella1.setChecked(true);
                holder.estrella2.setChecked(true);
                holder.estrella3.setChecked(true);
                break;
            case 4:
                holder.estrella1.setChecked(true);
                holder.estrella2.setChecked(true);
                holder.estrella3.setChecked(true);
                holder.estrella4.setChecked(true);
                break;
            case 5:
                    holder.estrella1.setChecked(true);
                    holder.estrella2.setChecked(true);
                    holder.estrella3.setChecked(true);
                    holder.estrella4.setChecked(true);
                    holder.estrella5.setChecked(true);
                    break;
            default:
                holder.estrella1.setChecked(false);
                holder.estrella2.setChecked(false);
                holder.estrella3.setChecked(false);
                holder.estrella4.setChecked(false);
                holder.estrella5.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return listaPeliculas.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder  {
            TextView nombre,autor,sinopsis;
            CheckBox estrella1,estrella2,estrella3,estrella4,estrella5;
            ImageView imageView;
            public ViewHolderDatos(View itemView) {
                super(itemView);
                nombre = itemView.findViewById(R.id.txtNombre);
                autor = itemView.findViewById(R.id.txtAutor);
                sinopsis = itemView.findViewById(R.id.txtSinopsis);
                imageView = itemView.findViewById(R.id.imageView);
                estrella1 = itemView.findViewById(R.id.estrella1);
                estrella2 = itemView.findViewById(R.id.estrella2);
                estrella3 = itemView.findViewById(R.id.estrella3);
                estrella4 = itemView.findViewById(R.id.estrella4);
                estrella5 = itemView.findViewById(R.id.estrella5);
                estrella1.setEnabled(false);
                estrella2.setEnabled(false);
                estrella3.setEnabled(false);
                estrella4.setEnabled(false);
                estrella5.setEnabled(false);



            }
        }

}
