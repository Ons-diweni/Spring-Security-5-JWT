package tn.esprit.kaddemspringbootproject.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspringbootproject.entities.Role;
import tn.esprit.kaddemspringbootproject.entities.RoleName;
import tn.esprit.kaddemspringbootproject.entities.User;
import tn.esprit.kaddemspringbootproject.repositories.IRoleDao;
import tn.esprit.kaddemspringbootproject.repositories.IUserDao;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service @RequiredArgsConstructor @Slf4j @Transactional
public class UserServices implements IUserServices{

    private final IUserDao iUserDao ;
    private final IRoleDao iRoleDao ;

    @Override
    public User saveUser(User user) {
        log.info("Saving new User in the database" );
/*        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));*/
        return iUserDao.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new Role {} in database " , role.getRoleName());
        return iRoleDao.save(role);
    }

  /*  @Override
    public void affectRoleToUser(Integer idUser, Integer idRole) {
        log.info("Affecting role with id {} to user with id {} in the database" , idUser ,idRole );
        User user = iUserDao.findById(idUser).orElse(null);
        Role role = iRoleDao.findById(idRole).orElse(null);
        role.setUser(user);
    }*/

      @Override
    public void affectRoleToUser(String email, RoleName roleName) {
        log.info("Affecting role {} to user  {} in the database" ,roleName , email );
        User user = iUserDao.findByEmail(email).orElse(null);
        Role role = iRoleDao.findByRoleName(roleName);
        user.getRoles().add(role);
    }


    /*@Override
    public void addUserAddRoleWithAffect(User user) {
        iUserDao.save(user);
        user.getRoles().forEach(r -> r.setUser(user));
    }*/


    @Override
    public User addUserAssignToRole(User user, RoleName roleName) {

        iUserDao.save(user);
        Role role = iRoleDao.findByRoleName(roleName);
        user.getRoles().add(role);
        return user ;

    /*    iUserDao.save(user);
        Role r = iRoleDao.findById(idRole).orElse(null);
        r.setUser(user);
        return user;
*/
    }

    @Override
    public User getUserById(Integer idUser) {
        log.info("Fetching User with Id {} in the database" , idUser);
        return iUserDao.findById(idUser).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return iUserDao.findAll();
    }


}
