package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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

        listaCanales.add(new Canales(1, "Canal 1", "info..", R.drawable.ic_launcher_background));
        listaCanales.add(new Canales(2, "Canal 2", "info..", R.drawable.ic_launcher_background));
        listaCanales.add(new Canales(3, "Canal 3", "info..", R.drawable.ic_launcher_background));
        listaCanales.add(new Canales(4, "Canal 4", "info..", R.drawable.ic_launcher_background));
        listaCanales.add(new Canales(5, "Canal 5", "info..", R.drawable.ic_launcher_background));
        listaCanales.add(new Canales(6, "Canal 6", "info..", R.drawable.ic_launcher_background));
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnList:
                List_to_Grid.visualizacion = List_to_Grid.LIST;
                break;
            case R.id.btnGrid:
                List_to_Grid.visualizacion = List_to_Grid.GRID;
                break;
        }
        construirRecycler();
    }

    private void construirRecycler() {
        listaCanales = new ArrayList<>();
        recyclerCanales = (RecyclerView) findViewById(R.id.RecyclerId);

        if (List_to_Grid.visualizacion == List_to_Grid.LIST) {
            recyclerCanales.setLayoutManager(new LinearLayoutManager(this));
        } else {
            recyclerCanales.setLayoutManager(new GridLayoutManager(this, 3));
        }

        llenarCanales();

        /**
         * Si deseas controlar los clicks de tu recyclerview con el objeto seleccionado descomenta esta seccion
         */
        CanalesAdapter adapter = new CanalesAdapter(listaCanales, canal -> {
            switch (canal.getId()) {
                case 1:
                    startActivity(new Intent(MainActivity.this, Canal_1.class));
                    break;
                case 2:
                    Toast.makeText(this, "Canal 2 selected", Toast.LENGTH_SHORT).show();
                    //Inicias una actividad con el canal con id = 2
                    break;
                case 3:
                    Toast.makeText(this, "Canal 3 selected", Toast.LENGTH_SHORT).show();
                    //Inicias una actividad con el canal con id = 3
                    break;
                case 4:
                    Toast.makeText(this, "Canal 4 selected", Toast.LENGTH_SHORT).show();
                    //Inicias una actividad con el canal con id = 4
                    break;
                default:
                    Toast.makeText(this, "Canal X selected", Toast.LENGTH_SHORT).show();
                    //Inicias una actividad por defecto en caso no coincida con ningun id
                    break;
            }
        });

/**
 * Si deseas controlar los clicks en tu recyclerview por la posicion del items descomenta la seccion de abajo y comenta la de arriba
  */
//        CanalesAdapter adapter = new CanalesAdapter(listaCanales, itemPosition -> {
//            switch (itemPosition) {
//                case 0:
//                    startActivity(new Intent(MainActivity.this, Canal_1.class));
//                    break;
//                case 1:
//                    break;
//                case 2:
//                    break;
//                case 3:
//                    break;
//            }
//        });

        recyclerCanales.setAdapter(adapter);
    }
}