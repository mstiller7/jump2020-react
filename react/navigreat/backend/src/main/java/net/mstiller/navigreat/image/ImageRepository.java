package net.mstiller.navigreat.image;

import org.springframework.data.mongodb.repository.MongoRepository;

//@RepositoryRestResource(collectionResourceRel = "photos", path = "photos")
public interface ImageRepository extends MongoRepository<Image, String> {

}
