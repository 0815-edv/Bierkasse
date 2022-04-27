package de.dlrg.backend.Controller;

import de.dlrg.backend.Entity.Benutzer;
import de.dlrg.backend.Repository.benutzerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Definiton der Klasse als RestController Klasse
@RequestMapping("/benutzer") //Pfad für den Aufruf der REST Services
public class benutzerController {

    private benutzerRepository benutzerrepository; // Attribut benuterrepository von benuterRepository.
    /*
        Gibt dem Controller die Möglichkeit zugriffe auf das Repository von Benutzer
     */

    //Methode für die Rückgabe aller Werte im Benutzerrepository
    public benutzerRepository getBenutzerrepository() {
        return benutzerrepository;
    }
    //Konstruktor mit dem ÜbergabeParameter benutzerRepository
    public benutzerController(benutzerRepository benutzerrepository) {
        this.benutzerrepository = benutzerrepository;
    }
    /*
        --Get all Benutzer--
        HTTP-Get Request
        Methode zur Rückgabe aller Benutzer Werte die sich im Repository von benutzerrepository befinden.
        Der RückgabeTyp ist ein Objekt von ResponseEntity
     */
    @GetMapping(path = "/get", produces = "application/json") //Annotation für HTTP-Get mit dem HTTP pfad /get und der Rückgabe eine JSON Strings
    public ResponseEntity<List<Benutzer>> get(){
        // Bedingung wenn alles aus dem benutzerrepository nicht leer ist
        if (!benutzerrepository.findAll().isEmpty()) {
            //Rückgabe des Objektes ResponseEntity mit dem statischen Methoden Aufruf "ok". ÜbergabeParameter ist das benutzerrepository mit dem Methodenaufruf "findall"
            return ResponseEntity.ok(benutzerrepository.findAll());
        }
        else
        {
            //Wenn das Repository null ist, Gibt es eine Liste von Benutzer mit dem Wert null zurück und dem HTTP Status Not found
            return new ResponseEntity<List<Benutzer>>((List<Benutzer>) null, HttpStatus.NOT_FOUND);
        }
    }
    /*
        --Get Benutzer anhand seiner Public ID--
        HTTP-Get Request
        Methode zur Rückgabe von BenutzerWerten mit der Übergeben-ID, die sich im Repository von benutzerrepository befinden.
        Der RückgabeTyp ist ein Objekt von ResponseEntity
     */
    @GetMapping(path = "/get/id", produces = "application/json") //Annotation für HTTP-Get mit dem HTTP pfad /get und der Rückgabe eine JSON Strings
    public ResponseEntity<Benutzer> getBenutzer(@RequestParam(value = "id", required = true) long id) // Übergabe beim HTTP Aufruf der ID.
    {
        var benutzer = benutzerrepository.findById(id); //Aufruf der Methode findbyID (mit dem Übergabeparameter id) von benutzerrepository. Der Rückgabetyp wird in einer Java var gespeichert
        //Bedingung wenn var Benutzer nicht leer ist
        if (!benutzer.isEmpty()){
            //Rückgabe des Objektes ResponseEntity  mit dem statischen Methodenaufruf "ok". Übergabeparameter ist der benutzer von var und den aufruf von get für die Rückgabe der Werte
            return ResponseEntity.ok(benutzer.get());

        }
        else {
            //Wenn der benutzer null ist, Gibt es eine Liste von Benutzer mit dem Wert null zurück und dem HTTP Status Not found
            return new ResponseEntity<Benutzer>((Benutzer) null, HttpStatus.NOT_FOUND);
        }
    }
    /*
        --Get Benutzer anhand der CHIPID--
        HTTP-Get Request
        Methode zur Rückgabe von BenutzerWerten mit der Übergeben-ID, die sich im Repository von benutzerrepository befinden.
        Der RückgabeTyp ist ein Objekt von ResponseEntity
        Das Prinzip ist das gleicher wie bei der Methode get nur wird das Attribut chipid abgefragt
     */
    @GetMapping(path = "/get/chipid", produces = "application/json") // //Annotation für HTTP-Get mit dem HTTP pfad /get und der Rückgabe eine JSON Strings
    public ResponseEntity<Benutzer> getBenutzerbyChipID(@RequestParam(value = "chipid", required = true) long id){
        var benutzer = benutzerrepository.findByChipid(id);
        if (!benutzer.isEmpty()) {
            return ResponseEntity.ok(benutzer.get());
        }
        else {
            return new ResponseEntity<Benutzer>((Benutzer) null, HttpStatus.NOT_FOUND);
        }
    }


    /*
        --Erstellung des Benutzers--
        HTTP-Post Methode
        Methode zur Erstellung von Benutzern im Repository.
        Notwendige Übergabeparameter sind der vorname als String, name als String und chipid als Long als RequestParameter
     */
    @PostMapping(path = "/add") // Annotation für HTTP Post  + HTTP-Pfad
    public ResponseEntity<String> addBenutzer(@RequestParam String vorname, @RequestParam String name, @RequestParam Long chipid) {
        //PRüfung ob die ChipID schon bei einem nutzer belegt ist
        if (benutzerrepository.findByChipid(chipid).isEmpty()) {
            //Temporäres benutzerobjekt wird initialisiert. Wert aus dem HTTP-Request werden dem Objekt gesetzt
            Benutzer tmp = new Benutzer();
            tmp.setName(name);
            tmp.setVorname(vorname);
            tmp.setChipid(chipid);
            tmp.setGuthaben(0); // Guthaben ist bei der neuanlage auf 0

            benutzerrepository.save(tmp); // Speicherung des temporären Benutzer in das Repository
            return new ResponseEntity<>("User entity added successfully.", HttpStatus.CREATED); // Rückgabe String + HTTP Created
        }
        else {
            return new ResponseEntity<>("User already present", HttpStatus.CONFLICT); // Bei vorhandenem Benutzer ist die Rückgabe String +  HttpStatus Conflict
        }
    }

    /*
        --Ändern von BenutzerInformationen--
        HTTP-PUT Methode
        Übergabe Parameter ist die ID + Änderungsparameter von Vorname, name, chipid beim Methodenaufruf als RequestParameter
     */
    @PutMapping(path = "/change") //Annotation für HTTP-PUT + HTTP Pfad
    public ResponseEntity<String> changeUser(@RequestParam(value = "id", required = true)long id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "vorname", required = false) String vorname, @RequestParam(value = "chipid", required = false, defaultValue = "0") long chipid){
        try {
            //Zwischenspeichern des Benutzer im objekt benutzer. Dieses wird anhand der ID mit der findByID methode aufgerufen
            var benutzer = benutzerrepository.findById(id).get();
            //Änderung der Daten wenn die Übergabeparameter nicht null sind in der temporären Objekt variable
            if (name != null) {
                benutzer.setName(name);
            }
            if (vorname != null) {
                benutzer.setVorname(vorname);
            }
            if (chipid != 0) {
                benutzer.setChipid(chipid);
            }
            //Speichern der Änderungen im Repository
            benutzerrepository.save(benutzer);
            //Rückgabewert von ResponseEntity mit HTTPStatus.OK
            return new ResponseEntity<>("User changed", HttpStatus.OK);
        }
        catch (Exception ex){
            //Bei Fehlerhaften aufruf wird der HTTPStatus.Conflict zurückgegeben
            return new ResponseEntity<>("User cannot Change", HttpStatus.CONFLICT);
        }
    }
    /*
        --Löschen des Benutzers--
        HTTP-Delete Methode
        Übergabe der ID für die Löschung des Benutzer als RequestParameter
         */
    @DeleteMapping(path = "/del/id") //Annotation für HTTP-Delete + HTTP Pfad
    public ResponseEntity<String> deleteBenutzer(@RequestParam(value = "id", required = true) long id){
        //Bedingungsaufruf wenn die suche nach dem Benutzer nicht null ist
        if (!benutzerrepository.findById(id).isEmpty()){
            //Benutzer wird aus dem Repository gelöscht
            benutzerrepository.deleteById(id);
            //Rückgabewert von ResponseEntity mit HTTPStatus.OK
            return new ResponseEntity<>("User deletet Sucessfully", HttpStatus.OK);
        }
        //Rückgabewert von ResponseEntity mit HTTPStatus.NOT_Found
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);

    }

    /*
        --Guthaben Erhöhen--
        HTTP-Patch Methode
        Übergeben wird beim Methodenaufruf die ID + den Geldwert der Änderung als RequestParameter
    */

    @PatchMapping(path = "/guthaben/add") //Annotation für HTTP-Patch + HTTP-Pfad
    public ResponseEntity<String> addGuthaben(@RequestParam(value = "id", required = true) long id, @RequestParam double guthaben){
         //Bedingungsaufruf wenn die suche nach dem Benutzer nicht null ist
        if (!benutzerrepository.findById(id).isEmpty()) {
            //Zwischenspeichern des Benutzer im objekt getbenutzer. Dieses wird anhand der ID mit der findByID methode aufgerufen
            var getBenutzer = benutzerrepository.findById(id).get();
            //Addition des aktuellen Guthaben + das zu ergänzende
            getBenutzer.setGuthaben(getBenutzer.getGuthaben() + guthaben);
            //Speicherung des benutzer im Repository
            benutzerrepository.save(getBenutzer);
            //RückgabeTyp von ResponseEntity mit HTTPStatus.OK
            return new ResponseEntity<>("Credit increased by " + guthaben + "€", HttpStatus.OK);
        }
        else {
            //Rückgabe wenn BEnutzer nicht vorhanden mit HttpStatus.Not_Found
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    /*
        --Guthaben Verringern--
        Gleich wie bei Guthaben Erhöhung

    */

    @PatchMapping(path = "/guthaben/sub")
    public ResponseEntity<String> delGuthaben(@RequestParam(value = "id", required = true) long id, @RequestParam double guthaben){
        var getBenutzer = benutzerrepository.findById(id).get();
        //Prüfung ob das Aktuelle guthaben Größer ist als das zu Verringernde. Ein Konto im Minus ist nicht möglich
        if (getBenutzer.getGuthaben() > guthaben) {
            //Suntraktion des aktuellen Guthaben - das Übergebene
            getBenutzer.setGuthaben(getBenutzer.getGuthaben() - guthaben);
        }
        else {
            return new ResponseEntity<>("Credit too low", HttpStatus.NOT_ACCEPTABLE);

        }
        benutzerrepository.save(getBenutzer);
        return new ResponseEntity<>("Credit was reduced by: " + guthaben + "€", HttpStatus.OK);

    }
}
