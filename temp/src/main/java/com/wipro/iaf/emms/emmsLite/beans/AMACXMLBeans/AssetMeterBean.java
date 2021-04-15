package com.wipro.iaf.emms.emmsLite.beans.AMACXMLBeans;

import org.springframework.stereotype.Component;

@Component
public class AssetMeterBean {

	private String assetMeterId;
	private String avgCalcMethod;
	private String domainID;
	private String lastReading;
	private String lastReadingDate;
	private String linearAssetMeterId;
	private String meterName;
	private String newReading;
	private String newReadingDate;
	private String previousReading;
	private String previousReadingDate;
	private String readingType;
	private String remarks;
	private String rollover;
	private String sinceInstall;
	private String sinceLastInspect;
	private String sinceLastOverHaul;
	private String sinceLastRepair;
	
	public String getAssetMeterId() {
		return assetMeterId;
	}
	public void setAssetMeterId(String assetMeterId) {
		this.assetMeterId = assetMeterId;
	}
	public String getAvgCalcMethod() {
		return avgCalcMethod;
	}
	public void setAvgCalcMethod(String avgCalcMethod) {
		this.avgCalcMethod = avgCalcMethod;
	}
	public String getDomainID() {
		return domainID;
	}
	public void setDomainID(String domainID) {
		this.domainID = domainID;
	}
	public String getLastReading() {
		return lastReading;
	}
	public void setLastReading(String lastReading) {
		this.lastReading = lastReading;
	}
	public String getLastReadingDate() {
		return lastReadingDate;
	}
	public void setLastReadingDate(String lastReadingDate) {
		this.lastReadingDate = lastReadingDate;
	}
	public String getLinearAssetMeterId() {
		return linearAssetMeterId;
	}
	public void setLinearAssetMeterId(String linearAssetMeterId) {
		this.linearAssetMeterId = linearAssetMeterId;
	}
	public String getMeterName() {
		return meterName;
	}
	public void setMeterName(String meterName) {
		this.meterName = meterName;
	}
	public String getNewReading() {
		return newReading;
	}
	public void setNewReading(String newReading) {
		this.newReading = newReading;
	}
	public String getNewReadingDate() {
		return newReadingDate;
	}
	public void setNewReadingDate(String newReadingDate) {
		this.newReadingDate = newReadingDate;
	}
	public String getPreviousReading() {
		return previousReading;
	}
	public void setPreviousReading(String previousReading) {
		this.previousReading = previousReading;
	}
	public String getReadingType() {
		return readingType;
	}
	public void setReadingType(String readingType) {
		this.readingType = readingType;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getRollover() {
		return rollover;
	}
	public void setRollover(String rollover) {
		this.rollover = rollover;
	}
	public String getSinceInstall() {
		return sinceInstall;
	}
	public void setSinceInstall(String sinceInstall) {
		this.sinceInstall = sinceInstall;
	}
	public String getSinceLastInspect() {
		return sinceLastInspect;
	}
	public void setSinceLastInspect(String sinceLastInspect) {
		this.sinceLastInspect = sinceLastInspect;
	}
	public String getSinceLastOverHaul() {
		return sinceLastOverHaul;
	}
	public void setSinceLastOverHaul(String sinceLastOverHaul) {
		this.sinceLastOverHaul = sinceLastOverHaul;
	}
	public String getSinceLastRepair() {
		return sinceLastRepair;
	}
	public void setSinceLastRepair(String sinceLastRepair) {
		this.sinceLastRepair = sinceLastRepair;
	}
	public String getPreviousReadingDate() {
		return previousReadingDate;
	}
	public void setPreviousReadingDate(String previousReadingDate) {
		this.previousReadingDate = previousReadingDate;
	}
	@Override
	public String toString() {
		return "AssetMeterBean [assetMeterId=" + assetMeterId
				+ ", avgCalcMethod=" + avgCalcMethod + ", domainID=" + domainID
				+ ", lastReading=" + lastReading + ", lastReadingDate="
				+ lastReadingDate + ", linearAssetMeterId="
				+ linearAssetMeterId + ", meterName=" + meterName
				+ ", newReading=" + newReading + ", newReadingDate="
				+ newReadingDate + ", previousReading=" + previousReading
				+ ", previousReadingDate=" + previousReadingDate
				+ ", readingType=" + readingType + ", remarks=" + remarks
				+ ", rollover=" + rollover + ", sinceInstall=" + sinceInstall
				+ ", sinceLastInspect=" + sinceLastInspect
				+ ", sinceLastOverHaul=" + sinceLastOverHaul
				+ ", sinceLastRepair=" + sinceLastRepair + "]";
	}
	
}
