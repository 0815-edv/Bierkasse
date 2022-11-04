/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.dlrg.fw.bierkasse.Api;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

/**
 *
 * @author flori
 */
public class ApiWare extends ApiConnection {

    private URI uri;

    public String getWare() {
        uri = URI.create(url + "/ware/get");
        httpRequest = HttpRequest.newBuilder(uri).build();

        try {
            var response = httpClient.send(httpRequest, BodyHandlers.ofString());
            return response.body();
        } catch (Exception ex) {
            return null;
        }
    }

}
