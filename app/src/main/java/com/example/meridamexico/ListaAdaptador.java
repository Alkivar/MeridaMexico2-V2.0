package com.example.meridamexico;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaAdaptador  extends RecyclerView.Adapter<ListaAdaptador.viewHolder>{

    ArrayList<Informacion> listadeDatos;

    public ListaAdaptador(ArrayList<Informacion> listadeDatos) {
        this.listadeDatos = listadeDatos;
    }

    @NonNull
    @Override
    public ListaAdaptador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View VistaItemLista= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista,parent,false);

        return new viewHolder(VistaItemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAdaptador.viewHolder holder, int position) {
        holder.ActualizarDatos(listadeDatos.get(position));

    }

    @Override
    public int getItemCount() {

        return listadeDatos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView NombreLugar;
        ImageView Fotos;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            NombreLugar=itemView.findViewById(R.id.nombrepueblo);
            Fotos=itemView.findViewById(R.id.imagenperfil);
//            descripcion=itemView.findViewById(R.id.descripcion);
        }

        public void ActualizarDatos(Informacion informacion) {
            NombreLugar.setText(informacion.getNombreLugar());
            //Fotos.setImageResource(informacion.getFotos());
//            descripcion.setText(informacion.getDescripcion());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent1 = new Intent(itemView.getContext(),MasInformacion.class);
                    intent1.putExtra( "DatosMexico",informacion);
                    itemView.getContext().startActivity(intent1);
                }
            });
        }
    }
}
