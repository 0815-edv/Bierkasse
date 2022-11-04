package de.dlrg.backend.Repository;

import de.dlrg.backend.Entity.Ware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
Für den Zugriff auf die Datenbank kommen sogenannte JPARepositories zum Einsatz.
Diese sind Interfaces, die von JpaRepository(Klasse, PublicID) erben.
Hier wird ein Zugriff auf Ware eingerichtet
 */
@Repository
public interface WareRepository extends JpaRepository<Ware, Long> {

    Optional<Ware> findWareByName(String name);
}
