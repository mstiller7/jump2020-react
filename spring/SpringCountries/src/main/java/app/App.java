package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class App {
	
	public static final String QUEUE = "country-queue";
	
	public static void main(String[] args) {
		
		Country.init();
		
		SpringApplication.run(App.class, args);
		
	}
	
}
