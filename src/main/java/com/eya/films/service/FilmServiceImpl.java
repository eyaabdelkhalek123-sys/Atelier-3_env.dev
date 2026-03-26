package com.eya.films.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.eya.films.dto.FilmDTO;
import com.eya.films.entities.Film;
import com.eya.films.entities.Genre;
import com.eya.films.repos.FilmRepository;
import com.eya.films.repos.GenreRepository;

@Service
public class FilmServiceImpl implements FilmService{
	
	@Autowired
	FilmRepository filmRepository;
	
	@Autowired 
	GenreRepository genreRepository; 
	
	@Autowired 
	ModelMapper modelMapper;

	@Override 
	public FilmDTO saveFilm(FilmDTO f) { 
		return  convertEntityToDto( filmRepository.save(convertDtoToEntity(f))); 
	} 
	@Override 
	public FilmDTO updateFilm(FilmDTO f) { 
		return convertEntityToDto(filmRepository.save(convertDtoToEntity(f))) ; 
	} 

	@Override
	public void deleteFilm(Film f) {
		filmRepository.delete(f);
	}

	@Override
	public void deleteFilmById(Long id) {
		filmRepository.deleteById(id);
	}

	@Override 
	public FilmDTO getFilm(Long id) { 
		return  convertEntityToDto( filmRepository.findById(id).get());
	} 
	 
	@Override 
	public List<FilmDTO> getAllFilms() { 
		return filmRepository.findAll().stream() 
			    .map(this::convertEntityToDto) 
			    .collect(Collectors.toList()); 
			   
	  //OU BIEN 
	  /*List<Film> fils =  filmsRepository.findAll(); 
	  List<FilmDTO> listfilDto = new ArrayList<>(fils.size()); 
	  for (Film f : fils) 
	   listfilDto.add(convertEntityToDto(p)); 
	  return listfilDto;*/ 
	}

	@Override
	public Page<Film> getAllFilmsParPage(int page, int size) {
		
		return filmRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Film> findByNomFilm(String nom) {
		return filmRepository.findByNomFilm(nom);
	}

	@Override
	public List<Film> findByNomFilmContains(String nom) {
		return filmRepository.findByNomFilmContains(nom);
	}

	@Override
	public List<Film> findByNomRate(String nom, Double rate) {
		return filmRepository.findByNomRate(nom,rate);
	}

	@Override
	public List<Film> findByGenre(Genre genre) {
		return filmRepository.findByGenre(genre);
	}

	@Override
	public List<Film> findByGenreIdGen(Long id) {
		return filmRepository.findByGenreIdGen(id);
	}

	@Override
	public List<Film> findByOrderByNomFilmAsc() {
		return filmRepository.findByOrderByNomFilmAsc();
	}

	@Override
	public List<Film> trierFilmsNomsRate() {
		return filmRepository.trierFilmsNomsRate();
	}
	
	@Override 
	 public List<Genre> getAllGenres() { 
	  return genreRepository.findAll(); 
	 }

	@Override 
	public FilmDTO convertEntityToDto(Film film) { 
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE); 
		
		FilmDTO filmDTO = modelMapper.map(film, FilmDTO.class); 
		return filmDTO;  
		
		/*FilmDTO filmDTO = new FilmDTO(); 
		filmDTO.setIdFilm(film.getIdFilm()); 
		filmDTO.setNomFilm(film.getNomFilm()); 
		filmDTO.setRateFilm(film.getRateFilm()); 
		filmDTO.setDateSortie(film.getDateSortie()); 
		filmDTO.setGenre(film.getGenre());   
	    return filmDTO;  */
	     
	   /*return FilmDTO.builder() 
	    .idFilm(film.getIdFilm()) 
	    .nomFilm(film.getNomFilm()) 
	    .rateFilm(film.getRateFilm()) 
		.dateSortie(film.getDateSortie()) 
		.nomGen(film.getGenre().getNomGen())
	    .genre(film.getGenre()) 
	    .build();*/
	 } 
	
	@Override 
	public Film convertDtoToEntity(FilmDTO filmDto) { 
		Film film = new Film(); 
		film = modelMapper.map(filmDto, Film.class); 
		
		/*Film film = new Film(); 
		film.setIdFilm(filmDto.getIdFilm()); 
		film.setNomFilm(filmDto.getNomFilm()); 
		film.setRateFilm(filmDto.getRateFilm()); 
		film.setDateSortie(filmDto.getDateSortie()); 
		film.setGenre(filmDto.getGenre());   */
		return film;
	} 

}
