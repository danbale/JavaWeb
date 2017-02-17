package com.softtek.academy.jstl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.dao.StatusRepositoryImpl;
import com.softtek.academy.model.Status;


@Service
public class StatusService {
    

	@Autowired
	StatusRepositoryImpl statusRepository;

    public List<Status> getCartStatus() {
        return this.statusRepository.getAll();
    }
}
