package de.dlrg.backend.Controller;


import de.dlrg.backend.Entity.GuthabenAuftraege;
import de.dlrg.backend.Entity.GuthabenRevision;
import de.dlrg.backend.Enum.AcceptEnum;
import de.dlrg.backend.Repository.benutzerRepository;
import de.dlrg.backend.Repository.guthabenRepository;
import de.dlrg.backend.Repository.revisionRepository;
import de.dlrg.backend.Time.sqlTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Definiton der Klasse als RestController Klasse
@RequestMapping("/guthaben")
public class guthabenController {
    /*
        Die Attribute geben dem Controller die Möglichkeit zugriffe auf die Repositories auszuführen
     */
    private guthabenRepository guthabenrepository; //Attribut von dem guthabenRepository
    private revisionRepository revisionsrepository; //Attribut von dem revisionRepository
    private benutzerRepository benutzerrepository; //Attribut von dem benutzerRepository

    //Konstruktor mit dem Übergabeparameter der Repositories
    public guthabenController(guthabenRepository guthabenrepository, revisionRepository revisionsrepository, benutzerRepository benutzerrepository) {
        this.guthabenrepository = guthabenrepository;
        this.revisionsrepository = revisionsrepository;
        this.benutzerrepository = benutzerrepository;
    }
    /*
        --Rückgabe aller Guthaben Anträge--
        HTTP-Get Methode
     */
    @GetMapping(path = "/get", produces = "application/json") // HTTP-PFad + Rückgabetyp als JSON String
    public ResponseEntity<List<GuthabenAuftraege>> get(){
        //Bedingung, wenn das Repository nicht leer ist
        if (!guthabenrepository.findAll().isEmpty()) {
            //Rückgabe einer ResponseEntity + HTTPStatus OK und dem kompletten guthabenRepository
            return ResponseEntity.ok(guthabenrepository.findAll());
        }
        else {
            //Wenn Repository leer ist, wird eine ResponseEntity mit dem HTTPStatus.Not_Found und einer leeren Liste zurückgegeben
            return new ResponseEntity<List<GuthabenAuftraege>>((List<GuthabenAuftraege>) null, HttpStatus.NOT_FOUND);
        }
    }
    /*
        --Rückgabe aller archivierten GuthabenAnträge--
        HTTP-Get Methode
     */
    @GetMapping(path = "/revision/get", produces = "application/json") // HTTP-PFad + Rückgabetyp als JSON String
    public ResponseEntity<List<GuthabenRevision>> getRevision(){
        //Bedingung, wenn das Repository nicht leer ist
        if (!revisionsrepository.findAll().isEmpty()) {
            //Rückgabe einer ResponseEntity + HTTPStatus OK und dem kompletten guthabenRepository
            return ResponseEntity.ok(revisionsrepository.findAll());
        }
        else{
            //Wenn Repository leer ist, wird eine ResponseEntity mit dem HTTPStatus.Not_Found und einer leeren Liste zurückgegeben
            return new ResponseEntity<List<GuthabenRevision>>((List<GuthabenRevision>) null, HttpStatus.NOT_FOUND);
        }
    }
    /*
        --Antrag für Guthaben erstellen--
        HTTP-Post Methode
        Übergabeparameter ist die BenutzerID + den Wert
     */
    @PostMapping(path = "/antrag/add")
    public ResponseEntity<String> addAntrag(@RequestParam long user_id, @RequestParam double wert) {
        //Temporäres Objekt von GuthabenAuftraege wird erstellt
        GuthabenAuftraege tmp =new GuthabenAuftraege();
        //Zeitstempel Objekt vom typ sqlTime wird erstellt
        sqlTime time = new sqlTime();
        //Bedingung ob der Benutzer und der übergebene Wert nicht 0 ist
        if (user_id != 0 && wert > 0) {
            try {
                //Zwischenspeichern des Benutzers im Objekt benutzertmp. Dieses wird anhand der ID mit der findByID methode aufgerufen
                var benutzertmp = benutzerrepository.findById(user_id);
                //Das Objekt tmp setzt das Objekt vom aufgerufen Benutzer
                tmp.setBenutzer(benutzertmp.get());
                // Das Objekt tmp setzt den Guthabenwert
                tmp.setWert(wert);
                // Das Objekt setzt den Zeitstempel der Durchführungszeit
                tmp.setAddDatum(time.getSqlDate());
                //Speicherung des Objektes im Repository
                guthabenrepository.save(tmp);
                //Rückgabe einer ResponseEntity mit dem HTTPStatus.CREATES
                return new ResponseEntity<>("Request created", HttpStatus.CREATED);
            }
            catch (Exception ex){
                //Bei fehlerhaftem Transfer: Rückgabe einer ResponseEntity mit dem HTTPStatus.COFLICT
                return new ResponseEntity<>("Error during transfer", HttpStatus.CONFLICT);
            }

        }
        else
        {
            //Wenn Benutzer und Ware 0 ist: Rückgabe einer ResponseEntity mit dem HTTPStatus.NOT_FOUND
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    /*
        --Antrag für Guthaben Akzeptieren--
        HTTP-Post Methode
        Übergabeparameter ist die ID von GuthabenAufträge
     */
    @PostMapping(path = "/antrag/accept")
    public ResponseEntity<String> acceptAntrag(@RequestParam(value = "AuftragsID", required = true) long id) {
        //Zeitstempel Objekt vom typ sqlTime wird erstellt
        sqlTime time = new sqlTime();
        //Bedingung wenn die id nicht 0 ist
        if (id != 0) {
            try {
                //Zwischenspeichern des Guthaben auftrages im Objekt auftrag. Dieses wird anhand der ID mit der findByID methode aufgerufen
                var auftrag = guthabenrepository.findById(id);
                //Zwischenspeichern des benutzers im Objekt tmp_benutzer. Dies wird anhand der ID mit der findByID methode aufgerufen
                var tmp_benutzer = benutzerrepository.findById(auftrag.get().getBenutzer().getId());
                //Erstellung eines neuen objektes addRevision vom Typ GuthabenRevision
                GuthabenRevision addRevision = new GuthabenRevision();
                //Anpassung des guthabens vom ausgewählten benutzer
                tmp_benutzer.get().setGuthaben(tmp_benutzer.get().getGuthaben() + auftrag.get().getWert());
                // Setzen folgender Paramater im Objekt addRevision (Benutzerobjekt + Zeitstempel + GuthabenWert + Akzeptiert)
                addRevision.setBenutzer(tmp_benutzer.get());
                addRevision.setAcceptDate(time.getSqlDate());
                addRevision.setWert(auftrag.get().getWert());
                addRevision.setStatus(AcceptEnum.accept);
                //Speicherung des Auftrages im RevisionsRepository
                revisionsrepository.save(addRevision);
                //Löschung vom guthaben auftrag im Auftrags repository
                guthabenrepository.delete(auftrag.get());
                //Rückgabe einer ResponseEntity mit dem HTTPStatus.OK
                return ResponseEntity.ok("Request accept");
            } catch (Exception ex) {
                //Bei fehlerhaftem Transfer: Rückgabe einer ResponseEntity mit dem HTTPStatus.Bad_Request
                return new ResponseEntity<>("Request can't deny", HttpStatus.BAD_REQUEST);

            }
        }
        //Wenn die AuftragsID 0 ist: Rückgabe einer ResponseEntity mit dem HTTPStatus.NOT_ACCEPTABLE
        return new ResponseEntity<>("User not found", HttpStatus.NOT_ACCEPTABLE);

    }

    /*
        --Antrag für Guthaben Ablehnen--
        HTTP-Post Methode
        Übergabeparameter ist die ID von GuthabenAufträge
     */
    @PostMapping(path = "/antrag/deny")
    public ResponseEntity<String> denyAntrag(@RequestParam(value = "AuftragsID", required = true)long id){
        //Zeitstempel Objekt vom typ sqlTime wird erstellt
        sqlTime time = new sqlTime();
        //Bedingung wenn die id nicht 0 ist
        if (id != 0) {
            try {
                //Zwischenspeichern des Guthaben auftrages im Objekt auftrag. Dieses wird anhand der ID mit der findByID methode aufgerufen
                var auftrag = guthabenrepository.findById(id);
                //Zwischenspeichern des im Auftrag hinterlegten Benutzer.
                var tmp_benutzer = benutzerrepository.findById(auftrag.get().getBenutzer().getId());
                //Anlegen eines neuen OBjektes vom Typ GuthabenRevision
                GuthabenRevision addRevision = new GuthabenRevision();

                //Benutzerobjekt an das Revisionsobjekt übergeben
                addRevision.setBenutzer(tmp_benutzer.get());
                //Zeitstempel Objekt an das Revisionsobjekt übergeben
                addRevision.setAcceptDate(time.getSqlDate());
                //Auftragswert an das Revisionsobjekt übergeben
                addRevision.setWert(auftrag.get().getWert());
                //Statuswert an das Revisionsobjekt übergeben
                addRevision.setStatus(AcceptEnum.deny);
                //Speicherung des Revisionsobjekt im Repository
                revisionsrepository.save(addRevision);
                //Löschen des AuftragsObjektes aus dem Guthabenrepository
                guthabenrepository.delete(auftrag.get());
                //Rückgabe einer ResponseEntity mit dem HTTPStatus.OK
                return ResponseEntity.ok("Request accept");
            } catch (Exception ex) {
                //Bei fehlerhaftem Transfer: Rückgabe einer ResponseEntity mit dem HTTPStatus.Bad_Request
                return new ResponseEntity<>("Request can't deny", HttpStatus.BAD_REQUEST);
            }
        }
        //Wenn die AuftragsID 0 ist: Rückgabe einer ResponseEntity mit dem HTTPStatus.NOT_ACCEPTABLE
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
}
