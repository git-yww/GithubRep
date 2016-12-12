package com.yww.hr.daoImp;

import org.hibernate.SessionFactory;
import com.yww.hr.dao.IAdminDao;
import com.yww.hr.entity.Admin;

public class AdminDao implements IAdminDao {

	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Admin admin) {

		sessionFactory.getCurrentSession().save(admin);
	}

	@Override
	public Admin findById(int id) {
		
		Admin admin = (Admin)sessionFactory.getCurrentSession().get(Admin.class, id);
		
		return admin;
	}

	@Override
	public Admin findByAdmin(Admin admin) {
		
		return (Admin) sessionFactory.getCurrentSession()
				.createQuery("from Admin where name=:name and password=:pwd")
				.setParameter("name", admin.getName())
				.setParameter("pwd", admin.getPassword())
				.uniqueResult();
	}
}
