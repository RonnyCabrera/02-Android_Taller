package com.example.usrgam.taller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import modelo.Items;

public class VerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);


        Items ite = (Items) getIntent().getExtras().getSerializable("idZapato");

        ((TextView)findViewById(R.id.nombre)).setText(ite.getNombre());
        ((TextView)findViewById(R.id.marca)).setText(ite.getMarca());
        ((TextView)findViewById(R.id.color)).setText(ite.getColor());
        ((TextView)findViewById(R.id.talla)).setText(ite.getTalla());
        ((TextView)findViewById(R.id.valor)).setText(ite.getValor());
    }
}
