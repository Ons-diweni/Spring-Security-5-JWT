package tn.esprit.kaddemspringbootproject.entities;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetailEquipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer  idDetailEquipe ;
    Integer salle ;
    String thematique ;

}
