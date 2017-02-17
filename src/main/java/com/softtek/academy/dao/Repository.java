package com.softtek.academy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
	
	public List<T> getAll();
	public T get(final String id);
	public void update(T data);
	public T build(final ResultSet rs) throws SQLException;

}
