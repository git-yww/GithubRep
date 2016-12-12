package com.yww.hr.dao;

import java.util.List;


/**
 * ����Dao��ͨ�ò����ӿ�
 * @author IVAN
 *
 */
public interface IBaseDao<T> {

	/**
	 * �������
	 * @param emp
	 */
	public void save(T emp);
	
	/**
	 * ����Ա����Ϣ
	 * @param emp
	 */
	public void update(T emp);
	
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
	public T findById(int id);
	
	/**
	 * ��ѯȫ��Ա��
	 * @return	ȫ��Ա��
	 */
	public List<T> getAll();
}
