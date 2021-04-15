package com.wipro.iaf.emms.emmsLite.beans;

import org.springframework.stereotype.Component;


@Component
public class XmlResponseBean {

	private String fileName;
	private String contentType;

	public XmlResponseBean(){}
	public XmlResponseBean(String fileName, String contentType) {
		super();
		this.fileName = fileName;
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}