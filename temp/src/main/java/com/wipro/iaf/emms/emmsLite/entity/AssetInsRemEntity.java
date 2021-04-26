package com.wipro.iaf.emms.emmsLite.entity;

/**
 * @author Shivam
 * Date:: 19 April 2021
 * Description:: Entity for asset install remove functionality
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
//Change Schema to emms_lite for TND:: Shivam
@Table(name = "elite_ir_tb", schema= "elite") 
@Component
public class AssetInsRemEntity {

	@Id
	@Column(name="ir_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long insRemId;
	@Column(name="workorder_id")
	private Long workorderId;
	@Column(name="job_type")
	private String jobType;
	@Column(name="build_item")
	private String buildItem;
	@Column(name="lcn")
	private String lcn;
	@Column(name="position")
	private String position;
	@Column(name="part_no")
	private String partNo;
	@Column(name="item")
	private String item;
	@Column(name="removed_part_no")
	private String removePartNo;
	@Column(name="serial_no")
	private String serialNo;
	@Column(name="asset_num")
	private String assetNo;
	@Column(name="removed_by")
	private String removedBy;
	@Column(name="removal_date")
	private String removalDate;
	@Column(name="removal_reason")
	private String removalReason;
	@Column(name="removal_cond")
	private String removalCond;
	@Column(name="removal_type")
	private String removalType;
	@Column(name="remarks")
	private String remarks;
	// MORE COLUMNS RO BE ADDED FOR ASSET INSTALL PART:: Shivam
	public Long getInsRemId() {
		return insRemId;
	}
	public void setInsRemId(Long insRemId) {
		this.insRemId = insRemId;
	}
	public Long getWorkorderId() {
		return workorderId;
	}
	public void setWorkorderId(Long workorderId) {
		this.workorderId = workorderId;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getBuildItem() {
		return buildItem;
	}
	public void setBuildItem(String buildItem) {
		this.buildItem = buildItem;
	}
	public String getLcn() {
		return lcn;
	}
	public void setLcn(String lcn) {
		this.lcn = lcn;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getRemovePartNo() {
		return removePartNo;
	}
	public void setRemovePartNo(String removePartNo) {
		this.removePartNo = removePartNo;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getAssetNo() {
		return assetNo;
	}
	public void setAssetNo(String assetNo) {
		this.assetNo = assetNo;
	}
	public String getRemovedBy() {
		return removedBy;
	}
	public void setRemovedBy(String removedBy) {
		this.removedBy = removedBy;
	}
	public String getRemovalDate() {
		return removalDate;
	}
	public void setRemovalDate(String removalDate) {
		this.removalDate = removalDate;
	}
	public String getRemovalReason() {
		return removalReason;
	}
	public void setRemovalReason(String removalReason) {
		this.removalReason = removalReason;
	}
	public String getRemovalCond() {
		return removalCond;
	}
	public void setRemovalCond(String removalCond) {
		this.removalCond = removalCond;
	}
	public String getRemovalType() {
		return removalType;
	}
	public void setRemovalType(String removalType) {
		this.removalType = removalType;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "AssetInsRemEntity [insRemId=" + insRemId + ", workorderId="
				+ workorderId + ", jobType=" + jobType + ", buildItem="
				+ buildItem + ", lcn=" + lcn + ", position=" + position
				+ ", partNo=" + partNo + ", item=" + item + ", removePartNo="
				+ removePartNo + ", serialNo=" + serialNo + ", assetNo="
				+ assetNo + ", removedBy=" + removedBy + ", removalDate="
				+ removalDate + ", removalReason=" + removalReason
				+ ", removalCond=" + removalCond + ", removalType="
				+ removalType + ", remarks=" + remarks + "]";
	}
}
