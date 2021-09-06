/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dlrg.bierkasseapi.Controller;

import de.dlrg.bierkasseapi.Benutzer;
import de.dlrg.bierkasseapi.Repository.benutzerRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author flori
 */
public class benutzerController {
 
    private benutzerRepository benutzerrepository;

    public benutzerController(benutzerRepository benutzerrepository) {
        this.benutzerrepository = benutzerrepository;
    }
    
    
    
    @GetMapping(path = "/get/benutzer", produces = "application/json")
    public ResponseEntity<List<Benutzer>> getCities() {
        return ResponseEntity.ok(benutzerrepository.findAll());
    }
    
}
