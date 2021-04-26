package com.wipro.iaf.emms.emmsLite.beans;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Lalit Singh Bisht
 */

@Component
public class CommonResponseBean {
	HttpStatus status;
	private String message;
	private String code;

	public CommonResponseBean() {
	}

	public CommonResponseBean(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
		this.code = status.toString();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
