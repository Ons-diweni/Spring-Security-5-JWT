package tn.esprit.kaddemspringbootproject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import tn.esprit.kaddemspringbootproject.entities.Role;
import tn.esprit.kaddemspringbootproject.entities.RoleName;
import tn.esprit.kaddemspringbootproject.entities.User;
import tn.esprit.kaddemspringbootproject.services.UserServices;

import java.util.ArrayList;


@SpringBootApplication
public class KaddemSpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaddemSpringBootProjectApplication.class, args);
	}
/*	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}*/

/*
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

*/

	@Bean
	CommandLineRunner run (UserServices userServices )
	{return  args ->
	{   userServices.saveRole(new Role(RoleName.ADMIN));
		userServices.saveRole(new Role(RoleName.ETUDIANT));
		userServices.saveRole(new Role(RoleName.SUPERADMIN));

	};}
}
