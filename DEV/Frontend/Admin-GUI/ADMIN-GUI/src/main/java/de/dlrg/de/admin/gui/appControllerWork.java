/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dlrg.de.admin.gui;

import com.google.gson.Gson;
import de.dlrg.de.admin.gui.Ware.WareFromDB;
import de.dlrg.de.admin.gui.Ware.WareGUI;
import de.dlrg.de.admin.gui.sql.DBConnector;
import de.dlrg.de.admin.gui.sql.DBConnectorMysql;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

/**
 *
 * @author flori
 */
public class appControllerWork {

    private AdminGUI adminGUI;
    private DBConnector dBConnector;
    private BenutzerFromDB benutzerliste;
    private WareFromDB warenliste;
    private WareGUI warenGUI;

    public void initApp() throws SQLException, FileNotFoundException {


        Gson gson = new Gson();
        Config config = null;
        try{
        Reader reader = new FileReader("C:\\Users\\flori\\Desktop\\config.json");
        config = gson.fromJson(reader, Config.class);
        }
        catch (IOException ex){
        ex.printStackTrace();
        }
        
        dBConnector = new DBConnectorMysql(config.getUrl(), 3306, config.getUser(), config.getPassword(), config.getDatabase());

        benutzerliste = new BenutzerFromDB(dBConnector);
        warenliste = new WareFromDB(dBConnector);

        adminGUI = new AdminGUI();
        adminGUI.setDBConnector(dBConnector);
        adminGUI.setBenutzerListe(benutzerliste);
        adminGUI.initialisierung();

        warenGUI = new WareGUI();
        warenGUI.setDbconnector(dBConnector);
        warenGUI.setWarenliste(warenliste);
        warenGUI.initialisierung();
        adminGUI.setWareGUI(warenGUI);
        adminGUI.setAdmingui(adminGUI);

    }

    public AdminGUI getAdminGUI() {
        return adminGUI;
    }

    public DBConnector getdBConnector() {
        return dBConnector;
    }

    public BenutzerFromDB getBenutzerliste() {
        return benutzerliste;
    }

    public WareFromDB getWarenliste() {
        return warenliste;
    }

    public WareGUI getWarenGUI() {
        return warenGUI;
    }

}
