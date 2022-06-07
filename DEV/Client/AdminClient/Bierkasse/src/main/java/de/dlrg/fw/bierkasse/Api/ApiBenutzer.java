/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.dlrg.fw.bierkasse.Api;

import de.dlrg.fw.bierkasse.Exception.BierkasseException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

/**
 *
 * @author flori
 */
public class ApiBenutzer extends ApiConnection {

    private URI uri;

    public ApiBenutzer() {

    }

    public String getBenutzer() {
        uri = URI.create(url + "/benutzer/get");
        httpRequest = HttpRequest.newBuilder(uri).build();
        try {
            var response = httpClient.send(httpRequest, BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException ex) {
            return null;
        }

    }

    public String getBenutzerByID(int ID) throws BierkasseException{
        if (ID != 0) {
            uri = URI.create(url + "/benutzer/get/id?id=" + ID);
            httpRequest = HttpRequest.newBuilder(uri).build();
            try {
                var response = httpClient.send(httpRequest, BodyHandlers.ofString());
            } catch (IOException | InterruptedException ex) {
                throw new BierkasseException("ApiBenutzer", "Aufruf nicht möglich");
            }
        }
        else{
            throw new BierkasseException("APIBenutzer","Benutzer nicht vorhanden");
        }
        return null;
    }
    
    public String getBenutzerByCHIPID(Long ID) throws BierkasseException{
        if (ID != 0) {
            uri = URI.create(url + "/benutzer/get/chipid?chipid=" + ID);
            httpRequest = HttpRequest.newBuilder(uri).build();
            try {
                var response = httpClient.send(httpRequest, BodyHandlers.ofString());
            } catch (IOException | InterruptedException ex) {
                throw new BierkasseException("ApiBenutzer", "Aufruf nicht möglich");
            }
        }
        else{
            throw new BierkasseException("APIBenutzer","CHIPID nicht vorhanden");
        }
        return null;
    }

}
