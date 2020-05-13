package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EServer {
	
	public static void main(String[] args) {
		
		Country.init();
		SpringApplication.run(EServer.class, args);
		
	}
	
}
