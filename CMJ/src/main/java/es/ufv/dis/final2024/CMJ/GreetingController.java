package es.ufv.dis.final2024.CMJ;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static es.ufv.dis.final2024.CMJ.CmjApplication.rutaDatos;

@RestController
public class GreetingController {
    @GetMapping("/naves")
    public ArrayList<Nave> users(){
        LectorJson lectorJson = new LectorJson();
        ArrayList<Nave> userList = lectorJson.leerJson(rutaDatos);
        return userList;
    }

    @PostMapping(path = "naves",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Nave> buscarNave(@RequestBody Peticion peticion){
        DataHandling dataHandling = new DataHandling();
        Nave nave1 = dataHandling.buscarPorNombre(peticion.getship());
        if(nave1 != null){
            EscritorPDF pdf = new EscritorPDF();
            pdf.escribirUsuarioPDF(nave1);
            return new ResponseEntity<>(nave1, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
