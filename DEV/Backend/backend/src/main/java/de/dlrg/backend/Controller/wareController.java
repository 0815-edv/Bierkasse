package de.dlrg.backend.Controller;

import de.dlrg.backend.Entity.Ware;
import de.dlrg.backend.Repository.wareRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Definiton der Klasse als RestController Klasse
@RequestMapping("/ware") //Pfad für den Aufruf der REST Services
public class wareController {

    /*
        Gibt dem Controller die Möglichkeit zugriff auf das Repository von Ware
     */
    private wareRepository warerepository; //Attribut von dem Warenrepository

    //Get-Methode für die Rückgabe des Repository
    public wareRepository getWarerepository() {
        return warerepository;
    }

    //Konstruktor mit dem Übergabeparameter des Warenrepositories
    public wareController(wareRepository warerepository) {
        this.warerepository = warerepository;
    }

    /*
        --Rückgabe aller Waren--
        HTTP-Get Methode
     */
    @GetMapping(path = "/get", produces = "application/json") // HTTP-PFad + Rückgabetyp als JSON String
    public ResponseEntity<List<Ware>> get() {
        //Bedingung, wenn das Repository nicht leer ist
        if (!warerepository.findAll().isEmpty()) {
            //Rückgabe einer ResponseEntity + HTTPStatus OK und dem kompletten Warenrepository
            return ResponseEntity.ok(warerepository.findAll());
        }
        else
        {
            //Wenn Repository leer ist, wird eine ResponseEntity mit dem HTTPStatus.Not_Found und einer leeren Liste zurückgegeben
            return new ResponseEntity<List<Ware>>((List<Ware>) null, HttpStatus.NOT_FOUND);
        }
    }

    /*
        --Rückgabe der Ware anhand der ID--
        HTTP-Get Methode
        ÜbergabeParameter ist die ID als Long
     */
    @GetMapping(path = "/get/id", produces = "application/json") // HTTP-Pfad + Rückgabetyp als JsonString
    public ResponseEntity<Ware> getWare(@RequestParam(value = "id", required = true) long id){
        //Zwischenspeichern der Ware im Objekt ware. Dieses wird anhand der ID mit der findByID methode aufgerufen
        var ware = warerepository.findById(id);
        //Bedingung wenn das Objet ware nicht leer ist
        if (!ware.isEmpty()){
            //Rückgabe einer ResponseEntity + HTTPStatus OK und den Werten des Objektes ware
            return ResponseEntity.ok(ware.get());

        }
        else {
            //Wenn das Objekt leer ist, wird eine ResponseEntity mit dem HTTPStatus.Not_Found und einem leeren Warenobjekt zurückgegeben
            return new ResponseEntity<Ware>((Ware) null, HttpStatus.NOT_FOUND);
        }
    }
    /*
        --Erstellung neuer Ware--
        HTTP-POST Methode
        ÜbergabeParameter ist der name als String und die Anzahl als int
     */
    @PostMapping(path = "/add") // HTTP-Pfad
    public ResponseEntity<String> addWare(@RequestParam(value = "Artikelname", required = true) String name, @RequestParam int anzahl) {
        //Erstellung des Objekt tmp vom Typ ware
        Ware tmp = new Ware();
        //Definition des Namens mit der SET-Methode
        tmp.setName(name);
        //Bedingung wenn die anzahl nicht leer ist
        if (anzahl != 0) {
            //Definition der Anzahl anhand des Übergabeparameters der Methode mit der SET-Methode
            tmp.setAnzahl(anzahl);
        }
        else
        {
            //Ansonsten wird die Zahl auf 0 gesetzt
            tmp.setAnzahl(0);
        }
        //Speicherung des Objektes im Repository
        warerepository.save(tmp);
        //Rückgabe einer ResponseEntity mit dem HTTPStatus.OK
        return new ResponseEntity<>("Product entity added successfully.", HttpStatus.OK);

    }
    /*
       --Löschen einer Ware--
       HTTP-Delete Methode
       ÜbergabeParameter ist die ID als Long
    */
    @DeleteMapping(path = "/del") //HTTP-Pfad
    public ResponseEntity<String> deleteWare(@RequestParam(value = "id", required = true) long id){
        //Bedingung wenn die Suche nach der Ware anhand der ID nicht null ist
        if (!warerepository.findById(id).isEmpty()){
            //Löschung des Objektes anhand der ID aus dem Repository
            warerepository.deleteById(id);
            //Rückgabe einer ResponseEntity mit dem HTTPStatus.OK
            return new ResponseEntity<>("Product deletet Sucessfully", HttpStatus.OK);
        }
        //Wenn Ware nicht vorhanden, Rückgabe einer ResponseEntity mit dem HTTPStatus.Not_Found
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);

    }
    /*
       --Anzahl Erhöhen der Ware--
       HTTP-Patch Methode
       ÜbergabeParameter ist die ID als Long und die anzahl als Int
    */
    @PatchMapping(path = "/anzahl/add") //HTTP-Pfad
    public ResponseEntity<String> addAnzahl(@RequestParam long id, int anzahl){
        //Bedingung wenn die Suche nach der Ware anhand der ID nicht null ist
        if (!warerepository.findById(id).isEmpty()){
            //Zwischenspeichern der Ware im Objekt tmp. Dieses wird anhand der ID mit der findByID methode aufgerufen
            var tmp = warerepository.findById(id).get();
            //Die Anzahl erhöhen durch die Aktuelle Anzahl + den Übergebebenen Wert
            tmp.setAnzahl(tmp.getAnzahl() + anzahl);
            //Speicherung des Überarbeiteten Objektes im Repository
            warerepository.save(tmp);
            //Rückgabe einer ResponseEntity mit dem HTTPStatus.OK
            return new ResponseEntity<>("Number sucessfully changed", HttpStatus.OK);
        }
        //Wenn Ware nicht vorhanden, Rückgabe einer ResponseEntity mit dem HTTPStatus.Not_Found
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);

    }
    /*
       --Anzahl Verringern der Ware--
       HTTP-Patch Methode
       ÜbergabeParameter ist die ID als Long und die Anzahl als Int
    */
    @PatchMapping(path = "/anzahl/sub") //HTTP-Pfad
    public ResponseEntity<String> subAnzahl(@RequestParam long id, int anzahl){
        //Bedingung wenn die Suche nach der Ware anhand der ID nicht null ist
        if (!warerepository.findById(id).isEmpty()){
            //Zwischenspeichern der Ware im Objekt tmp. Dieses wird anhand der ID mit der findByID methode aufgerufen
            var tmp = warerepository.findById(id).get();
            //Bedingung, ob die Aktuelle größer als 0 ist und ob die übergebene Anzahl größer als die aktuelle Anzahl des Objektes ist
            if (tmp.getAnzahl() > 0 && anzahl <= tmp.getAnzahl()) {
                //Die Anzahl verringern durch die aktuelle- übergebene
                tmp.setAnzahl(tmp.getAnzahl() - anzahl);
                //Speicherung des überarbeiteten Objektes im Repository
                warerepository.save(tmp);
                //Rückgabe einer ResponseEntity mit dem HTTPStatus.OK
                return new ResponseEntity<>("Number sucessfully changed", HttpStatus.OK);
            }
            else
            {
                //Wenn die aktuelle Anzahl geringer ist als die Übergebene, Rückgabe einer ResponseEntity mit dem HTTPStatus.Not_Acceptable
                return new ResponseEntity<>("Too few articles available", HttpStatus.NOT_ACCEPTABLE);
            }
        }
        //Wenn ware nicht vorhanden, Rückgabe einer ResponseEntity mit dem HttpStatus.Not Found
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);

    }

}
