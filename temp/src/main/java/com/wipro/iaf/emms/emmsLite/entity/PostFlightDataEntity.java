/**
 * PostFlightDataEntity is the Entity class to handle Post Flight Data Screen
 */

/**
 * @author Resham Das
 *
 */
package com.wipro.iaf.emms.emmsLite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table(name = "plusafltdata", schema= "emms_lite")
@Entity
@Component
public class PostFlightDataEntity {
	
	@Id
	private String plusafltdataid;
	@Column
	private String dateflt;
	@Column(name="iaf_sortieno",nullable=true)
	private String iafsortieno;
	@Column(name="iaf_flttype",nullable=true)
	private String iafflttype;
	private String departuretime;
	private String arrivaltime;
	private String flighthrs;
	private String status;
	
	public String getPlusafltdataid() {
		return plusafltdataid;
	}
	public void setPlusafltdataid(String plusafltdataid) {
		this.plusafltdataid = plusafltdataid;
	}
	public String getDateflt() {
		return dateflt;
	}
	public void setDateflt(String dateflt) {
		this.dateflt = dateflt;
	}
	public String getIafsortieno() {
		return iafsortieno;
	}
	public void setIafsortieno(String iafsortieno) {
		this.iafsortieno = iafsortieno;
	}
	public String getIafflttype() {
		return iafflttype;
	}
	public void setIafflttype(String iafflttype) {
		this.iafflttype = iafflttype;
	}
	public String getDeparturetime() {
		return departuretime;
	}
	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}
	public String getArrivaltime() {
		return arrivaltime;
	}
	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	public String getFlighthrs() {
		return flighthrs;
	}
	public void setFlighthrs(String flighthrs) {
		this.flighthrs = flighthrs;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "PostFlightDataEntity [plusafltdataid=" + plusafltdataid
				+ ", dateflt=" + dateflt + ", iaf_sortieno=" + iafsortieno
				+ ", iaf_flttype=" + iafflttype + ", departuretime="
				+ departuretime + ", arrivaltime=" + arrivaltime
				+ ", flighthrs=" + flighthrs + ", status=" + status + "]";
	}
}
