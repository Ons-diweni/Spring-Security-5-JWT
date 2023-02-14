package tn.esprit.kaddemspringbootproject.entities;

import org.springframework.security.core.GrantedAuthority;

public enum RoleName implements GrantedAuthority {
  SUPERADMIN, ADMIN , ETUDIANT;

     @Override
     public String getAuthority() {
          return name();
     }
}
