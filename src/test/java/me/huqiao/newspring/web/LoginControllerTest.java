package me.huqiao.newspring.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import me.huqiao.newspring.dao.TestBase;

public class LoginControllerTest extends TestBase {

	@Autowired  
    private WebApplicationContext wac;  
    private MockMvc mockMvc;  
    
    @Before  
    public void setUp() {  
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  
    }  
    
    
    @Test  
    public void testLogin() throws Exception {  
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
        		.param("username", "admin")
        		.param("password", "111111"))  
                //.andExpect(MockMvcResultMatchers.view().name("user/view"))  
                //.andExpect(MockMvcResultMatchers.model().attributeExists("user"))  
                .andDo(MockMvcResultHandlers.print())  
                .andReturn();  
          
        Assert.assertEquals(result.getModelAndView().getViewName(),"main");  
        
        result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
        		.param("username", "admin")
        		.param("password", "111112"))  
                //.andExpect(MockMvcResultMatchers.view().name("user/view"))  
                //.andExpect(MockMvcResultMatchers.model().attributeExists("user"))  
                .andDo(MockMvcResultHandlers.print())  
                .andReturn();  
        Assert.assertEquals(result.getModelAndView().getViewName(),"login");  
    }
    
	    
}
