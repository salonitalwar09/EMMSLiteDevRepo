package com.wipro.iaf.emms.emmsLite.beans;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Saloni Talwar
 * Changes done for EMMS Lite Project
 * Created on 06/04/2021
 * Description - This class is the Login response bean for the Arming/De-Arming Screen 
 * under Work Order.
 */

@Component
public class WorkOrderArmDearmResponseBean {
	
	private String workorderid;
	private String bulletItem;
	private String description;
	private String status;
	private int code;
	private String addArmStatus;
	private String loadArmStatus;
	private String deleteArmStatus;
	
	public String getWorkorderid() {
		return workorderid;
	}
	public void setWorkorderid(String workorderid) {
		this.workorderid = workorderid;
	}
	public String getBulletItem() {
		return bulletItem;
	}
	public void setBulletItem(String bulletItem) {
		this.bulletItem = bulletItem;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getAddArmStatus() {
		return addArmStatus;
	}
	public void setAddArmStatus(String addArmStatus) {
		this.addArmStatus = addArmStatus;
	}
	public String getLoadArmStatus() {
		return loadArmStatus;
	}
	public void setLoadArmStatus(String loadArmStatus) {
		this.loadArmStatus = loadArmStatus;
	}
	public String getDeleteArmStatus() {
		return deleteArmStatus;
	}
	public void setDeleteArmStatus(String deleteArmStatus) {
		this.deleteArmStatus = deleteArmStatus;
	}
	
	public void reset(){
		this.code=0;
		this.addArmStatus=null;
		this.loadArmStatus=null;
		this.deleteArmStatus=null;
	}
	
	@Override
	public String toString() {
		return "WO Arming De-Arming Response [code=" + code + ", status=" + status + "]";
	}
	public WorkOrderArmDearmResponseBean() {
	}
}
