package com.wipro.iaf.emms.emmsLite.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="elite_wo_meter_tb")
public class WoMeterEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="wo_meter_id")
	private Integer woMeterId;
	@Column(name="work_order_id")
	private Long workOrderId;
	@Column(name="asset_id")
	private Long assetId;
	@Column(name="description")
	private String description;
	@Column(name="part_Num")
	private String partNum;
	@Column(name="serial_Num")
	private String serialNum;
	@Column(name="build_Item")
	private String buildItem;
	@Column(name="asset_num")
	private String assetNum;
	@Column(name="meter_name")
	private String meterName; 
	@Column(name="initial_value")
	private String initialValue;
	@Column(name="final_value")
	private String finalValue;
	@Column(name="reading_date")
	private LocalDateTime readingDate;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="updated_date")
	private LocalDateTime updatedDate;
	@Transient
	private int statusCode;
	public Integer getWoMeterId() {
		return woMeterId;
	}
	public void setWoMeterId(Integer woMeterId) {
		this.woMeterId = woMeterId;
	}
	public Long getAssetId() {
		return assetId;
	}
	public void setAssetId(Long assetId) {
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
	public String getAssetNum() {
		return assetNum;
	}
	public void setAssetNum(String assetNum) {
		this.assetNum = assetNum;
	}
	public String getMeterName() {
		return meterName;
	}
	public void setMeterName(String meterName) {
		this.meterName = meterName;
	}
	public String getInitialValue() {
		return initialValue;
	}
	public void setInitialValue(String initialValue) {
		this.initialValue = initialValue;
	}
	public String getFinalValue() {
		return finalValue;
	}
	public void setFinalValue(String finalValue) {
		this.finalValue = finalValue;
	}
	public LocalDateTime getReadingDate() {
		return readingDate;
	}
	public void setReadingDate(LocalDateTime readingDate) {
		this.readingDate = readingDate;
	}
	public Long getWorkOrderId() {
		return workOrderId;
	}
	public void setWorkOrderId(Long workOrderId) {
		this.workOrderId = workOrderId;
	}	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "WoMeterEntity [woMeterId=" + woMeterId + ", workOrderId=" + workOrderId + ", assetId=" + assetId
				+ ", description=" + description + ", partNum=" + partNum + ", serialNum=" + serialNum + ", buildItem="
				+ buildItem + ", assetNum=" + assetNum + ", meterName=" + meterName + ", initialValue=" + initialValue
				+ ", finalValue=" + finalValue + ", readingDate=" + readingDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", statusCode=" + statusCode + "]";
	}
	public WoMeterEntity() {
	}
}
