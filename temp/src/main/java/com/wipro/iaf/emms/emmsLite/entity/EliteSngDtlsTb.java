package com.wipro.iaf.emms.emmsLite.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the elite_sng_dtls_tb database table.
 * 
 */
@Entity
@Table(name="elite_sng_dtls_tb")
@NamedQuery(name="EliteSngDtlsTb.findAll", query="SELECT e FROM EliteSngDtlsTb e")
public class EliteSngDtlsTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="snag_id")
	private String snagId;

	@Column(name="ata_code")
	private String ataCode;

	private String cause;

	@Column(name="corrective_action")
	private String correctiveAction;

	private String description;

	@Column(name="det_id")
	private String detId;

	@Column(name="failure_class")
	private String failureClass;

	@Column(name="problem_code")
	private String problemCode;

	private String remedy;

	@Column(name="reported_by")
	private String reportedBy;

	@Column(name="reported_date")
	private String reportedDate;

	@Column(name="snag_category")
	private String snagCategory;

	@Column(name="snag_num")
	private String snagNum;

	@Column(name="snag_status")
	private String snagStatus;

	@Column(name="status_date")
	private String statusDate;

	private String summary;

	private String wdc;

	public EliteSngDtlsTb() {
	}

	public String getSnagId() {
		return this.snagId;
	}

	public void setSnagId(String snagId) {
		this.snagId = snagId;
	}

	public String getAtaCode() {
		return this.ataCode;
	}

	public void setAtaCode(String ataCode) {
		this.ataCode = ataCode;
	}

	public String getCause() {
		return this.cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getCorrectiveAction() {
		return this.correctiveAction;
	}

	public void setCorrectiveAction(String correctiveAction) {
		this.correctiveAction = correctiveAction;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetId() {
		return this.detId;
	}

	public void setDetId(String detId) {
		this.detId = detId;
	}

	public String getFailureClass() {
		return this.failureClass;
	}

	public void setFailureClass(String failureClass) {
		this.failureClass = failureClass;
	}

	public String getProblemCode() {
		return this.problemCode;
	}

	public void setProblemCode(String problemCode) {
		this.problemCode = problemCode;
	}

	public String getRemedy() {
		return this.remedy;
	}

	public void setRemedy(String remedy) {
		this.remedy = remedy;
	}

	public String getReportedBy() {
		return this.reportedBy;
	}

	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}

	public String getReportedDate() {
		return this.reportedDate;
	}

	public void setReportedDate(String reportedDate) {
		this.reportedDate = reportedDate;
	}

	public String getSnagCategory() {
		return this.snagCategory;
	}

	public void setSnagCategory(String snagCategory) {
		this.snagCategory = snagCategory;
	}

	public String getSnagNum() {
		return this.snagNum;
	}

	public void setSnagNum(String snagNum) {
		this.snagNum = snagNum;
	}

	public String getSnagStatus() {
		return this.snagStatus;
	}

	public void setSnagStatus(String snagStatus) {
		this.snagStatus = snagStatus;
	}

	public String getStatusDate() {
		return this.statusDate;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getWdc() {
		return this.wdc;
	}

	public void setWdc(String wdc) {
		this.wdc = wdc;
	}

}