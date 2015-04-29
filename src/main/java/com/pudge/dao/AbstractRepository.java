/**
 * AbstractRepository.java
 * ��Ȩ����(C) 2012 
 * ����:cuiran 2012-12-12 11:40:40
 */
package com.pudge.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;

import com.pudge.entity.Company;

/**
 * @author xie
 */
public interface AbstractRepository {

	/**
	 * <b>function:</b>��Ӷ���
	 * @author xie
	 */
	public void insert(Object entity);

	/**
	 * <b>function:</b>���ID���Ҷ���
	 * @author xie
	 */
	public Company findOne(String id, Class<?> entity);

	public List<Company> findByRegex(String regex);

	/**
	 * <b>function:</b>ɾ��ָ����ID����
	 * @author xie
	 */
	public void removeOne(String id, Class<?> entity);

	/**
	 * ͨ��ID�ҵ����޸� <b>function:</b>
	 * @author xie
	 */
	public void findAndModify(String id);

	public List<?> findAll(Class<?> entity);

	/**
	 * �޸�ʵ��
	 */
	public void updateEntity(Object entity);
	
	/**
	 * ������ѯ
	 * @param <T>
	 * @param criteria
	 * @param entity
	 * @return
	 */
	public <T> T findEntityByCriteria(Criteria criteria,Class<T> entity);
}
