package com.yww.hr.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.yww.hr.dao.IDeptDao;
import com.yww.hr.entity.Dept;

public class DeptDao implements IDeptDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Dept> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from Dept").list();
	}

	@Override
	public Dept findById(int id) {
		
		return (Dept) sessionFactory.getCurrentSession().get(Dept.class, id);
	}
}
