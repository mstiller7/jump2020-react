package net.mstiller.navigreat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class NavigreatApplication implements CommandLineRunner {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
			}
		};
	}
	
	@Autowired
	private RoomRepository rooms;
	@Autowired
	private PhotoService photoService;
	
	public static void main(String[] args) {
		SpringApplication.run(NavigreatApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	}
	
	
}
