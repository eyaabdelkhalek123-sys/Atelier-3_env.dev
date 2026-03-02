package com.eya.films;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.eya.films.entities.Film;
import com.eya.films.entities.Genre;
import com.eya.films.repos.FilmRepository;
import com.eya.films.service.FilmService;

@SpringBootTest
class FilmsApplicationTests {

	@Autowired 
	private FilmRepository filmRepository; 
	
	@Autowired
	private FilmService filmService;
	
	@Test 
	public void testCreateFilm() { 
		Film fil = new Film("Zootopia",8.0,new Date()); 
		filmRepository.save(fil); 
	}  
	
	@Test 
	public void testFindFilm() 
	{ 
		Film f = filmRepository.findById(1L).get();     
		System.out.println(f); 
	}
	
	@Test 
	public void testUpdateFilm() 
	{ 
		Film f = filmRepository.findById(1L).get();   
		f.setRateFilm(8.1);
		filmRepository.save(f);
		System.out.println(f); 
	}
	
	@Test 
	public void testDeleteFilm() 
	{
		filmRepository.deleteById(1L);
	} 
	
	@Test 
	public void testListerTousFilms() 
	{ 
		List <Film>  fils = filmRepository.findAll();   
		for (Film f : fils) 
		{ 
			System.out.println(f); 
		}   
	}
	
	 @Test 
	 public void testFindByNomFilm() { 
		 List<Film> fils = filmRepository.findByNomFilm("Zootopia"); 
		 for (Film f : fils) { 
			 System.out.println(f); 
		} 
	 }
	
	 @Test 
	 public void testFindByNomFilmContains () { 
		 List<Film> fils=filmRepository.findByNomFilmContains("Z"); 
		 for (Film f : fils) 	{ 
			 System.out.println(f); 
		 } 
	}
	 
	 @Test 
	 public void testfindByNomRate() { 
		 List<Film>  fils = filmRepository.findByNomRate("Parasite",7.0); 
		 for (Film f : fils) { 
			 System.out.println(f); 
		 } 
	 } 
	 
	 @Test 
	 public void testfindByGenre() { 
		 Genre gen = new Genre(); 
		 gen.setIdGen(1L);    
		 List<Film>  fils = filmRepository.findByGenre(gen); 
		 for (Film f : fils) { 
			 System.out.println(f); 
		 } 
	 } 
	 
	 @Test 
	 public void testfindByGenreIdGen() {    
		 List<Film>  fils = filmRepository.findByGenreIdGen(1L); 
		 for (Film f : fils) { 
			 System.out.println(f); 
		 } 
	 } 
	 
	 @Test 
	 public void testfindByOrderByNomFilmAsc() { //ordre croissant
	  List<Film>  fils = filmRepository.findByOrderByNomFilmAsc();   
	   for (Film f : fils) 
	   { 
	    System.out.println(f); 
	   } 
	 } 
	 
	 @Test 
	 public void testTrierFilmsNomsRate() { 
		 List<Film>  fils = filmRepository.trierFilmsNomsRate();
		 
		 for (Film f : fils) { 
			 System.out.println(f); 
		 } 
	 } 
}
