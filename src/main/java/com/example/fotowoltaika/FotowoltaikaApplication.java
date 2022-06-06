package com.example.fotowoltaika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("appConfig.xml")
@EnableAutoConfiguration(exclude= HibernateJpaAutoConfiguration.class)
public class FotowoltaikaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FotowoltaikaApplication.class, args);
	}
}
