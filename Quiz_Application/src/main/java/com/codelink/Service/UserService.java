package com.codelink.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codelink.DAO.UserDao;
import com.codelink.Model.UserDetails;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public ResponseEntity<String> registerUser(UserDetails userDetails) {
    	
    	
        userDao.save(userDetails);
        return new ResponseEntity<>("Successfully Registered", HttpStatus.CREATED);
    	
    	//return new ResponseEntity<>("Re Enter data", HttpStatus.NOT_ACCEPTABLE);
    }

	

	public ResponseEntity<UserDetails> loginValidation(String email, String password) {
		
		
			UserDetails details= userDao.findByEmailAndPassword(email, password);
			if(details!=null) {
	            return new ResponseEntity<>(details,HttpStatus.ACCEPTED);

			}else {
				return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

			}
				
			
		
		
	}
}
