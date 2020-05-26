package net.mstiller.navigreat;

import net.mstiller.navigreat.objects.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NavigreatApplication implements CommandLineRunner {
	
	@Autowired
	private RoomRepository rooms;
	
	public static void main(String[] args) {
		SpringApplication.run(NavigreatApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
//		clear db
		rooms.deleteAll();
		
		rooms.save(new Room("lobby"));
		
	}
	
}
