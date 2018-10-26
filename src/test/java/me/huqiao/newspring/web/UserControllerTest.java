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

public class UserControllerTest extends TestBase {

	@Autowired  
    private WebApplicationContext wac;  
    private MockMvc mockMvc;  
    
    @Before  
    public void setUp() {  
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  
    }  
    
    
    @Test  
    public void testList() throws Exception {  
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/list"))  
                //.andExpect(MockMvcResultMatchers.view().name("user/view"))  
                //.andExpect(MockMvcResultMatchers.model().attributeExists("user"))  
                .andDo(MockMvcResultHandlers.print())  
                .andReturn();  
          
        Assert.assertNotNull(result.getModelAndView().getModel().get("user"));  
    }
    
    @Test  
    public void testDetail() throws Exception {  
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))  
                //.andExpect(MockMvcResultMatchers.view().name("user/view"))  
                //.andExpect(MockMvcResultMatchers.model().attributeExists("user"))  
                .andDo(MockMvcResultHandlers.print())  
                .andReturn();  
          
        Assert.assertNotNull(result.getModelAndView().getModel().get("user"));  
    }
    @Test  
    public void testDelete() throws Exception {  
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/delete/2"))  
    			//.andExpect(MockMvcResultMatchers.view().name("user/view"))  
    			//.andExpect(MockMvcResultMatchers.model().attributeExists("user"))  
    			.andExpect(MockMvcResultMatchers.content().string("200"))
    			.andDo(MockMvcResultHandlers.print())  
    			.andReturn();  
    	
    	Assert.assertNotNull(result.getModelAndView().getModel().get("user"));  
    }
    
    @Test  
    public void testAdd() throws Exception {  
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/add/")
    			.param("username", "admin3")
    			.param("password", "111111"))  
    			//.andExpect(MockMvcResultMatchers.view().name("user/view"))  
    			//.andExpect(MockMvcResultMatchers.model().attributeExists("user"))  
    			.andExpect(MockMvcResultMatchers.content().string("200"))
    			.andDo(MockMvcResultHandlers.print())  
    			.andReturn();  
    	
    	Assert.assertNotNull(result.getModelAndView().getModel().get("user"));  
    }
    
    @Test  
    public void testUpdate() throws Exception {  
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/update/1")
    			.param("username", "admin-updated")
    			.param("password", "111111"))  
    			//.andExpect(MockMvcResultMatchers.view().name("user/view"))  
    			//.andExpect(MockMvcResultMatchers.model().attributeExists("user"))  
    			.andExpect(MockMvcResultMatchers.content().string("200"))
    			.andDo(MockMvcResultHandlers.print())  
    			.andReturn();  
    	
    	Assert.assertNotNull(result.getModelAndView().getModel().get("user"));  
    }
	    
}
