package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Canales> listaCanales;
    RecyclerView recyclerCanales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        construirRecycler();

    }

    private void llenarCanales() {

        listaCanales.add(new Canales(1,"Canal 1","info..",R.drawable.ic_launcher_background));
        listaCanales.add(new Canales(2,"Canal 2","info..",R.drawable.ic_launcher_background));
        listaCanales.add(new Canales(3,"Canal 3","info..",R.drawable.ic_launcher_background));
        listaCanales.add(new Canales(4,"Canal 4","info..",R.drawable.ic_launcher_background));
        listaCanales.add(new Canales(5,"Canal 5","info..",R.drawable.ic_launcher_background));
        listaCanales.add(new Canales(6,"Canal 6","info..",R.drawable.ic_launcher_background));
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnList: List_to_Grid.visualizacion= List_to_Grid.LIST;
                break;
            case R.id.btnGrid: List_to_Grid.visualizacion= List_to_Grid.GRID;
                break;
        }
        construirRecycler();
    }

    private void construirRecycler() {
        listaCanales=new ArrayList<>();
        recyclerCanales= (RecyclerView) findViewById(R.id.RecyclerId);

        if (List_to_Grid.visualizacion== List_to_Grid.LIST){recyclerCanales.setLayoutManager(new LinearLayoutManager(this));}
        else {recyclerCanales.setLayoutManager(new GridLayoutManager(this,3));}

        llenarCanales();
        CanalesAdapter adapter=new CanalesAdapter(listaCanales);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Selección: "+listaCanales.get(recyclerCanales.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_SHORT).show();

            }
        });

        recyclerCanales.setAdapter(adapter);
    }
}