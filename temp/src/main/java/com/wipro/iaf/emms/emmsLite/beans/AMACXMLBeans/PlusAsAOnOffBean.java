package com.wipro.iaf.emms.emmsLite.beans.AMACXMLBeans;

import org.springframework.stereotype.Component;

@Component
public class PlusAsAOnOffBean {

	private String assetID;
	private String hasChildren;
	private String hasParent;
	private String iafRemovalCondition;
	private String iafRemovalType;
	private String iafRemovedBy;
	private String iafRemPartNum;
	private String iafRemReasonNP;
	private String iafRemSerialNum;
	private String iafRemRemarks;
	private String installAsset;
	private String label;
	private String LCN;
	private String name;
	private String offTime;
	private String onTime;
	private String parentAssetId;
	private String parentAssetNum;
	private String part;
	private String plusAsAOnOffId;
	private String position;
	private String removeAsset;
	private String removeToLocation;
	private String serial;

	public String getAssetID() {
		return assetID;
	}

	public void setAssetID(String assetID) {
		this.assetID = assetID;
	}

	public String getHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(String hasChildren) {
		this.hasChildren = hasChildren;
	}

	public String getHasParent() {
		return hasParent;
	}

	public void setHasParent(String hasParent) {
		this.hasParent = hasParent;
	}

	public String getIafRemovalCondition() {
		return iafRemovalCondition;
	}

	public void setIafRemovalCondition(String iafRemovalCondition) {
		this.iafRemovalCondition = iafRemovalCondition;
	}

	public String getIafRemovalType() {
		return iafRemovalType;
	}

	public void setIafRemovalType(String iafRemovalType) {
		this.iafRemovalType = iafRemovalType;
	}

	public String getIafRemovedBy() {
		return iafRemovedBy;
	}

	public void setIafRemovedBy(String iafRemovedBy) {
		this.iafRemovedBy = iafRemovedBy;
	}

	public String getIafRemPartNum() {
		return iafRemPartNum;
	}

	public void setIafRemPartNum(String iafRemPartNum) {
		this.iafRemPartNum = iafRemPartNum;
	}

	public String getIafRemReasonNP() {
		return iafRemReasonNP;
	}

	public void setIafRemReasonNP(String iafRemReasonNP) {
		this.iafRemReasonNP = iafRemReasonNP;
	}

	public String getIafRemSerialNum() {
		return iafRemSerialNum;
	}

	public void setIafRemSerialNum(String iafRemSerialNum) {
		this.iafRemSerialNum = iafRemSerialNum;
	}

	public String getInstallAsset() {
		return installAsset;
	}

	public void setInstallAsset(String installAsset) {
		this.installAsset = installAsset;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLCN() {
		return LCN;
	}

	public void setLCN(String lCN) {
		LCN = lCN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOffTime() {
		return offTime;
	}

	public void setOffTime(String offTime) {
		this.offTime = offTime;
	}

	public String getOnTime() {
		return onTime;
	}

	public void setOnTime(String onTime) {
		this.onTime = onTime;
	}

	public String getParentAssetId() {
		return parentAssetId;
	}

	public void setParentAssetId(String parentAssetId) {
		this.parentAssetId = parentAssetId;
	}

	public String getParentAssetNum() {
		return parentAssetNum;
	}

	public void setParentAssetNum(String parentAssetNum) {
		this.parentAssetNum = parentAssetNum;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getPlusAsAOnOffId() {
		return plusAsAOnOffId;
	}

	public void setPlusAsAOnOffId(String plusAsAOnOffId) {
		this.plusAsAOnOffId = plusAsAOnOffId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRemoveAsset() {
		return removeAsset;
	}

	public void setRemoveAsset(String removeAsset) {
		this.removeAsset = removeAsset;
	}

	public String getRemoveToLocation() {
		return removeToLocation;
	}

	public void setRemoveToLocation(String removeToLocation) {
		this.removeToLocation = removeToLocation;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getIafRemRemarks() {
		return iafRemRemarks;
	}

	public void setIafRemRemarks(String iafRemRemarks) {
		this.iafRemRemarks = iafRemRemarks;
	}

	@Override
	public String toString() {
		return "PlusAsAOnOffBean [assetID=" + assetID + ", hasChildren="
				+ hasChildren + ", hasParent=" + hasParent
				+ ", iafRemovalCondition=" + iafRemovalCondition
				+ ", iafRemovalType=" + iafRemovalType + ", iafRemovedBy="
				+ iafRemovedBy + ", iafRemPartNum=" + iafRemPartNum
				+ ", iafRemReasonNP=" + iafRemReasonNP + ", iafRemSerialNum="
				+ iafRemSerialNum + ", iafRemRemarks=" + iafRemRemarks
				+ ", installAsset=" + installAsset + ", label=" + label
				+ ", LCN=" + LCN + ", name=" + name + ", offTime=" + offTime
				+ ", onTime=" + onTime + ", parentAssetId=" + parentAssetId
				+ ", parentAssetNum=" + parentAssetNum + ", part=" + part
				+ ", plusAsAOnOffId=" + plusAsAOnOffId + ", position="
				+ position + ", removeAsset=" + removeAsset
				+ ", removeToLocation=" + removeToLocation + ", serial="
				+ serial + "]";
	}

	
}
