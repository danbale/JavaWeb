package com.softtek.academy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.softtek.academy.model.UserRole;

public class UserRoleRepositoryImpl extends SimpleRepository<UserRole> {

	public UserRoleRepositoryImpl(DataSource dataSource) {
		JdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<UserRole> getAll() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT description  FROM user_role");
		final List<UserRole> carts = JdbcTemplate.query(sql.toString(), new RowMapper<UserRole>() {
			@Override
			public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
				return build(rs);
			}
		});
		return carts;
	}

	@Override
	public UserRole build(ResultSet rs) throws SQLException {
		UserRole role = new UserRole();
		role.setDescription(rs.getString("description"));
		return role;
	}

}
