package de.dlrg.backend.Repository;

import de.dlrg.backend.Entity.GuthabenAuftraege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Für den Zugriff auf die Datenbank kommen sogenannte JPARepositories zum Einsatz.
Diese sind Interfaces, die von JpaRepository(Klasse, PublicID) erben.
Hier wird ein Zugriff auf GuthabenAuftraege eingerichtet
 */
@Repository
public interface GuthabenRepository extends JpaRepository<GuthabenAuftraege, Long> {
}
