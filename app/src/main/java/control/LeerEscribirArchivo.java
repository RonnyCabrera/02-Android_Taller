package control;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import modelo.Usuario;

public class LeerEscribirArchivo {

    private File file = Environment.getExternalStorageDirectory();
    private String ruta = file.getAbsolutePath() + File.separator;

    public void escribirArchivo(Usuario u, String nombre) {
        try {
            FileOutputStream fos = new FileOutputStream(ruta+nombre);
            ObjectOutputStream out = new ObjectOutputStream(fos);

            out.writeObject(u);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Usuario leerArchivo(String nombre) {
        Usuario u = null;
        try {
            FileInputStream file = new FileInputStream(ruta+nombre);
            ObjectInputStream in = new ObjectInputStream(file);
            u = (Usuario)in.readObject();
        } catch (FileNotFoundException e) {
            Log.e("error escribir : ", e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("error IO : ", e.toString());
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return u;
    }
}
