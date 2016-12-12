package com.yww.hr.daoImp;

import java.util.List;
import com.yww.hr.dao.IEmployeeDao;
import com.yww.hr.entity.Employee;

public class EmployeeDao extends BaseDao<Employee> implements IEmployeeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll(String employeeName) {
		
		return getSessionFactory().getCurrentSession()
				.createQuery("from Employee where name like :name")
				.setParameter("name", "%"+employeeName+"%")
				.list();
	}

}
