package de.dlrg.backend.Entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import de.dlrg.backend.Enum.AcceptEnum;

import javax.persistence.*;
import java.sql.Date;

@JsonAutoDetect(getterVisibility= JsonAutoDetect.Visibility.ANY)
@Entity //Weist die Klasse als Datenbanktabelle zu - alle Attribute werden gleichnamig benannt
@Table(name = "GuthabenRevision")  // Name der Tabelle in MySQL
public class GuthabenRevision {
    @Id // Festlegen der Public ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generierung des Public ID als Auto Increment
    private Long id = null; // Public ID

    @ManyToOne //Generierung der Annotation ManyToOne (Viele Objekte von GuthabenRevision zu einem Benutzer)
    private Benutzer benutzerRevision; // Attribut benutzer von Benutzer

    private Double wert; // Attribut wert als Double
    private Date acceptDate; // Attribut acceptDate als SQL Date
    private Boolean status; // Attribut Status als bool


    //Konstrutkor, wird für die Initialisierung der Datenbanktabelle benötigt
    public GuthabenRevision() {
    }

    //GET und SET Methoden
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Benutzer getBenutzerRevision() {
        return benutzerRevision;
    }

    public void setBenutzerRevision(Benutzer benutzerRevision) {
        this.benutzerRevision = benutzerRevision;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public Double getWert() {
        return wert;
    }

    public void setWert(Double wert) {
        this.wert = wert;
    }


    public Boolean getStatus() {
        return status;
    }

    //Methode setStatus für die Änderung des StatusTypes (Übergabe des Enums AcceptEnum)
    public void setStatus(AcceptEnum acceptEnum) {
        //Wenn der Übergabewert accept lautet, dann wird der Status auf true also gehnemigt gesetzt
        if (acceptEnum == AcceptEnum.accept){
            this.status = true;
        }
        //Wenn der ÜbergabeWert deny lautet, dann wird der status auf False also abgelehnt gesetzt
        else if (acceptEnum == AcceptEnum.deny){
            this.status = false;
        }
    }
}
