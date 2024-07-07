package com.codelink.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codelink.DAO.QuestionDao;
import com.codelink.Model.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionDao dao;


	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
		return new ResponseEntity<>(dao.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity< List<Question>> getQuestionByCategory(String type) {

		try {
			return new ResponseEntity<>( dao.findByCategory(type),HttpStatus.FOUND);

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
	}

	public ResponseEntity< String >addQuestion(Question ques) {

		 dao.save(ques);
		 return new ResponseEntity<>("sucessfully saved",HttpStatus.CREATED);
	}

	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub

		dao.deleteById(id);
		return;
	}


	public Question updatebyId(Question question) {


		Question update=dao.findById(question.getId()).orElse(null);

		if(update!=null) {
			return dao.save(question);
		}
		else {
			return null;
		}

	}







}
