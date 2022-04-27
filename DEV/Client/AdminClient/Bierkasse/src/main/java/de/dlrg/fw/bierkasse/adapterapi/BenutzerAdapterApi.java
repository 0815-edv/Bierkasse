/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.dlrg.fw.bierkasse.adapterapi;

import de.dlrg.fw.bierkasse.Api.ApiBenutzer;
import de.dlrg.fw.bierkasse.entitäten.Benutzer;
import de.dlrg.fw.bierkasse.persistenAdapter.benutzerAdapter;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;


/**
 *
 * @author flori
 */
public class BenutzerAdapterApi implements benutzerAdapter{
    private ApiBenutzer apiBenutzer;

    public BenutzerAdapterApi() {
        apiBenutzer = new ApiBenutzer();
    }
    
    
    
    @Override
    public ArrayList<Benutzer> get() {
        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<Benutzer>>(){}.getType();
        ArrayList<Benutzer> benutzer = gson.fromJson(apiBenutzer.getBenutzer(), userListType);
        return benutzer;
    }

    @Override
    public Benutzer getbyid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public Benutzer getbenutzerbychipud() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void change() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guthabenSub() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guthabenAdd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
