package net.mstiller.navigreat;

import net.mstiller.navigreat.photo.PhotoService;
import net.mstiller.navigreat.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NavigreatApplication implements CommandLineRunner {
	
	@Autowired
	private RoomService rooms;
	@Autowired
	private PhotoService photos;
	
	public static void main(String[] args) {
		SpringApplication.run(NavigreatApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	}
	
	
}
