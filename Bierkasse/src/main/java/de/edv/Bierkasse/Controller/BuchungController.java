/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.Bierkasse.Controller;

import java.util.ArrayList;
import java.util.List;
<<<<<<< Updated upstream
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.RestController;
import test.Person;

/**
 *
 * @author flori
 */
@RestController
//@RequestMapping("/test")
public class BuchungController {
    
    private static List<Person> personen = new ArrayList<>();
    @RequestMapping("/test")
    
    
//    public ResponseEntity<List<Person>> getCustomer() {
//        Person test = new Person("Max", "Mzstermann", "1");
//        personen.add(test);
//        return new ResponseEntity<>(personen, HttpStatus.OK);
//    }
    

    
<<<<<<< Updated upstream
    @GetMapping("/test")
    public person[] test() {
        initialize();
        person[] tmp = new person[personen.size()];
        return personen.toArray(tmp);
        //Repository.
    }
=======
    
>>>>>>> Stashed changes
    
//    @GetMapping("/create")
    

}
