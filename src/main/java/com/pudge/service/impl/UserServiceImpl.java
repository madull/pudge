package com.pudge.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pudge.dao.ClassDemoMapper;
import com.pudge.entity.ClassDemo;
import com.pudge.service.UserServiceI;

@Service("userService")
public class UserServiceImpl implements UserServiceI{
	
	@Autowired
	private ClassDemoMapper classDemoMapper;

	@Override
	public List<ClassDemo> getAll() {
		// TODO Auto-generated method stub
		return classDemoMapper.getAll();
	}

	@Override
	public void insertClass() {
		ClassDemo record =new ClassDemo();
		record.setId(21321);
		record.setName("王铜辉");
		record.setStarttime(new Date());
		classDemoMapper.insert(record);
		
	}


}
