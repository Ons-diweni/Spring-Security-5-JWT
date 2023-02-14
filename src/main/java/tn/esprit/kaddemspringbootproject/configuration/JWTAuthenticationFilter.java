package tn.esprit.kaddemspringbootproject.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
This class will provide a filterchain that will be used by Spring Security to check the token provided
by the request ( if it exist or not if it valid or not )
Every request that come to our APIs will be intercepted by this filter */


/**
 * @author Ons Diweni
 **/

@AllArgsConstructor
@NoArgsConstructor
@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    /*Authentication Filter : Its a Filter in the FilterChain
    which detects an authentication attempt and forwards it to the AuthenticationManager*/

    @Autowired
    private  JWTGenerator jwtGenerator ;

    @Autowired
    private  CustomerUserDetailsService customerUserDetailsService ;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String token = getJwtTokenFromRequest (request);
    if (StringUtils.hasText(token) && jwtGenerator.validateToken(token))
    {   String email = jwtGenerator.getUsernameFromJWT(token);
        UserDetails userDetails = customerUserDetailsService.loadUserByUsername(email);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails.getUsername() ,userDetails.getPassword(), userDetails.getAuthorities());
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }
        filterChain.doFilter(request,response);
    }

    //here we extract token from request
    private String getJwtTokenFromRequest (HttpServletRequest httpServletRequest)
    {  String bearerToken = httpServletRequest.getHeader("Authorization");
       if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer "))
       { return bearerToken.substring(7,bearerToken.length());}
       return null;

    }


}
