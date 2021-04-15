package com.wipro.iaf.emms.emmsLite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "wostatus", schema= "emms_lite")
@Component
public class WoStatusEntity {

	@Id
	private String wostatusid;
	public String getWostatusid() {
		return wostatusid;
	}
	public void setWostatusid(String wostatusid) {
		this.wostatusid = wostatusid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getWonum() {
		return wonum;
	}
	public void setWonum(String wonum) {
		this.wonum = wonum;
	}
	public String getChangeby() {
		return changeby;
	}
	public void setChangeby(String changeby) {
		this.changeby = changeby;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	@Column
	private String status;
	private String wonum;
	private String changeby;
	private String parent;
	
}
