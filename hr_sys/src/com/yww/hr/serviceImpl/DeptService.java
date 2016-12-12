package com.yww.hr.serviceImpl;

import java.util.List;

import com.yww.hr.dao.IDeptDao;
import com.yww.hr.entity.Dept;
import com.yww.hr.service.IDeptService;

public class DeptService implements IDeptService {

	private IDeptDao deptDao;
	
	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	@Override
	public List<Dept> getAll() {
		
		return deptDao.getAll();
	}

	@Override
	public Dept findById(int id) {
		
		return deptDao.findById(id);
	}

}
