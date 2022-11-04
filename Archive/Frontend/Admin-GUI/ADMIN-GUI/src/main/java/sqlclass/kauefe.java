/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlclass;

import java.sql.Date;

/**
 *
 * @author flori
 */
public class kauefe {
    private int id;
    private Date datum;
    private int benutzer_idrfid;
    private int ware_id;

    public kauefe(int id, Date datum, int benutzer_idrfid, int ware_id) {
        this.id = id;
        this.datum = datum;
        this.benutzer_idrfid = benutzer_idrfid;
        this.ware_id = ware_id;
    }

    public kauefe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getBenutzer_idrfid() {
        return benutzer_idrfid;
    }

    public void setBenutzer_idrfid(int benutzer_idrfid) {
        this.benutzer_idrfid = benutzer_idrfid;
    }

    public int getWare_id() {
        return ware_id;
    }

    public void setWare_id(int ware_id) {
        this.ware_id = ware_id;
    }
    
    
    
}
