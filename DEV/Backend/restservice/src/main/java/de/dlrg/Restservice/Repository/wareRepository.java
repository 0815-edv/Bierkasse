package de.dlrg.Restservice.Repository;


import de.dlrg.Restservice.Ware;
import org.springframework.data.jpa.repository.JpaRepository;

public interface wareRepository extends JpaRepository<Ware, Long> {
}
