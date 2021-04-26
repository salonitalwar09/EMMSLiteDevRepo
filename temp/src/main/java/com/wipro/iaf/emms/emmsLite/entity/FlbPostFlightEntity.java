package com.wipro.iaf.emms.emmsLite.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "elite_flb_post_flt_tb")
public class FlbPostFlightEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, updatable = false)
	Long postFltId;
	@JsonFormat(pattern = "dd-MMM-yy HH:mm:ss")
	Date fltDate;
	String fltType;
	String flbStatus;
	@Column(unique = true)
	String sortieNum;
	@JsonFormat(pattern = "HH:mm")
	Date departureTime;
	@JsonFormat(pattern = "HH:mm")
	Date arrivalTime;
	Double fltHours;
	String recordId;

	public Long getPostFltId() {
		return postFltId;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public void setPostFltId(Long postFltId) {
		this.postFltId = postFltId;
	}

	public Date getFltDate() {
		return fltDate;
	}

	public void setFltDate(Date fltDate) {
		this.fltDate = fltDate;
	}

	public String getFltType() {
		return fltType;
	}

	public void setFltType(String fltType) {
		this.fltType = fltType;
	}

	public String getFlbStatus() {
		return flbStatus;
	}

	public void setFlbStatus(String flbStatus) {
		this.flbStatus = flbStatus;
	}

	public String getSortieNum() {
		return sortieNum;
	}

	public void setSortieNum(String sortieNum) {
		this.sortieNum = sortieNum;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Double getFltHours() {
		return fltHours;
	}

	public void setFltHours(Double fltHours) {
		this.fltHours = fltHours;
	}
}