package com.wipro.iaf.emms.emmsLite.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="elite_wo_meter_tb")
public class WoMeterEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="wo_meter_id")
	private Integer woMeterId;
	@Column(name="asset_id")
	private Integer assetId;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="updated_date")
	private LocalDateTime updatedDate;
	@Column(name="description")
	private String description;
	@Column(name="part_Num")
	private String partNum;
	@Column(name="serial_Num")
	private String serialNum;
	@Column(name="build_Item")
	private String buildItem;
	@Column(name="asset_num")
	private Integer assetNum;
	@Column(name="meter_name")
	private String meterName; 
	@Column(name="initial_value")
	private double initialValue;
	@Column(name="final_value")
	private double finalValue;
	@Column(name="reading_date")
	private LocalDateTime readingDate;
	public Integer getWoMeterId() {
		return woMeterId;
	}
	public void setWoMeterId(Integer woMeterId) {
		this.woMeterId = woMeterId;
	}
	public Integer getAssetId() {
		return assetId;
	}
	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPartNum() {
		return partNum;
	}
	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public String getBuildItem() {
		return buildItem;
	}
	public void setBuildItem(String buildItem) {
		this.buildItem = buildItem;
	}
	public Integer getAssetNum() {
		return assetNum;
	}
	public void setAssetNum(Integer assetNum) {
		this.assetNum = assetNum;
	}
	public String getMeterName() {
		return meterName;
	}
	public void setMeterName(String meterName) {
		this.meterName = meterName;
	}
	public double getInitialValue() {
		return initialValue;
	}
	public void setInitialValue(double initialValue) {
		this.initialValue = initialValue;
	}
	public double getFinalValue() {
		return finalValue;
	}
	public void setFinalValue(double finalValue) {
		this.finalValue = finalValue;
	}
	public LocalDateTime getReadingDate() {
		return readingDate;
	}
	public void setReadingDate(LocalDateTime readingDate) {
		this.readingDate = readingDate;
	}
	@Override
	public String toString() {
		return "WoMeterEntity [woMeterId=" + woMeterId + ", assetId=" + assetId
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", description=" + description + ", partNum=" + partNum
				+ ", serialNum=" + serialNum + ", buildItem=" + buildItem
				+ ", assetNum=" + assetNum + ", meterName=" + meterName
				+ ", initialValue=" + initialValue + ", finalValue="
				+ finalValue + ", readingDate=" + readingDate + "]";
	}
	public WoMeterEntity() {
	}
	
	

}
