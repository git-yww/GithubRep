package com.yww.emp.service;

import com.yww.emp.dao.IEmpDao;
import com.yww.emp.entity.Employee;

public class EmpService implements IEmpService {

	private IEmpDao empDao;
	
	public void setEmpDao(IEmpDao empDao) {
		this.empDao = empDao;
	}
	
	@Override
	public void register(Employee emp) {

		empDao.addEmp(emp);
	}
}
