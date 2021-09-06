package de.dlrg.Restservice;


import javax.persistence.*;

@Entity
@Table(name = "Ware")
public class Ware {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int anzahl;

    public Ware(Long id, String name, int anzahl) {
        this.id = id;
        this.name = name;
        this.anzahl = anzahl;
    }

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
}
