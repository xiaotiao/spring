package com.zzh.service.impl;

import org.springframework.stereotype.Service;

import com.zzh.beans.User;
import com.zzh.service.IUserService;
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Override
	public boolean isLoginSuccess(User user) {
		boolean flag=false;
		if(user==null){
			throw new IllegalArgumentException("user 不能为空!");
		}
		flag=("root".equals(user.getUsername())&&"abc123".equals(user.getPassword()))
			  ?true:false;
		String loginState=(flag==true)?"成功了!":"失败了!";
		System.out.println("登录"+loginState);
		return flag;
	}

}
