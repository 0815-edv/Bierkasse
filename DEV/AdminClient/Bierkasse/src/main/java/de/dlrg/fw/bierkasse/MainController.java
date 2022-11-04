/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de.dlrg.fw.bierkasse;

import de.dlrg.fw.bierkasse.Adapter.BenutzerAdapterApi;
import de.dlrg.fw.bierkasse.Exception.BierkasseException;
import de.dlrg.fw.bierkasse.entitäten.Benutzer;
import de.dlrg.fw.bierkasse.gui.MainGUI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author flori
 */
public class MainController {

    /**
     * @param args the command line arguments
     */
    public MainController() {
        init();
    }

    private void init() {
        BenutzerAdapterApi baa;
        try {
            baa = new BenutzerAdapterApi();
            MainGUI gui = new MainGUI(baa);
            gui.setVisible(true);
        } catch (BierkasseException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainController mainController = new MainController();
            }
        });
    }

}
