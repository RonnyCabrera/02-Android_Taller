package com.example.usrgam.taller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

    public void abrirPantallaIngesar(View v) {
        Usuario u = lea.leerArchivo("usuario u");
        Intent intento = new Intent(getApplicationContext(), Main2Activity.class);

        if(usuario.getText().toString().equals(u.getNombre()) && contraseña.getText().toString().equals(u.getContrasenia())) {
            Toast.makeText(getApplicationContext(), "INGRESO CORRECTO", Toast.LENGTH_LONG).show();
            intento.putExtra("idUsuario", usuario.getText().toString());
            startActivity(intento);
        }
        else {
            Toast mensaje = Toast.makeText(getApplicationContext(), "Usuario o Contraseña Incorrectos", Toast.LENGTH_LONG);
            mensaje.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            mensaje.show();
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
