package tn.esprit.kaddemspringbootproject.entities;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Equipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEquipe ;
    String nomEquipe ;
    @Enumerated(EnumType.STRING)
    Niveau niveau ;

    @OneToMany (mappedBy = "equipe" , fetch = FetchType.LAZY , cascade =  {CascadeType.PERSIST , CascadeType.REMOVE})
    Set<Contrat> contrats ;

}
