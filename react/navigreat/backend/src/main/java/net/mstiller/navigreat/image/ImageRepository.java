package net.mstiller.navigreat.photo;

import net.mstiller.navigreat.photo.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

//@RepositoryRestResource(collectionResourceRel = "photos", path = "photos")
public interface PhotoRepository extends MongoRepository<Photo, String> {

}
