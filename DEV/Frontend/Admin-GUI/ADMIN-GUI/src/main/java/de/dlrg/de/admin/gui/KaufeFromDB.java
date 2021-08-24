/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dlrg.de.admin.gui;

import de.dlrg.de.admin.gui.sql.DBConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sqlclass.kauefe;

/**
 *
 * @author flori
 */
public class KaufeFromDB {

    private ArrayList<kauefe> käufe = new ArrayList<>();
    private DBConnector dbconnector;
    private ResultSet rs = null;

    public KaufeFromDB(DBConnector dbconnector) {
        this.dbconnector = dbconnector;
    }
    
    
    
    private void getData() throws SQLException {
        dbconnector.connect();
        kauefe tmp = new kauefe();
        
        while (rs.next()) {
            tmp.setId(rs.getInt(1));
            tmp.setDatum(rs.getDate(2));
            tmp.setBenutzer_idrfid(rs.getInt(3));
            tmp.setWare_id(rs.getInt(4));
            käufe.add(tmp);
        }
       
    }
    public ArrayList<kauefe> get(){
        return käufe;
    }
    
}
