package com.eya.films.service; 

import com.eya.films.entities.Role; 
import com.eya.films.entities.User; 

public interface UserService { 
	void deleteAllusers(); 
	void deleteAllRoles(); 
	User saveUser(User user); 
	User findUserByUsername (String username); 
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename); 
}