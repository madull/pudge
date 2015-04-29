/**
 * AbstractRepository.java
 * ��Ȩ����(C) 2012 
 * ����:cuiran 2012-12-12 11:40:40
 */
package com.pudge.service;

import java.util.List;

import com.pudge.entity.Company;

/**
 * TODO
 * @author xie
 * @version TODO
 */
public interface ICompany {
	
	/**
	 * ��ȡ���й�˾�б�
	 * @return
	 */
	public List<Company> findCompanys();
	
	/**
	 * ��ȡ��˾����
	 * @param id
	 * @return
	 */
	public Company findCompany(String id);
	
	/**
	 * ���¹�˾����
	 * @param entity
	 */
	public void updateCompany(Company entity);
	
	/**
	 * ��ӹ�˾��Ϣ
	 * @param entity
	 */
	public void addCompany(Company entity);
	
	/**
	 * ɾ��˾���id
	 * @param id
	 */
	public void delCompany(String id);
	
	/**
	 * ���url�жϸù�˾�Ƿ����
	 * @param url
	 * @return
	 */
	public Company searchCompanyByUrl(String ip);
}
