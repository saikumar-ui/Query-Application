package com.sevenEleven.queryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sevenEleven.queryservice.model.Query;

@Repository
public interface QueryRepository extends JpaRepository<Query, Integer>{
	
	List<Query>	findByAnswerIsNull();

}
