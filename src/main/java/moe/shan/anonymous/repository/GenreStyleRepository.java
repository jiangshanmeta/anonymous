package moe.shan.anonymous.repository;

import moe.shan.anonymous.model.genrestyle.GenreStyle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreStyleRepository extends MongoRepository<GenreStyle, String> {
}
