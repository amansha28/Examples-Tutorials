package com.springcrudproduct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcrudproduct.dao.DefaultProductCreationDao;

@Service
public class DefaultProductCreationServiceImpl implements DefaultProductCreationService{

	@Autowired
	private DefaultProductCreationDao defaultProductCreationDao;
	
	public void setDefaultFlag(boolean value) {
		defaultProductCreationDao.setDefaultFlag(value);
		
	}

	public boolean getIsCreated() {
		
		return defaultProductCreationDao.getIsCreated();
	}

}
