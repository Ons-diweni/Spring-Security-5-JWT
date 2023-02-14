package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.kaddemspringbootproject.entities.Evenement;

import java.util.List;

public interface IEvenenemtDao extends JpaRepository<Evenement,Integer> {

     public List<Evenement> findAllByUniversite_NomUniv(String nomUniv);


}
