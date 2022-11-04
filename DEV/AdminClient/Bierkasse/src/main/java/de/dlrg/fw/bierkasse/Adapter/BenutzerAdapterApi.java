/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.dlrg.fw.bierkasse.Adapter;

import de.dlrg.fw.bierkasse.Api.ApiBenutzer;
import de.dlrg.fw.bierkasse.entitäten.Benutzer;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import de.dlrg.fw.bierkasse.Exception.BierkasseException;
import de.dlrg.fw.bierkasse.persistenzAPI.benutzerInterface;


/**
 *
 * @author flori
 */
public class BenutzerAdapterApi {
    private ApiBenutzer apiBenutzer;

    public BenutzerAdapterApi() throws BierkasseException {
        apiBenutzer = new ApiBenutzer();
        getBenutzer();
    }
        
    public ArrayList<Benutzer> getBenutzer() throws BierkasseException{
        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<Benutzer>>(){}.getType();
        ArrayList<Benutzer> benutzer = gson.fromJson(apiBenutzer.getBenutzer(), userListType);
        return benutzer;
    }
}