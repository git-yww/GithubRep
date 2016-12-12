package com.yww.hr.serviceImpl;

import com.yww.hr.dao.IAdminDao;
import com.yww.hr.entity.Admin;
import com.yww.hr.service.IAdminService;

public class AdminService implements IAdminService {

	//注入dao 【这里一定要用接口接收，因为jdk动态代理注入的是代理对象，只能用接口接收】
	private IAdminDao adminDao;
	
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
	public void register(Admin admin) {
		
		adminDao.save(admin);
	}

	@Override
	public Admin login(Admin admin) {
		
		return adminDao.findByAdmin(admin);
	}

}
