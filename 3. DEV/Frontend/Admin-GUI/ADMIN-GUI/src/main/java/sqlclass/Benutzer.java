/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlclass;

/**
 *
 * @author flori
 */
public class Benutzer {

    private int idrfid;
    private String name;
    private String vorname;
    private double guthaben;
    private int isAdmin;    // 0-> ist kein Admin --  1-> ist Admin

    public Benutzer(int idrfid, String name, String vorname, double guthaben, int isAdmin) {
        this.idrfid = idrfid;
        this.name = name;
        this.vorname = vorname;
        this.guthaben = guthaben;

        if (isAdmin >= 0 || isAdmin <= 1) {
            this.isAdmin = isAdmin;
        } else {
            this.isAdmin = 0;
        }
    }

    public Benutzer() {
    }
    

    public int getIdrfid() {
        return idrfid;
    }

    public void setIdrfid(int idrfid) {
        this.idrfid = idrfid;
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

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        if (isAdmin >= 0 || isAdmin <= 1) {
            this.isAdmin = isAdmin;
        } else {
            this.isAdmin = 0;
        }
    }

}
