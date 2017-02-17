package com.softtek.academy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softtek.academy.jstl.service.UserRoleService;
import com.softtek.academy.jstl.service.UserService;
import com.softtek.academy.model.User;
import com.softtek.academy.model.UserRole;

/**
 * Handles requests for the application home page.
 */
@RequestMapping(value = "/User")
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@Autowired
	UserRoleService userRoleService;


	@RequestMapping(value = "/List")
	public ModelAndView List() {
		List<User> users = userService.list();
		return new ModelAndView("jsp/User/List", "users", users);
	}

	@RequestMapping(value = "/edit")
	public ModelAndView editUser(@RequestParam String username, @RequestParam String status) {
		User user = userService.findOne(username);
		List<UserRole> userRoleList = userRoleService.list();
		List<String> listStatus = userService.statusList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("users", user);
		map.put("userRole", userRoleList);
		map.put("listStatus", listStatus);
		map.put("status", status);
		return new ModelAndView("jsp/" + "User" + "/edit", "map", map);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute User user, @RequestParam String userRoleId,
			@RequestParam String description) {
		UserRole userRole = new UserRole();
		userRole.setUserRoleId(userRoleId);
		userRole.setDescription(description);
		user.setRole(userRole);
		if (userService.update(user)) {
			return "redirect:/User/List?subroot=User";
		}
		return "redirect:/User/edit?username=" + user.getUsername() + "&status=Not valid";
	}
}
