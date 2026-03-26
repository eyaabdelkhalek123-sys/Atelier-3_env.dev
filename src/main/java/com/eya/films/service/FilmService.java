package com.eya.films.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.eya.films.dto.FilmDTO;
import com.eya.films.entities.Film;
import com.eya.films.entities.Genre; 
 
public interface FilmService { 
  
	FilmDTO saveFilm(FilmDTO f); 
	FilmDTO getFilm(Long id); 
	List<FilmDTO> getAllFilms(); 
	FilmDTO updateFilm(FilmDTO f); 
	void deleteFilm(Film f); 
	void deleteFilmById(Long id); 
	List<Film> findByNomFilm(String nom); 
	List<Film> findByNomFilmContains(String nom); 
	List<Film> findByNomRate (String nom, Double rate); 
	List<Film> findByGenre (Genre genre); 
	List<Film> findByGenreIdGen(Long id); 
	List<Film> findByOrderByNomFilmAsc(); 
	List<Film> trierFilmsNomsRate();
  
	Page<Film> getAllFilmsParPage(int page, int size);
	
	List<Genre> getAllGenres(); 
	
	FilmDTO convertEntityToDto (Film film); 
	Film convertDtoToEntity(FilmDTO filmDto); 
  
}