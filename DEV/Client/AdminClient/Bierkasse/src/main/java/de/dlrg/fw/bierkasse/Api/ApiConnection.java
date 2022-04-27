/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.dlrg.fw.bierkasse.Api;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

/**
 *
 * @author flori
 */
public class ApiConnection {
    
    protected final String url = "http://backend.werner-intern.cloud:8080"; 
    
    protected HttpClient httpClient;
    protected HttpRequest httpRequest;

    public ApiConnection() {
        httpClient = HttpClient.newHttpClient();
    }
    
    
}
