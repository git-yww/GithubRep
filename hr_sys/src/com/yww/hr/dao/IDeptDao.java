package com.yww.hr.dao;

import java.util.List;

import com.yww.hr.entity.Dept;

public interface IDeptDao {

	/**
	 * ��ѯȫ����Ϣ
	 * @return	���в���
	 */
	public List<Dept> getAll();
	
	/**
	 * ����������ѯ
	 * @param id
	 * @return	��Ӧ�����Ĳ���
	 */
	public Dept findById(int id);
}
