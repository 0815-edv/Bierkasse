package de.dlrg.backend.Repository;

import de.dlrg.backend.Entity.Ware;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Für den Zugriff auf die Datenbank kommen sogenannte JPARepositories zum Einsatz.
Diese sind Interfaces, die von JpaRepository(Klasse, PublicID) erben.
Hier wird ein Zugriff auf Ware eingerichtet
 */
public interface wareRepository extends JpaRepository<Ware, Long> {
}
