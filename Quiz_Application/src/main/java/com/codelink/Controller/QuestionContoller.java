package com.codelink.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelink.Model.Question;
import com.codelink.Service.QuestionService;

@RestController
@RequestMapping("api/Question")
public class QuestionContoller {

	@Autowired
	QuestionService service;




	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> AllQueations() {

		return service.getAllQuestions();
	}


	@GetMapping("category/{type}")
	public ResponseEntity< List<Question>> getQuestionByCategory(@PathVariable String type){

		return  service.getQuestionByCategory(type);
	}


	@PostMapping("/addQuestion")
	public ResponseEntity< String> addQuestion(@RequestBody Question question) {

		return service.addQuestion(question);
	}


	@DeleteMapping("/deleteQuestion/{id}")
	public String deleteQuestion(@PathVariable int id ) {

		service.deleteQuestion(id);

		return "Successfull Deleted Question with id :"+id;
	}


	@PutMapping("/updateById/{question}")
	public String updateById(@RequestBody Question question ) {

		 service.updatebyId(question);

		 return "updated successfully with id :"+question.getId();
	}



}
