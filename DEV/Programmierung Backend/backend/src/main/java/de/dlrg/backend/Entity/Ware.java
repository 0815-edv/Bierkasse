package de.dlrg.backend.Entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect(getterVisibility= JsonAutoDetect.Visibility.ANY)

@Entity //Weist die Klasse als Datenbanktabelle zu - alle Attribute werden gleichnamig benannt
@Table(name = "Ware") //Name der Tabelle in MySQL
public class Ware {
    @Id // Festlegen der Public ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generierung der Public ID als Auto Increment
    private Long id; //Public-ID
    private String name; //Name als String
    private int anzahl; //Anzahl als INT

    @OneToMany(mappedBy = "ware", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Kaufe> kaufeList = new ArrayList<>();

    public Ware(Long id, String name, int anzahl) {
        this.id = id;
        this.name = name;
        this.anzahl = anzahl;
    }
    //Konstrutkor, wird für die Initialisierung der Datenbanktabelle benötigt
    public Ware() {

    }
    // GET und SET Methoden
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

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public List<Kaufe> getKaufeList() {
        return kaufeList;
    }

    public void setKaufeList(List<Kaufe> kaufeList) {
        this.kaufeList = kaufeList;
    }

    public void addKaufeList(Kaufe kaufe){
        kaufeList.add(kaufe);
    }
}
