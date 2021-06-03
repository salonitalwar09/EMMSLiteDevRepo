package com.wipro.iaf.emms.emmsLite.entity;
/**
 * @author Shivam

 * Date:: 05 April 2021
 * Description::Entity to Generate and maintain running ID records across various modules
 *
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "elite_plusasaonoff_tb", schema= "elite")
@Component
public class PlusasaonoffInsRemEntity {
	
	@Id
	@Column(name="PLUSASAONOFFID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long plusasaonoffId ;
	@Column(name="LABEL")
	private String label;
	@Column(name="position")
	private String position;
	@Column(name="name")
	private String name;
	@Column(name="lcn")
	private String lcn;
	@Column(name="alc")
	private String alc;
	@Column(name="ontime")
	private String ontime;
	@Column(name="OFFTIME")
	private String offTime;
	@Column(name="assetid")
	private String assetId;
	@Column(name="parentassetid")
	private String parentAssetId;
	@Column(name="NONSERIALIZED")
	private String nonSerialized;
	@Column(name="ORGID")
	private String orgId;
	@Column(name="SITEID")
	private String siteId;
	@Column(name="type")
	private String type;
	/*@Column(name="NONTRACKED")
	private String nonTracked;
	@Column(name="ROWSTAMP")
	private String rowStamp;
	@Column(name="IAF_RDCLOCATION")
	private String iafRdcLocation;
	@Column(name="IAF_CDC_TS")
	private String iafCdcTs;
	@Column(name="IAF_ROLLBACK")
	private String iafRollBack;*/
	public Long getPlusasaonoffId() {
		return plusasaonoffId;
	}
	public void setPlusasaonoffId(Long plusasaonoffId) {
		this.plusasaonoffId = plusasaonoffId;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLcn() {
		return lcn;
	}
	public void setLcn(String lcn) {
		this.lcn = lcn;
	}
	public String getAlc() {
		return alc;
	}
	public void setAlc(String alc) {
		this.alc = alc;
	}
	public String getOntime() {
		return ontime;
	}
	public void setOntime(String ontime) {
		this.ontime = ontime;
	}
	public String getOffTime() {
		return offTime;
	}
	public void setOffTime(String offTime) {
		this.offTime = offTime;
	}
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public String getParentAssetId() {
		return parentAssetId;
	}
	public void setParentAssetId(String parentAssetId) {
		this.parentAssetId = parentAssetId;
	}
	public String getNonSerialized() {
		return nonSerialized;
	}
	public void setNonSerialized(String nonSerialized) {
		this.nonSerialized = nonSerialized;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/*public String getNonTracked() {
		return nonTracked;
	}
	public void setNonTracked(String nonTracked) {
		this.nonTracked = nonTracked;
	}
	public String getRowStamp() {
		return rowStamp;
	}
	public void setRowStamp(String rowStamp) {
		this.rowStamp = rowStamp;
	}
	public String getIafRdcLocation() {
		return iafRdcLocation;
	}
	public void setIafRdcLocation(String iafRdcLocation) {
		this.iafRdcLocation = iafRdcLocation;
	}
	public String getIafCdcTs() {
		return iafCdcTs;
	}
	public void setIafCdcTs(String iafCdcTs) {
		this.iafCdcTs = iafCdcTs;
	}
	public String getIafRollBack() {
		return iafRollBack;
	}
	public void setIafRollBack(String iafRollBack) {
		this.iafRollBack = iafRollBack;
	}*/
	@Override
	public String toString() {
		return "PlusasaonoffInsRemEntity [plusasaonoffId=" + plusasaonoffId
				+ ", label=" + label + ", position=" + position + ", name="
				+ name + ", lcn=" + lcn + ", alc=" + alc + ", ontime=" + ontime
				+ ", offTime=" + offTime + ", assetId=" + assetId
				+ ", parentAssetId=" + parentAssetId + ", nonSerialized="
				+ nonSerialized + ", orgId=" + orgId + ", siteId=" + siteId
				+ ", type=" + type + ", "
				/*		+ "nonTracked=" + nonTracked
				+ ", rowStamp=" + rowStamp + ", iafRdcLocation="
				+ iafRdcLocation + ", iafCdcTs=" + iafCdcTs + ", iafRollBack="
				+ iafRollBack +*/ 
				+"]";
	}

}
