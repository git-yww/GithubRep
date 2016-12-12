package com.yww.hr.dao;

import com.yww.hr.entity.Admin;

public interface IAdminDao {

	/**
	 * �������Ա
	 * @param admin
	 */
	public void save(Admin admin);
	
	/**
	 * �����������ҹ���Ա
	 * @param id
	 * @return	��Ӧ�����Ĺ���Ա
	 */
	public Admin findById(int id);
	
	/**
	 * �����û�����������ҹ���Ա
	 * @param admin
	 * @return	����Ա
	 */
	public Admin findByAdmin(Admin admin);

}
