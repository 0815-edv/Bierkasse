package de.dlrg.backend.Time;

import java.sql.Date;
//Klasse für die Erstellung eines Zeitstempels
public class sqlTime {
    long now = System.currentTimeMillis(); //Attribut now von Long mit der Aktuellen SystemZeit in Millisekunden
    Date sqlDate = new Date(now);

    public sqlTime() {
    }
    //Get-Methode
    public Date getSqlDate() {
        return sqlDate;
    }
}

