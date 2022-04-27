/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package de.dlrg.fw.bierkasse.persistenAdapter;

import de.dlrg.fw.bierkasse.entitäten.Benutzer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author flori
 */
public interface benutzerAdapter {
    
    public ArrayList<Benutzer> get();
    public Benutzer getbyid();
    public Benutzer getbenutzerbychipud();
    public void change();
    public void add();
    public void guthabenSub();
    public void guthabenAdd();
    public void delete();
    
    
}
