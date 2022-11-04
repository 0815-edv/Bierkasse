package de.dlrg.backend.Repository;

import de.dlrg.backend.Entity.Kaufe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Für den Zugriff auf die Datenbank kommen sogenannte JPARepositories zum Einsatz.
Diese sind Interfaces, die von JpaRepository(Klasse, PublicID) erben.
Hier wird ein Zugriff auf Kaufe eingerichtet
 */
@Repository
public interface KaufeRepository extends JpaRepository<Kaufe, Long> {
}
