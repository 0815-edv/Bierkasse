/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dlrg.de.admin.gui;

import de.dlrg.de.admin.gui.Ware.WareGUI;
import ENUM.Guthaben;
import de.dlrg.de.admin.gui.sql.DBConnector;
import de.dlrg.de.admin.login.LoginGUI;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sqlclass.Benutzer;

/**
 *
 * @author flori
 */
public class AdminGUI extends javax.swing.JFrame {

    /**
     * Creates new form AdminGUI
     */
    private DBConnector dBConnector;
    private BenutzerTableModel benutzerTableModel;
    private BenutzerFromDB benutzerliste;
    private WareGUI wareGUI;
    private LoginGUI loginGUI;
    private AddUserGUI addusergui;
    private AdminGUI admingui;

    public AdminGUI() {
        initComponents();

    }

    public void initialisierung() {

        benutzerTableModel = new BenutzerTableModel(benutzerliste.get());
        jtableausgabe.setModel(benutzerTableModel);

    }

    public void setDBConnector(DBConnector dBConnector) {
        this.dBConnector = dBConnector;
    }

    public void setBenutzerListe(BenutzerFromDB tmp) {

        benutzerliste = tmp;
    }

    public void setWareGUI(WareGUI wareGUI) {
        this.wareGUI = wareGUI;
    }

    public void setAdmingui(AdminGUI admingui) {
        this.admingui = admingui;
    }

    public void refresh() {
        
        benutzerTableModel = null;
        benutzerTableModel = new BenutzerTableModel(benutzerliste.get());
        jtableausgabe.setModel(benutzerTableModel);
        jtableausgabe.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableausgabe = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txfrfidchip = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txfname = new javax.swing.JTextField();
        txfvorname = new javax.swing.JTextField();
        txfguthaben = new javax.swing.JTextField();
        btnändern = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnadd10 = new javax.swing.JButton();
        btnadd20 = new javax.swing.JButton();
        btnadd50 = new javax.swing.JButton();
        btnWare = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txfchipid = new javax.swing.JTextField();
        btnadduser = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnremove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtableausgabe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtableausgabe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableausgabeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtableausgabe);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setText("Benutzer");

        jLabel2.setText("ID");

        jLabel3.setText("Name");

        jLabel4.setText("Vorname");

        jLabel5.setText("Guthaben");

        txfguthaben.setEnabled(false);

        btnändern.setText("Ändern");
        btnändern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnändernActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 255, 255));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Guthaben aufladen");

        btnadd10.setText("10 EURO");
        btnadd10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadd10ActionPerformed(evt);
            }
        });

        btnadd20.setText("20 EURO");
        btnadd20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadd20ActionPerformed(evt);
            }
        });

        btnadd50.setText("50 EURO");
        btnadd50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadd50ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(76, 76, 76))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnadd10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnadd20, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnadd50, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadd10)
                    .addComponent(btnadd20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnadd50)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        btnWare.setText("Ware");
        btnWare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWareActionPerformed(evt);
            }
        });

        jLabel7.setText("RFID-CHIP");

        btnadduser.setText("Neuer Benutzer");
        btnadduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadduserActionPerformed(evt);
            }
        });

        jButton2.setText("Benutzer Historie");

        btnremove.setText("Remove");
        btnremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(114, 114, 114))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnremove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfrfidchip)
                    .addComponent(txfname)
                    .addComponent(txfvorname)
                    .addComponent(txfguthaben)
                    .addComponent(txfchipid)
                    .addComponent(btnändern, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnWare)
                                .addGap(18, 18, 18)
                                .addComponent(btnadduser)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfrfidchip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txfvorname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txfguthaben, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txfchipid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnändern)
                    .addComponent(btnremove))
                .addGap(17, 17, 17)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnWare)
                    .addComponent(btnadduser))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtableausgabeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableausgabeMouseClicked
        // TODO add your handling code here:
        Benutzer tmp = benutzerliste.get().get(jtableausgabe.getSelectedRow());

        txfrfidchip.setText(String.valueOf(tmp.getIdrfid()));
        txfvorname.setText(tmp.getVorname());
        txfname.setText(tmp.getName());
        txfguthaben.setText(String.valueOf(tmp.getGuthaben()));
        txfchipid.setText(String.valueOf(tmp.getChipid()));

    }//GEN-LAST:event_jtableausgabeMouseClicked

    private void btnadd20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadd20ActionPerformed
        // TODO add your handling code here:
        Benutzer tmp = benutzerliste.get().get(jtableausgabe.getSelectedRow());
        try {
            benutzerliste.changeGuthaben(Guthaben.zwanzig, tmp);
            jtableausgabe.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnadd20ActionPerformed

    private void btnadd10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadd10ActionPerformed
        // TODO add your handling code here:
        Benutzer tmp = benutzerliste.get().get(jtableausgabe.getSelectedRow());
        try {
            benutzerliste.changeGuthaben(Guthaben.zehn, tmp);
            jtableausgabe.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnadd10ActionPerformed

    private void btnändernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnändernActionPerformed
        // TODO add your handling code here:
        Benutzer tmp = benutzerliste.get().get(jtableausgabe.getSelectedRow());
        tmp.setIdrfid(Integer.parseInt(txfrfidchip.getText()));
        tmp.setName(txfname.getText());
        tmp.setVorname(txfvorname.getText());
        tmp.setChipid(Long.parseLong(txfchipid.getText()));
        try {
            benutzerliste.update(tmp);
        } catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnändernActionPerformed

    private void btnadd50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadd50ActionPerformed
        // TODO add your handling code here:
        Benutzer tmp = benutzerliste.get().get(jtableausgabe.getSelectedRow());
        try {
            benutzerliste.changeGuthaben(Guthaben.fuenfzig, tmp);
            jtableausgabe.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnadd50ActionPerformed

    private void btnWareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWareActionPerformed
        // TODO add your handling code here:
        wareGUI.setVisible(true);
    }//GEN-LAST:event_btnWareActionPerformed

    private void btnadduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadduserActionPerformed
        // TODO add your handling code here:
        addusergui = new AddUserGUI(benutzerliste);
        addusergui.setAdminGUI(admingui);
        addusergui.setVisible(true);
        refresh();
    }//GEN-LAST:event_btnadduserActionPerformed

    private void btnremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoveActionPerformed
        // TODO add your handling code here:
        Benutzer tmp = benutzerliste.get().get(jtableausgabe.getSelectedRow());
        try {
            benutzerliste.remove(tmp);
            refresh();

        } catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnremoveActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnWare;
    private javax.swing.JButton btnadd10;
    private javax.swing.JButton btnadd20;
    private javax.swing.JButton btnadd50;
    private javax.swing.JButton btnadduser;
    private javax.swing.JButton btnremove;
    private javax.swing.JButton btnändern;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtableausgabe;
    private javax.swing.JTextField txfchipid;
    private javax.swing.JTextField txfguthaben;
    private javax.swing.JTextField txfname;
    private javax.swing.JTextField txfrfidchip;
    private javax.swing.JTextField txfvorname;
    // End of variables declaration//GEN-END:variables
}
