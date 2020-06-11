package net.mstiller.navigreat.photo;

import net.mstiller.navigreat.photo.Photo;
import net.mstiller.navigreat.photo.PhotoRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@Service
public class PhotoService {
	
	@Autowired
	private PhotoRepository photos;
	
	@GetMapping("/photos")
	public List<Photo> getPhotos() {
		return photos.findAll();
	}
	
	@PostMapping("/photos")
	public String addPhoto(@RequestParam("title") String title,
	                       @RequestParam("image") MultipartFile image, Model model)
	throws IOException {
		return addPhoto(title, image);
	}
	
	@GetMapping("/photos/{id}")
	public Photo getPhoto(@PathVariable String id, Model model) {
		Photo photo = getPhoto(id);
		model.addAttribute("title", photo.getTitle());
		model.addAttribute("image",
		Base64.getEncoder().encodeToString(photo.getImage().getData()));
//		TODO return something useful here
		return photo;
	}
	
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
