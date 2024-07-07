package com.codelink.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codelink.Model.UserDetails;

public interface UserDao extends JpaRepository<UserDetails, Integer> {

	
	
             UserDetails findByEmailAndPassword(String email, String password);
         

}
