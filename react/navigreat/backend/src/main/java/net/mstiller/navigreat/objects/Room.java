package net.mstiller.navigreat.objects;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Room {
	
	@Id
	public String id;
	
	@Field
	public String name;
	
	@Field
	private Binary image;
	
	public Room() {
	}
	
	public Room(String name) {
		this.name = name;
	}
	
}