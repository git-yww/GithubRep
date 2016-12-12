package com.yww.hr.serviceImpl;

import com.yww.hr.dao.IAdminDao;
import com.yww.hr.entity.Admin;
import com.yww.hr.service.IAdminService;

public class AdminService implements IAdminService {

	//ע��dao ������һ��Ҫ�ýӿڽ��գ���Ϊjdk��̬����ע����Ǵ������ֻ���ýӿڽ��ա�
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
