package com.wipro.iaf.emms.emmsLite.entity;
import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;


/**
 * The persistent class for the elite_cause_remedy_tb database table.
 * 
 */
@Component
@Entity
@Table(name="elite_cause_remedy_tb")
@NamedQuery(name="RemedyEntity.findAll", query="SELECT r FROM RemedyEntity r")
public class RemedyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="remedy_code")
	private String remedyCode;

	@Column(name="cause_code")
	private String causeCode;

	@Column(name="remedy_desc")
	private String remedyDesc;

	public RemedyEntity() {
	}

	public String getRemedyCode() {
		return this.remedyCode;
	}

	public void setRemedyCode(String remedyCode) {
		this.remedyCode = remedyCode;
	}

	public String getCauseCode() {
		return this.causeCode;
	}

	public void setCauseCode(String causeCode) {
		this.causeCode = causeCode;
	}

	public String getRemedyDesc() {
		return this.remedyDesc;
	}

	public void setRemedyDesc(String remedyDesc) {
		this.remedyDesc = remedyDesc;
	}

}