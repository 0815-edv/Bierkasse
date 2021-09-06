package de.dlrg.Restservice.Repository;

import de.dlrg.Restservice.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface benutzerRepository extends JpaRepository<Benutzer, Long> {
}
