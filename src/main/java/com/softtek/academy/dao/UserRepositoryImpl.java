package com.softtek.academy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


import com.softtek.academy.model.User;
import com.softtek.academy.model.UserRole;

public class UserRepositoryImpl implements Repository<User> {

	private JdbcTemplate jdbcTemplate;
	
	public  UserRepositoryImpl(DataSource dataSource) {
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<User> getAll() {
	StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT u.*, ur.description");
		sql.append("  FROM user u ");
		sql.append("  JOIN user_role  ur ON ur.user_role_id = u.user_role_id ");
	final List<User> users=jdbcTemplate.query(sql.toString(),new RowMapper<User>()  {
		
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return build(rs);
		}
	});
	
	
		return users;
	}

	@Override
	public User get(String id) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u.*, ur.description ");
		sql.append("  FROM user u ");
		sql.append(" INNER JOIN user_role ur ON ur.user_role_id = u.user_role_id");
		sql.append(" WHERE u.username = ?");
		
		 return jdbcTemplate.query(sql.toString(), new ResultSetExtractor<User>() {
			 
		        @Override
		        public User extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		                return build(rs);
		            }
		 
		            return null;
		        }
		 
		    },id);
	}

	@Override
	public void update(User data) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE user u ");
		sql.append(" SET u.username=? , u.password =?,u.name=?,u.active=? , ");
		sql.append(" u.user_role_id=(SELECT user_role_id FROM user_role  WHERE description=?)");
		sql.append(" WHERE u.username=? ");
	
		
		  jdbcTemplate.update(sql.toString(), data.getUsername(), data.getPassword(),
	                data.getName(), data.getStatus(),data.getRole().getDescription(),data.getUsername());
	}
	
	
	@Override
	public User build(ResultSet rs) throws SQLException{
		User user =new User();
		user.setUsername(rs.getString("username"));
		user.setName(rs.getString("name"));
		user.setStatus(rs.getString("active"));
		UserRole userRole =new UserRole();
		userRole.setUserRoleId(rs.getString("user_role_id"));
		userRole.setDescription(rs.getString("description"));
		user.setRole(userRole);
		return user;
	}
	
	public List<String> statusList() {
		List <String>status=new ArrayList<String>();
		status.add("S");
		status.add("N");
		return status;
		
	}
	
	

}
