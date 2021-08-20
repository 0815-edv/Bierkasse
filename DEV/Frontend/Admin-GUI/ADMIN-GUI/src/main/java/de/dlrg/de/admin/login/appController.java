/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dlrg.de.admin.login;

import de.dlrg.de.admin.gui.appControllerWork;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author flori
 */
public class appController {

    private LoginGUI logingui;
    private appControllerWork apcontrollerwork;

    private void initialisierung() throws SQLException {
        logingui = new LoginGUI();
        apcontrollerwork = new appControllerWork();
        apcontrollerwork.initApp();
        logingui.setAdmingui(apcontrollerwork.getAdminGUI());
        logingui.setOwnLoginGui(logingui);
        logingui.setVisible(true);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                appController appcontroller = new appController();
                try {
                    appcontroller.initialisierung();
                } catch (SQLException ex) {
                    Logger.getLogger(appController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }
}
