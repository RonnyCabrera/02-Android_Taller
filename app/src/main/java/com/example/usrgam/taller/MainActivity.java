package com.example.usrgam.taller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import control.LeerEscribirArchivo;
import modelo.Usuario;

public class MainActivity extends AppCompatActivity {
    EditText usuario;
    EditText contraseña;

    private LeerEscribirArchivo lea = new LeerEscribirArchivo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.textUsuarioIngresar);
        contraseña = (EditText) findViewById(R.id.textContraseniaIngresar);
    }

    public void abrirPantallaLista(View v) {
        ArrayList<Usuario> u = lea.leerArchivo("usuario u");
        for (int i = 0; i < u.size(); i++) {
            Log.e("usuario : ", u.get(i).toString());
        }
    }

    public void abrirPantallaLogin(View v) {
        Intent intento = new Intent(getApplicationContext(), GmailActivity.class);
        startActivity(intento);
    }

    public void abrirPantallaRegistrar(View v) {
        Intent intento = new Intent(getApplicationContext(), RegistrarActivity.class);
        startActivity(intento);
    }
}
