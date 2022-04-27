package de.dlrg.backend.Repository;

import de.dlrg.backend.Entity.GuthabenRevision;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Für den Zugriff auf die Datenbank kommen sogenannte JPARepositories zum Einsatz.
Diese sind Interfaces, die von JpaRepository(Klasse, PublicID) erben.
Hier wird ein Zugriff auf GuthabenRevision eingerichtet
 */
public interface revisionRepository extends JpaRepository<GuthabenRevision, Long> {

}
