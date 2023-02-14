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
public class Cours implements Serializable {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer idFormation;
 private String nomFormation;
 private String nomFormateur;
 private String descriptionFormation;
 private Float prixFormation;
 private Integer nbParticipants;
 @Temporal(TemporalType.DATE)
 Date dateDebutFormation;
 @Temporal(TemporalType.DATE)
 Date dateFinFormation;
 String flyer;
 @ManyToOne()
 Universite universite;

}
