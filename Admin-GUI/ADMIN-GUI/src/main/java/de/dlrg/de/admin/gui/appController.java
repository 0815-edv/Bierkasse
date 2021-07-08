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
    
    
    public void initApp(){
        adminGUI = new AdminGUI();
        adminGUI.setVisible(true);
        
        dBConnector = new DBConnectorMysql("10.25.6.229", 3306, "flwerner", "Start123!", "bierkassedlrg");
        adminGUI.setDBConnector(dBConnector);
        
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
