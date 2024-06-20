package org.vaadin.example;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GreetService implements Serializable {

    public List<Nave> getAllNaves() throws URISyntaxException, IOException, InterruptedException {
        API api = new API();
        return api.getListaNaves();
    }

    public Nave getNavePorNombre(String nombre) throws URISyntaxException, IOException, InterruptedException {
        API api = new API();
        return api.buscarPorNombre(nombre);
    }

}
