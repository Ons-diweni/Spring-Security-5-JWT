package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.kaddemspringbootproject.entities.User;

import java.util.Optional;

public interface IUserDao extends JpaRepository<User,Integer> {

// User findByUsername(String username);

Optional<User> findByUsername(String username);
Boolean existsByUsername(String username);
Optional<User> findByEmail(String email);
Boolean existsByEmail(String email);
}
