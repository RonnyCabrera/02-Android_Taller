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
        Intent intento = new Intent(getApplicationContext(), ListaActivity.class);
        ArrayList<Usuario> u = lea.leerArchivo("usuario u");
        boolean bandera = false;

        for (int i = 0; i < u.size(); i++) {
            if(usuario.getText().toString().equals(u.get(i).getNombre()) && contraseña.getText().toString().equals(u.get(i).getContrasenia())) {
                bandera = true;
                break;
            }
            else {
                bandera = false;
            }
            Log.e("usuario : ", u.get(i).toString());
        }
        if(bandera) {
            Toast.makeText(getApplicationContext(), "INGRESO CORRECTO", Toast.LENGTH_LONG).show();
            startActivity(intento);
        }
        else {
            Toast.makeText(getApplicationContext(), "USUARIO O CONTRASEÑA INCORRECTOS", Toast.LENGTH_LONG).show();
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
