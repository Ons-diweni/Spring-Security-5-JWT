package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.kaddemspringbootproject.entities.Projet;

public interface IProjetDao extends JpaRepository<Projet,Integer> {
}
