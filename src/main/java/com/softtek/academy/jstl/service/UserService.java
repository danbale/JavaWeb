package com.softtek.academy.jstl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.dao.UserRepositoryImpl;
import com.softtek.academy.model.User;



@Service
public class UserService {
	

	@Autowired
	UserRepositoryImpl userRepository;
	public List<User> list() {
		List<User> user = userRepository.getAll();

		return user;
	}

	public User findOne(final String username) {
		return userRepository.get(username);

	}
	public List<String> statusList() {
		return userRepository.statusList();
		
	}
	
	public Boolean update(final User user) {
		if (this.isValidUser(user)) {
			System.out.println("update");
			userRepository.update(user);
		
			return true;
		}
		
		return false;
	}
	
	private Boolean isValidUser(final User user) {
		
		if (user.getName() == null || user.getName().isEmpty()) {
		
			return false;
		}
		
		if (user.getStatus()== null || user.getStatus().isEmpty()  ) {
			
			return false;
		}
		
		if(user.getUsername()==null){
		
			return false;
		}
		if(user.getRole()==null || user.getRole().getDescription().isEmpty()){
			
			return false;
		}
		System.out.println(user.getPassword());
		if(user.getPassword()==null||user.getPassword().isEmpty()){
			return false;
		}
		return true;
	}

}
