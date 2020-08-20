package com.sevenEleven.appuserservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sevenEleven.appuserservice.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}