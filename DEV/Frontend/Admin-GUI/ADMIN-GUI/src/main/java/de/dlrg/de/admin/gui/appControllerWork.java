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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
        
        startDBConnection();
        
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
    
    private void startDBConnection(){
    
    Gson gson = new Gson();
        Config config = null;
        try {
            Reader reader = new FileReader("C:\\Users\\flori\\OneDrive\\Programmierung\\Zusammenarbeit\\Bierkasse\\config.json");
            config = gson.fromJson(reader, Config.class);
        } catch (IOException ex) {
            Logger.getLogger(appControllerWork.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (config != null){
        dBConnector = new DBConnectorMysql(config.getUrl(), 3306, config.getUser(), config.getPassword(), config.getDatabase());
        }
        else
        {
            JOptionPane.showConfirmDialog(null, "Die Verbindung ist fehlgeschlagen");
        }
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
