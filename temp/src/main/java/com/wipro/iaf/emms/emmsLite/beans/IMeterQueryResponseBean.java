/**
 * 
 */
package com.wipro.iaf.emms.emmsLite.beans;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author RA20094813
 *
 */
public interface IMeterQueryResponseBean {

	public String getMeterName();
	
	public String getMeterType();

	public String getMeterDescription();

	@Value("#{200}")
	public int getCode();
}
