package com.softtek.academy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;

import com.softtek.academy.model.ShipTo;


public class ShipToRepositoryImpl extends SimpleRepository<ShipTo>{

	 public ShipToRepositoryImpl(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		 JdbcTemplate =new org.springframework.jdbc.core.JdbcTemplate(dataSource);
	}
	@Override
	public List<ShipTo> getAll() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ship_to_id, CONCAT(name, ' - ', address) name FROM ship_to");
		final List<ShipTo> shipToList=JdbcTemplate.query(sql.toString(),new RowMapper<ShipTo>()  {
			@Override
			public ShipTo mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return build(rs);
			}
		});
			return shipToList;
	}

	@Override
	public ShipTo build(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return new ShipTo(rs.getLong("ship_to_id"), rs.getString("name"));
	}

}
