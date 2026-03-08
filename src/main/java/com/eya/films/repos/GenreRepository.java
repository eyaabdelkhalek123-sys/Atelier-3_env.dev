package com.eya.films.repos; 
 
import org.springframework.data.jpa.repository.JpaRepository; 
import com.eya.films.entities.Genre; 
 
public interface GenreRepository extends JpaRepository<Genre, Long> { 
 
}