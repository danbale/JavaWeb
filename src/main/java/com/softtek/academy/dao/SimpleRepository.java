package com.softtek.academy.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class SimpleRepository<T> implements Repository<T> {
	
	
	protected JdbcTemplate JdbcTemplate;
	
	@Override
	public T get(final String id){
		return null;
	}
	@Override
	public void update(T data){
		
	}


}
