package com.wipro.iaf.emms.emmsLite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Saloni Talwar
 * Changes done for EMMS Lite Project
 * Created on 26/05/2021
 * Description - This class is the entity for the Work Order Arming/De-arming Screen. 
 */

@Entity
@Table(name = "elite_armdearm_history_tb", schema= "emms_lite")
public class WOArmingHistoryEntity {
	@Id
	@Column (name="ARMINGASSET_ID",nullable=false)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer armingAssetId;
	@Column (name="ASSET_NUM",nullable=false)
	private String assetNum;
	@Column (name="Build_Item",nullable=true)
	private String buildItem;
	@Column (name="Station_No",nullable=true)
	private String stationNo;
	@Column (name="ARM_POSITION",nullable=true)
	private String armPosition;
	@Column (name="ARM_GIGNO",nullable=true)
	private String armGIGNo;
	@Column (name="PART_NO",nullable=true)
	private String partNo;
	@Column (name="SERIAL_NO",nullable=true)
	private String serialNo;
	@Column (name="LOT_NO",nullable=true)
	private String lotNo;
	@Column (name="CURRENT_QUANT",nullable=true)
	private Integer currentQuant;
	public Integer getArmingAssetId() {
		return armingAssetId;
	}
	public void setArmingAssetId(Integer armingAssetId) {
		this.armingAssetId = armingAssetId;
	}
	public String getAssetNum() {
		return assetNum;
	}
	public void setAssetNum(String assetNum) {
		this.assetNum = assetNum;
	}
	public String getBuildItem() {
		return buildItem;
	}
	public void setBuildItem(String buildItem) {
		this.buildItem = buildItem;
	}
	public String getStationNo() {
		return stationNo;
	}
	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}
	public String getArmPosition() {
		return armPosition;
	}
	public void setArmPosition(String armPosition) {
		this.armPosition = armPosition;
	}
	public String getArmGIGNo() {
		return armGIGNo;
	}
	public void setArmGIGNo(String armGIGNo) {
		this.armGIGNo = armGIGNo;
	}
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getLotNo() {
		return lotNo;
	}
	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}
	public Integer getCurrentQuant() {
		return currentQuant;
	}
	public void setCurrentQuant(Integer currentQuant) {
		this.currentQuant = currentQuant;
	}
}
