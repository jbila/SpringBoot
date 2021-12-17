package com.bila.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bila.model.Users;
import com.bila.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public  List<Users> listAll(String keyword){
		if(keyword!=null) {
			return repo.findAll(keyword);
		}
		return  (List<Users>) repo.findAll();
		
	}
	/*notbeing used for the time being*/
	public  List<Users> listAllSearch(String keyword){ 
		if(keyword!=null) {
			return repo.findAll(keyword);
		}
		return  (List<Users>) repo.findAll();
		
	}
/*------------------------------------------------*/
	public void save(Users user) {
		repo.save(user);
		
	}
	public Optional<Users> get (int id) {
		
		return  repo.findById(id);
		/*if(result.isPresent()) 
			return result.get();
		
		throw new UsersNotFoundException("Could not find and user by id"+id);*/
		
	}

	public void  delete(Integer id) {
		repo.deleteById(id);
		
	}
	 

}
