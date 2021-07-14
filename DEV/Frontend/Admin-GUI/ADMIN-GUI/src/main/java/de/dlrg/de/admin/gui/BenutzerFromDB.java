/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dlrg.de.admin.gui;

import de.dlrg.de.admin.gui.sql.DBConnector;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sqlclass.Benutzer;

/**
 *
 * @author flori
 */
public class BenutzerFromDB {
    private ArrayList<Benutzer> benutzer = new ArrayList<>();
    private DBConnector dBConnector;
    private ResultSet rs = null;

    public BenutzerFromDB(DBConnector dBConnector) {
        this.dBConnector = dBConnector;
        try {
            getData();
        } catch (SQLException ex) {
            Logger.getLogger(BenutzerFromDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    private void getData() throws SQLException{
    
        dBConnector.connect();
        rs = dBConnector.query("Select * FROM benutzer");
        while (rs.next()){
            Benutzer tmp = new Benutzer();
            tmp.setIdrfid(rs.getInt(1));
            tmp.setName(rs.getString(2));
            tmp.setVorname(rs.getString(3));
            tmp.setGuthaben(rs.getInt(4));
            tmp.setIsAdmin(rs.getInt(5));
            benutzer.add(tmp);
        }
        
    
    }
    
    public ArrayList<Benutzer> get() {
        return benutzer;
    }
}
