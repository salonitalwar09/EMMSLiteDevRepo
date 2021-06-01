package com.wipro.iaf.emms.emmsLite.entity;

/**
 * 
 * @author Saloni Talwar
 * Changes done for EMMS Lite Project
 * Created on 11/05/2021
 * Description - This class is the entity for the Work Order Arming/De-arming Screen. 
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "elite_item_tb", schema= "emms_lite")
public class ArmGIGEntity {
	@Id
	@Column (name="ARM_GIGNO",nullable=false)	
	private Integer armGigNo;
	@Column (name="ARM_DESCRIPTION",nullable=true)
	private String armDesc;
	public Integer getArmGigNo() {
		return armGigNo;
	}
	public void setArmGigNo(Integer armGigNo) {
		this.armGigNo = armGigNo;
	}
	public String getArmDesc() {
		return armDesc;
	}
	public void setArmDesc(String armDesc) {
		this.armDesc = armDesc;
	}
}
