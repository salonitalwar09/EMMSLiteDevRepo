package com.wipro.iaf.emms.emmsLite.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the elite_failure_problem_tb database table.
 * 
 */
@Entity
@Table(name="elite_failure_problem_tb")
@NamedQuery(name="EliteFailureProblemTb.findAll", query="SELECT e FROM ProblemEntity e")
public class ProblemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="problem_code")
	private String problemCode;

	@Column(name="falilure_code")
	private String falilureCode;

	@Column(name="problem_desc")
	private String problemDesc;

	public ProblemEntity() {
	}

	public String getProblemCode() {
		return this.problemCode;
	}

	public void setProblemCode(String problemCode) {
		this.problemCode = problemCode;
	}

	public String getFalilureCode() {
		return this.falilureCode;
	}

	public void setFalilureCode(String falilureCode) {
		this.falilureCode = falilureCode;
	}

	public String getProblemDesc() {
		return this.problemDesc;
	}

	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}

}