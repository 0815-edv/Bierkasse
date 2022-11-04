package de.dlrg.backend.Repository;

import de.dlrg.backend.Entity.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/*
Für den Zugriff auf die Datenbank kommen sogenannte JPARepositories zum Einsatz.
Diese sind Interfaces, die von JpaRepository(Klasse, PublicID) erben.
Hier wird ein Zugriff auf den Benutzer eingerichtet
 */
@Repository
public interface BenutzerRepository extends JpaRepository<Benutzer, Long> {
    //Es wird die Suchfunktion "findbyChipid" definiert.
    Optional<Benutzer> findByChipid(Long chipid);
    Optional<Benutzer> findByName(String name);
}
