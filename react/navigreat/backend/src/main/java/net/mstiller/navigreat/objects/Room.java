package net.mstiller.navigreat.objects;

import org.springframework.data.annotation.Id;

public class Room {
	
	@Id	public String id;
	
	public String name;
	
	public Room() {
	}
	
	public Room(String name) {
		this.name = name;
	}
	
}