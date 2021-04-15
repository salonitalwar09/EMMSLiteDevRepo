package com.wipro.iaf.emms.emmsLite.utility;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.wipro.iaf.emms.emmsLite.beans.AMACXMLBeans.AssetBean;
import com.wipro.iaf.emms.emmsLite.beans.AMACXMLBeans.AssetMeterBean;
import com.wipro.iaf.emms.emmsLite.beans.AMACXMLBeans.PersonBean;
import com.wipro.iaf.emms.emmsLite.beans.AMACXMLBeans.PlusAsAOnOffBean;
@Component
public class AMACXMLHandler extends DefaultHandler {
	@Autowired
	 AssetBean assetBean;
	@Autowired
	AssetMeterBean assetMeterBean;
	@Autowired
	PlusAsAOnOffBean plusAsAOnOffBean;
	@Autowired
	PersonBean personBean;

	// Asset Meter properties
	boolean bAMAssetMeterId = false;
	boolean bAMAvgCalcMethod = false;
	boolean bAMDomainID = false;
	boolean bAMLastReading = false;
	boolean bAMLastReadingDate = false;
	boolean bAMLinearAssetMeterId = false;
	boolean bAMMeterName = false;
	boolean bAMNewReading = false;
	boolean bAMNewReadingDate = false;
	boolean bAMPreviousReading = false;
	boolean bAMPreviousReadingDate = false;
	boolean bAMReadingType = false;
	boolean bAMRemarks = false;
	boolean bAMRollover = false;
	boolean bAMSinceInstall = false;
	boolean bAMSinceLastInspect = false;
	boolean bAMSinceLastOverHaul = false;
	boolean bAMSinceLastRepair = false;

	//public AssetMeterBean assetMeterBean = new AssetMeterBean();

	
	// public PersonBean personEntry = new PersonBean();
	

	// Plus As A On Off properties
	boolean bPAssetID = false;
	boolean bPHasChildren = false;
	boolean bPHasParent = false;
	boolean bPIafRemovalCondition = false;
	boolean bPIafRemovalType = false;
	boolean bPIafRemovedBy = false;
	boolean bPIafRemPartNum = false;
	boolean bPIafRemReasonNP = false;
	boolean bPIafRemRemarks = false;
	boolean bPIafRemSerialNum = false;
	boolean bPInstallAsset = false;
	boolean bPLabel = false;
	boolean bPLCN = false;
	boolean bPName = false;
	boolean bPOffTime = false;
	boolean bPOnTime = false;
	boolean bPParentAssetId = false;
	boolean bPParentAssetNum = false;
	boolean bPPart = false;
	boolean bPPlusAsAOnOffId = false;
	boolean bPPosition = false;
	boolean bPRemoveAsset = false;
	boolean bPRemoveToLocation = false;
	boolean bPSerial = false;

	//private PlusAsAOnOffBean plusAsAOnOffBean = new PlusAsAOnOffBean();

	// Asset properties
	boolean bAncestor = false;
	boolean bAssetID = false;
	boolean bAssetNum = false;
	boolean bChildren = false;
	boolean bConditionCode = false;
	boolean bIafParentLoc = false;
	boolean bIafCDCTS = false;
	boolean bIafDateOfManu = false;
	boolean bIafRDCLoc = false;
	boolean bItemNum = false;
	boolean bLocation = false;
	boolean bPlusACAtID = false;
	boolean bPlusTModel = false;
	boolean bPlusTPos = false;
	boolean bSerialNum = false;
	boolean bSiteID = false;
	boolean bStatus = false;
	boolean bStatusDate = false;

	boolean bPlusAsAOnOff = false;
	boolean bAssetMeter = false;
	boolean bPerson = false;
	
	//People properties
	boolean bdisplayName =false;
	boolean blocation =false;
	boolean bpersonID =false;
	boolean bpersonUID =false;
	boolean bstatus =false;
	boolean bstatusDate =false;
	boolean btitle =false;


	//private AssetBean assetBean = new AssetBean();
	public ArrayList<AssetBean> assets = new ArrayList<AssetBean>();
	public ArrayList<PersonBean> persons = new ArrayList<PersonBean>();

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		if (bPlusAsAOnOff) {
			if (qName.equalsIgnoreCase("ASSETID")) {
				bPAssetID = true;
			} else if (qName.equalsIgnoreCase("HASCHILDREN")) {
				bPHasChildren = true;
			} else if (qName.equalsIgnoreCase("HASPARENT")) {
				bPHasParent = true;
			} else if (qName.equalsIgnoreCase("IAF_REMOVALCONDITION")) {
				bPIafRemovalCondition = true;
			} else if (qName.equalsIgnoreCase("IAF_REMOVALTYPE")) {
				bPIafRemovalType = true;
			} else if (qName.equalsIgnoreCase("IAF_REMOVED_BY")) {
				bPIafRemovedBy = true;
			} else if (qName.equalsIgnoreCase("IAF_REMPARTNUM")) {
				bPIafRemPartNum = true;
			} else if (qName.equalsIgnoreCase("IAF_REMREASON_NP")) {
				bPIafRemReasonNP = true;
			} else if (qName.equalsIgnoreCase("IAF_REMREMARKS")) {
				bPIafRemRemarks = true;
			} else if (qName.equalsIgnoreCase("IAF_REMSERIALNUM")) {
				bPIafRemSerialNum = true;
			} else if (qName.equalsIgnoreCase("INSTALLASSET")) {
				bPInstallAsset = true;
			} else if (qName.equalsIgnoreCase("LABEL")) {
				bPLabel = true;
			} else if (qName.equalsIgnoreCase("LCN")) {
				bPLCN = true;
			} else if (qName.equalsIgnoreCase("NAME")) {
				bPName = true;
			} else if (qName.equalsIgnoreCase("OFFTIME")) {
				bPOffTime = true;
			} else if (qName.equalsIgnoreCase("ONTIME")) {
				bPOnTime = true;
			} else if (qName.equalsIgnoreCase("PARENTASSETID")) {
				bPParentAssetId = true;
			} else if (qName.equalsIgnoreCase("PARENTASSETNUM")) {
				bPParentAssetNum = true;
			} else if (qName.equalsIgnoreCase("PART")) {
				bPPart = true;
			} else if (qName.equalsIgnoreCase("PLUSASAONOFFID")) {
				bPPlusAsAOnOffId = true;
			} else if (qName.equalsIgnoreCase("POSITION")) {
				bPPosition = true;
			} else if (qName.equalsIgnoreCase("REMOVEASSET")) {
				bPRemoveAsset = true;
			} else if (qName.equalsIgnoreCase("REMOVETOLOCATION")) {
				bPRemoveToLocation = true;
			} else if (qName.equalsIgnoreCase("SERIAL")) {
				bPSerial = true;
			}

		} else if (bAssetMeter) {
			if (qName.equalsIgnoreCase("ASSETMETERID")) {
				bAMAssetMeterId = true;
			} else if (qName.equalsIgnoreCase("AVGCALCMETHOD")) {
				bAMAvgCalcMethod = true;
			} else if (qName.equalsIgnoreCase("DOMAINID")) {
				bAMDomainID = true;
			} else if (qName.equalsIgnoreCase("LASTREADING")) {
				bAMLastReading = true;
			} else if (qName.equalsIgnoreCase("LASTREADINGDATE")) {
				bAMLastReadingDate = true;
			} else if (qName.equalsIgnoreCase("LINEARASSETMETERID")) {
				bAMLinearAssetMeterId = true;
			} else if (qName.equalsIgnoreCase("METERNAME")) {
				bAMMeterName = true;
			} else if (qName.equalsIgnoreCase("NEWREADING")) {
				bAMNewReading = true;
			} else if (qName.equalsIgnoreCase("NEWREADINGDATE")) {
				bAMNewReadingDate = true;
			} else if (qName.equalsIgnoreCase("PREVIOUSREADING")) {
				bAMPreviousReading = true;
			} else if (qName.equalsIgnoreCase("PREVIOUSREADINGDATE")) {
				bAMPreviousReadingDate = true;
			} else if (qName.equalsIgnoreCase("READINGTYPE")) {
				bAMReadingType = true;
			} else if (qName.equalsIgnoreCase("REMARKS")) {
				bAMRemarks = true;
			} else if (qName.equalsIgnoreCase("ROLLOVER")) {
				bAMRollover = true;
			} else if (qName.equalsIgnoreCase("SINCEINSTALL")) {
				bAMSinceInstall = true;
			} else if (qName.equalsIgnoreCase("SINCELASTINSPECT")) {
				bAMSinceLastInspect = true;
			} else if (qName.equalsIgnoreCase("SINCELASTOVERHAUL")) {
				bAMSinceLastOverHaul = true;
			} else if (qName.equalsIgnoreCase("SINCELASTREPAIR")) {
				bAMSinceLastRepair = true;
			}

		} else if(bPerson){
			if (qName.equalsIgnoreCase("displayName")) {
				bdisplayName = true;
			} else if (qName.equalsIgnoreCase("location")) {
				blocation = true;
			}
			else if (qName.equalsIgnoreCase("personID")) {
				bpersonID = true;
			}
			else if (qName.equalsIgnoreCase("personUID")) {
				bpersonUID = true;
			}
			else if (qName.equalsIgnoreCase("status")) {
				bstatus = true;
			}
			else if (qName.equalsIgnoreCase("statusDate")) {
				bstatusDate = true;
			}
			else if (qName.equalsIgnoreCase("title")) {
				btitle = true;
			}
		}
		
		else {
			if (qName.equalsIgnoreCase("PLUSASAONOFF")) {
				bPlusAsAOnOff = true;
			} else if (qName.equals("ASSETMETER")) {
				bAssetMeter = true;
			} else if (qName.equals("PERSON")) {
				bPerson = true;
			} else if (qName.equalsIgnoreCase("ANCESTOR")) {
				bAncestor = true;
			} else if (qName.equals("ASSETID")) {
				bAssetID = true;
			} else if (qName.equals("ASSETNUM")) {
				bAssetNum = true;
			} else if (qName.equals("CHILDREN")) {
				bChildren = true;
			} else if (qName.equals("CONDITIONCODE")) {
				bConditionCode = true;
			} else if (qName.equals("IAFPARENTLOC")) {
				bIafParentLoc = true;
			} else if (qName.equals("IAF_CDC_TS")) {
				bIafCDCTS = true;
			} else if (qName.equals("IAF_DATEOFMANU")) {
				bIafDateOfManu = true;
			} else if (qName.equals("IAF_RDCLOCATION")) {
				bIafRDCLoc = true;
			} else if (qName.equals("ITEMNUM")) {
				bItemNum = true;
			} else if (qName.equals("LOCATION")) {
				bLocation = true;
			} else if (qName.equals("PLUSACATID")) {
				bPlusACAtID = true;
			} else if (qName.equals("PLUSTMODEL")) {
				bPlusTModel = true;
			} else if (qName.equals("SERIALNUM")) {
				bSerialNum = true;
			} else if (qName.equals("SITEID")) {
				bSiteID = true;
			} else if (qName.equals("STATUS")) {
				bStatus = true;
			} else if (qName.equals("STATUSDATE")) {
				bStatusDate = true;
			} 
			
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equalsIgnoreCase("PLUSASAONOFF")) {
			System.out.println("End of plus a as on off");
			assetBean.setPlusAsAOnOff(plusAsAOnOffBean);
			plusAsAOnOffBean = new PlusAsAOnOffBean();
			bPlusAsAOnOff = false;
		} else if (qName.equalsIgnoreCase("ASSETMETER")) {
			System.out.println("End of Asset Meter");
			assetBean.setAssetMeter(assetMeterBean);
			assetMeterBean = new AssetMeterBean();
			bAssetMeter = false;
		} else if (qName.equalsIgnoreCase("ASSET")) {
			System.out.println("End element");
			assets.add(assetBean);
			assetBean = new AssetBean();
		} else if (qName.equalsIgnoreCase("PERSON")) {
			System.out.println("End element");
			persons.add(personBean);
			personBean = new PersonBean();
		}
	}

	@Override
	public void characters(char ch[], int start, int length) {

		if (bPlusAsAOnOff) {
			if (bPAssetID) {
				plusAsAOnOffBean.setAssetID(new String(ch, start, length));
				bPAssetID = false;
			} else if (bPHasChildren) {
				plusAsAOnOffBean.setHasChildren(new String(ch, start, length));
				bPHasChildren = false;
			} else if (bPHasParent) {
				plusAsAOnOffBean.setHasParent(new String(ch, start, length));
				bPHasParent = false;
			} else if (bPIafRemovalCondition) {
				plusAsAOnOffBean.setIafRemovalCondition(new String(ch, start,
						length));
				bPIafRemovalCondition = false;
			} else if (bPIafRemovalType) {
				plusAsAOnOffBean.setIafRemovalType(new String(ch, start, length));
				bPIafRemovalType = false;
			} else if (bPIafRemovedBy) {
				plusAsAOnOffBean.setIafRemovedBy(new String(ch, start, length));
				bPIafRemovedBy = false;
			} else if (bPIafRemPartNum) {
				plusAsAOnOffBean.setIafRemPartNum(new String(ch, start, length));
				bPIafRemPartNum = false;
			} else if (bPIafRemReasonNP) {
				plusAsAOnOffBean.setIafRemReasonNP(new String(ch, start, length));
				bPIafRemReasonNP = false;
			} else if (bPIafRemRemarks) {
				plusAsAOnOffBean.setIafRemRemarks(new String(ch, start, length));
				bPIafRemRemarks = false;
			} else if (bPIafRemSerialNum) {
				plusAsAOnOffBean.setIafRemSerialNum(new String(ch, start,length));
				bPIafRemSerialNum = false;
			} else if (bPInstallAsset) {
				plusAsAOnOffBean.setInstallAsset(new String(ch, start, length));
				bPInstallAsset = false;
			} else if (bPLabel) {
				plusAsAOnOffBean.setLabel(new String(ch, start, length));
				bPLabel = false;
			} else if (bPLCN) {
				plusAsAOnOffBean.setLCN(new String(ch, start, length));
				bPLCN = false;
			} else if (bPName) {
				plusAsAOnOffBean.setName(new String(ch, start, length));
				bPName = false;
			} else if (bPOffTime) {
				plusAsAOnOffBean.setOffTime(new String(ch, start, length));
				bPOffTime = false;
			} else if (bPOnTime) {
				plusAsAOnOffBean.setOnTime(new String(ch, start, length));
				bPOnTime = false;
			} else if (bPParentAssetId) {
				plusAsAOnOffBean.setParentAssetId(new String(ch, start, length));
				bPParentAssetId = false;
			} else if (bPParentAssetNum) {
				plusAsAOnOffBean.setParentAssetNum(new String(ch, start, length));
				bPParentAssetNum = false;
			} else if (bPPart) {
				plusAsAOnOffBean.setPart(new String(ch, start, length));
				bPPart = false;
			} else if (bPPlusAsAOnOffId) {
				plusAsAOnOffBean.setPlusAsAOnOffId(new String(ch, start, length));
				bPPlusAsAOnOffId = false;
			} else if (bPPosition) {
				plusAsAOnOffBean.setPosition(new String(ch, start, length));
				bPPosition = false;
			} else if (bPRemoveAsset) {
				plusAsAOnOffBean.setRemoveAsset(new String(ch, start, length));
				bPRemoveAsset = false;
			} else if (bPRemoveToLocation) {
				plusAsAOnOffBean.setRemoveToLocation(new String(ch, start,
						length));
				bPRemoveToLocation = false;
			} else if (bPSerial) {
				plusAsAOnOffBean.setSerial(new String(ch, start, length));
				bPSerial = false;
			}
		} else if (bAssetMeter) {
			if(bAMAssetMeterId){
				assetMeterBean.setAssetMeterId(new String(ch, start, length));
				bAMAssetMeterId = false;
			} else if(bAMAvgCalcMethod){
				assetMeterBean.setAvgCalcMethod(new String(ch, start, length));
				bAMAvgCalcMethod = false;
			} else if(bAMDomainID){
				assetMeterBean.setDomainID(new String(ch, start, length));
				bAMDomainID = false;
			} else if(bAMLastReading){
				assetMeterBean.setLastReading(new String(ch, start, length));
				bAMLastReading = false;
			} else if(bAMLastReadingDate){
				assetMeterBean.setLastReadingDate(new String(ch, start, length));
				bAMLastReadingDate = false;
			} else if(bAMLinearAssetMeterId){
				assetMeterBean.setLinearAssetMeterId(new String(ch, start, length));
				bAMLinearAssetMeterId = false;
			} else if(bAMMeterName){
				assetMeterBean.setMeterName(new String(ch, start, length));
				bAMMeterName = false;
			} else if(bAMNewReading){
				assetMeterBean.setNewReading(new String(ch, start, length));
				bAMNewReading = false;
			} else if(bAMNewReadingDate){
				assetMeterBean.setNewReadingDate(new String(ch, start, length));
				bAMNewReadingDate = false;
			} else if(bAMPreviousReading){
				assetMeterBean.setPreviousReading(new String(ch, start, length));
				bAMPreviousReading = false;
			} else if(bAMPreviousReadingDate){
				assetMeterBean.setPreviousReadingDate(new String(ch, start, length));
				bAMPreviousReadingDate = false;
			} else if(bAMReadingType){
				assetMeterBean.setReadingType(new String(ch, start, length));
				bAMReadingType = false;
			} else if(bAMRemarks){
				assetMeterBean.setRemarks(new String(ch, start, length));
				bAMRemarks = false;
			} else if(bAMRollover){
				assetMeterBean.setRollover(new String(ch, start, length));
				bAMRollover = false;
			} else if(bAMSinceInstall){
				assetMeterBean.setSinceInstall(new String(ch, start, length));
				bAMSinceInstall = false;
			} else if(bAMSinceLastInspect){
				assetMeterBean.setSinceLastInspect(new String(ch, start, length));
				bAMSinceLastInspect = false;
			} else if(bAMSinceLastOverHaul){
				assetMeterBean.setSinceLastOverHaul(new String(ch, start, length));
				bAMSinceLastOverHaul = false;
			} else if(bAMSinceLastRepair){
				assetMeterBean.setSinceLastRepair(new String(ch, start, length));
				bAMSinceLastRepair = false;
			}

		} else if(bPerson) {
			if(bdisplayName){
				personBean.setDisplayName(new String(ch, start, length));
				bdisplayName = false;
			} else if(blocation){
				personBean.setLocation(new String(ch, start, length));
				blocation = false;
			}
			else if(bpersonID){
				personBean.setPersonID(new String(ch, start, length));
				bpersonID = false;
			}
			else if(bpersonUID){
				personBean.setPersonUID(new String(ch, start, length));
				bpersonUID = false;
			}
			else if(bstatus){
				personBean.setStatus(new String(ch, start, length));
				bstatus = false;
			}
			else if(bstatusDate){
				personBean.setStatusDate(new String(ch, start, length));
				bstatusDate = false;
			}
			else if(btitle){
				personBean.setTitle(new String(ch, start, length));
				btitle = false;
			}
		}
		
		
		else if (bAncestor) {
			assetBean.setAncestor(new String(ch, start, length));
			bAncestor = false;
		} else if (bAssetID) {
			assetBean.setAssetID(new String(ch, start, length));
			bAssetID = false;
		} else if (bAssetNum) {
			assetBean.setAssetNum(new String(ch, start, length));
			bAssetNum = false;
		} else if (bChildren) {
			assetBean.setChildren(new String(ch, start, length));
			bChildren = false;
		} else if (bConditionCode) {
			assetBean.setConditionCode(new String(ch, start, length));
			bConditionCode = false;
		} else if (bIafParentLoc) {
			assetBean.setIafParentLoc(new String(ch, start, length));
			bIafParentLoc = false;
		} else if (bIafCDCTS) {
			assetBean.setIafCDCTS(new String(ch, start, length));
			bIafCDCTS = false;
		} else if (bIafDateOfManu) {
			assetBean.setIafDateOfManu(new String(ch, start, length));
			bIafDateOfManu = false;
		} else if (bIafRDCLoc) {
			assetBean.setIafRDCLoc(new String(ch, start, length));
			bIafRDCLoc = false;
		} else if (bItemNum) {
			assetBean.setItemNum(new String(ch, start, length));
			bItemNum = false;
		} else if (bLocation) {
			assetBean.setLocation(new String(ch, start, length));
			bLocation = false;
		} else if (bPlusACAtID) {
			assetBean.setPlusACAtID(new String(ch, start, length));
			bPlusACAtID = false;
		} else if (bPlusTModel) {
			assetBean.setPlusTModel(new String(ch, start, length));
			bPlusTModel = false;
		} else if (bPlusTPos) {
			assetBean.setPlusTPos(new String(ch, start, length));
			bPlusTPos = false;
		} else if (bSerialNum) {
			assetBean.setSerialNum(new String(ch, start, length));
			bSerialNum = false;
		} else if (bSiteID) {
			assetBean.setSiteID(new String(ch, start, length));
			bSiteID = false;
		} else if (bStatus) {
			assetBean.setStatus(new String(ch, start, length));
			bStatus = false;
		} else if (bStatusDate) {
			assetBean.setStatusDate(new String(ch, start, length));
			bStatusDate = false;
		}

	}
}