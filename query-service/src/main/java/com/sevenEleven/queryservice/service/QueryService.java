package com.sevenEleven.queryservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenEleven.queryservice.exception.AdminNotFoundException;
import com.sevenEleven.queryservice.exception.QueryNotFoundException;
import com.sevenEleven.queryservice.exception.QuestionNotFoundExpection;
import com.sevenEleven.queryservice.model.Query;
import com.sevenEleven.queryservice.model.User;
import com.sevenEleven.queryservice.repository.QueryRepository;

@Service
public class QueryService {

	@Autowired
	private QueryRepository queryRepository;
	
	@Transactional
	public void addQuestion(Query query) {
		query.setStatus(true);
		queryRepository.save(query);
	}
	
	@Transactional
	public List<Query> getAllQuestions(String role) throws QuestionNotFoundExpection{
		try {
			if(role == "ADMIN") {
				return queryRepository.findByAnswerIsNull();
			}else {
				throw new AdminNotFoundException();
			}
		} catch (Exception questionNotFoundExpextion) {
			throw new QuestionNotFoundExpection();
		} 	
	}
	
	@Transactional
	public void addAnswer(Query query) throws QueryNotFoundException{
		try {
			User adminUser = query.getUser();
			if(adminUser.getRole() == "ADMIN") {
				Query existedQuery = queryRepository.findById(query.getId()).get();
				existedQuery.setAnswer(query.getAnswer());
				existedQuery.setIsAnswered(true);
				queryRepository.save(existedQuery);	
			} else {
				throw new AdminNotFoundException();
			}
		}catch (Exception queryNotFoundException){
			throw new QueryNotFoundException();
		}
	}

	@Transactional
	public void deleteQueryById(int queryId) throws QueryNotFoundException {
		try {
			queryRepository.deleteById(queryId);
		}catch (Exception queryNotFound){
			throw new QueryNotFoundException();
		}
	}
}
