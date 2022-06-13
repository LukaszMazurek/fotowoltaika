package com.example.fotowoltaika;

import com.example.fotowoltaika.domain.User;
import com.example.fotowoltaika.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
//@EnableScheduling
public class FotowoltaikaApplication {

	private final UserService userService;

	public FotowoltaikaApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FotowoltaikaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			userService.signup("defaultUser", "defaultUser");
		};
	}

}


