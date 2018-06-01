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

import modelo.Items;

public class ListaActivity extends AppCompatActivity {

    ListView listaI;
    ArrayAdapter<Items> adaptador;
    Items [] datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listaI = (ListView) findViewById(R.id.listaItems);
        cargarLista();
        adaptador = new ArrayAdapter<Items>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, datos);
        listaI.setAdapter(adaptador);

        listaI.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                //Intent intento = new Intent(getApplicationContext(), Main3Activity.class);
                //intento.putExtra("idItems", datos[i]);
                //startActivity(intento);
                abrirMenu(view, i);

            }
        });
    }

    public void abrirMenu(View v, final int j) {
        PopupMenu menuPopupMenu = new PopupMenu(this, v);
        menuPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.itemVer:
                        Intent intento = new Intent(getApplicationContext(), Main3Activity.class);
                        intento.putExtra("idZapato", datos[j]);
                        startActivity(intento);
                        //Toast.makeText(getApplicationContext(), "ver producto", Toast.LENGTH_LONG);
                        return true;
                    case R.id.itemComprar:
                        Toast.makeText(getApplicationContext(), "comprar producto", Toast.LENGTH_LONG);
                        return true;
                    case R.id.itemModificar:
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
        datos = new Items[]{new Items("ZAPATO1", "marca1", "blanco", "25", "7"),
                new Items("ZAPATO2", "marca2", "blanco", "60", "6"),
                new Items("ZAPATO3", "marca3", "rojo", "58", "8"),
                new Items("ZAPATO4", "marca4", "negro", "96", "6"),
                new Items("ZAPATO5", "marca5", "verde", "85", "9"),
                new Items("ZAPATO6", "marca6", "cafe", "84", "5"),
                new Items("ZAPATO7", "marca7", "azul", "65", "4")};
    }
}
