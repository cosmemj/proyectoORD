package org.vaadin.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class API {
    private static final String urlPrefix = "http://localhost:8080";
    public List<Nave> getListaNaves() throws URISyntaxException, IOException, InterruptedException {
        String fullUrl = String.format(urlPrefix + "/naves");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        String jsonString = response.body();
        // Convertir a objetos Java con Gson
        Gson gson = new Gson();
        Nave[] navesArray = gson.fromJson(jsonString, Nave[].class);
        List<Nave> navesList = Arrays.asList(navesArray);
        return navesList;
    }

    public Nave buscarPorNombre(String nombre) throws URISyntaxException, IOException, InterruptedException {
        String fullUrl = String.format(urlPrefix + "/naves");

        JsonObject jsonPayload = new JsonObject();
        jsonPayload.addProperty("nombre", nombre);
        String requestBody = new Gson().toJson(jsonPayload);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        Nave nave = gson.fromJson(response.body(), Nave.class);
        return nave;
    }
}
