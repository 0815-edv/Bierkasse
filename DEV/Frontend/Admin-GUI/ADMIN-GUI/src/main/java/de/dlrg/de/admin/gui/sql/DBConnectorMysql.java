/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dlrg.de.admin.gui.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author flori
 */
public class DBConnectorMysql extends DBConnector {

    public DBConnectorMysql(String ip, int port, String user, String password, String dbName) {
        super(ip, port, user, password, dbName);
    }

    
    
    
    @Override
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.
                    getConnection("jdbc:mysql://" + ip + ":" + port + "/" + dbName, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnectorMysql.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectorMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void disconnect() {
        try {
            res.close();
            stat.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectorMysql.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public ResultSet query(String sql) {
        if (sql != null) {
            try {
                stat = con.createStatement();
                stat.executeQuery(sql);
                res = stat.getResultSet();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnectorMysql.class.getName()).log(Level.SEVERE, null, ex);
            }
            return res;
        } else {
            return null;
        }
    }

    @Override
    public void update(String sql) {
        if (sql != null) {
            try {
                stat = con.createStatement();
                stat.executeUpdate(sql);
            } catch (SQLException ex) {
                Logger.getLogger(DBConnectorMysql.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    
    @Override
    public void preparedExecute(PreparedStatement psql){
        try {
            if (psql != null){
            psql.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectorMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
