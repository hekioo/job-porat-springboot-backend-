package com.boot.controller;

import com.boot.entity.UserEntity;
import com.boot.service.UserService;
import com.boot.serviceImplementation.UserServiceImplementation;
import com.boot.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController      // to deal with the REST API
@RequestMapping("/public")
@Slf4j
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/signup")
    public ResponseEntity<UserEntity> signup(@RequestBody UserEntity user)
    {
        UserEntity savedUser = this.userService.addUser(user);
        return new ResponseEntity<UserEntity>(savedUser, HttpStatus.CREATED);

    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserEntity user)
    {


            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUserName(), user.getUserPassword()));
            UserDetails users =  userDetailsService.loadUserByUsername(user.getUserName());
            String jwt = jwtUtils.generateToken(users.getUsername());
            return new ResponseEntity<>(jwt, HttpStatus.OK);



    }

}
