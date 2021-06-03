package com.wipro.iaf.emms.emmsLite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "elite_pm_tb", schema= "elite")
@Component
public class PmEntity {

	@Id
	@Column(name = "pm_uid")
	private Long pmuId;
	@Column(name = "pm_num")
	private String pmNum;
	@Column(name = "pm_desc")
	private String pmDesc;
	@Column(name = "asset_num")
	private String assetNum;
	@Column(name = "parent")
	private String parent;
	@Column(name= "work_type")
	private String workType;

	

	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public Long getPmuId() {
		return pmuId;
	}
	public void setPmuId(Long pmuId) {
		this.pmuId = pmuId;
	}
	public String getPmNum() {
		return pmNum;
	}
	public void setPmNum(String pmNum) {
		this.pmNum = pmNum;
	}
	public String getPmDesc() {
		return pmDesc;
	}
	public void setPmDesc(String pmDesc) {
		this.pmDesc = pmDesc;
	}
	public String getAssetNum() {
		return assetNum;
	}
	public void setAssetNum(String assetNum) {
		this.assetNum = assetNum;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "PmEntity [pmuId=" + pmuId + ", pmNum=" + pmNum + ", pmDesc="
				+ pmDesc + ", assetNum=" + assetNum + ", parent=" + parent
				+ "]";
	}



}
