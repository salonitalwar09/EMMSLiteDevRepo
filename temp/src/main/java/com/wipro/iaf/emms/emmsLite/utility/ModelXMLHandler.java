package com.wipro.iaf.emms.emmsLite.utility;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.wipro.iaf.emms.emmsLite.beans.ModelXMLBeans.ModelBean;
import com.wipro.iaf.emms.emmsLite.beans.ModelXMLBeans.PlusACACatBean;
import com.wipro.iaf.emms.emmsLite.beans.ModelXMLBeans.PlusACMBuildBean;
import com.wipro.iaf.emms.emmsLite.beans.ModelXMLBeans.PlusACMBuildItemBean;
import com.wipro.iaf.emms.emmsLite.beans.ModelXMLBeans.PlusACMConfigBean;
import com.wipro.iaf.emms.emmsLite.beans.ModelXMLBeans.PlusACMModelBean;
import com.wipro.iaf.emms.emmsLite.beans.ModelXMLBeans.PlusACMXCatBean;

public class ModelXMLHandler extends DefaultHandler {
	
	// List of tags present in Model XML
	private final String ASSETNUM = "ASSETNUM";
	private final String CMITEM = "CMITEM";
	private final String DESCRIPTION = "DESCRIPTION";
	private final String DETTLOCATION = "DETTLOCATION";
	private final String DETTLOCATIONBASE = "DETTLOCATIONBASE";
	private final String IAF_DETTFLB_POSTFGTDATA_STATUS = "IAF_DETTFLB_POSTFGTDATA_STATUS";
	private final String IAF_DETTINSTALLREMOVE_STATUS = "IAF_DETTINSTALLREMOVE_STATUS";
	private final String IAF_DETTPLANNEDASSET_STATUS = "IAF_DETTPLANNEDASSET_STATUS";
	private final String IAF_DETTSNAGDETAILS_STATUS = "IAF_DETTSNAGDETAILS_STATUS";
	private final String IAF_DETTWODETAILS_STATUS = "IAF_DETTWODETAILS_STATUS";
	private final String IAF_DETT_ARMDEARM_STATUS = "IAF_DETT_ARMDEARM_STATUS";
	private final String IAF_DETT_ASSETMETER_STATUS = "IAF_DETT_ASSETMETER_STATUS";
	private final String IAF_DETT_SORTIE_STATUS = "IAF_DETT_SORTIE_STATUS";
	private final String IAF_EMMSHALTRANSID = "IAF_EMMSHALTRANSID";
	private final String IAF_VALSTATUS = "IAF_VALSTATUS";
	private final String IAF_WO_TLC_STATUS = "IAF_WO_TLC_STATUS";
	private final String INDUCTIONDATE = "INDUCTIONDATE";
	private final String LOCATION = "LOCATION";
	private final String MODEL = "MODEL";
	private final String RECORDID = "RECORDID";
	private final String RETURNDATE = "RETURNDATE";
	private final String SERIALNUM = "SERIALNUM";
	private final String SIGNALOUTDATE = "SIGNALOUTDATE";
	private final String STATUS = "STATUS";
	private final String TRANSFERDATE = "TRANSFERDATE";
	private final String VARIATION = "VARIATION";
	private final String PLUSACMMODEL = "PLUSACMMODEL";
	private final String INSTALLABLE = "INSTALLABLE";
	private final String ITEMSETID = "ITEMSETID";
	private final String PLUSACMBUILD = "PLUSACMBUILD";
	private final String BUILDITEM = "BUILDITEM";
	private final String BUILDITEMID = "BUILDITEMID";
	private final String HASCHILDREN = "HASCHILDREN";
	private final String HASPARENT = "HASPARENT";
	private final String INDENTURE = "INDENTURE";
	private final String INDICATOR = "INDICATOR";
	private final String LABEL = "LABEL";
	private final String LCN = "LCN";
	private final String MODELID = "MODELID";
	private final String PLUSACMBUILDID = "PLUSACMBUILDID";
	private final String POSITION = "POSITION";
	private final String PLUSACMCONFIG = "PLUSACMCONFIG";
	private final String PLUSACMCONFIGID = "PLUSACMCONFIGID";
	private final String PLUSACMBUILDITEM = "PLUSACMBUILDITEM";
	private final String NAME = "NAME";
	private final String PLUSACMBUILDITEMID = "PLUSACMBUILDITEMID";
	private final String PLUSACMXCAT = "PLUSACMXCAT";
	private final String ISDEFAULT = "ISDEFAULT";
	private final String ITEM = "ITEM";
	private final String PLUSACMXCATID = "PLUSACMXCATID";
	private final String PLUSACACAT = "PLUSACACAT";
	private final String ITEMID = "ITEMID";
	private final String ITEMNUM = "ITEMNUM";
	private final String PLUSACACATID = "PLUSACACATID";

	// String value present between the tags
	private String elementValue;

	// Beans
	private ModelBean bean;

	private PlusACMModelBean plusACMModelBean;

	private ArrayList<PlusACMBuildBean> plusACMBuildList;
	private PlusACMBuildBean plusACMBuildBean;

	private ArrayList<PlusACMConfigBean> plusACMConfigList;
	private PlusACMConfigBean plusACMConfigBean;

	private ArrayList<PlusACMBuildItemBean> plusACMBuildItemList;
	private PlusACMBuildItemBean plusACMBuildItemBean;

	private ArrayList<PlusACMXCatBean> plusACMXCatList;
	private PlusACMXCatBean plusACMXCatBean;

	private PlusACACatBean plusACACatBean;

	
	@Override
	public void startDocument(){
		bean = new ModelBean();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		String tag = qName.toUpperCase();
		switch (tag) {
			case PLUSACMMODEL:
				plusACMModelBean = new PlusACMModelBean();
				plusACMBuildList = new ArrayList<>();
				plusACMBuildItemList = new ArrayList<>();
				break;
			case PLUSACMBUILD:
				plusACMBuildBean = new PlusACMBuildBean();
				plusACMConfigList = new ArrayList<>();
				break;
			case PLUSACMCONFIG:
				plusACMConfigBean = new PlusACMConfigBean();
				break;
			case PLUSACMBUILDITEM:
				plusACMBuildItemBean = new PlusACMBuildItemBean();
				plusACMXCatList = new ArrayList<>();
				break;
			case PLUSACMXCAT:
				plusACMXCatBean = new PlusACMXCatBean();
				break;
			case PLUSACACAT:
				plusACACatBean = new PlusACACatBean();
		}
	}

	@Override
	public void characters(char ch[], int start, int length) {
		elementValue = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		String tag = qName.toUpperCase();
		switch (tag) {
			case ASSETNUM:
				bean.setAssetNum(elementValue);
				break;
			case CMITEM:
				bean.setCmItem(elementValue);
				break;
			case DESCRIPTION:
				if (plusACACatBean != null)
					plusACACatBean.setDescription(elementValue);
				if (plusACMModelBean != null)
					plusACMModelBean.setDescription(elementValue);
				else
					bean.setDescription(elementValue);
				break;
			case DETTLOCATION:
				bean.setDettLocation(elementValue);
				break;
			case DETTLOCATIONBASE:
				bean.setDettLocationBase(elementValue);
				break;
			case IAF_DETTFLB_POSTFGTDATA_STATUS:
				bean.setIafDettFlbPostFGTDataStatus(elementValue);
				break;
			case IAF_DETTINSTALLREMOVE_STATUS:
				bean.setIafDettInstallRemoveStatus(elementValue);
				break;
			case IAF_DETTPLANNEDASSET_STATUS:
				bean.setIafDettPlannedAssetStatus(elementValue);
				break;
			case IAF_DETTSNAGDETAILS_STATUS:
				bean.setDettSnagDetailsStatus(elementValue);
				break;
			case IAF_DETTWODETAILS_STATUS:
				break;
			case IAF_DETT_ARMDEARM_STATUS:
				bean.setIafDettArmDearmStatus(elementValue);
				break;
			case IAF_DETT_ASSETMETER_STATUS:
				bean.setIafDettAssetmeterStatus(elementValue);
				break;
			case IAF_DETT_SORTIE_STATUS:
				bean.setIafDettSortieStatus(elementValue);
				break;
			case IAF_EMMSHALTRANSID:
				bean.setIafEmmsHALTransID(elementValue);
				break;
			case IAF_VALSTATUS:
				bean.setIafValStatus(elementValue);
				break;
			case IAF_WO_TLC_STATUS:
				bean.setIafWOTLCStatus(elementValue);
				break;
			case INDUCTIONDATE:
				bean.setInductionDate(elementValue);
				break;
			case LOCATION:
				bean.setLocation(elementValue);
				break;
			case MODEL:
				if (plusACMBuildItemBean != null)
					plusACMBuildItemBean.setModelID(elementValue);
				else
					bean.setModel(elementValue);
				break;
			case RECORDID:
				bean.setRecordID(elementValue);
				break;
			case RETURNDATE:
				bean.setReturnDate(elementValue);
				break;
			case SERIALNUM:
				bean.setSerialNum(elementValue);
				break;
			case SIGNALOUTDATE:
				bean.setSignalOutDate(elementValue);
				break;
			case STATUS:
				bean.setStatus(elementValue);
				break;
			case TRANSFERDATE:
				bean.setTransferDate(elementValue);
				break;
			case VARIATION:
				if(plusACMConfigBean != null)
					plusACMConfigBean.setVariation(elementValue);
				else
					bean.setVariation(elementValue);
				break;
			case PLUSACMMODEL:
				plusACMModelBean.setPlusACMBuildItemList(plusACMBuildItemList);
				plusACMModelBean.setPlusACMBuildList(plusACMBuildList);
				bean.setPlusACMModel(plusACMModelBean);
				break;
			case INSTALLABLE:
				plusACMModelBean.setDescription(elementValue);
				break;
			case ITEMSETID:
				plusACMModelBean.setItemSetID(elementValue);
				break;
			case PLUSACMBUILD:
				plusACMBuildBean.setPlusACMConfigList(plusACMConfigList);
				plusACMConfigList = null;
				plusACMBuildList.add(plusACMBuildBean);
				plusACMBuildBean = new PlusACMBuildBean();
				break;
			case BUILDITEM:
				plusACMBuildBean.setBuildItem(elementValue);
				break;
			case BUILDITEMID:
				if (plusACMXCatBean != null)
					plusACMXCatBean.setBuildItemID(elementValue);
				else
					plusACMBuildBean.setBuildItemID(elementValue);
				break;
			case HASCHILDREN:
				plusACMBuildBean.setHasChildren(elementValue);
				break;
			case HASPARENT:
				plusACMBuildBean.setHasParent(elementValue);
				break;
			case INDENTURE:
				plusACMBuildBean.setIndenture(elementValue);
				break;
			case INDICATOR:
				plusACMBuildBean.setIndicator(elementValue);
				break;
			case LABEL:
				plusACMBuildBean.setLabel(elementValue);
				break;
			case LCN:
				plusACMBuildBean.setLcn(elementValue);
				break;
			case MODELID:
				plusACMBuildBean.setModelID(elementValue);
				break;
			case PLUSACMBUILDID:
				plusACMBuildBean.setPlusACMBuildID(elementValue);
				break;
			case POSITION:
				plusACMBuildBean.setPosition(elementValue);
				break;
			case PLUSACMCONFIG:
				plusACMConfigList.add(plusACMConfigBean);
				plusACMConfigBean = null;
				break;
			case PLUSACMCONFIGID:
				plusACMConfigBean.setPlusACMConfigID(elementValue);
				break;
			case PLUSACMBUILDITEM:
				plusACMBuildItemBean.setPlusACMXCatBeanList(plusACMXCatList);
				plusACMXCatList = null;
				plusACMBuildItemList.add(plusACMBuildItemBean);
				plusACMBuildItemBean = null;
				break;
			case NAME:
				plusACMBuildItemBean.setName(elementValue);
				break;
			case PLUSACMBUILDITEMID:
				plusACMBuildItemBean.setPlusACMBuiltItemID(elementValue);
				break;
			case PLUSACMXCAT:
				plusACMXCatList.add(plusACMXCatBean);
				plusACMXCatBean = null;
				break;
			case ISDEFAULT:
				plusACMXCatBean.setIsDefault(elementValue);
				break;
			case ITEM:
				if (plusACACatBean != null)
					plusACACatBean.setItem(elementValue);
				else
					plusACMXCatBean.setItem(elementValue);
				break;
			case PLUSACMXCATID:
				plusACMXCatBean.setPlusACMXCatID(elementValue);
				break;
			case PLUSACACAT:
				plusACMXCatBean.setPlusACACat(plusACACatBean);
				plusACACatBean = null;
				break;
			case ITEMID:
				plusACACatBean.setItemID(elementValue);
			case ITEMNUM:
				plusACACatBean.setItemNum(elementValue);
				break;
			case PLUSACACATID:
				plusACACatBean.setPlusACACatID(elementValue);
		}
	}

	public ModelBean getModel() {
		return bean;
	}
}
