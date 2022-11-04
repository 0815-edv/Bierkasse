package de.dlrg.backend.Entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @JsonIgnore
    @OneToMany(mappedBy = "benutzer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Kaufe> kaeuefe= new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "benutzerAuftrag", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GuthabenAuftraege> guthabenAuftraegeList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "benutzerRevision", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GuthabenRevision> guthabenRevisionList = new ArrayList<>();

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

    public List<Kaufe> getKaeuefe() {
        return kaeuefe;
    }

    public void setKaeuefe(List<Kaufe> kaeuefe) {
        this.kaeuefe = kaeuefe;
    }

    public List<GuthabenAuftraege> getGuthabenAuftraegeList() {
        return guthabenAuftraegeList;
    }

    public void setGuthabenAuftraegeList(List<GuthabenAuftraege> guthabenAuftraegeList) {
        this.guthabenAuftraegeList = guthabenAuftraegeList;
    }

    public List<GuthabenRevision> getGuthabenRevisionList() {
        return guthabenRevisionList;
    }

    public void setGuthabenRevisionList(List<GuthabenRevision> guthabenRevisionList) {
        this.guthabenRevisionList = guthabenRevisionList;
    }

    public void addKaeufe(Kaufe kaufe){
        kaeuefe.add(kaufe);
    }

    public void addGuthabenAuftrag( GuthabenAuftraege guthabenAuftraege){
        guthabenAuftraegeList.add(guthabenAuftraege);
    }

    public void addGuthabenRevision(GuthabenRevision guthabenRevision){
        guthabenRevisionList.add(guthabenRevision);
    }

}
