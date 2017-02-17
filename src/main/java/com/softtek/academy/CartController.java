package com.softtek.academy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softtek.academy.jstl.service.CartService;
import com.softtek.academy.jstl.service.ShipToService;
import com.softtek.academy.jstl.service.StatusService;
import com.softtek.academy.model.Cart;
import com.softtek.academy.model.ShipTo;
import com.softtek.academy.model.Status;

@RequestMapping(value = "/Cart")
@Controller
public class CartController {
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	@Autowired
	CartService cartService;

	@Autowired
	ShipToService shipToService;

	@Autowired
	StatusService statusService;

	@RequestMapping(value = "/List")
	public ModelAndView List() {
		List<Cart> carts = cartService.list();
		return new ModelAndView("jsp/Cart/List", "carts", carts);
	}

	@RequestMapping(value = "/CartTest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> cartListTest() {
		List<Cart> carts = cartService.list();
		return new ResponseEntity<List<Cart>>(carts, HttpStatus.OK);
	}

	@RequestMapping(value = "/edit")
	public ModelAndView editUser(@RequestParam Long cartId, @RequestParam String status) {
		Cart cart = cartService.findOne(cartId);
		List<Status> cartStatus = statusService.getCartStatus();
		List<ShipTo> shipTos = shipToService.list();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cart", cart);
		map.put("cartStatus", cartStatus);
		map.put("shipTos", shipTos);
		map.put("status", status);
		return new ModelAndView("jsp/" + "Cart" + "/edit", "map", map);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCart(HttpServletRequest request) {
		System.out.println("Hola");
		return "";
	}

}
