package me.huqiao.newspring.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.huqiao.newspring.domain.User;
import me.huqiao.newspring.service.UserService;
import me.huqiao.newspring.util.Md5Util;

@RestController()
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user/list",method = RequestMethod.GET)
	public List<User> list(){
		return userService.getAll();
	}
	
	@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
	public User detail(@PathVariable("id")Long id){
		User user = userService.findById(id);
		return user;
	}
	
	@RequestMapping(value = "/user/delete/{id}",method = {RequestMethod.DELETE,RequestMethod.POST})
	public String delete(@PathVariable("id")Long id){
		userService.delete(id);
		return "200";
	}
	
	@RequestMapping(value = "/user/add",method = {RequestMethod.POST})
	public String add(@RequestParam("username")String username,@RequestParam("password")String password){
		User user = new User(username,password);
		userService.add(user);
		return "200";
	}
	
	@RequestMapping(value = "/user/update/{id}",method = {RequestMethod.POST})
	public String update(@PathVariable("id")Long id,
			@RequestParam("username")String username,@RequestParam("password")String password){
		User user = userService.findById(id);
		if(user!=null) {
			user.setUsername(username);
			user.setPassword(Md5Util.getMD5String(password));
			userService.update(user);
		}
		return "200";
	}

}
