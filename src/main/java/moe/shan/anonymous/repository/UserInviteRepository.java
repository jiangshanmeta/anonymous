package moe.shan.anonymous.repository;

import moe.shan.anonymous.model.userinvite.UserInvite;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserInviteRepository extends MongoRepository<UserInvite, String> {
    List<UserInvite> findByUserId(ObjectId userId);
}
