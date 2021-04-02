package com.springcrudproduct.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class DefaultProductCreation {
	
	// Simple table to avoid the insertion of multiple entries default entries in the Product Table.
	
	@Id
	@ColumnDefault("false")
	private boolean isCreated ;

	/**
	 * @return the isCreated
	 */
	public boolean isCreated() {
		return isCreated;
	}

	/**
	 * @param isCreated the isCreated to set
	 */
	public void setCreated(boolean isCreated) {
		this.isCreated = isCreated;
	}
	
	
	
}
