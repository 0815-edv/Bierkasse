/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dlrg.de.admin.gui;

import sqlclass.Benutzer;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author flori
 */
public class BenutzerTableModel extends AbstractTableModel{
    private List<Benutzer> benutzer;

    public BenutzerTableModel(List<Benutzer> benutzer) {
        this.benutzer = benutzer;
    }

    @Override
    public int getRowCount() {
        return benutzer.size();
    }

    @Override
    public int getColumnCount() {
           return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return benutzer.get(rowIndex).getIdrfid();
            case 1:
                return benutzer.get(rowIndex).getName();
            case 2: 
                return benutzer.get(rowIndex).getVorname();
            case 3:
                return benutzer.get(rowIndex).getGuthaben();
            case 4:
                return benutzer.get(rowIndex).getIsAdmin();
        
        }
        return false;
            
    }
    public String getColumnName(int index) {

        String[] title = {"ID-RFID", "Name", "Vorname", "Guthaben", "ADMIN"};
        return title[index];
    }
        
    
}
