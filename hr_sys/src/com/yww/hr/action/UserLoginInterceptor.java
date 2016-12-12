package com.yww.hr.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 对访问的用户进行拦截校验
 * 只有登录后才能进行操作
 * 没有登录，只能查看列表，不能操作
 * 
 * @author IVAN
 *
 */
public class UserLoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 2942821527391563816L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
	
		//获取当前执行的方法(invocation.getProxy()返回的是ActionProxy)
		String methodName = invocation.getProxy().getMethod();
		
		//获取session,并从中获取登陆的管理员信息
		ActionContext ac = invocation.getInvocationContext();
		Object obj = ac.getSession().get("adminBack");
		
		//判断是否是login方法和list方法
		if("login".equals(methodName) || "list".equals(methodName) || "register".equals(methodName)){
			
			//继续执行action
			return invocation.invoke();
		}else{
			
			//没有登录则跳转至登陆页面
			//登录了则继续执行action
			return obj == null ? "login" : invocation.invoke();
		}
	}

}
