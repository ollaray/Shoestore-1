package com.shoestore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shoestore.entity.Role;
import com.shoestore.entity.User;
import com.shoestore.entity.UserRole;
import com.shoestore.service.SecurityService;
import com.shoestore.service.UserService;


@SpringBootApplication
public class ShoestoreApplication implements CommandLineRunner {
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(ShoestoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		User user = new User();
//		user.setFirstname("Demo");
//		user.setLastname("Dev");
//		user.setEmail("demo@gmail.com");
//		user.setPassword(securityService.bCryptPasswordEncoder().encode("password"));
//		user.setAddress("somewhere in lagos");
//		user.setUsername("demoUser");
//		Role role = new Role();
//		role.setId(1);
//		role.setName("ROLE_USER");
//		Set<UserRole> userRoles = new HashSet<>();
//		userRoles.add(new UserRole(user, role));
//		
//		userService.createUser(user, userRoles);
		
	}



}
