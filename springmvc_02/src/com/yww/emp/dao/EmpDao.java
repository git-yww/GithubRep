package com.yww.emp.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yww.emp.entity.Employee;

public class EmpDao implements IEmpDao {

	private JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	/**
	 * 1°¢ÃÌº”‘±π§
	 * 
	 */
	@Override
	public void addEmp(Employee emp) {
		
		String sql = "insert into t_emp(id,name,gender,salary,hiredate) values(?,?,?,?,?);";
		jt.update(sql, new Object[]{emp.getId(),emp.getName(),emp.getGender(),emp.getSalary(),emp.getHiredate()});
	
	}

}
