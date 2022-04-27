/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.dlrg.fw.bierkasse.entitäten;

/**
 *
 * @author flori
 */
public class Benutzer {
    private int id;
    private String name;
    private String vorname;
    private double guthaben;
    private Long chipid;

    public Benutzer(int id, String name, String vorname, double guthaben, Long chipid) {
        this.id = id;
        this.name = name;
        this.vorname = vorname;
        this.guthaben = guthaben;
        this.chipid = chipid;
    }

    public Benutzer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getGuthaben() {
        return guthaben;
    }

    public void setGuthaben(double guthaben) {
        this.guthaben = guthaben;
    }

    public Long getChipid() {
        return chipid;
    }

    public void setChipid(Long chipid) {
        this.chipid = chipid;
    }
    
    
}
