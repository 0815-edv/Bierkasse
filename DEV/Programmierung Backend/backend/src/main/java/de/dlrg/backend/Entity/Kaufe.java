package de.dlrg.backend.Entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.sql.Date;

@JsonAutoDetect(getterVisibility= JsonAutoDetect.Visibility.ANY)
@Entity //Weist die Klasse als Datenbanktabelle zu - alle Attribute werden gleichnamig benannt
@Table(name = "kaufe") //Name der Tabelle in MySQL
public class Kaufe {
    @Id // Festlegen der Public ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generierung der Public ID als Auto Increment
    private Long id; //Public-ID
    private Date datum; // Datum als SQLDate Attribut

    @ManyToOne
    @JoinColumn(name = "fk_benutzer")//Generierung der Annotation ManyToOne (Viele Objekte von Kaeufe zu einem Benutzer)
    private Benutzer benutzer; //Attribut User von Benutzer
    @ManyToOne //Generierung der Annotation ManyToOne (Viele Objekte von Kaeufe zu einer Ware)
    @JoinColumn(name = "fk_ware")
    private Ware ware; //Attribut ware von Ware

    //Konstrutkor, wird für die Initialisierung der Datenbanktabelle benötigt
    public Kaufe(){
    }
    // GET und SET Methoden
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Benutzer getUser() {
        return benutzer;
    }

    public void setUser(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public Ware getWare() {
        return ware;
    }

    public void setWare(Ware ware) {
        this.ware = ware;
    }
}
