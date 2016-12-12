package com.yww.hr.dao;

import java.util.List;

import com.yww.hr.entity.Employee;

public interface IEmployeeDao {

	/**
	 * ����Ա����Ϣ
	 * @param emp
	 */
	public void save(Employee emp);
	
	/**
	 * ����Ա����Ϣ
	 * @param emp
	 */
	public void update(Employee emp);
	
	/**
	 * ��������ɾ��Ա��
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * ������������Ա��
	 * @param id
	 * @return	��Ӧ������Ա��
	 */
	public Employee findById(int id);
	
	/**
	 * ��ѯȫ��Ա��
	 * @return	ȫ��Ա��
	 */
	public List<Employee> getAll();
	
	/**
	 * ����Ա����������Ա��
	 * @param EmployeeName
	 * @return	��Ӧ������Ա��
	 */
	public List<Employee> getAll(String employeeName);
}
