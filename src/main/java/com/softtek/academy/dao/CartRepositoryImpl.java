package com.softtek.academy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.softtek.academy.model.Cart;
import com.softtek.academy.model.ShipTo;
import com.softtek.academy.model.Status;

public class CartRepositoryImpl implements Repository<Cart> {

	// private JdbcTemplete jdbcTemplete;

	private JdbcTemplate jdbcTemplate;

	public CartRepositoryImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Cart> getAll() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT c.*, st.name ship_to, s.description status");
		sql.append("  FROM cart c");
		sql.append("  JOIN ship_to st ON st.ship_to_id = c.ship_to_id");
		sql.append("  JOIN status s ON s.status_id = c.status_id");
		
		final List<Cart> carts = jdbcTemplate.query(sql.toString(), new RowMapper<Cart>() {
			@Override
			public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
				return build(rs);
			}
		});
		return carts;
	}

	@Override
	public Cart get(String id) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM cart WHERE cart_id = " + id);
		return jdbcTemplate.query(sql.toString(), new ResultSetExtractor<Cart>() {

			@Override
			public Cart extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					return build(rs);
				}

				return null;
			}

		});
	}

	@Override
	public void update(Cart data) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE cart c");
		sql.append(" SET c.lines_amount = ?, c.shipping_amount = ?, c.cart_amount = ?,");
		sql.append(" c.ship_to_id = ?, c.status_id = ?");
		sql.append(" WHERE c.cart_id = ?");
		jdbcTemplate.update(sql.toString(), data.getLinesAmount(), data.getShippingAmount(), data.getCartAmount(),
				data.getShipTo().getId(), data.getStatus().getId(), data.getId());

	}

	@Override
	public Cart build(ResultSet rs) throws SQLException {
		Cart cart = new Cart();
		final int columnCount = rs.getMetaData().getColumnCount();
		cart.setId(rs.getLong("cart_id"));
		cart.setLinesAmount(rs.getDouble("lines_amount"));
		cart.setShippingAmount(rs.getDouble("shipping_amount"));
		cart.setCartAmount(rs.getDouble("cart_amount"));
		cart.setShipTo(new ShipTo(rs.getLong("ship_to_id"), columnCount > 10 ? rs.getString("ship_to") : ""));
		cart.setStatus(new Status(rs.getLong("status_id"), columnCount > 10 ? rs.getString("status") : "", ""));
		cart.setCreateUser(rs.getString("create_user"));
		cart.setCreateDate(rs.getTimestamp("create_date"));
		cart.setUpdateUser(rs.getString("update_user"));
		cart.setUpdateDate(rs.getTimestamp("update_date"));
		return cart;
	}
}
