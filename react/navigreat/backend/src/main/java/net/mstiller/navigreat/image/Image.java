package net.mstiller.navigreat.image;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "images")
public class Image {
	
	@Id
	private String id;
	
	private String title;
	
	private Binary image;
	
	public Image(String title, Binary image) {
		this.title = title;
		this.image = image;
	}
	
	public String getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Binary getImage() {
		return image;
	}
}
