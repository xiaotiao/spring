package com.zzh.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.zzh.beans.User;

@Aspect
@Component("userAspect")
public class UserAspect {

	/**
	 * 通过此方法定义可重用的切点
	 */
	@Pointcut(" execution(* com.zzh.service.IUserService.isLoginSuccess(..)) && args(user)")
	public void definePointCut(User user){
		
	}
	
	@Before("definePointCut(user)")
	public void printInfoBeforeLogin(User user){
		if(user==null){
			throw new IllegalArgumentException("user is null!");
		}
		System.out.println("before Advice start...");
		System.out.println(user.getUsername()+"即将登录!");
		System.out.println("before Advice end...");
	}
	
	@After("definePointCut(user)")
	public void printInfoAfterLogin(User user){
		if(user==null){
			throw new IllegalArgumentException("user is null!");
		}
		System.out.println("after Advice start...");
		System.out.println(user.getUsername()+"登录成功了吗?");
		System.out.println("after Advice end...");
	}
	
	@AfterThrowing("definePointCut(user)")
	public void printLoginEx(User user){
		 System.out.println("有异常!");
		 System.exit(1);
	}
	
	@Around("execution(* com.zzh.service.IUserService.isLoginSuccess(..)) ")
	public Object printInfoAroundLogin(ProceedingJoinPoint joinPoint){
		Object[] args=joinPoint.getArgs();
		System.out.println("time:"+System.currentTimeMillis()+" around before user login....");
		Object obj=null;
		try {
			obj=joinPoint.proceed(args);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("time:"+System.currentTimeMillis()+" around after user login....");
		return obj;
	}
	
	
}
