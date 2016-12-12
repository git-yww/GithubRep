package com.yww.hr.service;

import com.yww.hr.entity.Admin;

public interface IAdminService {

	/**
	 * ×¢²á
	 * @param admin
	 */
	public void register(Admin admin);
	
	/**
	 * µÇÂ¼
	 * @param admin
	 */
	public Admin login(Admin admin);
}
