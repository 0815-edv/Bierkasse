/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.dlrg.fw.bierkasse.TableModel;

import de.dlrg.fw.bierkasse.entitäten.Benutzer;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author flori
 */
public class BenutzerTableModel extends AbstractTableModel {

    private List<Benutzer> benutzerliste;

    public BenutzerTableModel(List<Benutzer> benutzerliste) {
        this.benutzerliste = benutzerliste;
    }

    @Override
    public int getRowCount() {
        return benutzerliste.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return benutzerliste.get(rowIndex).getId();
            case 1:
                return benutzerliste.get(rowIndex).getVorname();
            case 2:
                return benutzerliste.get(rowIndex).getName();
            case 3:
                return benutzerliste.get(rowIndex).getGuthaben();
            case 4:
                return benutzerliste.get(rowIndex).getChipid();
        }
        return false;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Vorname";
            case 2:
                return "Nachname";
            case 3:
                return "Guthaben";
            case 4:
                return "Chipid";
        }
        return null;
    }

}
