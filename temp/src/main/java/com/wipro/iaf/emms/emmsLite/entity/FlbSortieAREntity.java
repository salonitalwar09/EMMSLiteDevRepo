package com.wipro.iaf.emms.emmsLite.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.wipro.iaf.emms.emmsLite.beans.Views;

/**
 * @author Lalit Singh Bisht
 */

@Entity
@Table(name = "elite_flb_sortie_accept_reject_tb")
public class FlbSortieAREntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, updatable = false)
	@JsonView(Views.SortieNumViews.class)
	private Long sortieId;
	@JsonView(Views.SortieNumViews.class)
	@Column(unique = true)
	private String sortieNum;
	private String recordId;
	private String reason;
	private String remarks;
	private String fltType;
	@Column(nullable = false, columnDefinition = "varchar(20) default 'PENDING'")
	private String status = "PENDING";
	private Long duration;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date sortieDate;
	@JsonFormat(pattern = "HH:mm")
	private Date etd;
	private Date etdDate;
	@Column(insertable = false)
	@UpdateTimestamp
	private Date statusDate;
	private String changedBy;

	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

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

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
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

	@Override
	public String toString() {
		return "FlbSortieAREntity [sortieId=" + sortieId + ", sortieNum=" + sortieNum + ", recordId=" + recordId
				+ ", reason=" + reason + ", remarks=" + remarks + ", fltType=" + fltType + ", status=" + status
				+ ", duration=" + duration + ", sortieDate=" + sortieDate + ", etd=" + etd + ", etdDate=" + etdDate
				+ ", statusDate=" + statusDate + ", changedBy=" + changedBy + "]";
	}
}