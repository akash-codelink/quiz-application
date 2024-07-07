package com.codelink.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codelink.DAO.QuestionDao;
import com.codelink.DAO.QuizDao;
import com.codelink.Model.Question;
import com.codelink.Model.QuestionWrapper;
import com.codelink.Model.Quiz;
import com.codelink.Model.Response;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	@Autowired
	QuestionDao questionDao;



	// creation of set of quiz Question table

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

		// accept the random 5 java questions from DB
	    List<Question> questions=questionDao.findRandamQuestionByCategory(category, numQ);

		//create a object for quiz model

		Quiz quiz=new Quiz();    // need to pass the values get from URL
		quiz.setTitle(title);
		quiz.setQuestions(questions); // assign 5 random questions

		quizDao.save(quiz);   // save the data's 5 random questions saved into a new table

		return new ResponseEntity<>("successfully created ",HttpStatus.CREATED);
	}



	public ResponseEntity<List<QuestionWrapper>> getquizQuestions(Integer id) {

	Optional<Quiz> quiz=	quizDao.findById(id); // choose the id in random questions table

	List<Question> questionFromDB=quiz.get().getQuestions(); // take questions from DB in quiz table ( random ques)

	List<QuestionWrapper> questionsForUser=new ArrayList<>();  // create array list of wrapper to store list of quiz data
	for(Question q:questionFromDB) {
		// take every questions from quiz DB and initialise them using Wrapper class constructor
		QuestionWrapper qw=new QuestionWrapper(q.getId(), q.getQuestion_title(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
		questionsForUser.add(qw);


	}

	return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
	}



	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

		Optional<Quiz>  quiz=quizDao.findById(id);
		List<Question> quizQues= quiz.get().getQuestions();
		int right=0;
		int nextId=0;
		for(Response response:responses) {

			if(response.getResponse().equals(quizQues.get(nextId).getRight_answer())){
				right++;

				nextId++;

			}

		}


		return new ResponseEntity<>(right,HttpStatus.OK);
	}








}
