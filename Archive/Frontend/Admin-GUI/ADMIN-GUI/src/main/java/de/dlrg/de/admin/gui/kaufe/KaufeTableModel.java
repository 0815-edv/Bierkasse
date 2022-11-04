/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dlrg.de.admin.gui.kaufe;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sqlclass.*;

/**
 *
 * @author flori
 */
public class KaufeTableModel extends AbstractTableModel {

    private List<kauefe> kauefe;
    private List<Benutzer> benutzer;
    private List<Ware> waren;

    public KaufeTableModel(List<kauefe> kauefe, List<Benutzer> benutzer, List<Ware> waren) {
        this.kauefe = kauefe;
        this.benutzer = benutzer;
        this.waren = waren;
    }

    @Override
    public int getRowCount() {
        return kauefe.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return kauefe.get(rowIndex).getId();
            case 1:
                for (int i = 0; i < benutzer.size(); i++) {
                    if (benutzer.get(i).getIdrfid() == kauefe.get(rowIndex).getBenutzer_idrfid()) {
                        return benutzer.get(i).getName();
                    }
                }
                return false;

            case 2:
                return kauefe.get(rowIndex).getDatum();
            case 3:
                for (int i = 0; i < waren.size(); i++) {
                    if (waren.get(i).getId() == kauefe.get(rowIndex).getWare_id()){
                        return waren.get(i).getName();
                    }
                }
                return false;
        }
        return false;
    }

    @Override
    public String getColumnName(int column) {
        String[] tmp = {"ID", "Benutzer", "Datum", "Ware"};
        return tmp[column];
    }

}
