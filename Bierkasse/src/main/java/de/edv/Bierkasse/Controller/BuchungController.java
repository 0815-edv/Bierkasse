/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.Bierkasse.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.person;

/**
 *
 * @author flori
 */
@RestController
public class BuchungController {
    
    private static ArrayList<person> personen = new ArrayList<>();

    public void initialize(){
    personen.add(new person("Florian", "WErner", "1"));
        personen.add(new person("Florian", "WErner", "2"));

    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/register", produces = APPLICATION_JSON_VALUE)
    

    
    @GetMapping("/test")
    public person[] test() {
        initialize();
        person[] tmp = new person[personen.size()];
        return personen.toArray(tmp);
        Repository.
    }
    
//    @GetMapping("/create")
    

}
