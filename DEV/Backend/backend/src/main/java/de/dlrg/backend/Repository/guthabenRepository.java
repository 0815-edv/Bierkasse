package de.dlrg.backend.Repository;

import de.dlrg.backend.Entity.GuthabenAuftraege;
import org.springframework.data.jpa.repository.JpaRepository;
/*
Für den Zugriff auf die Datenbank kommen sogenannte JPARepositories zum Einsatz.
Diese sind Interfaces, die von JpaRepository(Klasse, PublicID) erben.
Hier wird ein Zugriff auf GuthabenAuftraege eingerichtet
 */
public interface guthabenRepository extends JpaRepository<GuthabenAuftraege, Long> {
}
