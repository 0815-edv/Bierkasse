package de.dlrg.backend.Repository;

import de.dlrg.backend.Entity.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/*
Für den Zugriff auf die Datenbank kommen sogenannte JPARepositories zum Einsatz.
Diese sind Interfaces, die von JpaRepository(Klasse, PublicID) erben.
Hier wird ein Zugriff auf den Benutzer eingerichtet
 */
public interface benutzerRepository extends JpaRepository<Benutzer, Long> {
    //Es wird die Suchfunktion "findbyChipid" definiert.
    Optional<Benutzer> findByChipid(Long chipid); // Das Attribut Optional ist eine Datenobjekt das zusätzlich auch den Wert null enthalten kann
}
