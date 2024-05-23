package moe.shan.anonymous.service.userinvite;

import moe.shan.anonymous.model.userinvite.UserInvite;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserInviteService {
    List<UserInvite> findByUserId(ObjectId userId);
}
