package com.sevenEleven.appuserservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sevenEleven.appuserservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

//	@Query(value = "SELECT u.menuItemList from User u where u.id = :id")
//	List<MenuItem> getAllCartItems(@Param("id") int id);
//
//	@Query(value = "SELECT SUM(m.price) from User u INNER JOIN u.menuItemList m where u.id = :id")
//	float getCartTotal(@Param("id") int id);

}
