package com.yww.hr.daoImp;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;

import com.yww.hr.dao.IBaseDao;

public class BaseDao<T> implements IBaseDao<T> {

	//��ǰ������ʵ�ʵ�bean����
	private Class<T> clazz;
	
	private String className;
	
	//���䷺��
	public BaseDao(){
		//��ȡ��ǰ������ĸ���Ĳ���������
		Type type = this.getClass().getGenericSuperclass();
		//ת��Ϊ����������
		ParameterizedType pt = (ParameterizedType) type;
		//�õ�ʵ������
		Type types[] = pt.getActualTypeArguments();
		//��ȡʵ������
		clazz = (Class<T>) types[0];
		
		//������͵����ƣ���HQL��ѯ�����ʹ��
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

		/******��HQL����ɾ�������⣡*****/
		/*****ԭ����֪����hibernate4��"id=?"�ķ�ʽ����֧��*****/
		/*****�޸�Ϊ"id=:id"�����⼴�ɽ������*****/
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
