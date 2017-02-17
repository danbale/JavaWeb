package com.softtek.academy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;

import com.softtek.academy.model.Status;

public class StatusRepositoryImpl  extends SimpleRepository<Status>{
	
	private String statusType;

	public  StatusRepositoryImpl(DataSource dataSource) {
		JdbcTemplate=new org.springframework.jdbc.core.JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Status> getAll() {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append("SELECT * FROM status WHERE status_type = ?");
		final List<Status> statusList=JdbcTemplate.query(sql.toString(),new RowMapper<Status>()  {
			@Override
			public Status mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return build(rs);
			}
		},statusType);
			return statusList;
	}

	@Override
	public Status build(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return new Status(rs.getLong("status_id"), rs.getString("description"), rs.getString("status_type"));
	}
	public String getStatusType() {
		return statusType;
	}
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	

}
