package com.wipro.iaf.emms.emmsLite.beans.ModelXMLBeans;

public class PlusACMConfigBean {
	String plusACMConfigID;
	String variation;

	public String getPlusACMConfigID() {
		return plusACMConfigID;
	}

	public void setPlusACMConfigID(String plusACMConfigID) {
		this.plusACMConfigID = plusACMConfigID;
	}

	public String getVariation() {
		return variation;
	}

	public void setVariation(String variation) {
		this.variation = variation;
	}

	@Override
	public String toString() {
		return "PlusACMConfigBean [plusACMConfigID=" + plusACMConfigID
				+ ", variation=" + variation + "]";
	}

}
