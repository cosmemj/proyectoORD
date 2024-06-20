package es.ufv.dis.final2024.CMJ;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LectorJson {
    public ArrayList<Nave> leerJson (String fichero) {
        try {
            Gson gson = new Gson();

            // Lee el fichero que le pasemos y lo carga en un reader
            Reader reader = Files.newBufferedReader(Paths.get(fichero));

            // Convierte el array JSON a un arraylist de users
            ArrayList<Nave> naves = new Gson().fromJson(reader, new TypeToken<ArrayList<Nave>>() {}.getType());
            naves.forEach(System.out::println);// imprime los users
            reader.close(); // Close reader

            return naves;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>(); // Si no ha leido nada, devuelve un array vacio
        }
    }
}
