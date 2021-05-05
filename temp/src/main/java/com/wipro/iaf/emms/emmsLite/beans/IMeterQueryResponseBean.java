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

	 public String getBuildItem();
	 public String getSerialNum();
	 public String getAssetDescription();
	 public String getMeterpartNumber_meterLookup();
	 public String getDescription_Meter();
	 public String getPartNumber();
	 @Value("#{200}")
	 public int getCode();
}
