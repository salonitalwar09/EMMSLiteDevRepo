package com.wipro.iaf.emms.emmsLite.beans.DomainXMLBeans;

import org.springframework.stereotype.Component;

@Component
public class ALNDomainBean {
	private String Description;
	private String orgID;
	private String value;
	private String SiteID;
	public String getSiteID() {
		return SiteID;
	}

	public void setSiteID(String siteID) {
		SiteID = siteID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getOrgID() {
		return orgID;
	}

	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ALNDomainBean [Description=" + Description + ", orgID=" + orgID
				+ ", value=" + value + ", SiteID=" + SiteID + "]";
	}

	

}
