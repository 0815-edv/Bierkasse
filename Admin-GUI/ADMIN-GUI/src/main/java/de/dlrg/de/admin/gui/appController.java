/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dlrg.de.admin.gui;

import de.dlrg.de.admin.gui.sql.DBConnector;
import de.dlrg.de.admin.gui.sql.DBConnectorMysql;

/**
 *
 * @author flori
 */
public class appController {

    /**
     * @param args the command line arguments
     */
    
    private AdminGUI adminGUI;
    private DBConnector dBConnector;
    private BenutzerFromDB benutzerliste;
    
    
    public void initApp(){
        
        
        dBConnector = new DBConnectorMysql("10.25.6.229", 3306, "flwerner", "Start123!", "bierkassedlrg");
        
        benutzerliste = new BenutzerFromDB(dBConnector);
        
        
        adminGUI = new AdminGUI();
        adminGUI.setDBConnector(dBConnector);
        adminGUI.setBenutzerListe(benutzerliste);
        adminGUI.initialisierung();
        adminGUI.setVisible(true);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                appController appController = new appController();
                appController.initApp();
            }
        });
    }
    
}
