package de.dlrg.backend.Controller;


import de.dlrg.backend.Entity.GuthabenAuftraege;
import de.dlrg.backend.Entity.GuthabenRevision;
import de.dlrg.backend.Enum.AcceptEnum;
import de.dlrg.backend.Repository.BenutzerRepository;
import de.dlrg.backend.Repository.GuthabenRepository;
import de.dlrg.backend.Repository.RevisionRepository;
import de.dlrg.backend.Service.GuthabenService;
import de.dlrg.backend.Time.sqlTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Definiton der Klasse als RestController Klasse
@RequestMapping("/guthaben")
public class guthabenController {

    private GuthabenService guthabenService;

    public guthabenController(GuthabenService guthabenService) {
        this.guthabenService = guthabenService;
    }

    @GetMapping(path = "/get", produces = "application/json")
    public ResponseEntity<List<GuthabenAuftraege>> get(){
        return ResponseEntity.ok(guthabenService.getAuftröge());
    }


    @GetMapping(path = "/revision/get", produces = "application/json")
    public ResponseEntity<List<GuthabenRevision>> getRevision(){
        return ResponseEntity.ok(guthabenService.getRevision());
    }

    @PostMapping(path = "/antrag/add")
    public ResponseEntity<String> addAntrag(@RequestParam long user_id, @RequestParam double wert) {
        if (guthabenService.offer(user_id, wert)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    /*
        --Antrag für Guthaben Akzeptieren--
        HTTP-Post Methode
        Übergabeparameter ist die ID von GuthabenAufträge
     */
    @PostMapping(path = "/antrag/accept")
    public ResponseEntity<String> acceptAntrag(@RequestParam(value = "AuftragsID", required = true) long id) {
        if(guthabenService.offerService(id, AcceptEnum.accept)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    /*
        --Antrag für Guthaben Ablehnen--
        HTTP-Post Methode
        Übergabeparameter ist die ID von GuthabenAufträge
     */
    @PostMapping(path = "/antrag/deny")
    public ResponseEntity<String> denyAntrag(@RequestParam(value = "AuftragsID", required = true)long id){
        if(guthabenService.offerService(id, AcceptEnum.deny)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
