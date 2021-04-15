package com.wipro.iaf.emms.emmsLite.utility;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParserFactory;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.iaf.emms.emmsLite.Repository.AssetRepository;
import com.wipro.iaf.emms.emmsLite.beans.AMACXMLBeans.AMACXmlBean;
import com.wipro.iaf.emms.emmsLite.beans.DomainXMLBeans.MaxDomainBean;
import com.wipro.iaf.emms.emmsLite.beans.ModelXMLBeans.ModelBean;
@Component
public class SAXParser {
	@Autowired
	private AMACXMLHandler assetHandler;
	@Autowired
	private AMACXmlBean amacxmlBean;
	@Autowired
	private DomainXMLHandler domainhandler;

	public void readXML(InputStream file, String fileName, AssetRepository assetRepository) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();

			if (fileName.contains("DOMAIN")) {


				//AMACXMLHandler assetHandler = new AMACXMLHandler();
				saxParser.parse(file, domainhandler);
				//amacxmlBean.setAssetList(assetHandler.assets);
				ArrayList<MaxDomainBean> data = domainhandler.maxDomainList;
				/*for (int i = 0; i < data.size(); i++) {
					System.out.println(data.get(i).toString());
				}*/
				/*ArrayList<PersonBean> data1 = assetHandler.persons;
				for (int i = 0; i < data1.size(); i++) {
					System.out.println(data1.get(i).toString());
				}*/
				
//				for (int i = 0; i < data.size(); i++) {
//					Asset asset = new Asset();
//					
//					asset.setAncestor(data.get(i).getAncestor())
				
				;
//					asset.setAssetid(data.get(i).getAssetID());
//					asset.setAssetnum(data.get(i).getAssetNum());
//					asset.setSiteid(data.get(i).getSiteID());
//					asset.setStatus(data.get(i).getStatus());
//					
//					assetRepository.save(asset);
//					System.out.println("saved");
//				}

			} 
/*			else if (fileName.contains("DOMAIN")) {

				DomainXMLHandler domainHandler = new DomainXMLHandler();
				saxParser.parse(file, domainHandler);
				ArrayList<MaxDomainBean> data = domainHandler.maxDomainList;

				for (int i = 0; i < data.size(); i++) {
					System.out.println(data.get(i).toString());
				}
			}*/
			else if(fileName.contains("MODEL")) {
				ModelXMLHandler modelHandler = new ModelXMLHandler();
				saxParser.parse(file, modelHandler);
				ModelBean data = modelHandler.getModel();
				System.out.println(data.toString());
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// public static void main(String[] args) {
	//
	// File file = new File(System.getProperty("user.dir")
	// + "/IAF_EMMS_DOMAIN161356060323939342.xml");
	// // try{
	// // SAXParserFactory factory = SAXParserFactory.newInstance();
	// // javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
	// //
	// // AMACXMLHandler assetHandler = new AMACXMLHandler();
	// // saxParser.parse(file, assetHandler);
	// // ArrayList<AssetBean> data = assetHandler.assets;
	// // for(int i = 0; i < data.size(); i++){
	// // System.out.println(data.get(i).toString());
	// // }
	// // }
	// // catch(Exception e){
	// // e.printStackTrace();
	// // }
	//
	// try {
	// SAXParserFactory factory = SAXParserFactory.newInstance();
	// javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
	//
	// DomainXMLHandler domainHandler = new DomainXMLHandler();
	// saxParser.parse(file, domainHandler);
	// ArrayList<MaxDomainBean> data = domainHandler.maxDomainList;
	// for (int i = 0; i < data.size(); i++) {
	// System.out.println(data.get(i).toString());
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// }
}
