/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package de.dlrg.fw.bierkasse.persistenzAPI;

import de.dlrg.fw.bierkasse.Exception.BierkasseException;
import de.dlrg.fw.bierkasse.entitäten.Benutzer;
import java.util.ArrayList;

/**
 *
 * @author flori
 */
public interface benutzerInterface {
    
    public String getBenutzer() throws BierkasseException;
    public String getBenutzerByID(int ID) throws BierkasseException;
    public String getBenutzerByCHIPID(Long ID) throws BierkasseException;
    public void change(Benutzer benutzer) throws BierkasseException;
    public void add(Benutzer benutzer) throws BierkasseException;
    public void guthabenSub(Benutzer benutzer, Double wert) throws BierkasseException;
    public void guthabenAdd(Benutzer benutzer, Double wer) throws BierkasseException;
    public void delete(Benutzer benutzer) throws BierkasseException;
    
    
}
