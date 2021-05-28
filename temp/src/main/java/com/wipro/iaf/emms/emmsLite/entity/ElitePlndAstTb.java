package com.wipro.iaf.emms.emmsLite.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;


/**
 * The persistent class for the elite_plnd_ast_tb database table.
 * 
 */
@Component
@Entity
@Table(name="elite_plnd_ast_tb", schema= "emms_lite")
@NamedQuery(name="ElitePlndAstTb.findAll", query="SELECT e FROM ElitePlndAstTb e")
public class ElitePlndAstTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="asset_num")
	private String assetNum;

	@Column(name="cm_item")
	private String cmItem;

	@Column(name="curr_value")
	private String currValue;

	private String description;

	private String item;

	@Column(name="rem_value")
	private String remValue;

	@Column(name="serial_no")
	private String serialNo;

	public ElitePlndAstTb() {
	}

	public String getAssetNum() {
		return this.assetNum;
	}

	public void setAssetNum(String assetNum) {
		this.assetNum = assetNum;
	}

	public String getCmItem() {
		return this.cmItem;
	}

	public void setCmItem(String cmItem) {
		this.cmItem = cmItem;
	}

	public String getCurrValue() {
		return this.currValue;
	}

	public void setCurrValue(String currValue) {
		this.currValue = currValue;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getRemValue() {
		return this.remValue;
	}

	public void setRemValue(String remValue) {
		this.remValue = remValue;
	}

	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	@Override
	public String toString() {
		return "ElitePlndAstTb[assetNum = "+ assetNum+",cmItem="+cmItem+",currValue="+currValue
				
				+",description="+description+",item="+item+",remValue=+"+remValue+
				",serialNo="+serialNo+"]";
					
                  }
}