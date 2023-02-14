package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.kaddemspringbootproject.entities.DetailEquipe;

public interface IDetailEquipeDao extends JpaRepository<DetailEquipe,Integer> {
}
