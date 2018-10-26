package me.huqiao.newspring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import me.huqiao.newspring.domain.User;
import me.huqiao.newspring.service.UserService;
import me.huqiao.newspring.util.Md5Util;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/","/index.html"},method = RequestMethod.GET)
	public ModelAndView loginPage() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = {"/login"},method = RequestMethod.POST)
	public ModelAndView loginCheck(@RequestParam("username")String username,
			@RequestParam("password")String password) {
		ModelAndView mav = new ModelAndView("login");
		User user = userService.findByUsername(username);
		if(user==null) {
			mav.addObject("error", "Username or password error!");
			return mav;
		}
		String pwd = user.getPassword();
		if(!Md5Util.getMD5String(password).equals(pwd)) {
			mav.addObject("error", "Username or password error!");
			return mav;
		}
		mav.setViewName("main");
		return mav;
	}
}
