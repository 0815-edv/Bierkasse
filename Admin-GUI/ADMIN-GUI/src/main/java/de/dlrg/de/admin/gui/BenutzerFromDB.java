/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dlrg.de.admin.gui;

import de.dlrg.de.admin.gui.sql.DBConnector;
import java.util.ArrayList;
import sqlclass.Benutzer;

/**
 *
 * @author flori
 */
public class BenutzerFromDB {
    private ArrayList<Benutzer> benutzer = new ArrayList<>();
    private DBConnector dBConnector;

    public BenutzerFromDB(DBConnector dBConnector) {
        this.dBConnector = dBConnector;
    }
    
    
    
    private void get(){
    
        
    
    }
}
