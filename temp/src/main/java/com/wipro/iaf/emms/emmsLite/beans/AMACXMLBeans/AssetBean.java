package com.wipro.iaf.emms.emmsLite.beans.AMACXMLBeans;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class AssetBean {

	private String ancestor;
	private String assetID;
	private String assetNum;
	private String children;
	private String conditionCode;
	private String iafParentLoc;
	private String iafCDCTS;
	private String iafDateOfManu;
	private String iafRDCLoc;
	private String itemNum;
	private String location;
	private String plusACAtID;
	private String plusTModel;
	private String plusTPos;
	private String serialNum;
	private String siteID;
	private String status;
	private String statusDate;
	
	private PlusAsAOnOffBean plusAsAOnOff;
	private AssetMeterBean assetMeter;
	//public ArrayList<AssetMeterBean> assetmeterbean = new ArrayList<AssetMeterBean>();

	public String getAncestor() {
		return ancestor;
	}

	public void setAncestor(String ancestor) {
		this.ancestor = ancestor;
	}

	public String getAssetID() {
		return assetID;
	}

	public void setAssetID(String assetID) {
		this.assetID = assetID;
	}

	public String getAssetNum() {
		return assetNum;
	}

	public void setAssetNum(String assetNum) {
		this.assetNum = assetNum;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getConditionCode() {
		return conditionCode;
	}

	public void setConditionCode(String conditionCode) {
		this.conditionCode = conditionCode;
	}

	public String getIafParentLoc() {
		return iafParentLoc;
	}

	public void setIafParentLoc(String iafParentLoc) {
		this.iafParentLoc = iafParentLoc;
	}

	public String getIafCDCTS() {
		return iafCDCTS;
	}

	public void setIafCDCTS(String iafCDCTS) {
		this.iafCDCTS = iafCDCTS;
	}

	public String getIafDateOfManu() {
		return iafDateOfManu;
	}

	public void setIafDateOfManu(String dateOfManu) {
		this.iafDateOfManu = dateOfManu;
	}

	public String getIafRDCLoc() {
		return iafRDCLoc;
	}

	public void setIafRDCLoc(String iafRDCLoc) {
		this.iafRDCLoc = iafRDCLoc;
	}

	public String getItemNum() {
		return itemNum;
	}

	public void setItemNum(String itemNum) {
		this.itemNum = itemNum;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPlusACAtID() {
		return plusACAtID;
	}

	public void setPlusACAtID(String plusACAtID) {
		this.plusACAtID = plusACAtID;
	}

	public String getPlusTModel() {
		return plusTModel;
	}

	public void setPlusTModel(String plusTModel) {
		this.plusTModel = plusTModel;
	}

	public String getPlusTPos() {
		return plusTPos;
	}

	public void setPlusTPos(String plusTPos) {
		this.plusTPos = plusTPos;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getSiteID() {
		return siteID;
	}

	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public PlusAsAOnOffBean getPlusAsAOnOff() {
		return plusAsAOnOff;
	}

	public void setPlusAsAOnOff(PlusAsAOnOffBean plusAsAOnOff) {
		this.plusAsAOnOff = plusAsAOnOff;
	}

	public AssetMeterBean getAssetMeter() {
		return assetMeter;
	}

	public void setAssetMeter(AssetMeterBean assetMeter) {
		this.assetMeter = assetMeter;
	}

	@Override
	public String toString() {
		return "AssetBean [ancestor=" + ancestor + ", assetID=" + assetID
				+ ", assetNum=" + assetNum + ", children=" + children
				+ ", conditionCode=" + conditionCode + ", iafParentLoc="
				+ iafParentLoc + ", iafCDCTS=" + iafCDCTS + ", iafDateOfManu="
				+ iafDateOfManu + ", iafRDCLoc=" + iafRDCLoc + ", itemNum="
				+ itemNum + ", location=" + location + ", plusACAtID="
				+ plusACAtID + ", plusTModel=" + plusTModel + ", plusTPos="
				+ plusTPos + ", serialNum=" + serialNum + ", siteID=" + siteID
				+ ", status=" + status + ", statusDate=" + statusDate
				+ ", plusAsAOnOff=" + plusAsAOnOff.toString() + ", assetMeter="
				+ assetMeter.toString() + "]";
	}

	


}
