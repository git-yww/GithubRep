package com.yww.hr.service;

import java.util.List;

import com.yww.hr.entity.Employee;

public interface IEmployeeService {

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
	
	
	/**
	 * ɾ�����Ա����Ϣ����ҵ����߼�
	 * @param ids
	 */
	public void deleteMany(int[] ids);
}
