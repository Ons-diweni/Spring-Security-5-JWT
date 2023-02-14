package tn.esprit.kaddemspringbootproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contrat implements Serializable {

    // champs métier

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idContrat ;
    @Temporal(TemporalType.DATE)
    Date dateDebutContrat ;
    @Temporal(TemporalType.DATE)
    Date dateFinContrat  ;
    @Enumerated(EnumType.STRING)
    Specialite specialite ;
    Boolean archive ;
    Integer montantContrat ;


    // champs de relation

    @ManyToOne (fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
    Equipe equipe;

    @ManyToOne (fetch = FetchType.EAGER ,cascade = CascadeType.PERSIST)
    User etudiant ;




}
