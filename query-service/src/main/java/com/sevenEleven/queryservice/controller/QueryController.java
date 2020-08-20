package com.sevenEleven.queryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sevenEleven.queryservice.exception.QueryNotFoundException;
import com.sevenEleven.queryservice.exception.QuestionNotFoundExpection;
import com.sevenEleven.queryservice.model.Query;
import com.sevenEleven.queryservice.service.QueryService;

@RestController
public class QueryController {

	@Autowired
	private QueryService queryService;

	@GetMapping("/getAllQuestions/{role}")
	public List<Query> getAllQuestions(@PathVariable String role) throws QuestionNotFoundExpection{
		return queryService.getAllQuestions(role);
	}
	
	@PostMapping("/askQuestion")
	public void addQuestion(@RequestBody Query query) {
		queryService.addQuestion(query);
	}
	
	@PutMapping("/updateAnswer")
	public void  addAnswer(@RequestBody Query query) throws QueryNotFoundException {
		queryService.addAnswer(query);
	}
	
	@DeleteMapping("/deleteById/{queryId}")
	public void deleteQuery(@PathVariable int queryId) throws QueryNotFoundException {
		queryService.deleteQueryById(queryId);
	}
		
}