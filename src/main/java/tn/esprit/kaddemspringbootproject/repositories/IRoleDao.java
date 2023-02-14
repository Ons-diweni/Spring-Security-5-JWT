package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.kaddemspringbootproject.entities.Role;
import tn.esprit.kaddemspringbootproject.entities.RoleName;

public interface IRoleDao extends JpaRepository<Role,Integer>{


   Role findByRoleName(RoleName roleName) ;

}
