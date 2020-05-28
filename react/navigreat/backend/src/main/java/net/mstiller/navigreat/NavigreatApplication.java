package net.mstiller.navigreat;

import net.mstiller.navigreat.objects.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@SpringBootApplication
public class NavigreatApplication implements CommandLineRunner {
	
	@Autowired
	private RoomRepository rooms;
	
	@Autowired
	private PhotoService photos;
	
	public static void main(String[] args) {
		SpringApplication.run(NavigreatApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
	}
	
	@PostMapping("/photos/add")
	public String addPhoto(
	@RequestParam("title") String title,
	@RequestParam("image") MultipartFile image, Model model) throws IOException {
		String id = photos.addPhoto(title, image);
		return "redirect:/photos/" + id;
	}
	
	@GetMapping("/photos/{id}")
	public String getPhoto(@PathVariable String id, Model model) {
		Photo photo = photos.getPhoto(id);
		model.addAttribute("title", photo.getTitle());
		model.addAttribute("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
		return "photos";
	}
	
}
