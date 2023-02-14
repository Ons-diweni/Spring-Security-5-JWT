package tn.esprit.kaddemspringbootproject.entities;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUniv ;
    private String nomUniv  ;
    private String emailUniv ;
    private String logoUniv ;
    private Long numUniv;
    private String lienUniv;
    private String adresseUniv;
    @Enumerated(EnumType.STRING)
    private categorieUniv categorieUniv;
    @OneToMany()
    Set<Departement> departements;
    @OneToMany(mappedBy = "universite")
    Set<Cours> cours;


    @OneToOne(mappedBy = "universite" , fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    User chefUniv ;

    @OneToMany (mappedBy = "universite" , fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    List<Evenement> evenements ;

}
