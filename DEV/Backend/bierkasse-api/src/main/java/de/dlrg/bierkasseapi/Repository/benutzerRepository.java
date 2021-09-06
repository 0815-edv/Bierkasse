/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dlrg.bierkasseapi.Repository;

import de.dlrg.bierkasseapi.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author flori
 */
public interface benutzerRepository extends JpaRepository<Benutzer, Long> {
    
}
