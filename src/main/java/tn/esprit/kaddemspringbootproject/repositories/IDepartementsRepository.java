package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.kaddemspringbootproject.entities.Departement;

public interface IDepartementsRepository extends JpaRepository<Departement,Integer> {
}
