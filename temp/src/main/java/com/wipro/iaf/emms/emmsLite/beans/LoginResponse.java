package com.wipro.iaf.emms.emmsLite.beans;

import org.springframework.stereotype.Component;

@Component
public class LoginResponse {
	
	private int code;
	private String status;
	private String loginStatus;
	private String passwordStatus;

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getPasswordStatus() {
		return passwordStatus;
	}

	public void setPasswordStatus(String passwordStatus) {
		this.passwordStatus = passwordStatus;
	}

	public String getStatus() {
		return status;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void reset(){
		this.code=0;
		this.loginStatus=null;
		this.passwordStatus=null;
		this.status=null;
	}
	
	@Override
	public String toString() {
		return "LoginResponse [code=" + code + ", status=" + status + "]";
	}
	public LoginResponse() {
	}
	

}
