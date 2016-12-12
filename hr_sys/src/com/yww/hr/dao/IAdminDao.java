package com.yww.hr.dao;

import com.yww.hr.entity.Admin;

public interface IAdminDao {

	/**
	 * 保存管理员
	 * @param admin
	 */
	public void save(Admin admin);
	
	/**
	 * 根据主键查找管理员
	 * @param id
	 * @return	对应主键的管理员
	 */
	public Admin findById(int id);
	
	/**
	 * 根据用户名和密码查找管理员
	 * @param admin
	 * @return	管理员
	 */
	public Admin findByAdmin(Admin admin);

}
