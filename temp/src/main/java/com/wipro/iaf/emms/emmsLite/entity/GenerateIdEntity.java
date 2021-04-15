package com.wipro.iaf.emms.emmsLite.entity;

/**
 * @author Shivam
 * Date:: 05 April 2021
 * Description::Entity to Generate and maintain running ID records across various modules
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "elite_generate_id_tb", schema= "emms_lite")
@Component
	public class GenerateIdEntity {
	
	@Id
	@Column(name="property_name")
	private String propertyName;
	@Column
	private int key;
	private String prefix;
	
	
	
	
	@Override
	
	public String toString(){
		
		return "GenerateIdEntity [propertyName=" + propertyName + ", key=" + key
				+ ", prefix=" + prefix + "]";
	}




	public String getPropertyName() {
		return propertyName;
	}




	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}




	public int getKey() {
		return key;
	}




	public void setKey(int key) {
		this.key = key;
	}




	public String getPrefix() {
		return prefix;
	}




	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

}
