package tn.esprit.kaddemspringbootproject.configuration;


import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


/**
 * @author Ons Diweni
 **/

@Slf4j
@Component
public class JWTGenerator {

  public static final long  JWTexpiration = 70000000 ;
  public static final String  JWTsecret = "Onssecret" ;

    public String generateToken(Authentication authentication)

    {   // getName returns the Principal from the Authentication Object which is in our case the user email
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime()+JWTexpiration);

        String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).claim("roles",authentication.getAuthorities()).
                setExpiration(expireDate).signWith(SignatureAlgorithm.HS512,JWTsecret).compact();

        return token;
    }


    public String getUsernameFromJWT (String token)
    {Claims claims = Jwts.parser().setSigningKey(JWTsecret).parseClaimsJws(token).getBody();
//        System.out.println("hooooooooooooooooooooooy Ons I'm here " +claims);
    return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWTsecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            log.info("Invalid JWT signature.");
            log.trace("Invalid JWT signature trace: {}", e);
        } catch (MalformedJwtException e) {
            log.info("Invalid JWT token.");
            log.trace("Invalid JWT token trace: {}", e);
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT token.");
            log.trace("Expired JWT token trace: {}", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT token.");
            log.trace("Unsupported JWT token trace: {}", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT token compact of handler are invalid.");
            log.trace("JWT token compact of handler are invalid trace: {}", e);
        }
        return false;
    }
}



