package de.dlrg.Restservice;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "kaufe")
public class Kaufe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date datum;

    @OneToMany
    private Set<Benutzer> user;
    @OneToMany
    private Set<Ware> ware;

    public Kaufe(Long id, Date datum, Set<Benutzer> user, Set<Ware> ware) {
        this.id = id;
        this.datum = datum;
        this.user = user;
        this.ware = ware;
    }

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

    public Set<Benutzer> getUser() {
        return user;
    }

    public void setUser(Set<Benutzer> benutzer) {
        this.user = benutzer;
    }

    public Set<Ware> getWare() {
        return ware;
    }

    public void setWare(Set<Ware> ware) {
        this.ware = ware;
    }
}
