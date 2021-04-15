package com.wipro.iaf.emms.emmsLite.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the elite_header_tb database table.
 * 
 */
@Entity
@Table(name="elite_header_tb")
@NamedQuery(name="EliteHeaderTb.findAll", query="SELECT e FROM EliteHeaderTb e")
public class EliteHeaderTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="record_no")
	private int recordNo;

	@Column(name="arcrft_lctn")
	private String arcrftLctn;

	private String arcrft_No;

	@Column(name="dett_lctn")
	private String dettLctn;

	@Column(name="dett_lctn_bse")
	private String dettLctnBse;

	private String model;

	@Column(name="rturn_dte")
	private String rturnDte;

	private String status;

	@Column(name="trnsfr_dte")
	private String trnsfrDte;

	private String variation;

	//bi-directional many-to-one association to EliteSngDtlsTb
	@OneToMany(mappedBy="eliteHeaderTb")
	private List<EliteSngDtlsTb> eliteSngDtlsTbs;

	public EliteHeaderTb() {
	}

	public int getRecordNo() {
		return this.recordNo;
	}

	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}

	public String getArcrftLctn() {
		return this.arcrftLctn;
	}

	public void setArcrftLctn(String arcrftLctn) {
		this.arcrftLctn = arcrftLctn;
	}

	public String getArcrft_No() {
		return this.arcrft_No;
	}

	public void setArcrft_No(String arcrft_No) {
		this.arcrft_No = arcrft_No;
	}

	public String getDettLctn() {
		return this.dettLctn;
	}

	public void setDettLctn(String dettLctn) {
		this.dettLctn = dettLctn;
	}

	public String getDettLctnBse() {
		return this.dettLctnBse;
	}

	public void setDettLctnBse(String dettLctnBse) {
		this.dettLctnBse = dettLctnBse;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRturnDte() {
		return this.rturnDte;
	}

	public void setRturnDte(String rturnDte) {
		this.rturnDte = rturnDte;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTrnsfrDte() {
		return this.trnsfrDte;
	}

	public void setTrnsfrDte(String trnsfrDte) {
		this.trnsfrDte = trnsfrDte;
	}

	public String getVariation() {
		return this.variation;
	}

	public void setVariation(String variation) {
		this.variation = variation;
	}

	public List<EliteSngDtlsTb> getEliteSngDtlsTbs() {
		return this.eliteSngDtlsTbs;
	}

	public void setEliteSngDtlsTbs(List<EliteSngDtlsTb> eliteSngDtlsTbs) {
		this.eliteSngDtlsTbs = eliteSngDtlsTbs;
	}

	public EliteSngDtlsTb addEliteSngDtlsTb(EliteSngDtlsTb eliteSngDtlsTb) {
		getEliteSngDtlsTbs().add(eliteSngDtlsTb);
		eliteSngDtlsTb.setEliteHeaderTb(this);

		return eliteSngDtlsTb;
	}

	public EliteSngDtlsTb removeEliteSngDtlsTb(EliteSngDtlsTb eliteSngDtlsTb) {
		getEliteSngDtlsTbs().remove(eliteSngDtlsTb);
		eliteSngDtlsTb.setEliteHeaderTb(null);

		return eliteSngDtlsTb;
	}

}