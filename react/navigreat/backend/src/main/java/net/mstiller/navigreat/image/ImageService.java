package net.mstiller.navigreat.image;

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
public class ImageService {
	
	@Autowired
	private ImageRepository images;
	
	@GetMapping("/images")
	public List<Image> getImages() {
		return images.findAll();
	}
	
	@PostMapping("/images")
	public String addImage(@RequestParam("title") String title,
	                       @RequestParam("image") MultipartFile image, Model model)
	throws IOException {
		return addImage(title, image);
	}
	
	@GetMapping("/images/{id}")
	public Image getImage(@PathVariable String id, Model model) {
		Image image = getImage(id);
		model.addAttribute("title", image.getTitle());
		model.addAttribute("image",
		Base64.getEncoder().encodeToString(image.getImage().getData()));
//		TODO return something useful here
		return image;
	}
	
	@Autowired
	private ImageRepository repo;
	
	//	adds a photo file to the db and returns its id as a string.
	public String addImage(String title, MultipartFile file) throws IOException {
		Image image = new Image(
		title,
		new Binary(BsonBinarySubType.BINARY, file.getBytes())
		);
		image = repo.insert(image);
		return image.getId();
		
	}
	
	//	retrieves a given photo if it exists.
	public Image getImage(String id) {
		return repo.findById(id).get();
	}
	
}
