/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dlrg.de.admin.gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sqlclass.Ware;

/**
 *
 * @author flori
 */
public class WareTableModel extends AbstractTableModel {
    
    private List<Ware> waren;

    public WareTableModel(List<Ware> waren) {
        this.waren = waren;
    }

    @Override
    public int getRowCount() {
        return waren.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return waren.get(rowIndex).getId();
            case 1:
                return waren.get(rowIndex).getName();       
        }
        return false;
    }
    
}
