package com.wipro.iaf.emms.emmsLite.beans;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class WorkOrderResponseBean {

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getResponsestatus() {
		return responsestatus;
	}
	public void setResponsestatus(String responsestatus) {
		this.responsestatus = responsestatus;
	}
	
	
	@Id
	private String workorderid;
	@Column
	private String wonum;
	private String description;
	private String status;
	private String assetnum;
	private String pmnum;
	private String worktype;
	private int code;
	private String responsestatus;
	private Long insRemRowId;
	
	public Long getinsRemRowId() {
		return insRemRowId;
	}
	public void setinsRemRowId(Long insRemRowId) {
		this.insRemRowId = insRemRowId;
	}
	public String getWorkorderid() {
		return workorderid;
	}
	public void setWorkorderid(String workorderid) {
		this.workorderid = workorderid;
	}
	public String getWonum() {
		return wonum;
	}
	public void setWonum(String wonum) {
		this.wonum = wonum;
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
	public String getAssetnum() {
		return assetnum;
	}
	public void setAssetnum(String assetnum) {
		this.assetnum = assetnum;
	}
	public String getPmnum() {
		return pmnum;
	}
	public void setPmnum(String pmnum) {
		this.pmnum = pmnum;
	}
	public String getWorktype() {
		return worktype;
	}
	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}
	
	
}
