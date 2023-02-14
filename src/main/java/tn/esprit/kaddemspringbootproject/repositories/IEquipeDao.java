package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.kaddemspringbootproject.entities.Equipe;

public interface IEquipeDao extends JpaRepository<Equipe,Integer> {
}
