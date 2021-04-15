package com.wipro.iaf.emms.emmsLite.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the elite_failure_class_tb database table.
 * 
 */
@Entity
@Table(name="elite_failure_class_tb")
@NamedQuery(name="EliteFailureClassTb.findAll", query="SELECT e FROM FailureClassEntity e")
public class FailureClassEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="failure_code")
	private String failureCode;

	@Column(name="failure_code_desc")
	private String failureCodeDesc;

	public FailureClassEntity() {
	}

	public String getFailureCode() {
		return this.failureCode;
	}

	public void setFailureCode(String failureCode) {
		this.failureCode = failureCode;
	}

	public String getFailureCodeDesc() {
		return this.failureCodeDesc;
	}

	public void setFailureCodeDesc(String failureCodeDesc) {
		this.failureCodeDesc = failureCodeDesc;
	}

}