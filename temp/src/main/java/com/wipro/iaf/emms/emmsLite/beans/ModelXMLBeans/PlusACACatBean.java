package com.wipro.iaf.emms.emmsLite.beans.ModelXMLBeans;

public class PlusACACatBean {
	String description;
	String item;
	String itemID;
	String itemNum;
	String plusACACatID;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getItemNum() {
		return itemNum;
	}

	public void setItemNum(String itemNum) {
		this.itemNum = itemNum;
	}

	public String getPlusACACatID() {
		return plusACACatID;
	}

	public void setPlusACACatID(String plusACACatID) {
		this.plusACACatID = plusACACatID;
	}

	@Override
	public String toString() {
		return "PlusACACat [description=" + description + ", item=" + item
				+ ", itemID=" + itemID + ", itemNum=" + itemNum
				+ ", plusACACatID=" + plusACACatID + "]";
	}

}
