package net.mstiller.navigreat.room;

import net.mstiller.navigreat.Reservation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Document(collection = "rooms")
public class Room {
	
	@Id
	public String id;
	
	@Field
	public String name;
	
	@Field
	String photo;
	
	@Field
	String building;
	
	@Field
	int floor;
	
	@Field
	int number;
	
	@Field
	int capacity;
	
	@Field
	ArrayList<Reservation> reservations;
	
//	! Important to retain
	public Room() {
	}
	
	public Room(String name) {
		this.name = name;
	}
	
	
//	we can send a payload array
//	payload:
//	[0] name
//	[1] photo id
	
	
	public String getId() {
		return id;
	}
}