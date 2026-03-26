package com.eya.films.dto; 

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.eya.films.entities.Genre;

import lombok.AllArgsConstructor; 
import lombok.Builder; 
import lombok.Data; 
import lombok.NoArgsConstructor; 

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class FilmDTO { 
	private Long idFilm; 
	private String nomFilm; 
	private Double rateFilm; 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateSortie;
	private Genre genre;
	//private String nomGen;
} 