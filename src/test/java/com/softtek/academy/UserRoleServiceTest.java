package com.softtek.academy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.softtek.academy.dao.UserRoleRepositoryImpl;
import com.softtek.academy.jstl.service.UserRoleService;
import com.softtek.academy.model.UserRole;

import junit.framework.Assert;


@RunWith(MockitoJUnitRunner.class)
public class UserRoleServiceTest {

	@Mock
	UserRoleRepositoryImpl userRoleDAOImp;
	
	@InjectMocks
	UserRoleService userRoleService;
	
	@Test
	public void userRoleListTest() {
		userRoleService = Mockito.mock(UserRoleService.class);
		System.out.println(userRoleService);
		Assert.assertNotNull(userRoleService);
	}
	
	@Test
	public void userRoleListTest2(){
		List<UserRole> list;
		list = userRoleDAOImp.getAll();
		System.out.println(list);
		Assert.assertNotNull(list);
	}
	
	

}
