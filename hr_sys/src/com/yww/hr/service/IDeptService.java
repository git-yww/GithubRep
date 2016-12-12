package com.yww.hr.service;

import java.util.List;

import com.yww.hr.entity.Dept;

public interface IDeptService {

	/**
	 * 查询全部信息
	 * @return	所有部门
	 */
	public List<Dept> getAll();
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return	对应主键的部门
	 */
	public Dept findById(int id);
}
