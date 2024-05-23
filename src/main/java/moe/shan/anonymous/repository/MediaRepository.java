package moe.shan.anonymous.repository;

import moe.shan.anonymous.model.media.Media;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MediaRepository extends MongoRepository<Media,String> {

}
