package com.wipro.iaf.emms.emmsLite.beans;

import org.springframework.stereotype.Component;

@Component
public class ChangePasswordBean {
	private String userid;
	private String password;
	private String newPassword;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
