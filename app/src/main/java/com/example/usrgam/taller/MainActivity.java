package com.example.usrgam.taller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usuario;
    EditText contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.textUsuario);
        contraseña = (EditText) findViewById(R.id.textContraseña);
    }

    public void abrirPantallaIngesar(View v) {
        Intent intento = new Intent(getApplicationContext(), Main2Activity.class);
        if(usuario.getText().toString().equals("ron") && contraseña.getText().toString().equals("123")) {
            intento.putExtra("idUsuario", usuario.getText().toString());
            startActivity(intento);
        }
        else {
            Toast mensaje = Toast.makeText(getApplicationContext(), "Usuario "+ usuario.getText().toString() +" o Contraseña " + contraseña.getText() + " Incorrectos", Toast.LENGTH_LONG);
            mensaje.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            mensaje.show();
        }
    }
}
