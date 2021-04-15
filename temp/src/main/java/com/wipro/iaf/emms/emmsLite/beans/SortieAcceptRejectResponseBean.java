package com.wipro.iaf.emms.emmsLite.beans;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Saloni Talwar
 * Changes done for EMMS Lite Project
 * Created on 24/03/2021
 * Description - This class is the bean for the Sortie Accept/Reject response 
 * under Flight Log Book (CM). 
 */

@Component
public class SortieAcceptRejectResponseBean {

	private int code;	
	private String sortieAcceptStatus;
	private String sortieRejectStatus;
	private String sortieNewStatus;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getSortieAcceptStatus() {
		return sortieAcceptStatus;
	}
	public void setSortieAcceptStatus(String sortieAcceptStatus) {
		this.sortieAcceptStatus = sortieAcceptStatus;
	}
	public String getSortieRejectStatus() {
		return sortieRejectStatus;
	}
	public void setSortieRejectStatus(String sortieRejectStatus) {
		this.sortieRejectStatus = sortieRejectStatus;
	}
	public String getSortieNewStatus() {
		return sortieNewStatus;
	}
	public void setSortieNewStatus(String sortieNewStatus) {
		this.sortieNewStatus = sortieNewStatus;
	}
	
	@Override
	public String toString() {
		return "Sortie Update Response [Code=" + code + ",SortieAcceptStatus=" + sortieAcceptStatus + ", SortieRejectStatus="+sortieRejectStatus+", SortieNewStatus"+sortieNewStatus+"]";
	}
	public SortieAcceptRejectResponseBean() {
	}
	
	public void reset(){
		this.code=0;
		this.sortieAcceptStatus=null;
		this.sortieRejectStatus=null;
		this.sortieNewStatus=null;
	}
}
