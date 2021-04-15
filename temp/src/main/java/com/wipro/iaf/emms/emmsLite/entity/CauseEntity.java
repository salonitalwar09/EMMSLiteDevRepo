package com.wipro.iaf.emms.emmsLite.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the elite_problem_cause_tb database table.
 * 
 */
@Entity
@Table(name="elite_problem_cause_tb")
@NamedQuery(name="CauseEntity.findAll", query="SELECT c FROM CauseEntity c")
public class CauseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cause_code")
	private String causeCode;

	@Column(name="cause_desc")
	private String causeDesc;

	@Column(name="problem_code")
	private String problemCode;
	
	public CauseEntity() {
	}

	public String getCauseCode() {
		return this.causeCode;
	}

	public void setCauseCode(String causeCode) {
		this.causeCode = causeCode;
	}

	public String getCauseDesc() {
		return this.causeDesc;
	}

	public void setCauseDesc(String causeDesc) {
		this.causeDesc = causeDesc;
	}

	public String getProblemCode() {
		return this.problemCode;
	}

	public void setProblemCode(String problemCode) {
		this.problemCode = problemCode;
	}

}