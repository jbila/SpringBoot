package com.bila.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bila.model.Users;

public interface UserRepository extends CrudRepository<Users,Integer> {
	@Query ("SELECT U FROM Users U  WHERE U.name LIKE %?1%  OR U.country LIKE %?1%") 
	public List<Users> findAll(String keyword);
	

}
