/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dlrg.de.admin.gui;

import de.dlrg.de.admin.gui.sql.DBConnector;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author flori
 */
public class WareFromDB {
    
    private DBConnector dbConnector;
    private ResultSet rs =null;
    
    private ArrayList<Ware> waren;

    public WareFromDB(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }
    
    
    private void getData() throws SQLException{
    
        rs = dbConnector.query("Select * FROM Ware");
        while (rs.next()) {
        
        }
    }
}
