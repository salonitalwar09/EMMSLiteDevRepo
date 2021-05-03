package com.wipro.iaf.emms.emmsLite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author Shivam
 * Date:: 26 April 2021
 * Description:: Entity for ALNDOMAIN Table. This is a generic table entity and can be used across various moudles
 *
 */

@Entity
//Change Schema to emms_lite for TND:: Shivam
@Table(name = "elite_aln_domain_tb", schema= "elite") 
@Component

public class AlndomainEntity {

	@Id
	@Column(name="alndomain_id")
	private Long alndomainId;
	@Column(name="domain_id")
	private String domainId;
	@Column(name="value")
	private String value;
	@Column(name="desc")
	private String desc;
	@Column(name="site_id")
	private String siteId; 
	@Column(name="org_id")
	private String orgId;
	@Column(name="value_id")
	private String valueId;
	public Long getAlndomainId() {
		return alndomainId;
	}
	public void setAlndomainId(Long alndomainId) {
		this.alndomainId = alndomainId;
	}
	public String getDomainId() {
		return domainId;
	}
	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getValueId() {
		return valueId;
	}
	public void setValueId(String valueId) {
		this.valueId = valueId;
	}
	@Override
	public String toString() {
		return "AlndomainEntity [alndomainId=" + alndomainId + ", domainId="
				+ domainId + ", value=" + value + ", desc=" + desc
				+ ", siteId=" + siteId + ", orgId=" + orgId + ", valueId="
				+ valueId + "]";
	}


}
