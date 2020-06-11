package net.mstiller.navigreat.room;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

// defines the REST path; e.g. "localhost:8080/customers"
//@CrossOrigin(origins = "*")
//@RepositoryRestResource(collectionResourceRel = "rooms", path = "rooms")
public interface RoomRepository extends MongoRepository<Room, String> {
	
}

