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
	public String image;
	
	@Field
	public String summary;
	
	@Field
	public String building;
	
	@Field
	public int floor;
	
	@Field
	public int number;
	
	@Field
	public int capacity;
	
	@Field
	public ArrayList<Reservation> reservations;
	
//	! Important to retain
	public Room() {
	}
	
	public Room(String title, String image, String building, int floor, int number, int capacity) {
		this.title = title;
		this.image = image;
		this.building = building;
		this.floor = floor;
		this.number = number;
		this.capacity = capacity;
	}
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Room{" +
		"id='" + id + '\'' +
		", title='" + title + '\'' +
		", image='" + image + '\'' +
		", summary='" + summary + '\'' +
		", building='" + building + '\'' +
		", floor=" + floor +
		", number=" + number +
		", capacity=" + capacity +
		", reservations=" + reservations +
		'}';
	}
}