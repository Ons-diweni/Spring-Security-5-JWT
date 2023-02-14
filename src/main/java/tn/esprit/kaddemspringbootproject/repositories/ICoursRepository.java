package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.kaddemspringbootproject.entities.Cours;

public interface ICoursRepository extends JpaRepository<Cours,Integer> {
}
