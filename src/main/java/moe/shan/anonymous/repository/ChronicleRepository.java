package moe.shan.anonymous.repository;

import moe.shan.anonymous.model.chronicle.Chronicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChronicleRepository extends MongoRepository<Chronicle,String> {
}
