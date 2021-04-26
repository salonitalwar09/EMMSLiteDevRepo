package com.wipro.iaf.emms.emmsLite.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;


/**
 * The persistent class for the elite_person_tb database table.
 * 
 */
@Entity
@Table(name="elite_person_tb")
@NamedQuery(name="PersonEntity.findAll", query="SELECT p FROM PersonEntity p")
public class PersonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="person_id")
	private String personId;

	private String name;

	private String servicenum;

	public PersonEntity() {
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServicenum() {
		return this.servicenum;
	}

	public void setServicenum(String servicenum) {
		this.servicenum = servicenum;
	}

}