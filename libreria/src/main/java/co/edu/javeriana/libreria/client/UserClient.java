package co.edu.javeriana.libreria.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserClient {

	public static void main(String[] args) {
        System.setProperty("spring.config.name", "user-client");
		SpringApplication.run(UserClient.class, args);
	}
}
