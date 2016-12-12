package com.yww.hr.daoImp;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;

import com.yww.hr.dao.IBaseDao;

public class BaseDao<T> implements IBaseDao<T> {

	//当前操作的实际的bean类型
	private Class<T> clazz;
	
	private String className;
	
	//反射泛型
	public BaseDao(){
		//获取当前运行类的父类的参数化类型
		Type type = this.getClass().getGenericSuperclass();
		//转换为参数化类型
		ParameterizedType pt = (ParameterizedType) type;
		//得到实际类型
		Type types[] = pt.getActualTypeArguments();
		//获取实际类型
		clazz = (Class<T>) types[0];
		
		//获得类型的名称，在HQL查询语句中使用
		this.className = clazz.getSimpleName();
	}
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Override
	public void save(T obj) {
		
		sessionFactory.getCurrentSession().save(obj);
	}

	@Override
	public void update(T obj) {

		sessionFactory.getCurrentSession().update(obj);
	}

	@Override
	public void delete(int id) {

		/******用HQL进行删除有问题！*****/
		/*****原因已知：是hibernate4对"id=?"的方式不再支持*****/
		/*****修改为"id=:id"，问题即可解决！！*****/
		sessionFactory.getCurrentSession()
			.createQuery("delete from "+ className +" where id=:id")
			.setParameter("id", id)
			.executeUpdate();
	
//		T obj = (T) sessionFactory.getCurrentSession().get(clazz, id);
//		
//		if(obj != null){
//			sessionFactory.getCurrentSession().delete(obj);
//		}
	}

	@Override
	public T findById(int id) {
		
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public List<T> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from "+className).list();
	}

}
