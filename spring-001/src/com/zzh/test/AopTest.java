package com.zzh.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.zzh.beans.User;
import com.zzh.service.IUserService;

public class AopTest {

	@Autowired
	private IUserService userService;
	
	@SuppressWarnings("all")
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserService userService=applicationContext.getBean("userService",IUserService.class);
		User user=applicationContext.getBean("user",User.class);
		user.setUsername("root");
		user.setPassword("abc123");
		userService.isLoginSuccess(user);
	}
}
