/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.bierkasseapi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hax0r
 */
@RestController
public class AbrechnungsController {
    @GetMapping("/version")
    public String getVersion(){
        return "1.0";
    }
}
