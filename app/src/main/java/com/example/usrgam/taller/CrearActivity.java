package com.example.usrgam.taller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import modelo.Items;

public class CrearActivity extends AppCompatActivity {

    EditText nombre;
    EditText marca;
    EditText color;
    EditText valor;
    EditText talla;
    Items item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        nombre = (EditText) findViewById(R.id.textNombre);
        marca = (EditText) findViewById(R.id.textMarca);
        color = (EditText) findViewById(R.id.textColor);
        valor = (EditText) findViewById(R.id.textValor);
        talla = (EditText) findViewById(R.id.textTalla);
    }

    public void Guardar(View v) {
        String nom = nombre.getText().toString();
        String mar = nombre.getText().toString();
        String col = nombre.getText().toString();
        String val = nombre.getText().toString();
        String tal = nombre.getText().toString();
        item = new Items(nom, mar, col, val, tal);

        if(nom.equals("") && mar.equals("") && col.equals("") && val.equals("") && tal.equals("")) {
            Toast.makeText(getApplicationContext(), "LLENE TODO LOS CAMPOS", Toast.LENGTH_LONG).show();
        }
        else {
        }
    }
}
