package com.wipro.iaf.emms.emmsLite.utility;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.wipro.iaf.emms.emmsLite.beans.DomainXMLBeans.ALNDomainBean;
import com.wipro.iaf.emms.emmsLite.beans.DomainXMLBeans.DomainXMLBean;
import com.wipro.iaf.emms.emmsLite.beans.DomainXMLBeans.MaxDomainBean;
@Component
public class DomainXMLHandler extends DefaultHandler {
	@Autowired
	private MaxDomainBean maxDomainBean;
	@Autowired
	private DomainXMLBean domainxmlbean;
	@Autowired
	private ALNDomainBean alnDomainBean;
	boolean bMaxDomain = false;
	boolean bIAF_EMMSHALTRANS =false;
	//domain xml properties
	boolean bAssetNum = false;
	boolean bCmItem = false;
	boolean bDescription = false;
	boolean bDettLocation = false;
	boolean bDettLocationbase = false;
	boolean bIafEmmsHalTransID = false;
	boolean bInductionDate = false;
	boolean bLocation = false;
	boolean bModel = false;
	boolean bRecordId = false;
	boolean bSerialNumber = false;
	boolean bSignalOutDate = false;
	boolean bVariation = false;
	
	
	
	// Max Domain properties
	boolean bMDescription = false;
	boolean bMDomainID = false;
	boolean bMALNDomain = false;

	
	ArrayList<MaxDomainBean> maxDomainList = new ArrayList<MaxDomainBean>();
//	MaxDomainBean maxDomainBean = new MaxDomainBean();   
	ArrayList<ALNDomainBean> alnDomainList = new ArrayList<ALNDomainBean>();

	// ALN Domain properties
	boolean bALNDescription = false;
	boolean bALNOrgID = false;
	boolean bALNSiteID = false;
	boolean bALNValue = false;

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		if(bMaxDomain){
			/*if (bMALNDomain) {
				if (qName.equalsIgnoreCase("DESCRIPTION")) {
					bALNDescription = true;
				} else if (qName.equalsIgnoreCase("ORGID")) {
					bALNOrgID = true;
				} else if (qName.equalsIgnoreCase("SITEID")) {
					bALNSiteID = true;
				} else if (qName.equalsIgnoreCase("VALUE")) {
					bALNValue = true;
				}
			}*/

			 if (qName.equalsIgnoreCase("DESCRIPTION")) {
				 
				bMDescription = true;
			} else if (qName.equalsIgnoreCase("DOMAINID")) {
				bMDomainID = true;
			}	}

		 if (bMALNDomain) {
			 bMaxDomain = false;
			if (qName.equalsIgnoreCase("DESCRIPTION")) {
				bALNDescription = true;
			} else if (qName.equalsIgnoreCase("ORGID")) {
				bALNOrgID = true;
			} else if (qName.equalsIgnoreCase("SITEID")) {
				bALNSiteID = true;
			} else if (qName.equalsIgnoreCase("VALUE")) {
				bALNValue = true;
			}
		} else {
			  if (qName.equalsIgnoreCase("ALNDOMAIN")) {
				bMALNDomain = true;
			} else if (qName.equalsIgnoreCase("MAXDOMAIN")) {
				bMaxDomain = true;
			} else if (qName.equals("ASSETNUM")) {
				bAssetNum = true;
			} else if (qName.equals("CMITEM")) {
				bCmItem = true;
			} else if (qName.equals("DESCRIPTION")) {
				bDescription = true;
			}else if (qName.equals("DETTLOCATION")) {
				bDettLocation = true;
			}else if (qName.equals("DETTLOCATIONBASE")) {
				bDettLocationbase = true;
			}else if (qName.equals("IAF_EMMSHALTRANSID")) {
				bIafEmmsHalTransID = true;
			}else if (qName.equals("INDUCTIONDATE")) {
				bInductionDate = true;
			}else if (qName.equals("LOCATION")) {
				bLocation = true;
			}else if (qName.equals("MODEL")) {
				bModel = true;
			}else if (qName.equals("RECORDID")) {
				bRecordId = true;
			}else if (qName.equals("SERIALNUM")) {
				bSerialNumber = true;
			}else if (qName.equals("SIGNALOUTDATE")) {
				bSignalOutDate = true;
			}else if (qName.equals("VARIATION")) {
				bVariation = true;
			}else if (qName.equals("IAF_EMMSHALTRANS")) {
				bIAF_EMMSHALTRANS = true;
			}
			  
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		if(qName.equalsIgnoreCase("ALNDOMAIN")){
			alnDomainList.add(alnDomainBean);
			alnDomainBean = new ALNDomainBean();
			bMALNDomain = false;
			
		} else if(qName.equalsIgnoreCase("MAXDOMAIN")){
			maxDomainBean.setAlnDomains(alnDomainList);
			alnDomainList = new ArrayList<ALNDomainBean>();
			maxDomainList.add(maxDomainBean);
			maxDomainBean = new MaxDomainBean();
			bMaxDomain = false;
		} else if (qName.equals("ASSETNUM")) {
			bAssetNum = true;
		} else if (qName.equals("CMITEM")) {
			bCmItem = true;
			
		} else if (qName.equals("DESCRIPTION")) {
			bDescription = true;
		}else if (qName.equals("DETTLOCATION")) {
			bDettLocation = true;
		}else if (qName.equals("DETTLOCATIONBASE")) {
			bDettLocationbase = true;
		}else if (qName.equals("IAF_EMMSHALTRANSID")) {
			bIafEmmsHalTransID = true;
		}else if (qName.equals("INDUCTIONDATE")) {
			bInductionDate = true;
		}else if (qName.equals("LOCATION")) {
			bLocation = true;
		}else if (qName.equals("MODEL")) {
			bModel = true;
		}else if (qName.equals("RECORDID")) {
			bRecordId = true;
		}else if (qName.equals("SERIALNUM")) {
			bSerialNumber = true;
		}else if (qName.equals("SIGNALOUTDATE")) {
			bSignalOutDate = true;
		}else if (qName.equals("VARIATION")) {
			bVariation = true;
		}else if (qName.equals("IAF_EMMSHALTRANS")) {
			domainxmlbean.setMaxdomainbeans(maxDomainList);
			bIAF_EMMSHALTRANS = false;
		}

	}

	@Override
	public void characters(char ch[], int start, int length) {
		if (bMALNDomain) {
			if(bALNDescription){
				bALNDescription = false;

				alnDomainBean.setDescription(new String(ch, start, length));
			} else if (bALNOrgID) {
				bALNOrgID = false;
				alnDomainBean.setOrgID(new String(ch, start, length));
			} else if (bALNSiteID) {
				bALNSiteID = false;
				alnDomainBean.setSiteID(new String(ch, start, length));
			} else if (bALNValue) {
				bALNValue = false;
				alnDomainBean.setValue(new String(ch, start, length));
			}
		} else if(bMaxDomain) {
			if(bMDescription){
			
				bMDescription = false;
				maxDomainBean.setDescription(new String(ch, start, length));
				
			} else if(bMDomainID){
				bMDomainID = false;
				maxDomainBean.setDomainID(new String(ch, start, length));

			}
		} else {
			 if (bAssetNum) {
				bAssetNum = false;
				domainxmlbean.setAssetNum(new String(ch, start, length));
			} 
			 else if (bCmItem) {
				 bCmItem = false;
					domainxmlbean.setcMItem(new String(ch, start, length));
				}
			 /*else if (bAssetNum) {
					bAssetNum = false;
					domainxmlbean.setAssetNum(new String(ch, start, length));
				}
			 else if (bAssetNum) {
					bAssetNum = false;
					domainxmlbean.setAssetNum(new String(ch, start, length));
				}
			 else if (bAssetNum) {
					bAssetNum = false;
					domainxmlbean.setAssetNum(new String(ch, start, length));
				}
			 else if (bAssetNum) {
					bAssetNum = false;
					domainxmlbean.setAssetNum(new String(ch, start, length));
				}
			 else if (bAssetNum) {
					bAssetNum = false;
					domainxmlbean.setAssetNum(new String(ch, start, length));
				}
			 else if (bAssetNum) {
					bAssetNum = false;
					domainxmlbean.setAssetNum(new String(ch, start, length));
				}
			 else if (bAssetNum) {
					bAssetNum = false;
					domainxmlbean.setAssetNum(new String(ch, start, length));
				}
			 else if (bAssetNum) {
					bAssetNum = false;
					domainxmlbean.setAssetNum(new String(ch, start, length));
				}
			 else if (bAssetNum) {
					bAssetNum = false;
					domainxmlbean.setAssetNum(new String(ch, start, length));
				}
			 else if (bAssetNum) {
					bAssetNum = false;
					domainxmlbean.setAssetNum(new String(ch, start, length));
				}
			 else if (bAssetNum) {
					bAssetNum = false;
					domainxmlbean.setAssetNum(new String(ch, start, length));
				}*/
			 
			
		}
	}
}
