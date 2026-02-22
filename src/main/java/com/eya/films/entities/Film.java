package com.eya.films.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFilm;
	private String nomFilm;
	private Double rateFilm;
	private Date dateSortie;
	
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

	@Override
	public String toString() {
		return "Film [idFilm=" + idFilm + ", nomFilm=" + nomFilm + ", rateFilm=" + rateFilm + ", dateSortie="
				+ dateSortie + "]";
	}
	
	
	
	
}
