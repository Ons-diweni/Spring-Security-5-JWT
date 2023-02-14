package tn.esprit.kaddemspringbootproject.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspringbootproject.entities.User;
import tn.esprit.kaddemspringbootproject.repositories.IUserDao;

import java.util.HashSet;
import java.util.Set;


/**
 * @author Ons Diweni
 **/

@Service
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {

    /*The role of this class is Fetching user information in the database
    and mapping it with user(Spring Security user) Object*/
    private final IUserDao iUserDao ;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = iUserDao.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User not found !"));
        Set<GrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName().getAuthority())));
        return  new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);

    }
}
