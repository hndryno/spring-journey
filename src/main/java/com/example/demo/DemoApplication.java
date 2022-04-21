package com.example.demo;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run (UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "SUPER_ADMIN"));

			userService.saveUser(new User(null, "John", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Hendriyono", "hndryno", "1234", new ArrayList<>()));

			userService.addRoleToUser("John", "ROLE_MANAGER");
			userService.addRoleToUser("hndryno", "ROLE_MANAGER");
		};
	}
}
