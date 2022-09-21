package co.edu.javeriana.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LibreriaServerApplication {


	public static void main(String[] args) {
		SpringApplication.run(LibreriaServerApplication.class, args);
	}

}
