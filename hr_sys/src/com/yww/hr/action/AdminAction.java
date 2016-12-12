package com.yww.hr.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yww.hr.entity.Admin;
import com.yww.hr.service.IAdminService;

public class AdminAction extends ActionSupport implements ModelDriven<Admin>{
	
	private static final long serialVersionUID = 4788470529058539163L;

	//封装实例化的请求数据
	private Admin admin = new Admin();	//模型驱动，必须要new一个对象！！！！否则会报NullPointerException
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public Admin getAdmin() {
		return admin;
	}

	@Override
	public Admin getModel() {
		
		return admin;
	}
	
	//注入service
	private IAdminService adminService;
	
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	
	//登录
	public String login(){
		
		Admin adminBack = adminService.login(admin);
		
		if(adminBack != null){
			ActionContext.getContext().getSession().put("adminBack", adminBack);
		}else{
			return "loginFailed";
		}
		return "index";
	}
	
	//注册
	public String register(){
		
		adminService.register(admin);
		
		return "login";
	}

}
