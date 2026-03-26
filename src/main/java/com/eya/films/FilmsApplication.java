package com.eya.films; 
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.CommandLineRunner; 
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.eya.films.entities.Film;
import com.eya.films.entities.Role;
import com.eya.films.entities.User;
import com.eya.films.service.FilmService;
import com.eya.films.service.UserService;

import jakarta.annotation.PostConstruct; 

@SpringBootApplication 
public class FilmsApplication implements CommandLineRunner  { 
	/*@Autowired  
	FilmService filmService;*/
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService ;
	
	public static void main(String[] args) { 
		SpringApplication.run(FilmsApplication.class, args); 
	} 
	
	   
    /*@PostConstruct 
    void init_users() { 
	    //ajouter les rôles 
	    userService.addRole(new Role(null,"ADMIN")); 
	    userService.addRole(new Role(null,"AGENT")); 
	    userService.addRole(new Role(null,"USER")); 
	   
	    //ajouter les users 
	    userService.saveUser(new User(null,"admin","123",true,null)); 
	    userService.saveUser(new User(null,"eya","123",true,null)); 
	    userService.saveUser(new User(null,"sou","123",true,null)); 
	   
	    //ajouter les rôles aux users 
	    userService.addRoleToUser("admin", "ADMIN"); 
	    userService.addRoleToUser("eya", "USER"); 
	    userService.addRoleToUser("eya", "AGENT"); 
	    userService.addRoleToUser("sou", "USER");   
    } */
	
	@Override 
	public void run(String... args) throws Exception { 
		
		 /*System.out.println("Password Encoded BCRYPT :******************** "); 
	     System.out.println(passwordEncoder.encode("123")); */
	       
		//filmService.saveFilm(new Film("Parasite", 8.5 , new Date()));
		//filmService.saveFilm(new Film("The Pltform : El Hoyo", 7.0 , new Date()));
		//filmService.saveFilm(new Film("Dune : Part 2", 8.4 , new Date()));
	} 
	
	@Bean 
	public ModelMapper modelMapper() { 
		return new ModelMapper(); 
	}
}