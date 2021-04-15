package com.wipro.iaf.emms.emmsLite.beans;

import org.springframework.stereotype.Component;

@Component
public class WoMeterLookupResponse {

	private String assetId_assetLookup;
	private String buildItem;
	private String serialNum;
	private String assetDescription_assetLookup;
	private String partNumber_meterLookup;
	private String partDescription_meterLookup;
	private String assetNum_meterLookup;
	private String  statusString;
	private int statusCode;
	
	public String getAssetId_assetLookup() {
		return assetId_assetLookup;
	}
	public void setAssetId_assetLookup(String assetId_assetLookup) {
		this.assetId_assetLookup = assetId_assetLookup;
	}
	public String getBuildItem() {
		return buildItem;
	}
	public void setBuildItem(String buildItem) {
		this.buildItem = buildItem;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public String getAssetDescription_assetLookup() {
		return assetDescription_assetLookup;
	}
	public void setAssetDescription_assetLookup(String assetDescription_assetLookup) {
		this.assetDescription_assetLookup = assetDescription_assetLookup;
	}
	public String getPartNumber_meterLookup() {
		return partNumber_meterLookup;
	}
	public void setPartNumber_meterLookup(String partNumber_meterLookup) {
		this.partNumber_meterLookup = partNumber_meterLookup;
	}
	public String getPartDescription_meterLookup() {
		return partDescription_meterLookup;
	}
	public void setPartDescription_meterLookup(String partDescription_meterLookup) {
		this.partDescription_meterLookup = partDescription_meterLookup;
	}
	public String getAssetNum_meterLookup() {
		return assetNum_meterLookup;
	}
	public void setAssetNum_meterLookup(String assetNum_meterLookup) {
		this.assetNum_meterLookup = assetNum_meterLookup;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusString() {
		return statusString;
	}
	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}
	@Override
	public String toString() {
		return "WoMeterLookupResponse [assetId_assetLookup="
				+ assetId_assetLookup + ", buildItem=" + buildItem
				+ ", serialNum=" + serialNum
				+ ", assetDescription_assetLookup="
				+ assetDescription_assetLookup + ", partNumber_meterLookup="
				+ partNumber_meterLookup + ", partDescription_meterLookup="
				+ partDescription_meterLookup + ", assetNum_meterLookup="
				+ assetNum_meterLookup + "]";
	}
	public WoMeterLookupResponse() {
	}

	
}
