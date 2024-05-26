package moe.shan.anonymous.service.userinvite;

import moe.shan.anonymous.model.userinvite.UserInvite;
import moe.shan.anonymous.repository.UserInviteRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInviteServiceImpl implements UserInviteService {
    private final UserInviteRepository userInviteRepository;

    public UserInviteServiceImpl(
            UserInviteRepository userInviteRepository
    ) {
        this.userInviteRepository = userInviteRepository;
    }

    public List<UserInvite> findByUserId(ObjectId userId) {
        return userInviteRepository.findByUserId(userId);
    }
}
