package com.pudge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.pudge.dao.AbstractRepository;
import com.pudge.entity.Company;
import com.pudge.service.ICompany;
@Service("companyService")
public class CompanyImpl implements ICompany {
    @Autowired
	private AbstractRepository dataManager;
	@Override
	public List<Company> findCompanys() {
		return (List<Company>) dataManager.findAll(Company.class);
	}

	@Override
	public Company findCompany(String id) {
		return dataManager.findOne(id,Company.class);
	}

	@Override
	public void updateCompany(Company entity) {
		 dataManager.updateEntity(entity);
	}

	@Override
	public void addCompany(Company entity) {
		dataManager.insert(entity);
	}

	@Override
	public void delCompany(String id) {
		dataManager.removeOne(id, Company.class);
	}
	@Override
	public Company searchCompanyByUrl(String ip){
		Company company=dataManager.findEntityByCriteria(Criteria.where("ip").ne(ip), Company.class);
		return company;
	}
   
	

}
