package com.boot.controller;

import com.boot.entity.UserEntity;
import com.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController      // to deal with the REST API
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @PostMapping("/add_user")    // end point  http://localhost:8080/user/add_user
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user)
    {
        UserEntity savedUser = this.userService.addUser(user);
        return new ResponseEntity<UserEntity>(savedUser, HttpStatus.CREATED);

        // we have used ResponseEntity because to change the HTTP status to 201(CREATED) (request send and new resource created)
        // earlier which was at default at 200(OK) Status i.e request created
    }

    @PostMapping("/newUser")    // end point  http://localhost:8080/user/newUser
    public ResponseEntity<UserEntity> newUser(@RequestBody UserEntity user)
    {

        UserEntity savedUser = this.userService.addUser(user);
        return new ResponseEntity<UserEntity>(savedUser, HttpStatus.CREATED);

        // we have used ResponseEntity because to change the HTTP status to 201(CREATED) (request send and new resource created)
        // earlier which was at default at 200(OK) Status i.e request created
    }
}
