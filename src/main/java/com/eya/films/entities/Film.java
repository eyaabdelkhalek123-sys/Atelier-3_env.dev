package com.eya.films.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max; 
import jakarta.validation.constraints.Min; 
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size; 


@Entity
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFilm;
	
	@NotNull 
	@Size (min=1 , max= 200) 
	private String nomFilm;
	
	@Min(value= 1) 
	@Max(value = 10) 
	private Double rateFilm;
	
	@Temporal(TemporalType.DATE) 
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	@PastOrPresent 
	private Date dateSortie;
	
	
	@ManyToOne 
	private Genre genre;
	
	public Film() {
		super();
		
	}
	
	public Film(String nomFilm, Double rateFilm, Date dateSortie) {
		super();
		this.nomFilm = nomFilm;
		this.rateFilm = rateFilm;
		this.dateSortie = dateSortie;
	}
	
	public Long getIdFilm() {
		return idFilm;
	}
	
	public void setIdFilm(Long idFilm) {
		this.idFilm = idFilm;
	}
	
	public String getNomFilm() {
		return nomFilm;
	}
	
	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}
	
	public Double getRateFilm() {
		return rateFilm;
	}
	
	public void setRateFilm(Double rateFilm) {
		this.rateFilm = rateFilm;
	}
	
	public Date getDateSortie() {
		return dateSortie;
	}
	
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Film [idFilm=" + idFilm + ", nomFilm=" + nomFilm + ", rateFilm=" + rateFilm + ", dateSortie="
				+ dateSortie + "]";
	}

	
	
	
	
	
}
