package net.mstiller.navigreat.room;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@Service
public class RoomService {
	
	@Autowired
	private RoomRepository repo;
	
	@GetMapping("/rooms")
	public List<Room> getRooms() {
		return repo.findAll();
	}
	
	@GetMapping("/rooms/{id}")
	public Room getRoom(@PathVariable String id) {
		return repo.findById(id).get();
	}
	
	//	takes a JSON string
	@PostMapping("/rooms")
	public String addRoom(@RequestBody String payload) {
		Room room = new Gson().fromJson(payload, Room.class);
		return repo.save(room).getId();
	}
	
}
