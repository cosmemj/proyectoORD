package es.ufv.dis.final2024.CMJ;

import java.util.ArrayList;

import static es.ufv.dis.final2024.CMJ.CmjApplication.rutaDatos;

public class DataHandling {
    public Nave getUserInfo (String name){
        Nave foundNave = null;
        LectorJson reader = new LectorJson();

        ArrayList<Nave> listaNaves = reader.leerJson(rutaDatos);
        for (Nave nave0 : listaNaves){
            if (nave0.getName().equalsIgnoreCase(name)){
                foundNave = nave0;
            }
        }

        return foundNave;
    }

    public Nave buscarPorNombre (String name){
        Nave foundNave = null;
        LectorJson reader = new LectorJson();
        ArrayList<Nave> listaNaves = reader.leerJson(rutaDatos);
        for (Nave nave0 : listaNaves){
            if (nave0.getName().equals(name)){
                foundNave = nave0;
            }
        }
        return foundNave;
    }
}
