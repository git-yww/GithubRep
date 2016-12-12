package com.yww.hr.dao;

import java.util.List;


/**
 * 所有Dao的通用操作接口
 * @author IVAN
 *
 */
public interface IBaseDao<T> {

	/**
	 * 保存对象
	 * @param emp
	 */
	public void save(T emp);
	
	/**
	 * 更新员工信息
	 * @param emp
	 */
	public void update(T emp);
	
	/**
	 * 根据主键删除员工
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 根据主键查找员工
	 * @param id
	 * @return	对应主键的员工
	 */
	public T findById(int id);
	
	/**
	 * 查询全部员工
	 * @return	全部员工
	 */
	public List<T> getAll();
}
