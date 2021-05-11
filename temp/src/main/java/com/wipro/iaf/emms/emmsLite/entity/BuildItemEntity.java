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
@Table(name = "elite_build_item_tb", schema= "emms_lite")
public class BuildItemEntity {
	@Id
	@Column (name="BUILDITEMID",nullable=false)	
	private Integer builditemid;
	@Column (name="BUILD_TYPE",nullable=true)
	private String buildType;
	@Column (name="POSITION",nullable=true)
	private String position;
	public Integer getBuilditemid() {
		return builditemid;
	}
	public void setBuilditemid(Integer builditemid) {
		this.builditemid = builditemid;
	}
	public String getBuildType() {
		return buildType;
	}
	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}	
}