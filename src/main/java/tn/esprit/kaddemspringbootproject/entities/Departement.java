package tn.esprit.kaddemspringbootproject.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



    @Getter
    @Setter
    @Entity
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public class Departement implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idDepart ;
        private String nomDepart ;

    @OneToMany(mappedBy = "departement" , fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
    List<User> etudiants ;


}
