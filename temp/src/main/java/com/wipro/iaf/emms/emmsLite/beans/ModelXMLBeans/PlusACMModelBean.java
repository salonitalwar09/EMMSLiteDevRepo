package com.wipro.iaf.emms.emmsLite.beans.ModelXMLBeans;

import java.util.ArrayList;

public class PlusACMModelBean {
	String description;
	String installable;
	String itemSetID;
	String model;

	ArrayList<PlusACMBuildBean> plusACMBuildList;
	ArrayList<PlusACMBuildItemBean> plusACMBuildItemList;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstallable() {
		return installable;
	}

	public void setInstallable(String installable) {
		this.installable = installable;
	}

	public String getItemSetID() {
		return itemSetID;
	}

	public void setItemSetID(String itemSetID) {
		this.itemSetID = itemSetID;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public ArrayList<PlusACMBuildBean> getPlusACMBuildList() {
		return plusACMBuildList;
	}

	public void setPlusACMBuildList(ArrayList<PlusACMBuildBean> plusACMBuildList) {
		this.plusACMBuildList = plusACMBuildList;
	}

	public ArrayList<PlusACMBuildItemBean> getPlusACMBuildItemList() {
		return plusACMBuildItemList;
	}

	public void setPlusACMBuildItemList(
			ArrayList<PlusACMBuildItemBean> plusACMBuildItemList) {
		this.plusACMBuildItemList = plusACMBuildItemList;
	}

	@Override
	public String toString() {
		return "PlusACMModelBean [description=" + description
				+ ", installable=" + installable + ", itemSetID=" + itemSetID
				+ ", model=" + model + ", plusACMBuildList=" + plusACMBuildList
				+ ", plusACMBuildItemList=" + plusACMBuildItemList + "]";
	}

}
