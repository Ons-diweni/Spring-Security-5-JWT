package tn.esprit.kaddemspringbootproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
//@EqualsAndHashCode(of = {"idUser","email"})
@EqualsAndHashCode
@ToString(exclude = {"username" , "password" , "email"})
@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor()

public class User implements Serializable {


 // champs métier
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)

 Integer idUser;
 String lastName ;
 String username ;
 String email ;
 String password;
 Option option ;
 String userPicture ;

 // champs de relation

 //@JsonIgnore
 @ManyToMany(fetch = FetchType.EAGER  , cascade = CascadeType.PERSIST)
 List <Role> roles = new ArrayList<>();

 @JsonIgnore
 @ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
 List<Evenement> evenements ;

 @JsonIgnore
 @OneToOne (fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
 Universite universite ;

 @JsonIgnore
 @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
 Departement departement ;

 @JsonIgnore
 @OneToMany (mappedBy = "etudiant" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
 Set<Contrat> contrats ;


  public User (String email , String password , ArrayList<Role> arrayList )
  { this.email = email ; this.password=password ; this.roles = arrayList;}

}
