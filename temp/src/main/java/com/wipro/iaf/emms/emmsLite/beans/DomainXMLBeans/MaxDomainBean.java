package com.wipro.iaf.emms.emmsLite.beans.DomainXMLBeans;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
@Component
public class MaxDomainBean {
	
	private String description;
	private String domainID;
	
	private ArrayList<ALNDomainBean> alnDomains;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDomainID() {
		return domainID;
	}

	public void setDomainID(String domainID) {
		this.domainID = domainID;
	}

	public ArrayList<ALNDomainBean> getAlnDomains() {
		return alnDomains;
	}

	public void setAlnDomains(ArrayList<ALNDomainBean> alnDomains) {
		this.alnDomains = alnDomains;
	}

	@Override
	public String toString() {
		return "MaxDomainBean [description=" + description + ", domainID="
				+ domainID + ", alnDomains=" + alnDomains.toString() + "]";
	}
	
	

}
