package com.wipro.iaf.emms.emmsLite.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Lalit Singh Bisht
 */

@Entity
@Table(name = "elite_flb_sortie_accept_reject_tb")
public class FlbSortieAREntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, updatable = false)
	private Long sortieId;
	@Column(unique = true)
	private String sortieNum;
	private String recordId;
	private String reason;
	private String remarks;
	private String fltType;
	@Column(insertable=false)
	private String status;
	private Double duration;
	@JsonFormat(pattern = "dd-MMM-yy HH:mm:ss")
	private Date sortieDate;
	private Date etdDate;
	@JsonFormat(pattern = "HH:mm:ss")
	private Date etd;
	@Column(insertable = false)
	private Date statusDate;
	
	public Long getSortieId() {
		return sortieId;
	}
	public void setSortieId(Long sortieId) {
		this.sortieId = sortieId;
	}
	public String getSortieNum() {
		return sortieNum;
	}
	public void setSortieNum(String sortieNum) {
		this.sortieNum = sortieNum;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getFltType() {
		return fltType;
	}
	public void setFltType(String fltType) {
		this.fltType = fltType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public Date getSortieDate() {
		return sortieDate;
	}
	public void setSortieDate(Date sortieDate) {
		this.sortieDate = sortieDate;
	}
	public Date getEtdDate() {
		return etdDate;
	}
	public void setEtdDate(Date etdDate) {
		this.etdDate = etdDate;
	}
	public Date getEtd() {
		return etd;
	}
	public void setEtd(Date etd) {
		this.etd = etd;
	}
	public Date getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
}