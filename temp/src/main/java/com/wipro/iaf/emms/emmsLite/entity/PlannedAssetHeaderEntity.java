package com.wipro.iaf.emms.emmsLite.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "elite_planned_asset_header_tb")
public class PlannedAssetHeaderEntity {
	@Id
	private Integer recordNum;
	private String arcrftNum;
	private String model;
	private String status;
	private Date trnsfrDate;
	private String arcrftLoc;
	private String variation;
	private Date returnDate;
	private String dettLoc;
	private String dettLocBase;
	
	public int getRecordNum() {
		return recordNum;
	}
	public void setRecordNum(int recordNum) {
		this.recordNum = recordNum;
	}
	public String getArcrftNum() {
		return arcrftNum;
	}
	public void setArcrftNum(String arcrftNum) {
		this.arcrftNum = arcrftNum;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTrnsfrDate() {
		return trnsfrDate;
	}
	public void setTrnsfrDate(Date trnsfrDate) {
		this.trnsfrDate = trnsfrDate;
	}
	public String getArcrftLoc() {
		return arcrftLoc;
	}
	public void setArcrftLoc(String arcrftLoc) {
		this.arcrftLoc = arcrftLoc;
	}
	public String getVariation() {
		return variation;
	}
	public void setVariation(String variation) {
		this.variation = variation;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public String getDettLoc() {
		return dettLoc;
	}
	public void setDettLoc(String dettLoc) {
		this.dettLoc = dettLoc;
	}
	public String getDettLocBase() {
		return dettLocBase;
	}
	public void setDettLocBase(String dettLocBase) {
		this.dettLocBase = dettLocBase;
	}
}
