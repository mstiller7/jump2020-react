package net.mstiller.navigreat;

import net.mstiller.navigreat.objects.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.Base64;

@CrossOrigin(allowedHeaders = {"*"}, origins = "http://localhost")
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
	private PhotoService photos;
	
	public static void main(String[] args) {
		SpringApplication.run(NavigreatApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
	}
	
	
}
