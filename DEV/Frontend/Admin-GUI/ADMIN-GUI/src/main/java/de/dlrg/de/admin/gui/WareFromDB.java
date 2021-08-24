/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dlrg.de.admin.gui;

import de.dlrg.de.admin.gui.sql.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import sqlclass.Ware;

/**
 *
 * @author flori
 */
public class WareFromDB {

    private DBConnector dbConnector;
    private ResultSet rs = null;

    private ArrayList<Ware> waren = new ArrayList<>();

    public WareFromDB(DBConnector dbConnector) throws SQLException {
        this.dbConnector = dbConnector;
        getData();
    }

    private void getData() throws SQLException {
        waren.clear();
        dbConnector.connect();
        rs = dbConnector.query("Select * FROM Ware");
        while (rs.next()) {
            Ware tmp = new Ware();
            tmp.setId(rs.getInt(1));
            tmp.setName(rs.getString(2));
            waren.add(tmp);
        }
    }

    public ArrayList<Ware> get() {
        return waren;
    }

    public void addWare(String name) throws SQLException {
        
        String query = "insert into Ware (id, name)"
                + " Values (?, ?)";
        PreparedStatement psql = null;
        psql = dbConnector.getCon().prepareStatement(query);
        int ID = waren.size() + 1;
        for (int i = 0; i < waren.size(); i++) {
            if (ID == waren.get(i).getId()) {
                ID = ID + 1;
                i = 0;
            } else {
                i = waren.size();
            }

        }
        if (name != null) {
            psql.setInt(1, ID);
            psql.setString(2, name);
            dbConnector.preparedExecute(psql);
        }
        getData();
    }
}
