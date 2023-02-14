package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.kaddemspringbootproject.entities.Universite;

public interface IUniversiteRepository extends JpaRepository<Universite,Integer> {
}
