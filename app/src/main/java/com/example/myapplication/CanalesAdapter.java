package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CanalesAdapter extends RecyclerView.Adapter<CanalesAdapter.ViewHolderCanales> {

    ArrayList<Canales> listaCanales;
    OnCanalesClick onCanalesClick;

    public CanalesAdapter(ArrayList<Canales> listaCanales, OnCanalesClick onCanalesClick) {
        this.listaCanales = listaCanales;
        this.onCanalesClick = onCanalesClick;
    }

    @Override
    public ViewHolderCanales onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout=0;
        if (List_to_Grid.visualizacion== List_to_Grid.LIST){
            layout=R.layout.item_list;
        }else {
            layout=R.layout.item_grid;
        }

        View view= LayoutInflater.from(parent.getContext()).inflate(layout,null,false);

        return new ViewHolderCanales(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderCanales holder, int position) {
        holder.etiNombre.setText(listaCanales.get(position).getNombre());

        if (List_to_Grid.visualizacion== List_to_Grid.LIST){
            holder.etiInformacion.setText(listaCanales.get(position).getInfo());
        }

        holder.foto.setImageResource(listaCanales.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaCanales.size();
    }

    public class ViewHolderCanales extends RecyclerView.ViewHolder {

        TextView etiNombre,etiInformacion;
        ImageView foto;

        public ViewHolderCanales(View itemView) {
            super(itemView);
            itemView.setOnClickListener(view -> onCanalesClick.onClick(listaCanales.get(getAdapterPosition())));
            etiNombre= (TextView) itemView.findViewById(R.id.idNombre);
            if (List_to_Grid.visualizacion== List_to_Grid.LIST){
                etiInformacion= (TextView) itemView.findViewById(R.id.idInfo);
            }
            foto= (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}