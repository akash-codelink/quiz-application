package com.codelink.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codelink.Model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
