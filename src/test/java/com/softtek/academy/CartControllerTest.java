package com.softtek.academy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class CartControllerTest {

	@Autowired
	private CartController cartController;

	private MockMvc mockMvc; 
	
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(cartController).build();
    }
    
    @Test
    public void testCartControllerListViewStatusEqual200() throws Exception{
    	int statusTest = mockMvc.perform(MockMvcRequestBuilders.get("/Cart/List", "")).
    			andReturn().getResponse().getStatus();
    	Assert.assertTrue(statusTest == 200);
    }
    
   
    

}
