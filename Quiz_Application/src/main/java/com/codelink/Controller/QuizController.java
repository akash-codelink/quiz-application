package com.codelink.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codelink.Model.QuestionWrapper;
import com.codelink.Model.Response;
import com.codelink.Service.QuizService;

@RestController
@RequestMapping("api/quiz")
public class QuizController {

	@Autowired
	QuizService quizservice;

	@PostMapping("create") // quiz/create?Category=java&numQ=5&title=JQuiz ( for title , 5 questions created randomly )
	public ResponseEntity<String> creatQuiz(@RequestParam String Category,@RequestParam int numQ,@RequestParam String title){

		return quizservice.createQuiz(Category,numQ,title);

	}

	@GetMapping("/getQuiz/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){


	return	quizservice.getquizQuestions(id);

	}

	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> Correction(@PathVariable Integer id, @RequestBody List<Response> responses){

		return quizservice.calculateResult(id,responses);
	}
}
