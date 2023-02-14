package tn.esprit.kaddemspringbootproject.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspringbootproject.configuration.JWTGenerator;
import tn.esprit.kaddemspringbootproject.dto.AuthResponseDto;
import tn.esprit.kaddemspringbootproject.dto.LoginDto;
import tn.esprit.kaddemspringbootproject.dto.RegisterDto;
import tn.esprit.kaddemspringbootproject.entities.Role;
import tn.esprit.kaddemspringbootproject.entities.RoleName;
import tn.esprit.kaddemspringbootproject.entities.User;
import tn.esprit.kaddemspringbootproject.repositories.IRoleDao;
import tn.esprit.kaddemspringbootproject.repositories.IUserDao;
import tn.esprit.kaddemspringbootproject.services.UserServices;

import java.util.Collections;
import java.util.List;


/**
 * @author Ons Diweni
 **/

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {

   private final UserServices userServices ;
   private final PasswordEncoder passwordEncoder;
   private final AuthenticationManager authenticationManager;
   private final IRoleDao iRoleDao;
   private final IUserDao iUserDao ;
   private final JWTGenerator jwtGenerator;


   //RessourceEndPoint:http://localhost:8085/Kaddem/user/register
   @PostMapping("/register")
   public ResponseEntity<String> register (@RequestBody  RegisterDto registerDto)
   {if(iUserDao.existsByEmail(registerDto.getEmail()))
   { return new ResponseEntity<>("email is already taken ! try an other ", HttpStatus.SEE_OTHER) ; }
      User user = new User();
      user.setEmail(registerDto.getEmail());
      user.setOption(registerDto.getOption());
      user.setUsername(registerDto.getUsername());
      user.setLastName(registerDto.getLastName());
      user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
      //we will register it as a Student by Default
      Role role = iRoleDao.findByRoleName(RoleName.ETUDIANT);
      user.setRoles(Collections.singletonList(role));
      iUserDao.save(user);
      return new ResponseEntity<>("User registered with success",HttpStatus.CREATED);
   }


   //RessourceEndPoint:http://localhost:8085/Kaddem/user/login
   @PostMapping("/login")
   public ResponseEntity<AuthResponseDto> login (@RequestBody LoginDto loginDto)
   {
      /*Hey engineer Authentication its is an interface
      Its implementation specifies the type of Authentication to be conducted
      here UsernamePasswordAuthenticationToken is an implementation of the Authentication interface
      which specifies that the user wants to authenticate using a username and password*/

    /*  A UsernamePasswordAuthenticationToken
    is created using the username and password provided by the user
    and is passed to the AuthenticationManager so that the token can be authenticated*/

       Authentication authentication= authenticationManager.
       authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));

     // System.out.println(authenticationManager.getClass());

      //update the context by setting the Authentication Object
      SecurityContextHolder.getContext().setAuthentication(authentication);
      String token = jwtGenerator.generateToken(authentication);
      return new ResponseEntity<>(new AuthResponseDto(token),HttpStatus.OK);
      //return new ResponseEntity<>("Sign in with sucess ",HttpStatus.CREATED);
   }


/*   //RessourceEndPoint:http://localhost:8085/Kaddem/user/add
   @PostMapping("/add")
   User addUser (@RequestBody User user)
   { return  userServices.saveUser(user);}  */


   //RessourceEndPoint:http://localhost:8085/Kaddem/user/add
   @PostMapping("/add")
   ResponseEntity <User> addUser (@RequestBody User user)
   { return  new ResponseEntity<>(userServices.saveUser(user), HttpStatus.CREATED) ;}


  /* //RessourceEndPoint:http://localhost:8085/Kaddem/user/getAll
   @GetMapping("/getAll")
   List<User> getAll ()
   { return  userServices.getAllUsers();} */


   //RessourceEndPoint:http://localhost:8085/Kaddem/user/getAll
   @GetMapping("/getAll")
     ResponseEntity< List<User> >  getAll ()
   { return  ResponseEntity.status(HttpStatus.FOUND).body(userServices.getAllUsers());}


   //RessourceEndPoint:http://localhost:8085/Kaddem/user/addRole
   @PostMapping("/addRole")
   Role addRole (@RequestBody Role role)
   { return  userServices.saveRole(role);}


   //RessourceEndPoint:http://localhost:8085/Kaddem/user/affectRoleToUser/{email}/{roleName}
   @PostMapping("/affectRoleToUser/{email}/{roleName}")
   void  addRoleToUser (@PathVariable("email") String email , @PathVariable("roleName") RoleName roleName)
   { userServices.affectRoleToUser(email,roleName);}


/*  // We can do this simply with cascading since user is Parent
   //RessourceEndPoint:http://localhost:8085/Kaddem/user/addUserAddRoleWithAffect
   @PostMapping("/addUserAddRoleWithAffect")
   public void addUserAddRoleWithAffect( @RequestBody User user)
   { userServices.addUserAddRoleWithAffect(user);  }
*/

   //RessourceEndPoint:http://localhost:8085/Kaddem/user/addUserAssignToRole/{idR}
   @PostMapping("/addUserAssignToRole/{roleName}")
   public User addUserAssignToRole(@RequestBody User user,@PathVariable("roleName") RoleName roleName)
   { return  userServices.addUserAssignToRole(user , roleName);}


   //RessourceEndPoint:http://localhost:8085/Kaddem/user/getUserById/{idU}
   @GetMapping("/getUserById/{idU}")
   User getUserById (@PathVariable("idU")Integer idUser)
   { return  userServices.getUserById(idUser);}
}
