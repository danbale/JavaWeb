package com.softtek.academy.jstl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.dao.UserRoleRepositoryImpl;
import com.softtek.academy.model.UserRole;




@Service
public class UserRoleService {

	@Autowired
	UserRoleRepositoryImpl userRoleRepository;
	
    public List<UserRole> list() {
        return this.userRoleRepository.getAll();
    }
}
