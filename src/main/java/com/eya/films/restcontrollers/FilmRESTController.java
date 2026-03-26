package com.eya.films.restcontrollers;

import com.eya.films.dto.FilmDTO;
import com.eya.films.entities.Film;
import com.eya.films.service.FilmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FilmRESTController {
	
	@Autowired
	FilmService filmService;

	@RequestMapping(method = RequestMethod.GET)
	public List<FilmDTO> getAllFilms() {
		return filmService.getAllFilms();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public FilmDTO getFilmsByID(@PathVariable("id") Long id) {
		return filmService.getFilm(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public FilmDTO createFilm(@RequestBody FilmDTO filmDTO) {
		return filmService.saveFilm(filmDTO);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public FilmDTO updateFilm(@RequestBody FilmDTO filmDTO) {
		return filmService.updateFilm(filmDTO);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public void deleteFilm(@PathVariable ("id") Long id) {
		filmService.deleteFilmById(id);
	}
	
	@RequestMapping(value="/filsgen/{idGen}",method=RequestMethod.GET)
	public List<Film> getFilmsByGenId(@PathVariable ("idGen") Long idGen) {
		return filmService.findByGenreIdGen(idGen);
	}
    
}