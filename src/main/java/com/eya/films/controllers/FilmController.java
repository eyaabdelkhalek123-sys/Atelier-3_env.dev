package com.eya.films.controllers; 
 
import java.text.ParseException; 
import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import com.eya.films.entities.Film;
import com.eya.films.entities.Genre;
import com.eya.films.service.FilmService;

import jakarta.validation.Valid; 
 
@Controller 
public class FilmController { 
	@Autowired 
	FilmService filmService; 
 
	@RequestMapping("/ListeFilms") 
	public String listeFilms(ModelMap modelMap , 
			@RequestParam (name="page",defaultValue = "0") int page, 
			@RequestParam (name="size", defaultValue = "2") int size) {
		
		Page<Film> fils = filmService.getAllFilmsParPage(page, size); 
		modelMap.addAttribute("films", fils); 
		modelMap.addAttribute("pages", new int[fils.getTotalPages()]);  
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		
		return "listeFilms";  
	} 
 
	/*@RequestMapping("/showCreate") 
	public String showCreate() { 
		return "createFilm"; 
	}*/
	
	@RequestMapping("/showCreate") 
	public String showCreate(ModelMap modelMap) { 
		List<Genre> gens = filmService.getAllGenres();
		modelMap.addAttribute("film", new Film()); 
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("genres", gens); 
		return "formFilm"; 
	} 
  
	/*@RequestMapping("/saveFilm") 
	public String saveFilm(@ModelAttribute("film") Film film,  
    @RequestParam("date") String date, 
    ModelMap modelMap) throws ParseException  { 
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd"); 
        Date dateSortie = dateformat.parse(String.valueOf(date)); 
        film.setDateSortie(dateSortie); 
       
        Film saveFilm= filmService.saveFilm(film); 
        String msg ="film enregistré avec Id "+saveFilm.getIdFilm(); 
        modelMap.addAttribute("msg", msg); 
        return "createFilm"; 
	}*/
	
	@RequestMapping("/saveFilm") 
	public String saveProduit(@Valid Film film, BindingResult bindingResult, 
			@RequestParam (name="page",defaultValue = "0") int page, 
			@RequestParam (name="size",defaultValue = "2") int size) { 
		int currentPage; 
		boolean isNew = false; 
		if (bindingResult.hasErrors()) 
			return "formFilm";       
		if (film.getIdFilm()==null) 
			isNew=true; 
		filmService.saveFilm(film); 
		if (isNew) { 
			Page<Film> fils = filmService.getAllFilmsParPage(page, size); 
			currentPage = fils.getTotalPages()-1; 
		} 
		else 
			currentPage=page; 
		return ("redirect:/ListeFilms?page="+currentPage+"&size="+size); 
	} 
 
	@RequestMapping("/supprimerFilm") 
	public String supprimerFilm(@RequestParam("id") Long id,ModelMap modelMap , 
			@RequestParam (name="page",defaultValue = "0") int page, 
			@RequestParam (name="size", defaultValue = "2") int size) {    
		filmService.deleteFilmById(id); 
		Page<Film> fils = filmService.getAllFilmsParPage(page, size);  
		modelMap.addAttribute("films", fils);   
		modelMap.addAttribute("pages", new int[fils.getTotalPages()]);  
		modelMap.addAttribute("currentPage", page);   
		modelMap.addAttribute("size", size);  

		return "listeFilms";
	} 
  
	@RequestMapping("/modifierFilm") 
	public String editerFilm(@RequestParam("id") Long id,ModelMap modelMap ,
			@RequestParam (name="page",defaultValue = "0") int page, 
			@RequestParam (name="size", defaultValue = "2") int size) { 
		Film f=  filmService.getFilm(id); 
		List<Genre> gens = filmService.getAllGenres();
		modelMap.addAttribute("film", f);  
		modelMap.addAttribute("mode", "edit"); 
		modelMap.addAttribute("genres", gens); 
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size); 
		return "formFilm";  
	} 

	@RequestMapping("/updateFilm") 
	public String updateFilm(@ModelAttribute("film") Film 
			film,  @RequestParam("date") String date, 
			ModelMap modelMap) throws ParseException  {   
		//conversion de la date  
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd"); 
		Date dateSortie = dateformat.parse(String.valueOf(date)); 
		film.setDateSortie(dateSortie); 
       
		filmService.updateFilm(film); 
		List<Film> fils= filmService.getAllFilms(); 
		modelMap.addAttribute("films", fils);  
		return "listeFilms"; 
	} 
} 
