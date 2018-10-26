package me.huqiao.newspring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;
import me.huqiao.newspring.domain.User;
import me.huqiao.newspring.util.Md5Util;

@RunWith(SpringRunner.class)	
@SpringBootTest
public class UserServiceTest {
	@Autowired
    private UserService userService;

    @Test
    public void addUser() throws Exception {
    	User user = new User();
    	user.setUsername("admin");
    	user.setPassword(Md5Util.getMD5String("123456"));
    	userService.add(user);
    }
    
    @Test
    public void findUser() throws Exception {
    	User user = userService.findById(1l);
    	org.junit.Assert.assertNotNull(user);
    	System.out.println(user);
    }
    
    
}
