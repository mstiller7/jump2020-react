package net.mstiller.navigreat;

import net.mstiller.navigreat.objects.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> {

}
