/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dlrg.de.admin.gui;

import de.dlrg.de.admin.gui.sql.DBConnector;
import de.dlrg.de.admin.gui.sql.DBConnectorMysql;
import java.sql.SQLException;

/**
 *
 * @author flori
 */
public class appControllerWork {

    /**
     * @param args the command line arguments
     */
    private AdminGUI adminGUI;
    private DBConnector dBConnector;
    private BenutzerFromDB benutzerliste;
    private WareFromDB warenliste;
    private WareGUI warenGUI;

    public void initApp() throws SQLException {

        dBConnector = new DBConnectorMysql("159.69.144.39", 3306, "flwerner", "BierkasseDLRG123!", "bierkassedlrg");

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
