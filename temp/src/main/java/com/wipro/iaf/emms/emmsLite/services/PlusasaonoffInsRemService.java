package com.wipro.iaf.emms.emmsLite.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.wipro.iaf.emms.emmsLite.Repository.PlusasaonoffInsRemRepository;
import com.wipro.iaf.emms.emmsLite.entity.AssetInsRemEntity;
import com.wipro.iaf.emms.emmsLite.entity.PlusasaonoffInsRemEntity;

@Service
public class PlusasaonoffInsRemService {

	@Autowired
	PlusasaonoffInsRemRepository plusasaonoffRemRepo;
	//@Autowired
	//PlusasaonoffInsRemEntity plusasaonoffInsRemEntity;
	@Autowired AssetInsRemEntity assetInsRemEntity; 

	public List<PlusasaonoffInsRemEntity> plusasaonoffInsRemupdate(String buildItem, String lcn, String label, String jobType){

		try {
			DateTimeFormatter ontimeUpdate= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime ontime= LocalDateTime.now();
			
			//Global Variables Decleration:: Shivam
			String globalCurrentDate = ontimeUpdate.format(ontime);
			String globalAssetId = null;
			String globalParentAssetId = null;
			String globalLabel = null;
			String globalPosition = null;
			String globalName = null;
			String globalLCN = null;
			String globalAlc = null;
			String globalNonSerialized = null;
			String globalOrgId = "IAF";
			String globalSiteId = "IAFSITE";
			String globalNullValue = null;
			
			
			if(jobType.equalsIgnoreCase("Install"))
			{
				//For Install Functionality:: Shivam
				System.out.println("Into Install:: "+buildItem+" "+" "+label+" "+lcn) ;
				List<PlusasaonoffInsRemEntity> plusasaonoffInstallListValues = plusasaonoffRemRepo.getPlusasaonoffInstallRecord(buildItem, label, lcn);
				System.out.println("query Result:: "+ plusasaonoffInstallListValues.toString());
				System.out.println("Size of List:: "+plusasaonoffInstallListValues.size());
				PlusasaonoffInsRemEntity plusasaonoffInsRemEntity = new PlusasaonoffInsRemEntity();
				for(PlusasaonoffInsRemEntity listValue: plusasaonoffInstallListValues){
					//Local variables for IF/Else Statement:: Shivam
					System.out.println("assetId:: "+ listValue.getAssetId());
					String localAssetId = listValue.getAssetId();
					System.out.println("parentAssetId:: "+ listValue.getParentAssetId());
					String localParentAssetId = listValue.getParentAssetId();
										
					if(localAssetId== null && localParentAssetId!=null){
						
						Long plusasaonoffId = listValue.getPlusasaonoffId();
						System.out.println("PlusasaonoffId when assetId is Null:: "+plusasaonoffId);
						
						globalParentAssetId = listValue.getParentAssetId();
						
						plusasaonoffRemRepo.updateOffTimeInstall(globalCurrentDate, plusasaonoffId);

					}else if(localAssetId!= null && localParentAssetId==null){
						
						Long plusasaonoffId = listValue.getPlusasaonoffId();
						System.out.println("PlusasaonoffId when parentAssetId is null:: "+plusasaonoffId);
						
						globalAssetId = listValue.getAssetId();
						
						plusasaonoffRemRepo.updateOffTimeInstall(globalCurrentDate, plusasaonoffId);	

					}
					System.out.println("Global AssetId:: "+listValue.getAssetId());
					System.out.println("Global ParentAssetId :: "+listValue.getParentAssetId());
					
					globalLabel = listValue.getLabel();
					System.out.println("Global Label:: "+listValue.getLabel());
					
					globalPosition = listValue.getPosition();
					System.out.println("Global Position:: "+ listValue.getPosition());
					
					globalName = listValue.getName();
					System.out.println("Global Name:: "+listValue.getName());
					
					globalLCN = listValue.getLcn();
					System.out.println("Global Lcn:: "+listValue.getLcn());
					
					globalAlc = listValue.getAlc();
					System.out.println("Global ALC:: "+listValue.getAlc());
					
					globalNonSerialized = listValue.getNonSerialized();
					System.out.println("Global NonSerialized:: "+listValue.getNonSerialized());
					

				}
				plusasaonoffInsRemEntity.setLabel(globalLabel);
				plusasaonoffInsRemEntity.setPosition(globalPosition);
				plusasaonoffInsRemEntity.setName(globalName);
				plusasaonoffInsRemEntity.setLcn(globalLCN);
				plusasaonoffInsRemEntity.setAssetId(globalAssetId);
				plusasaonoffInsRemEntity.setParentAssetId(globalParentAssetId);
				plusasaonoffInsRemEntity.setType("N");
				plusasaonoffInsRemEntity.setOrgId(globalOrgId);
				plusasaonoffInsRemEntity.setSiteId(globalSiteId);
				plusasaonoffInsRemEntity.setOntime(globalCurrentDate);
				//setting offtime to be null:: Shivam
				plusasaonoffInsRemEntity.setOffTime(globalNullValue);
				plusasaonoffInsRemEntity.setAlc(globalAlc);
				plusasaonoffInsRemEntity.setNonSerialized(globalNonSerialized);
				System.out.println("Before Save Entity");
				
				plusasaonoffRemRepo.save(plusasaonoffInsRemEntity);
				
				System.out.println("New Row for after install Created..");
				
			}else {

				//For Install Functionality:: Shivam
				System.out.println("Into Removal:: ");
				List<PlusasaonoffInsRemEntity> plusasaonoffRemoveListValues = plusasaonoffRemRepo.getPlusasaonoffRemoveRecord(buildItem, label, lcn);
				//System.out.println("query Result:: "+ plusasaonoffRemoveListValues.toString());
				System.out.println("Size of List:: "+plusasaonoffRemoveListValues.size());

				for(PlusasaonoffInsRemEntity listValue: plusasaonoffRemoveListValues){

					//Update exisiting fetched row with offtime:: Shivam
					//PlusasaonoffInsRemEntity plusasaonoffInsRemEntity = new PlusasaonoffInsRemEntity();
					Long plusasaonoffId = listValue.getPlusasaonoffId();
					String type = "B";
					
					System.out.println("PlusasaonoffId when assetID and parentAssetId is not null:: "+plusasaonoffId);
					System.out.println("GlobalTime:: "+globalCurrentDate);
					plusasaonoffRemRepo.updateOffTimeRemove(globalCurrentDate, type, plusasaonoffId );

					//Insert 2 seprate rows with assetid and parentassetid:: Shivam


					System.out.println("assetId:: "+ listValue.getAssetId());
					//String localAssetId = listValue.getAssetId();
					
					Long localAssetId = Long.parseLong(listValue.getAssetId());
					
					
					System.out.println("parentAssetId:: "+ listValue.getParentAssetId());
					Long localParentAssetId = Long.parseLong(listValue.getParentAssetId());

					System.out.println("label:: "+listValue.getLabel());
					String localLabel= listValue.getLabel();

					System.out.println("Position:: "+listValue.getPosition());
					String localPosition= listValue.getPosition();

					System.out.println("Name:: "+listValue.getName());
					String localName= listValue.getName();

					System.out.println("LCN:: "+listValue.getLcn());
					String localLcn= listValue.getLcn();

					System.out.println("ACL:: "+listValue.getAlc());
					String localAcl= listValue.getAlc();

					System.out.println("OnTime:: "+globalCurrentDate);
					String localOntime= globalCurrentDate;

					System.out.println("nonSerialized:: "+listValue.getNonSerialized());
					String localNonSerialized= listValue.getNonSerialized();
					
				/*	plusasaonoffRemRepo.insertRemoveRowsAssetId(localLabel, localPosition, localName, 
							localLcn, localAcl, localOntime, "", localAssetId, "", localNonSerialized, "IAF", "IAFSITE", "N");
				*/	
					plusasaonoffRemRepo.insertRemoveRowsAssetId(localLabel, localPosition, localName, localLcn, localAcl, localOntime, globalNullValue, localAssetId , null , localNonSerialized, "IAF", "IAFSITE", "G");
					
					System.out.println("AssetID Row Inserted");

					plusasaonoffRemRepo.insertRemoveRowsParentAssetId(localLabel, localPosition, localName, 
							localLcn, localAcl, localOntime, globalNullValue, null, localParentAssetId, localNonSerialized, "IAF", "IAFSITE", "G");
					
					System.out.println("ParentAssetID Row Inserted");
				}

			}
		} catch (Exception e) {
			System.out.println("plusasaonoff error:: "+ e.getMessage());
		}
		return null;

	}

}
