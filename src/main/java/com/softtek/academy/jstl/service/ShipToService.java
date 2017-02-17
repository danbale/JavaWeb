package com.softtek.academy.jstl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.dao.ShipToRepositoryImpl;
import com.softtek.academy.model.ShipTo;


@Service
public class ShipToService {
	
   @Autowired
   ShipToRepositoryImpl shipToRepository;

    public List<ShipTo> list() {
        return this.shipToRepository.getAll();
    }
}
