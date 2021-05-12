/**
 * TaskLevelComplianceEntity is the persistent class for the elite_wo_tlc_tb database table.
 */

package com.wipro.iaf.emms.emmsLite.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.sql.Timestamp;

/**
 * @author Resham Das
 *
 */


@Entity
@Table(name = "elite_wo_tlc_tb")
@NamedQuery(name = "TaskLevelComplianceEntity.findAll", query = "SELECT t FROM TaskLevelComplianceEntity t")
public class TaskLevelComplianceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tlc_id")
	private String tlcId;

	@Column(name = "compliance_dte")
	private Timestamp complianceDte;

	@Column(name = "task_desc")
	private String taskDesc;

	@Column(name = "technician_name")
	private String technicianName;

	@Column(name = "technician_servicenum")
	private String technicianServicenum;

	@Column(name = "workorder_id")
	private String workorderid;

	@Column(name = "task_no")
	private String taskNo;

	@Column(name = "create_dte")
	private Timestamp createDte;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "complied_by")
	private String compliedBy;

	public String getTaskNo() {
		return taskNo;
	}

	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}

	public Timestamp getCreateDte() {
		return createDte;
	}

	public void setCreateDte(Timestamp createDte) {
		this.createDte = createDte;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCompliedBy() {
		return compliedBy;
	}

	public void setCompliedBy(String compliedBy) {
		this.compliedBy = compliedBy;
	}

	public TaskLevelComplianceEntity() {
	}

	public String getTlcId() {
		return this.tlcId;
	}

	public void setTlcId(String tlcId) {
		this.tlcId = tlcId;
	}

	public Timestamp getComplianceDte() {
		return this.complianceDte;
	}

	public void setComplianceDte(Timestamp complianceDte) {
		this.complianceDte = complianceDte;
	}

	public String getTaskDesc() {
		return this.taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public String getTechnicianName() {
		return this.technicianName;
	}

	public void setTechnicianName(String technicianName) {
		this.technicianName = technicianName;
	}

	public String getTechnicianServicenum() {
		return this.technicianServicenum;
	}

	public void setTechnicianServicenum(String technicianServicenum) {
		this.technicianServicenum = technicianServicenum;
	}

	public String getWorkorderid() {
		return workorderid;
	}

	public void setWorkorderid(String workorderid) {
		this.workorderid = workorderid;
	}

	@Override
	public String toString() {
		return "TaskLevelComplianceEntity [tlcId=" + tlcId + ", complianceDte=" + complianceDte + ", taskDesc="
				+ taskDesc + ", technicianName=" + technicianName + ", technicianServicenum=" + technicianServicenum
				+ ", workorderid=" + workorderid + ", taskNo=" + taskNo + ", createDte=" + createDte + ", createdBy="
				+ createdBy + ", compliedBy=" + compliedBy + "]";
	}
}