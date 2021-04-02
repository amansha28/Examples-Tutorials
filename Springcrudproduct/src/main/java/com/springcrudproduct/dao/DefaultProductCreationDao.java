package com.springcrudproduct.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springcrudproduct.model.DefaultProductCreation;

@Repository
public class DefaultProductCreationDao {

	@Autowired
	private HibernateTemplate template;
	
	//Method to set the flag=true once the default entries are created in the Product Table of H2 DB.
	@Transactional
	public void setDefaultFlag(boolean value)
	{
		DefaultProductCreation defaultcreation = new DefaultProductCreation();
		defaultcreation.setCreated(value);
		template.saveOrUpdate(defaultcreation);
	}
	
	// To get the value of the flag from the DefaultProductCreation table.
	public boolean getIsCreated()
	{
		List<DefaultProductCreation> defaultValue = template.loadAll(DefaultProductCreation.class);
		System.out.println("Size of list :: "+defaultValue.size());
		if(defaultValue.size() >0)
			return defaultValue.get(defaultValue.size()-1).isCreated();
		else
			return defaultValue.get(0).isCreated();
	}
}
