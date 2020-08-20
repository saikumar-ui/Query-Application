package com.sevenEleven.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sevenEleven.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String name);

//	@Query(value = "SELECT u.menuItemList from User u where u.id = :id")
//	List<MenuItem> getAllCartItems(@Param("id") int id);
//
//	@Query(value = "SELECT SUM(m.price) from User u INNER JOIN u.menuItemList m where u.id = :id")
//	float getCartTotal(@Param("id") int id);

}
