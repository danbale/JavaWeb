package com.softtek.academy.jstl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.dao.CartRepositoryImpl;
import com.softtek.academy.model.Cart;


@Service
public class CartService {
	

	@Autowired
	CartRepositoryImpl cartRepository;

	public List<Cart> list() {
		List<Cart> carts = cartRepository.getAll();
		
		return carts;
	}
	
	public Cart findOne(final Long cartId) {
		return cartRepository.get(Long.toString(cartId));
	
	}
	
	public Boolean update(final Cart cart) {
		if (this.isValidCart(cart)) {
			  cartRepository.update(cart);
			
			return true;
		}
		
		return false;
	}
	
	public Cart update(final Long id){
		
		return null;
	}
	
	private Boolean isValidCart(final Cart cart) {
		
		if (cart.getLinesAmount() == null) {
			return false;
		}
		
		if (cart.getShippingAmount() == null) {
			return false;
		}
		
		if (cart.getShipTo() == null || cart.getShipTo().getId().equals(0L)) {
			return false;
		}
		
		if (cart.getStatus() == null || cart.getStatus().getId().equals(0L)) {
			return false;
		}
		
		return true;
	}
	
}