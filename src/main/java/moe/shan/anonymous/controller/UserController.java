package moe.shan.anonymous.controller;

import moe.shan.anonymous.model.userinvite.UserInvite;
import moe.shan.anonymous.service.userinvite.UserInviteService;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserInviteService userInviteService;
    public UserController(
            UserInviteService userInviteService
    ){
        this.userInviteService = userInviteService;
    }

    @GetMapping("my/inviteCodes")
    public ResponseEntity<List<UserInvite>> myInviteCodes(){
        // TODO get userId hardcoded for now

        return ResponseEntity.ok(userInviteService.findByUserId(new ObjectId("5b03e10aaf7540e1f2cb18ed")));
    }

}
