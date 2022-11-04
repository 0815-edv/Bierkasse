/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dlrg.de.admin.gui.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author flori
 */
public abstract class DBConnector {

    protected String ip;
    protected int port;
    protected String user;
    protected String password;
    protected String dbName;
    
    protected Connection con;
    protected ResultSet res;
    protected Statement stat;

    public DBConnector(String ip, int port, String user, String password, String dbName) {
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.password = password;
        this.dbName = dbName;
    }
    public Connection getCon() {
        return con;
    }

    public abstract void connect();

    public abstract void disconnect();

    public abstract ResultSet query(String sql);
    
    public abstract void preparedExecute(PreparedStatement psql);
    
    public void update(String sql){};

}
