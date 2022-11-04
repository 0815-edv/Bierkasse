package de.dlrg.backend.Controller;

import de.dlrg.backend.Entity.Kaufe;
import de.dlrg.backend.Repository.BenutzerRepository;
import de.dlrg.backend.Repository.KaufeRepository;
import de.dlrg.backend.Repository.WareRepository;
import de.dlrg.backend.Service.KaufeService;
import de.dlrg.backend.Time.sqlTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/kaeufe")
public class kaufeController {
    private KaufeService kaufeService;

    public kaufeController(KaufeService kaufeService) {
        this.kaufeService = kaufeService;
    }

    @GetMapping(path = "/get", produces = "application/json") //Annotation für HTTP-Get + HTTP-Pfad + den Rückgabetyp als JSON String
    public ResponseEntity<List<Kaufe>> get(){
        return ResponseEntity.ok(kaufeService.get());
    }

    @PostMapping(path = "/add") //Annotation für HTTP-Post + HTTP-Pfad
    public ResponseEntity<String> add(@RequestParam(value = "userid", required = true)long userid,
                                      @RequestParam(value = "wareid", required = true) long wareid)
    {

        if(kaufeService.add(userid, wareid)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

}
