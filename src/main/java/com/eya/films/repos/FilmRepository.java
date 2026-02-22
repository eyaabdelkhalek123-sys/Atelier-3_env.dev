package com.eya.films.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eya.films.entities.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
