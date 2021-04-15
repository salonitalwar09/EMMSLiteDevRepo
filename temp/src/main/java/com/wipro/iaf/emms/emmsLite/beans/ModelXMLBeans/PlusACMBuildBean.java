package com.wipro.iaf.emms.emmsLite.beans.ModelXMLBeans;

import java.util.ArrayList;

public class PlusACMBuildBean {
	String buildItem;
	String buildItemID;
	String hasChildren;
	String hasParent;
	String indenture;
	String indicator;
	String label;
	String lcn;
	String modelID;
	String plusACMBuildID;
	String position;

	ArrayList<PlusACMConfigBean> plusACMConfigList;

	public String getBuildItem() {
		return buildItem;
	}

	public void setBuildItem(String buildItem) {
		this.buildItem = buildItem;
	}

	public String getBuildItemID() {
		return buildItemID;
	}

	public void setBuildItemID(String buildItemID) {
		this.buildItemID = buildItemID;
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

	public String getIndenture() {
		return indenture;
	}

	public void setIndenture(String indenture) {
		this.indenture = indenture;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLcn() {
		return lcn;
	}

	public void setLcn(String lcn) {
		this.lcn = lcn;
	}

	public String getModelID() {
		return modelID;
	}

	public void setModelID(String modelID) {
		this.modelID = modelID;
	}

	public String getPlusACMBuildID() {
		return plusACMBuildID;
	}

	public void setPlusACMBuildID(String plusACMBuildID) {
		this.plusACMBuildID = plusACMBuildID;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public ArrayList<PlusACMConfigBean> getPlusACMConfigList() {
		return plusACMConfigList;
	}

	public void setPlusACMConfigList(
			ArrayList<PlusACMConfigBean> plusACMConfigList) {
		this.plusACMConfigList = plusACMConfigList;
	}

	@Override
	public String toString() {
		return "PlusACMBuildBean [buildItem=" + buildItem + ", buildItemID="
				+ buildItemID + ", hasChildren=" + hasChildren + ", hasParent="
				+ hasParent + ", indenture=" + indenture + ", indicator="
				+ indicator + ", label=" + label + ", lcn=" + lcn
				+ ", modelID=" + modelID + ", plusACMBuildID=" + plusACMBuildID
				+ ", position=" + position + ", plusACMConfigList="
				+ plusACMConfigList + "]";
	}

}
