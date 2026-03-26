package com.eya.films.repos;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.eya.films.entities.User; 

public interface UserRepository extends JpaRepository<User, Long> { 
	User findByUsername (String username); 
} 