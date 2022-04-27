package de.dlrg.backend.Controller;

import de.dlrg.backend.Entity.Kaufe;
import de.dlrg.backend.Repository.benutzerRepository;
import de.dlrg.backend.Repository.kaufeRepository;
import de.dlrg.backend.Repository.wareRepository;
import de.dlrg.backend.Time.sqlTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Definition als RestController Klasse
@RestController
@RequestMapping("/kaeufe") //Pfad für den Aufruf der REST Services
public class kaufeController {
    //Attribut der benötigten Repository werden angelegt
    private kaufeRepository kauferepository;
    private benutzerRepository benutzerrepository;
    private wareRepository warerepository;

    //Beim Aufruf der Klasse werden die Repositorys mit im Konstruktor übergeben
    public kaufeController(kaufeRepository kauferepository, benutzerRepository benutzerrepository, wareRepository warerepository) {
        this.kauferepository = kauferepository;
        this.benutzerrepository = benutzerrepository;
        this.warerepository = warerepository;
    }
    /*
        --Abfrage aller Käufe--
        HTTP-Get Methode
        Beim Aufruf werden alle Inhalte des Repositories zurückgegeben
     */
    @GetMapping(path = "/get", produces = "application/json") //Annotation für HTTP-Get + HTTP-Pfad + den Rückgabetyp als JSON String
    public ResponseEntity<List<Kaufe>> get(){
        //Bedingung wenn das Repository nicht leer ist
        if (!kauferepository.findAll().isEmpty()) {
            //Wird das komplette Repository als ResponseEntity List zurückgegeben
            return ResponseEntity.ok(kauferepository.findAll());
        }
        else{
            //Wenn das Repsoitory leer ist, wird ein NullWert und HTTPStatus.Not_Found zurückgegeben
            return new ResponseEntity<List<Kaufe>>((List<Kaufe>) null, HttpStatus.NOT_FOUND);
        }
    }

    /*
        --Kauf erstellen--
        HTTP-Post Methode
        Beim Methodenaufruf wird die BenutzerID und die WarenID übergeben
     */
    @PostMapping(path = "/add") //Annotation für HTTP-Post + HTTP-Pfad
    public ResponseEntity<String> add(@RequestParam(value = "userid", required = true)long userid, @RequestParam(value = "wareid", required = true) long wareid){
        sqlTime time = new sqlTime(); //Objekt time vom Typ sqlTime
        Kaufe tmp = new Kaufe(); //Objekt tmp vom Typ Kaufe

        //Bedingung Übergabeparameter userid und wareid dürfen nicht 0 sein
        if (!(userid == 0) && !(wareid == 0)) {
            try {
                //Speicherung des gesuchten Benutzerobjektes in einer variable
                var tmpbenutzer = benutzerrepository.findById(userid);
                //Speicherung des gesuchten Warenobjektes in einer variable
                var tmpware = warerepository.findById(wareid);
                //Prüfung ob Guthaben größer als 0 ist
                if (tmpbenutzer.get().getGuthaben() > 0) {
                    //Prüfung ob die Anzahl der Waren größer als 0ist
                    if (tmpware.get().getAnzahl() != 0) {
                        //Die Aktuelle Ware wird um 1 verringert
                        tmpware.get().setAnzahl(tmpware.get().getAnzahl() - 1);
                        //Das Objekt wird anschließend im Repository gespeichert
                        warerepository.save(tmpware.get());
                    }
                    else
                    {
                        return new ResponseEntity<>("Ware is empty", HttpStatus.NOT_ACCEPTABLE);
                    }
                    tmp.setDatum(time.getSqlDate()); //Kaufobjekt wird mit dem Objekt time hinterlegt
                    tmp.setUser(tmpbenutzer.get()); //Kaufobjekt wird mit dem Objekt tmpbenutzer hinterlegt
                    tmp.setWare(tmpware.get()); //Kaufobjekt wird mit dem Objekt tmpware hinterlegt
                    tmpbenutzer.get().setGuthaben(tmpbenutzer.get().getGuthaben() - 1); //Guthaben des Benutzers wird reduziert
                    kauferepository.save(tmp);//Speicherung vom Objekt tmp im repository kaufe
                    //Rückgabe bei Erfolgreicher Erstellung der ResponseEntity + HTTPStatus.ok
                    return new ResponseEntity<>("Purchase successful", HttpStatus.OK);
                }
                else{
                    //Rückgabe wenn das Guthaben zu Gering ist einer ResponseEntity + HttpStatus.NOT_Acceptablr
                    return new ResponseEntity<>("Credit not sufficient", HttpStatus.NOT_ACCEPTABLE);
                }
            }
            catch (Exception ex){
                //Bei Fehlern im Aufruf wird eine ResponseEntity + HttpStaus.Bad_Request zurückgegeben
                return new ResponseEntity<>("Creation incorrect", HttpStatus.BAD_REQUEST);
            }


        }
        //Wenn die Waren oder BenutzerID null ist wird eine ResponseEntity + HttpStatus.Bas_Request zurückgegeben
        return new ResponseEntity<>("Creation incorrect", HttpStatus.BAD_REQUEST);
    }

}
