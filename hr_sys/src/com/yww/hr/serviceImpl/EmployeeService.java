package com.yww.hr.serviceImpl;

import java.util.List;

import com.yww.hr.dao.IEmployeeDao;
import com.yww.hr.entity.Employee;
import com.yww.hr.service.IEmployeeService;

public class EmployeeService implements IEmployeeService {

	private IEmployeeDao employeeDao;
	
	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public void save(Employee emp) {
		
		employeeDao.save(emp);
	}

	@Override
	public void update(Employee emp) {

		employeeDao.update(emp);
	}

	@Override
	public void delete(int id) {

		employeeDao.delete(id);
	}

	@Override
	public Employee findById(int id) {

		return employeeDao.findById(id);
	}

	@Override
	public List<Employee> getAll() {
		
		return employeeDao.getAll();
	}

	@Override
	public List<Employee> getAll(String employeeName) {
		
		return employeeDao.getAll(employeeName);
	}

	@Override
	public void deleteMany(int[] ids) {

		if(ids!=null && ids.length > 0){
			for(int id : ids){
				//循环调用delete方法
				delete(id);
			}
		}
	}

}
