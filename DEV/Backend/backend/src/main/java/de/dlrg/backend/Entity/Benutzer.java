package de.dlrg.backend.Entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import javax.persistence.*;

@JsonAutoDetect(getterVisibility= JsonAutoDetect.Visibility.ANY)
@Entity //Weist die Klasse als Datenbanktabelle zu - alle Attribute werden gleichnamig benannt
@Table(name = "Benutzer") // Name der Tabelle in MySQL
public class Benutzer { //Benutzer-Klasse, wird als Tabelle in MySQL erstellt
    @Id // Festlegen der Public ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generierung des Public ID als Auto Increment
    private Long id; //Public-ID
    private String name; //Name als String
    private String vorname; // Vorname als String
    private double guthaben; //Guthabenwert als Double
    private Long chipid; // CHIPID als Long

    public Benutzer(Long id, String name, String vorname, double guthaben, Long chipid) {
        this.id = id;
        this.name = name;
        this.vorname = vorname;
        this.guthaben = guthaben;
        this.chipid = chipid;
    }

    //Konstrutkor, wird für die Initialisierung der Datenbanktabelle benötigt
    public Benutzer() {
    }

    //Get und Set Methoden
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
