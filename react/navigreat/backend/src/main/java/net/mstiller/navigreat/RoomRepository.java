package net.mstiller.navigreat;

import net.mstiller.navigreat.objects.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

// allows CORS policy
//@CrossOrigin(allowedHeaders = {"*"})
// defines the REST path; e.g. "localhost:8080/customers"
@RepositoryRestResource(collectionResourceRel = "rooms", path = "rooms")
public interface RoomRepository extends MongoRepository<Room, String> {
	
}

