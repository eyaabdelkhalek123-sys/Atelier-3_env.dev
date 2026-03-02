package com.eya.films; 
import java.util.Date; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.CommandLineRunner; 
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import com.eya.films.entities.Film; 
import com.eya.films.service.FilmService; 

@SpringBootApplication 
public class FilmsApplication implements CommandLineRunner  { 
	@Autowired  
	FilmService filmService; 
	public static void main(String[] args) { 
		SpringApplication.run(FilmsApplication.class, args); 
	} 
	
	@Override 
	public void run(String... args) throws Exception { 
		//filmService.saveFilm(new Film("Parasite", 8.5 , new Date()));
		//filmService.saveFilm(new Film("The Pltform : El Hoyo", 7.0 , new Date()));
		//filmService.saveFilm(new Film("Dune : Part 2", 8.4 , new Date()));
	} 
}