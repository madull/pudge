package com.pudge.dao;

import java.util.List;

import com.pudge.entity.ClassDemo;

public interface ClassDemoMapper extends SqlMapper{
	int deleteByPrimaryKey(Integer id);

	int insert(ClassDemo record);

	int insertSelective(ClassDemo record);

	ClassDemo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ClassDemo record);

	int updateByPrimaryKey(ClassDemo record);

	/**
	 * 查询所有信息
	 * 
	 * @return
	 */
	List<ClassDemo> getAll();
}