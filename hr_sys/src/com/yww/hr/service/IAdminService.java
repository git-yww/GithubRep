package com.yww.hr.service;

import com.yww.hr.entity.Admin;

public interface IAdminService {

	/**
	 * ע��
	 * @param admin
	 */
	public void register(Admin admin);
	
	/**
	 * ��¼
	 * @param admin
	 */
	public Admin login(Admin admin);
}
