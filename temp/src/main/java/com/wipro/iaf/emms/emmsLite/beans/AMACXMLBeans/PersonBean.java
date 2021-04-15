package com.wipro.iaf.emms.emmsLite.beans.AMACXMLBeans;

import org.springframework.stereotype.Component;

@Component
public class PersonBean {

	private String displayName;
	private String location;
	private String personID;
	private String personUID;
	private String status;
	private String statusDate;
	private String title;
	
	@Override
	public String toString() {
		return "PersonDAO [displayName=" + displayName + ", location="
				+ location + ", personID=" + personID + ", personUID="
				+ personUID + ", status=" + status + ", statusDate="
				+ statusDate + ", title=" + title + "]";
	}


	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public String getPersonUID() {
		return personUID;
	}

	public void setPersonUID(String personUID) {
		this.personUID = personUID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}