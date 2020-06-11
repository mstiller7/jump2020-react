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
	public String title;
	
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
	
	public Room(String title) {
		this.title = title;
	}
	
	
//	we can send a payload array
//	payload:
//	[0] name
//	[1] photo id
	
	
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Room{" +
		"id='" + id + '\'' +
		", title='" + title + '\'' +
		", photo='" + photo + '\'' +
		", building='" + building + '\'' +
		", floor=" + floor +
		", number=" + number +
		", capacity=" + capacity +
		", reservations=" + reservations +
		'}';
	}
}