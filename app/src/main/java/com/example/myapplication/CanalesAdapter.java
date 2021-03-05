package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CanalesAdapter extends RecyclerView.Adapter<CanalesAdapter.ViewHolderCanales> implements View.OnClickListener{

    ArrayList<Canales> listaCanales;
    private View.OnClickListener listener;

    public CanalesAdapter(ArrayList<Canales> listaCanales) {
        this.listaCanales = listaCanales;
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

        view.setOnClickListener(this);

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

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderCanales extends RecyclerView.ViewHolder {

        TextView etiNombre,etiInformacion;
        ImageView foto;

        public ViewHolderCanales(View itemView) {
            super(itemView);
            etiNombre= (TextView) itemView.findViewById(R.id.idNombre);
            if (List_to_Grid.visualizacion== List_to_Grid.LIST){
                etiInformacion= (TextView) itemView.findViewById(R.id.idInfo);
            }
            foto= (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}