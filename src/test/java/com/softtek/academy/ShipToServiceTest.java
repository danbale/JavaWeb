package com.softtek.academy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.softtek.academy.dao.ShipToRepositoryImpl;
import com.softtek.academy.jstl.service.ShipToService;
import com.softtek.academy.model.ShipTo;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class ShipToServiceTest {
	
	@Mock
	ShipToRepositoryImpl ShipToDao;

	@InjectMocks
	ShipToService shipToService;

	@Test
	public void shipToServiceTest() {
		shipToService = Mockito.mock(ShipToService.class);
		System.out.println(shipToService);
		Assert.assertNotNull(shipToService);
	}

	@Test
	public void shipToServiceTest2() {
		shipToService = Mockito.mock(ShipToService.class);
		List<ShipTo> list;
		list = shipToService.list();
		list.add(new ShipTo(1L, "J"));
		System.out.println(list);
		Assert.assertEquals(list, ShipToDao.getAll());
	}

	@Test
	public void shipToDAOList() {
		List<ShipTo> list;
		list = ShipToDao.getAll();
		System.out.println(list);
		Assert.assertNotNull(list);
	}

}
