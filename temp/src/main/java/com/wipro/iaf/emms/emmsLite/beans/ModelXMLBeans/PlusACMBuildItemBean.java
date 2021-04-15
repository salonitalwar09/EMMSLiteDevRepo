package com.wipro.iaf.emms.emmsLite.beans.ModelXMLBeans;

import java.util.ArrayList;

public class PlusACMBuildItemBean {
	String modelID;
	String name;
	String plusACMBuiltItemID;

	ArrayList<PlusACMXCatBean> plusACMXCatBeanList;

	public String getModelID() {
		return modelID;
	}

	public void setModelID(String modelID) {
		this.modelID = modelID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlusACMBuiltItemID() {
		return plusACMBuiltItemID;
	}

	public void setPlusACMBuiltItemID(String plusACMBuiltItemID) {
		this.plusACMBuiltItemID = plusACMBuiltItemID;
	}

	public ArrayList<PlusACMXCatBean> getPlusACMXCatBeanList() {
		return plusACMXCatBeanList;
	}

	public void setPlusACMXCatBeanList(
			ArrayList<PlusACMXCatBean> plusACMXCatBeanList) {
		this.plusACMXCatBeanList = plusACMXCatBeanList;
	}

	@Override
	public String toString() {
		return "PlusACMBuildItemBean [modelID=" + modelID + ", name=" + name
				+ ", plusACMBuiltItemID=" + plusACMBuiltItemID
				+ ", plusACMXCatBeanList=" + plusACMXCatBeanList + "]";
	}
	
	
}
