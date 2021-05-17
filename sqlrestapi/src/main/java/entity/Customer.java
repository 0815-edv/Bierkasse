/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author flori
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int guthaben;
    
    private String name;
    
    private String vorname;
    
    private boolean isAdmin;

    public Long getRfid_id() {
        return id;
    }

    public void setRfid_id(Long rfid_id) {
        this.id = rfid_id;
    }

    public int getGuthaben() {
        return guthaben;
    }

    public void setGuthaben(int guthaben) {
        this.guthaben = guthaben;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    

    
    
}
