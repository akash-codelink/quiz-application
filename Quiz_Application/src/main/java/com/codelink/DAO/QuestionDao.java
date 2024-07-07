package com.codelink.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codelink.Model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {


	List<Question> findByCategory(String type);

	// this query takes 5 random questions form table ,where category=java

	@Query( value="SELECT * FROM Question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
	List<Question> findRandamQuestionByCategory(String category, int numQ);




}
