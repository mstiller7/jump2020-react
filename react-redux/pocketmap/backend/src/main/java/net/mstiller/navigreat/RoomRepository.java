package net.mstiller.navigreat;

import java.util.List;

import net.mstiller.navigreat.objects.Room;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

// allows CORS policy
@CrossOrigin(allowedHeaders = {"*"})
// defines the REST path; e.g. "localhost:8080/customers"
@RepositoryRestResource(collectionResourceRel = "rooms", path = "rooms")
public interface RoomRepository extends PagingAndSortingRepository<Room, Long> {
	
	List<Room> findRoomByName(@Param("name") String name);
	
}