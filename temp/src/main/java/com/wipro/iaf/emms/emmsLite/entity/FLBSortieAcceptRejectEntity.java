package com.wipro.iaf.emms.emmsLite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Saloni Talwar
 * Changes done for EMMS Lite Project
 * Created on 24/03/2021
 * Description - This class is the entity for the Sortie Accept/Reject Screen 
 * under Flight Log Book (CM). 
 */

@Entity
@Table(name = "iaf_sortieacceptance", schema= "emms_lite")
@Component
public class FLBSortieAcceptRejectEntity {

	@Id 
	private String iaf_sortienum;
	@Column (name="sortiedate",nullable=true)
	private String sortieDate;
	@Column (name="iaf_etddate",nullable=true)
	private String iaf_etdDate;
	private String iaf_edt;
	private String iaf_duration;
	@Column (name="iaf_flttype",nullable=true)
	private String iaf_fltType;
	private String status;
	@Column (name="statusdate",nullable=true)
	private String statusDate;
	private String reason;
	boolean sortieAccept = false;
	boolean sortieReject = false;
	
	public boolean isSortieAccept() {
		return sortieAccept;
	}

	public void setSortieAccept(boolean sortieAccept) {
		this.sortieAccept = sortieAccept;
	}

	public boolean isSortieReject() {
		return sortieReject;
	}

	public void setSortieReject(boolean sortieReject) {
		this.sortieReject = sortieReject;
	}
	
	public String getIaf_sortienum() {
		return iaf_sortienum;
	}

	public void setIaf_sortienum(String iaf_sortienum) {
		this.iaf_sortienum = iaf_sortienum;
	}

	public String getSortieDate() {
		return sortieDate;
	}

	public void setSortieDate(String sortieDate) {
		this.sortieDate = sortieDate;
	}

	public String getIaf_etdDate() {
		return iaf_etdDate;
	}

	public void setIaf_etdDate(String iaf_etdDate) {
		this.iaf_etdDate = iaf_etdDate;
	}

	public String getIaf_edt() {
		return iaf_edt;
	}

	public void setIaf_edt(String iaf_edt) {
		this.iaf_edt = iaf_edt;
	}

	public String getIaf_duration() {
		return iaf_duration;
	}

	public void setIaf_duration(String iaf_duration) {
		this.iaf_duration = iaf_duration;
	}

	public String getIaf_fltType() {
		return iaf_fltType;
	}

	public void setIaf_fltType(String iaf_fltType) {
		this.iaf_fltType = iaf_fltType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Override	
	public String toString() {
		return "SortieAcceptRejectBean [SORTIE NUM = " + iaf_sortienum + ", REASON = " + getReason()
				+ ", STATUS DATE = " + getStatusDate() + ", STATUS = " + getStatus() + "]";
	}
}
