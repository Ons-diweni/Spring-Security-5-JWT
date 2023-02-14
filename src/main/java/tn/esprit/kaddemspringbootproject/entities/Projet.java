package tn.esprit.kaddemspringbootproject.entities;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Projet implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
 Integer idProjet;
 String nomProjet;
 String descriptionProjet;
 Float prixProjet;
 @Temporal(TemporalType.DATE)
 Date dateDebutProjet;
 @Temporal(TemporalType.DATE)
 Date dateFinProjet;
 String flyer;



}
