package com.codelink.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codelink.Model.UserDetails;
import com.codelink.Service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDetails userDetails) {
        return userService.registerUser(userDetails);
    }
    
    @GetMapping("/login")
    public ResponseEntity<UserDetails>login(@RequestParam String email, @RequestParam String password){
    	
    	return userService.loginValidation(email,password);
    	
    }  	 
}
