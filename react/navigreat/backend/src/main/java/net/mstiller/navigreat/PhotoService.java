package net.mstiller.navigreat;

import net.mstiller.navigreat.objects.Photo;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoService {
	
	@Autowired
	private PhotoRepository repo;
	
	//	adds a photo file to the db and returns its id as a string.
	public String addPhoto(String title, MultipartFile file) throws IOException {
		Photo photo = new Photo(
				title,
				new Binary(BsonBinarySubType.BINARY, file.getBytes())
		);
		photo = repo.insert(photo);
		return photo.getId();
		
	}
	
	//	retrieves a given photo if it exists.
	public Photo getPhoto(String id) {
		return repo.findById(id).get();
	}
	
}
