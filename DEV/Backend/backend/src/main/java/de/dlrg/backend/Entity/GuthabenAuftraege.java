package de.dlrg.backend.Entity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.sql.Date;

@JsonAutoDetect(getterVisibility= JsonAutoDetect.Visibility.ANY)
@Entity //Weist die Klasse als Datenbanktabelle zu - alle Attribute werden gleichnamig benannt
@Table(name = "GuthabenAuftraege") //Name der Tabelle in MySQL
public class GuthabenAuftraege {
    @Id // Festlegen der Public ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generierung des Public ID als Auto Increment
    private Long id = null; // Public-ID
    @ManyToOne  //Generierung der Annotation ManyToOne (Viele Objekte von GuthabenAufträge zu einem Benutzer)
    private Benutzer benutzer; // Attribut Benutzer
    private Double wert; // Wert in Double
    private Date addDatum; //Generierungsdatum als SQL-Date

    //Konstrutkor, wird für die Initialisierung der Datenbanktabelle benötigt
    public GuthabenAuftraege() {
    }

    //GET und SET Methoden
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public Double getWert() {
        return wert;
    }

    public void setWert(Double wert) {
        this.wert = wert;
    }

    public Date getAddDatum() {
        return addDatum;
    }

    public void setAddDatum(Date addDatum) {
        this.addDatum = addDatum;
    }
}
