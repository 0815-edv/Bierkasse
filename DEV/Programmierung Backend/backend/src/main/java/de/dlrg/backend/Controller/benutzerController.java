package de.dlrg.backend.Controller;

import de.dlrg.backend.Entity.Benutzer;
import de.dlrg.backend.Enum.Direction;
import de.dlrg.backend.Logging.LogService;
import de.dlrg.backend.Service.BenutzerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/benutzer")
public class benutzerController {

    private BenutzerService benutzerService;


    public benutzerController(BenutzerService benutzerService) {
        this.benutzerService = benutzerService;
    }

    @GetMapping(path = "/get", produces = "application/json")
    public ResponseEntity<List<Benutzer>> get(){
        LogService.logger.info("Liste Benutzer generiert");
        return ResponseEntity.ok(benutzerService.get());
    }


    @GetMapping(value = "/getid/{id}", produces = "application/json")
    public ResponseEntity<Benutzer> getbyid(@RequestParam(value = "id", required = true) long id) {
        Benutzer benutzer = benutzerService.getbyId(id);
        if (benutzer != null){
            return ResponseEntity.ok(benutzer);
        }
        else {

            return new ResponseEntity<Benutzer>((Benutzer) null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/getchipid/{chipid}", produces = "application/json")
    public ResponseEntity<Benutzer> getbychipid(@RequestParam(value = "chipid", required = true) long chipid){

        Benutzer benutzer = benutzerService.getbychipid(chipid);
        if (benutzer != null){
            return ResponseEntity.ok(benutzer);
        }
        else{
            return new ResponseEntity<Benutzer>((Benutzer) null, HttpStatus.NOT_FOUND);
        }

    }



    @PostMapping(path = "/create")
    public ResponseEntity<String> create(@RequestParam(value = "vorname", required = true) String vorname,
                                         @RequestParam(value = "name", required = true) String name,
                                         @RequestParam(value = "chipid", required = true) Long chipid) {

        if (benutzerService.create(vorname, name, chipid)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }


    @PatchMapping(path = "/change") //Annotation für HTTP-PUT + HTTP Pfad
    public ResponseEntity<String> changeUser(@RequestParam(value = "id", required = true)long id,
                                             @RequestParam(value = "name", required = false) String name,
                                             @RequestParam(value = "vorname", required = false) String vorname,
                                             @RequestParam(value = "chipid", required = false) long chipid)
    {
        if (benutzerService.change(id, name, vorname, chipid)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBenutzer(@RequestParam(value = "id", required = true) long id){
        if (benutzerService.deletebyid(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping(path = "/guthaben/add") //Annotation für HTTP-Patch + HTTP-Pfad
    public ResponseEntity<String> addGuthaben(@RequestParam(value = "id", required = true) long id,
                                              @RequestParam double credit) {
        if (benutzerService.changeCredit(id, credit, Direction.add)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }


    @PatchMapping(path = "/guthaben/sub")
    public ResponseEntity<String> delGuthaben(@RequestParam(value = "id", required = true) long id,
                                              @RequestParam double credit){
        if (benutzerService.changeCredit(id, credit, Direction.sub)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
