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
 * Created on 01/04/2021
 * Description - This class is the entity for the Work Order Arming/De-arming Screen. 
 */

@Entity
@Table(name = "elite_wo_armdearm_tb", schema= "emms_lite")
public class WorkOrderArmDearmEntity {
	@Id
	@Column (name="armid_pk",nullable=false)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer arm_id;
	@Column (name="workorder_id",nullable=true)
	private String workorderId;
	@Column (name="build_item",nullable=true)
	private String buildItem;
	@Column (name="station_no",nullable=true)
	private String stationNo;
	@Column (name="arm_position",nullable=true)
	private String armPosition;
	@Column (name="arm_gigno",nullable=true)
	private String armGIGNo;
	@Column (name="arm_description",nullable=true)
	private String armDescription;
	@Column (name="part_no",nullable=true)
	private String partNo;
	@Column (name="serial_no",nullable=true)
	private String serialNo;
	@Column (name="lot_no",nullable=true)
	private String lotNo;
	@Column (name="current_quant",nullable=true)
	private Integer currentQuant;
	@Column (name="load_quant",nullable=true)
	private Integer loadQuant;
	@Column (name="unload_quant",nullable=true)
	private Integer unloadQuant;
	@Column (name="evaluated_quant",nullable=true)
	private Integer evaluatedQuant;
	@Column (name="remarks",nullable=true)
	private String armRemarks;
	@Column (name="arm_status",nullable=true)
	private String armStatus;
	
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
	public String getArmDescription() {
		return armDescription;
	}
	public void setArmDescription(String armDescription) {
		this.armDescription = armDescription;
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
	public Integer getLoadQuant() {
		return loadQuant;
	}
	public void setLoadQuant(Integer loadQuant) {
		this.loadQuant = loadQuant;
	}
	public Integer getUnloadQuant() {
		return unloadQuant;
	}
	public void setUnloadQuant(Integer unloadQuant) {
		this.unloadQuant = unloadQuant;
	}
	public Integer getEvaluatedQuant() {
		return evaluatedQuant;
	}
	public void setEvaluatedQuant(Integer evaluatedQuant) {
		this.evaluatedQuant = evaluatedQuant;
	}
	public String getArmRemarks() {
		return armRemarks;
	}
	public void setArmRemarks(String armRemarks) {
		this.armRemarks = armRemarks;
	}
	public String getArmStatus() {
		return armStatus;
	}
	public void setArmStatus(String armStatus) {
		this.armStatus = armStatus;
	}
	public Integer getArm_id() {
		return arm_id;
	}
	public void setArm_id(Integer arm_id) {
		this.arm_id = arm_id;
	}
	public String getWorkorderId() {
		return workorderId;
	}
	public void setWorkorderId(String workorderId) {
		this.workorderId = workorderId;
	}	
}
