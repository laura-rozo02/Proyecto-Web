package co.edu.javeriana.libreria.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookClient {

	public static void main(String[] args) {
        System.setProperty("spring.config.name", "book-client");
		SpringApplication.run(BookClient.class, args);
	}
}