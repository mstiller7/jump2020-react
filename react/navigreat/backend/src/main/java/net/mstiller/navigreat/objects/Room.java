package net.mstiller.navigreat.objects;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

public class Room {
	
	@Id
	public String id;
	
	@Field
	public String name;
	
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
	
	@Field
	private Binary image;
	
//	! Important to retain
	public Room() {
	}
	
	public Room(String name) {
		this.name = name;
	}
	
}