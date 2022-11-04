/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.dlrg.fw.bierkasse.Api;

import de.dlrg.fw.bierkasse.Exception.BierkasseException;
import de.dlrg.fw.bierkasse.entitäten.Benutzer;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import de.dlrg.fw.bierkasse.persistenzAPI.benutzerInterface;

/**
 *
 * @author flori
 */
public class ApiBenutzer extends ApiConnection implements benutzerInterface{

    private URI uri;

    public ApiBenutzer() {

    }

    @Override
    public String getBenutzer() throws BierkasseException {
        uri = URI.create(url + "/benutzer/get");
        httpRequest = HttpRequest.newBuilder(uri).build();
        try {
            var response = httpClient.send(httpRequest, BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException ex) {
            throw new BierkasseException("APIBenutzer", "Benutzer nicht Aufrufbar");
        }

    }

    @Override
    public String getBenutzerByID(int ID) throws BierkasseException {
        if (ID != 0) {
            uri = URI.create(url + "/benutzer/get/id?id=" + ID);
            httpRequest = HttpRequest.newBuilder(uri).build();
            try {
                var response = httpClient.send(httpRequest, BodyHandlers.ofString());
            } catch (IOException | InterruptedException ex) {
                throw new BierkasseException("ApiBenutzer", "Aufruf nicht möglich");
            }
        } else {
            throw new BierkasseException("APIBenutzer", "Benutzer nicht vorhanden");
        }
        return null;
    }

    @Override
    public String getBenutzerByCHIPID(Long ID) throws BierkasseException {
        if (ID != 0) {
            uri = URI.create(url + "/benutzer/get/chipid?chipid=" + ID);
            httpRequest = HttpRequest.newBuilder(uri).build();
            try {
                var response = httpClient.send(httpRequest, BodyHandlers.ofString());
            } catch (IOException | InterruptedException ex) {
                throw new BierkasseException("ApiBenutzer", "Aufruf nicht möglich");
            }
        } else {
            throw new BierkasseException("APIBenutzer", "CHIPID nicht vorhanden");
        }
        return null;
    }

    @Override
    public void change(Benutzer benutzer) throws BierkasseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Benutzer benutzer) throws BierkasseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guthabenSub(Benutzer benutzer, Double wert) throws BierkasseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guthabenAdd(Benutzer benutzer, Double wer) throws BierkasseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Benutzer benutzer) throws BierkasseException {
        Benutzer delBenutzer = benutzer;
        uri = URI.create(url + "/benutzer/del/id?id="+delBenutzer.getId());
    }

    
}