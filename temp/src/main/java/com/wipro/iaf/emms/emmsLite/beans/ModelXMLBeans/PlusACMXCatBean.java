package com.wipro.iaf.emms.emmsLite.beans.ModelXMLBeans;

public class PlusACMXCatBean {
	String buildItemID;
	String isDefault;
	String item;
	String plusACMXCatID;

	PlusACACatBean plusACACat;

	public String getBuildItemID() {
		return buildItemID;
	}

	public void setBuildItemID(String buildItemID) {
		this.buildItemID = buildItemID;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getPlusACMXCatID() {
		return plusACMXCatID;
	}

	public void setPlusACMXCatID(String plusACMXCatID) {
		this.plusACMXCatID = plusACMXCatID;
	}

	public PlusACACatBean getPlusACACat() {
		return plusACACat;
	}

	public void setPlusACACat(PlusACACatBean plusACACat) {
		this.plusACACat = plusACACat;
	}

	@Override
	public String toString() {
		return "PlusACMXCat [buildItemID=" + buildItemID + ", isDefault="
				+ isDefault + ", item=" + item + ", plusACMXCatID="
				+ plusACMXCatID + ", plusACACat=" + plusACACat + "]";
	}

}
