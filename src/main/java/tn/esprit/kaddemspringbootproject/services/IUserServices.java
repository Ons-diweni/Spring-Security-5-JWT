package tn.esprit.kaddemspringbootproject.services;

import tn.esprit.kaddemspringbootproject.entities.Role;
import tn.esprit.kaddemspringbootproject.entities.RoleName;
import tn.esprit.kaddemspringbootproject.entities.User;

import java.util.List;


public interface IUserServices {

    User saveUser( User user ) ;
    Role saveRole(Role role);
    User getUserById (Integer idUser);
    List<User> getAllUsers ();
    void affectRoleToUser(String email, RoleName roleName);
//    void addUserAddRoleWithAffect (User user ) ;
    User addUserAssignToRole(User user, RoleName roleName);




}
