package com.example.usrgam.taller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

import modelo.Items;

public class ListaActivity extends AppCompatActivity {

    ListView listaI;
    ArrayAdapter<Items> adaptador;
    ArrayList<Items> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listaI = (ListView) findViewById(R.id.listaItems);
        list = new ArrayList<Items>();
        cargarLista();
        adaptador = new ArrayAdapter<Items>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, list);
        listaI.setAdapter(adaptador);

        listaI.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                abrirMenu(view, i);
            }
        });
    }

    public void abrirPantallaCodigo(View v) {
        Intent intento = new Intent(getApplicationContext(), CodigoActivity.class);
        startActivity(intento);
    }

    public void abrirMenu(View v, final int j) {
        PopupMenu menuPopupMenu = new PopupMenu(this, v);
        menuPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.itemVer:
                        Intent intento = new Intent(getApplicationContext(), VerActivity.class);
                        intento.putExtra("idZapato", list.get(j));
                        startActivity(intento);
                        return true;
                    case R.id.itemModificar:
                        Toast.makeText(getApplicationContext(), "comparar producto", Toast.LENGTH_LONG);
                        return true;
                    case R.id.itemEliminar:
                        Toast.makeText(getApplicationContext(), "comparar producto", Toast.LENGTH_LONG);
                        return true;
                }
                return false;
            }
        });
        menuPopupMenu.inflate(R.menu.pop_menu_principal);
        menuPopupMenu.show();
    }

    public void cargarLista() {
        list.add(new Items("ZAPATO 1", "MARCA 1", "BLANCO", "50", "8"));
        list.add(new Items("ZAPATO 2", "MARCA 2", "NEGRO", "32", "7"));
        list.add(new Items("ZAPATO 3", "MARCA 3", "CAFE", "45", "9"));
        list.add(new Items("ZAPATO 4", "MARCA 4", "ROJO", "65", "7"));
        list.add(new Items("ZAPATO 5", "MARCA 5", "AZUL", "35", "8"));
    }
}
