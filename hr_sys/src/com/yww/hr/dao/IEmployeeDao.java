package com.yww.hr.dao;

import java.util.List;

import com.yww.hr.entity.Employee;

public interface IEmployeeDao {

	/**
	 * 保存员工信息
	 * @param emp
	 */
	public void save(Employee emp);
	
	/**
	 * 更新员工信息
	 * @param emp
	 */
	public void update(Employee emp);
	
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
	public Employee findById(int id);
	
	/**
	 * 查询全部员工
	 * @return	全部员工
	 */
	public List<Employee> getAll();
	
	/**
	 * 根据员工姓名查找员工
	 * @param EmployeeName
	 * @return	对应姓名的员工
	 */
	public List<Employee> getAll(String employeeName);
}
