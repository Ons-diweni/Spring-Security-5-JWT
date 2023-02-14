package tn.esprit.kaddemspringbootproject.configuration;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * @author Ons Diweni
 * @version : Spring Security 5.7.5
 **/

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {


    private final CustomerUserDetailsService customerUserDetailsService ;
    private final JwtAuthEntryPoint jwtAuthEntryPoint;

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception
    { http.
        csrf().disable()
        .exceptionHandling().authenticationEntryPoint(jwtAuthEntryPoint)
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .antMatchers("/user/**").permitAll()
     /*   .antMatchers("/user/login").permitAll()
        .antMatchers("/user/register").permitAll()
     */   .antMatchers("/superadmin/**").access("hasRole('SUPERADMIN')")
        .antMatchers("/admin").access("hasRole('ADMIN')")
        .anyRequest().authenticated();
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
       // http.addFilterAfter(makeTestFilter() , JWTAuthenticationFilter.class);
        return  http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
    { return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public PasswordEncoder passwordEncoder()
    { return new BCryptPasswordEncoder();
    }


  @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter ()
      { return  new JWTAuthenticationFilter();}
}
