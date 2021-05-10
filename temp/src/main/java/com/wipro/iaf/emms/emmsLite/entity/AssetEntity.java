package com.wipro.iaf.emms.emmsLite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "asset")
@Entity
public class AssetEntity {

	@Id
	@Column
	private String assetid;
	private String ancestor;
	private String assetnum;
	private String description;
	private String iafAllotinnum;
	private String iafReportMonth;
	private String iafReportYear;
	private String parent;
	private String siteid;
	private String status;
	private String cmitem;
	private String model;
	private String serialnum;
	private String variation;


	public String getAssetid() {
		return assetid;
	}

	public void setAssetid(String assetid) {
		this.assetid = assetid;
	}

	public String getAncestor() {
		return ancestor;
	}

	public void setAncestor(String ancestor) {
		this.ancestor = ancestor;
	}

	public String getAssetnum() {
		return assetnum;
	}

	public void setAssetnum(String assetnum) {
		this.assetnum = assetnum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIafAllotinnum() {
		return iafAllotinnum;
	}

	public void setIafAllotinnum(String iafAllotinnum) {
		this.iafAllotinnum = iafAllotinnum;
	}

	public String getIafReportMonth() {
		return iafReportMonth;
	}

	public void setIafReportMonth(String iafReportMonth) {
		this.iafReportMonth = iafReportMonth;
	}

	public String getIafReportYear() {
		return iafReportYear;
	}

	public void setIafReportYear(String iafReportYear) {
		this.iafReportYear = iafReportYear;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCmitem() {
		return cmitem;
	}

	public void setCmitem(String cmitem) {
		this.cmitem = cmitem;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialnum() {
		return serialnum;
	}

	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}

	public String getVariation() {
		return variation;
	}

	public void setVariation(String variation) {
		this.variation = variation;
	}

	@Override
	public String toString() {
		return "Asset [assetid=" + assetid + ", ancestor=" + ancestor
				+ ", assetnum=" + assetnum + ", description=" + description
				+ ", iafAllotinnum=" + iafAllotinnum + ", iafReportMonth="
				+ iafReportMonth + ", iafReportYear=" + iafReportYear
				+ ", parent=" + parent + ", siteid=" + siteid + ", status="
				+ status + ", cmitem=" + cmitem + ", model=" + model
				+ ", serialnum=" + serialnum + ", variation=" + variation + "]";
	}

	

}
