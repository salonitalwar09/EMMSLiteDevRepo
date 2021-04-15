package com.wipro.iaf.emms.emmsLite.beans.DomainXMLBeans;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class DomainXMLBean {
	private String assetNum;
	private String cMItem;
	private String description;
	private String dettLocation;
	private String dettLocationBase;
	private String iafDettFLBPostFGTDataStatus;
	private String iafDettInstallRemoveStatus;
	private String iafDettPlannedAssetStatus;
	private String iafDettSnagDetailsStatus;
	private String iafDettWODetailsStatus;
	private String iafDettArmdearmStatus;
	private String iafDettAssetMeterStatus;
	private String iafDettSortieStatus;
	private String iafEmmsHALTransID;
	private String iafValStatus;
	private String iafWOTLCStatus;
	private String inductionDate;
	private String location;
	private String model;
	private String recordId;
	private String returnDate;
	private String serialNum;
	private String signalOutDate;
	private String status;
	private String transferDate;
	private String variation;
	private ArrayList<MaxDomainBean> maxdomainbeans;
	@Override
	public String toString() {
		return "DomainXMLBean [assetNum=" + assetNum + ", cMItem=" + cMItem
				+ ", description=" + description + ", dettLocation="
				+ dettLocation + ", dettLocationBase=" + dettLocationBase
				+ ", iafDettFLBPostFGTDataStatus="
				+ iafDettFLBPostFGTDataStatus + ", iafDettInstallRemoveStatus="
				+ iafDettInstallRemoveStatus + ", iafDettPlannedAssetStatus="
				+ iafDettPlannedAssetStatus + ", iafDettSnagDetailsStatus="
				+ iafDettSnagDetailsStatus + ", iafDettWODetailsStatus="
				+ iafDettWODetailsStatus + ", iafDettArmdearmStatus="
				+ iafDettArmdearmStatus + ", iafDettAssetMeterStatus="
				+ iafDettAssetMeterStatus + ", iafDettSortieStatus="
				+ iafDettSortieStatus + ", iafEmmsHALTransID="
				+ iafEmmsHALTransID + ", iafValStatus=" + iafValStatus
				+ ", iafWOTLCStatus=" + iafWOTLCStatus + ", inductionDate="
				+ inductionDate + ", location=" + location + ", model=" + model
				+ ", recordId=" + recordId + ", returnDate=" + returnDate
				+ ", serialNum=" + serialNum + ", signalOutDate="
				+ signalOutDate + ", status=" + status + ", transferDate="
				+ transferDate + ", variation=" + variation
				+ ", maxdomainbeans=" + maxdomainbeans + "]";
	}
	public String getAssetNum() {
		return assetNum;
	}
	public void setAssetNum(String assetNum) {
		this.assetNum = assetNum;
	}
	public String getcMItem() {
		return cMItem;
	}
	public void setcMItem(String cMItem) {
		this.cMItem = cMItem;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDettLocation() {
		return dettLocation;
	}
	public void setDettLocation(String dettLocation) {
		this.dettLocation = dettLocation;
	}
	public String getDettLocationBase() {
		return dettLocationBase;
	}
	public void setDettLocationBase(String dettLocationBase) {
		this.dettLocationBase = dettLocationBase;
	}
	public String getIafDettFLBPostFGTDataStatus() {
		return iafDettFLBPostFGTDataStatus;
	}
	public void setIafDettFLBPostFGTDataStatus(String iafDettFLBPostFGTDataStatus) {
		this.iafDettFLBPostFGTDataStatus = iafDettFLBPostFGTDataStatus;
	}
	public String getIafDettInstallRemoveStatus() {
		return iafDettInstallRemoveStatus;
	}
	public void setIafDettInstallRemoveStatus(String iafDettInstallRemoveStatus) {
		this.iafDettInstallRemoveStatus = iafDettInstallRemoveStatus;
	}
	public String getIafDettPlannedAssetStatus() {
		return iafDettPlannedAssetStatus;
	}
	public void setIafDettPlannedAssetStatus(String iafDettPlannedAssetStatus) {
		this.iafDettPlannedAssetStatus = iafDettPlannedAssetStatus;
	}
	public String getIafDettSnagDetailsStatus() {
		return iafDettSnagDetailsStatus;
	}
	public void setIafDettSnagDetailsStatus(String iafDettSnagDetailsStatus) {
		this.iafDettSnagDetailsStatus = iafDettSnagDetailsStatus;
	}
	public String getIafDettWODetailsStatus() {
		return iafDettWODetailsStatus;
	}
	public void setIafDettWODetailsStatus(String iafDettWODetailsStatus) {
		this.iafDettWODetailsStatus = iafDettWODetailsStatus;
	}
	public String getIafDettArmdearmStatus() {
		return iafDettArmdearmStatus;
	}
	public void setIafDettArmdearmStatus(String iafDettArmdearmStatus) {
		this.iafDettArmdearmStatus = iafDettArmdearmStatus;
	}
	public String getIafDettAssetMeterStatus() {
		return iafDettAssetMeterStatus;
	}
	public void setIafDettAssetMeterStatus(String iafDettAssetMeterStatus) {
		this.iafDettAssetMeterStatus = iafDettAssetMeterStatus;
	}
	public String getIafDettSortieStatus() {
		return iafDettSortieStatus;
	}
	public void setIafDettSortieStatus(String iafDettSortieStatus) {
		this.iafDettSortieStatus = iafDettSortieStatus;
	}
	public String getIafEmmsHALTransID() {
		return iafEmmsHALTransID;
	}
	public void setIafEmmsHALTransID(String iafEmmsHALTransID) {
		this.iafEmmsHALTransID = iafEmmsHALTransID;
	}
	public String getIafValStatus() {
		return iafValStatus;
	}
	public void setIafValStatus(String iafValStatus) {
		this.iafValStatus = iafValStatus;
	}
	public String getIafWOTLCStatus() {
		return iafWOTLCStatus;
	}
	public void setIafWOTLCStatus(String iafWOTLCStatus) {
		this.iafWOTLCStatus = iafWOTLCStatus;
	}
	public String getInductionDate() {
		return inductionDate;
	}
	public void setInductionDate(String inductionDate) {
		this.inductionDate = inductionDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public String getSignalOutDate() {
		return signalOutDate;
	}
	public void setSignalOutDate(String signalOutDate) {
		this.signalOutDate = signalOutDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}
	public String getVariation() {
		return variation;
	}
	public void setVariation(String variation) {
		this.variation = variation;
	}
	public ArrayList<MaxDomainBean> getMaxdomainbeans() {
		return maxdomainbeans;
	}
	public void setMaxdomainbeans(ArrayList<MaxDomainBean> maxdomainbeans) {
		this.maxdomainbeans = maxdomainbeans;
	}
}
