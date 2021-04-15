package com.wipro.iaf.emms.emmsLite.beans.ModelXMLBeans;

public class ModelBean {
	String assetNum;
	String cmItem;
	String description;
	String dettLocation;
	String dettLocationBase;
	String iafDettFlbPostFGTDataStatus;
	String iafDettInstallRemoveStatus;
	String iafDettPlannedAssetStatus;
	String dettSnagDetailsStatus;
	String dettWODetailsStatus;
	String iafDettArmDearmStatus;
	String iafDettAssetmeterStatus;
	String iafDettSortieStatus;
	String iafEmmsHALTransID;
	String iafValStatus;
	String iafWOTLCStatus;
	String inductionDate;
	String location;
	String model;
	String recordID;
	String returnDate;
	String serialNum;
	String signalOutDate;
	String status;
	String transferDate;
	String variation;
	
	PlusACMModelBean plusACMModel;

	public String getAssetNum() {
		return assetNum;
	}

	public void setAssetNum(String assetNum) {
		this.assetNum = assetNum;
	}

	public String getCmItem() {
		return cmItem;
	}

	public void setCmItem(String cmItem) {
		this.cmItem = cmItem;
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

	public String getIafDettFlbPostFGTDataStatus() {
		return iafDettFlbPostFGTDataStatus;
	}

	public void setIafDettFlbPostFGTDataStatus(String iafDettFlbPostFGTDataStatus) {
		this.iafDettFlbPostFGTDataStatus = iafDettFlbPostFGTDataStatus;
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

	public String getDettSnagDetailsStatus() {
		return dettSnagDetailsStatus;
	}

	public void setDettSnagDetailsStatus(String dettSnagDetailsStatus) {
		this.dettSnagDetailsStatus = dettSnagDetailsStatus;
	}

	public String getDettWODetailsStatus() {
		return dettWODetailsStatus;
	}

	public void setDettWODetailsStatus(String dettWODetailsStatus) {
		this.dettWODetailsStatus = dettWODetailsStatus;
	}

	public String getIafDettArmDearmStatus() {
		return iafDettArmDearmStatus;
	}

	public void setIafDettArmDearmStatus(String iafDettArmDearmStatus) {
		this.iafDettArmDearmStatus = iafDettArmDearmStatus;
	}

	public String getIafDettAssetmeterStatus() {
		return iafDettAssetmeterStatus;
	}

	public void setIafDettAssetmeterStatus(String iafDettAssetmeterStatus) {
		this.iafDettAssetmeterStatus = iafDettAssetmeterStatus;
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

	public String getRecordID() {
		return recordID;
	}

	public void setRecordID(String recordID) {
		this.recordID = recordID;
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

	public PlusACMModelBean getPlusACMModel() {
		return plusACMModel;
	}

	public void setPlusACMModel(PlusACMModelBean plusACMModel) {
		this.plusACMModel = plusACMModel;
	}

	@Override
	public String toString() {
		return "ModelBean [assetNum=" + assetNum + ", cmItem=" + cmItem
				+ ", description=" + description + ", dettLocation="
				+ dettLocation + ", dettLocationBase=" + dettLocationBase
				+ ", iafDettFlbPostFGTDataStatus="
				+ iafDettFlbPostFGTDataStatus + ", iafDettInstallRemoveStatus="
				+ iafDettInstallRemoveStatus + ", iafDettPlannedAssetStatus="
				+ iafDettPlannedAssetStatus + ", dettSnagDetailsStatus="
				+ dettSnagDetailsStatus + ", dettWODetailsStatus="
				+ dettWODetailsStatus + ", iafDettArmDearmStatus="
				+ iafDettArmDearmStatus + ", iafDettAssetmeterStatus="
				+ iafDettAssetmeterStatus + ", iafDettSortieStatus="
				+ iafDettSortieStatus + ", iafEmmsHALTransID="
				+ iafEmmsHALTransID + ", iafValStatus=" + iafValStatus
				+ ", iafWOTLCStatus=" + iafWOTLCStatus + ", inductionDate="
				+ inductionDate + ", location=" + location + ", model=" + model
				+ ", recordID=" + recordID + ", returnDate=" + returnDate
				+ ", serialNum=" + serialNum + ", signalOutDate="
				+ signalOutDate + ", status=" + status + ", transferDate="
				+ transferDate + ", variation=" + variation + ", plusACMModel="
				+ plusACMModel + "]";
	}
	
	
}
