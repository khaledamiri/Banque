package org.banque.amiri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("spring-beans.xml")
public class BanqueAmiriApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanqueAmiriApplication.class, args);
	}
}
