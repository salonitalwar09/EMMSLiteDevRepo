package com.wipro.iaf.emms.emmsLite.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.Constants.Constants;
import com.wipro.iaf.emms.emmsLite.Repository.ArmamentGIGRepository;
import com.wipro.iaf.emms.emmsLite.Repository.BuildItemRepository;
import com.wipro.iaf.emms.emmsLite.Repository.WorkOrderArmDearmRepository;
import com.wipro.iaf.emms.emmsLite.beans.WorkOrderArmDearmResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.ArmGIGEntity;
import com.wipro.iaf.emms.emmsLite.entity.BuildItemEntity;
import com.wipro.iaf.emms.emmsLite.entity.WorkOrderArmDearmEntity;

/**
 * 
 * @author Saloni Talwar
 * Changes done for EMMS Lite Project
 * Created on 24/03/2021
 * Description - This class is the Service class for the Arming/De-Arming Screen 
 * under Work Order.
 */

@Service
public class WorkOrderArmDeArmService {
	
	@Autowired
	WorkOrderArmDearmRepository woArmDearmRepo;
	@Autowired
	BuildItemRepository buildItemRepository;
	@Autowired
	ArmamentGIGRepository armGIGRepository;
	@Autowired
	WorkOrderArmDearmResponseBean woArmDearmResponseBean;
	@Autowired
	Constants con;
	
	public List<WorkOrderArmDearmEntity>getAllWOArmDeArming(String workOrderId)
	{
		List<WorkOrderArmDearmEntity> armDearmList = new ArrayList<>();
		System.out.println("+++++++++++++Inside getAllWOArmDeArming+++++++++++++");
		if (armDearmList != null) {
			System.out.println("+++++++++++++Inside getAllWOArmDeArming++++++armDearmList is not null+++++++");
			try {
				armDearmList = woArmDearmRepo.getAllWOArmDeArmRecords(workOrderId);
			}catch(Exception e) {
				System.out.println("Error occured while Arming De-Arming data from repository");
				System.out.println(e.getMessage());
			}
			
			if (!armDearmList.isEmpty()) {
				System.out.println("+++++++++++++Inside getAllWOArmDeArming++++++armDearmList is not empty+++++++");
				woArmDearmResponseBean.setCode(202);
				woArmDearmResponseBean.setStatus("Successful");
				woArmDearmResponseBean.setDescription("All Work Order Arming De-Arming records fetched successfully");
			}else {
				System.out.println("+++++++++++++Inside getAllWOArmDeArming++++++armDearmList is empty+++++++");
				woArmDearmResponseBean.setCode(202);
				woArmDearmResponseBean.setStatus("Successful");
				woArmDearmResponseBean.setDescription("There are no records present for Work Order Arming De-Arming");
			}			
		} 
		System.out.println("+++++++++++++End of getAllWOArmDeArming+++++++++++++");
		return armDearmList;
	}
	
	public List<ArmGIGEntity>getArmamentItemDDList()
	{
		System.out.println("+++++++++++++Inside getArmamentItemDDList+++++++++++++");
		List<ArmGIGEntity>armamentItemList = new ArrayList<>();		
		if (armamentItemList != null) {
			System.out.println("+++++++++++++Inside getArmamentItemDDList++++++armamentItemList is not null+++++++");
			try {
				armamentItemList = armGIGRepository.getItemListForArmItem();
			}catch(Exception e) {
				System.out.println("Error occured while Arming De-Arming Armament/GIG No. data from repository");
				System.out.println(e.getMessage());
			}
			
			woArmDearmResponseBean.setCode(202);
			woArmDearmResponseBean.setStatus("Successful");
			woArmDearmResponseBean.setDescription("Armament Item GIG No. Lookup Successful");
		}
		System.out.println("+++++++++++++End of getArmamentItemDDList+++++++++++++");
		return armamentItemList;
	}
	
/*	public String getStationNoForBuildItem(String builditem) {
		System.out.println("****Reached inside getStationNoForBuildItem****");
		String stationNo = woArmDearmRepo.getBuildItemPositionForBuildItem(builditem);
		if (stationNo != null) {
			System.out.println("****Reached inside getStationNoForBuildItem****stationNo != null****");
			woArmDearmResponseBean.setCode(202);
			woArmDearmResponseBean.setStatus("Successful");
			woArmDearmResponseBean.setDescription("Armament Item GIG No Lookup Successful");
			return stationNo; 
		}
		return "";
	}
*/	
/*	public String getArmDescription(String gigNo) {
		System.out.println("****Reached inside getArmDescription****");
		String armGigNo = woArmDearmRepo.getArmamentDescriptionForGIG(gigNo);
		if (armGigNo != null) {
			System.out.println("****Reached inside getArmDescription****armGigNo != null****");
			return armGigNo; 
		}
		return "";
	}	
*/
	public List<BuildItemEntity> getValuesForBuildType() {
		System.out.println("+++++++++++++Inside getValuesForBuildType+++++++++++++");
		List<BuildItemEntity> buildItemList = new ArrayList<>();
		String buildType = "HARD POINT";
		try {
			buildItemList = buildItemRepository.getBuildItemListForArmItem(buildType);
		}catch(Exception e) {
			System.out.println("Error occured while Arming De-Arming Build Item data from repository");
			System.out.println(e.getMessage());
		}
		System.out.println("+++++++++++++End of getValuesForBuildType+++++++++++++");
		return buildItemList; 
	}
	
	public WorkOrderArmDearmResponseBean addNewBuildItemRow(WorkOrderArmDearmEntity woArmDearmEntity, String workorderId,String arm_id){
		woArmDearmResponseBean.reset();
		StringBuffer str = new StringBuffer();
		if (Integer.parseInt(arm_id) == 0) {
			List<WorkOrderArmDearmEntity> woBuildGigSelectiveList = new ArrayList<>(); 
			System.out.println("+++++++++++++Inside addNewBuildItemRow+++++++++++++");
			if (workorderId!= null && woArmDearmEntity != null) {
				if (woArmDearmEntity.getBuildItem() != null
						&& woArmDearmEntity.getArmPosition() != null
						&& woArmDearmEntity.getArmGIGNo() != null) {
					System.out.println("+++++++++++++Inside addNewBuildItemRow+++++++No value is null++++++");
					woArmDearmEntity.setWorkorderId(workorderId);
					woArmDearmEntity.setArmStatus("NEW");
					try {
						woBuildGigSelectiveList = woArmDearmRepo.getBuildItemGigNoRecords(woArmDearmEntity.getBuildItem(),woArmDearmEntity.getArmGIGNo(), woArmDearmEntity.getArmPosition(),workorderId);
					}catch(Exception e){
						System.out.println("Error occured while Arming De-Arming data for specific Build Item,GIG NO.,ARM POSITION from repository");
						System.out.println(e.getMessage());
					}
					if (woBuildGigSelectiveList != null && woBuildGigSelectiveList.size() > 1) {
						System.out.println("+++++++++++++Inside getValuesForBuildType++++++woBuildGigSelectiveList>1+++++++");
						int max = woArmDearmRepo.getMaxArmId();
						System.out.println("+++++++++++++Inside getValuesForBuildType+++++MAX ARM ID++++++++"+max);
						woBuildGigSelectiveList.sort(Comparator.comparing(WorkOrderArmDearmEntity::getArm_id));										
						WorkOrderArmDearmEntity woArmDearmPrevious = woBuildGigSelectiveList.get(woBuildGigSelectiveList.size()-1);					
						if (woArmDearmEntity != null && woArmDearmPrevious != null && (woArmDearmPrevious.getEvaluatedQuant() != null && woArmDearmPrevious.getEvaluatedQuant() != 0) && (woArmDearmEntity.getCurrentQuant() == null || woArmDearmEntity.getCurrentQuant() == 0)) {
							System.out.println("+++++++++++++Inside getValuesForBuildType+++++PREVIOUS VALUE++++++++"+woBuildGigSelectiveList.get(woBuildGigSelectiveList.size()-1).getArm_id());						
							woArmDearmEntity.setCurrentQuant(woArmDearmPrevious.getEvaluatedQuant());
							System.out.println("+++++++++++++Inside getValuesForBuildType+++++CURRENT QUANTITY IS SET TO++++++++"+woArmDearmEntity.getCurrentQuant());
							woArmDearmRepo.save(woArmDearmEntity);				
							str.append("Current Quantity Load Successful");
						}
					}
					
					if (!str.equals(null)) {
						woArmDearmResponseBean.setCode(202);		
						woArmDearmResponseBean.setStatus(str.toString());
					} else {
						woArmDearmResponseBean.setCode(500);		
						woArmDearmResponseBean.setStatus("Current Quantity Update Failed");
					}
					woArmDearmRepo.save(woArmDearmEntity);
					woArmDearmResponseBean.setCode(202);
					woArmDearmResponseBean.setStatus("Database Addition Successful");
					woArmDearmResponseBean.setAddArmStatus("New Build Item has been added successfully");
				}			
			}else {
				woArmDearmResponseBean.setCode(500);
				woArmDearmResponseBean.setStatus("Database Addition was not Successful");
				woArmDearmResponseBean.setAddArmStatus("New Build Item Addition Failed");
			}
		}
			System.out.println("+++++++++++++End of addNewBuildItemRow+++++++++++++");
		return woArmDearmResponseBean;
	}
	
	public WorkOrderArmDearmResponseBean onLoadClickItem (String armId) {
		System.out.println("+++++++++++++Inside onLoadClickItem+++++++++++++");
		StringBuffer str = new StringBuffer();
		int current = 0;
		int load = 0;
		int unload = 0;
		int evaluateQuan = 0;
		Optional<WorkOrderArmDearmEntity> woArmDearmEntityList = woArmDearmRepo.findById(Integer.valueOf(armId));		
		WorkOrderArmDearmEntity woArmDearmEntity = woArmDearmEntityList.get();		
		WorkOrderArmDearmEntity evaluatedQ = woArmDearmRepo.getEvaluatedQuantBuildItem(Integer.valueOf(armId));	
		if (evaluatedQ.getEvaluatedQuant() == null || evaluatedQ.getEvaluatedQuant() == 0 ) {
			System.out.println("+++++++++++++Inside onLoadClickItem+++++++Calculating EValuated Quant++++++");
			if (evaluatedQ.getCurrentQuant() != null) {
				current = evaluatedQ.getCurrentQuant();
				System.out.println("+++++++++++++Inside onLoadClickItem+++++++CURRENT QUANT++++++"+current);
			}			
			if (evaluatedQ.getLoadQuant() != null) {
				load = evaluatedQ.getLoadQuant();
				System.out.println("+++++++++++++Inside onLoadClickItem+++++++LOAD QUANT++++++"+load);
			}
			if (evaluatedQ.getUnloadQuant() != null) {
				unload = evaluatedQ.getUnloadQuant();
				System.out.println("+++++++++++++Inside onLoadClickItem+++++++UNLOAD QUANT++++++"+unload);
			}			
			if (current !=0) {
				if (load != 0) {
					evaluateQuan = current + load;
				}
				if (unload != 0 && current > unload) {
					evaluateQuan = current - unload;
				}
			}
			System.out.println("+++++++++++++Inside onLoadClickItem+++++++EVALUATED QUANT++++++"+evaluateQuan);
			woArmDearmEntity.setEvaluatedQuant(evaluateQuan);
			str.append("Evaluated Quantity Load Successful");
		}
		if (!woArmDearmEntity.getArmStatus().equals(con.COMP_STATUS)) {
			woArmDearmEntity.setArmStatus(con.COMP_STATUS);
			str.append("Status Update to COMPLETED Successful");
		}		
		woArmDearmRepo.save(woArmDearmEntity);
		if (!str.equals("") && !str.equals(null)) {
			woArmDearmResponseBean.setCode(202);		
			woArmDearmResponseBean.setStatus(str.toString());
		} else {
			woArmDearmResponseBean.setCode(500);		
			woArmDearmResponseBean.setStatus("Evaluated Quantity and Status Update Failed");
		}
		System.out.println("+++++++++++++End of onLoadClickItem+++++++++++++");	
		return woArmDearmResponseBean;
	}
	
	public WorkOrderArmDearmResponseBean deleteBuildItem(String arm_id) {
		woArmDearmResponseBean.reset();
		if (arm_id != null) {
			woArmDearmRepo.deleteById(Integer.valueOf(arm_id));
			woArmDearmResponseBean.setCode(202);
			woArmDearmResponseBean.setStatus("Database Deletion Successful");
			woArmDearmResponseBean.setAddArmStatus("Build Item has been deleted successfully");
		}
		return woArmDearmResponseBean;
	}
	
	/*public String getEvaluatedQuantity(WorkOrderArmDearmEntity woArmDearmEntity,String armId) {		
	String currentQuan=null;
	String loadQuan=null;
	String unLoadQuan=null;
	
	List<Integer> evaluatedQ = woArmDearmRepo.getEvaluatedQuantBuildItem(armId);
	System.out.println("****My results "+evaluatedQ.get(0));
	int index1 = evaluatedQ.indexOf(",");
	System.out.println("index 1:: "+index1);
	woArmDearmEntity.setEvaluatedQuant(evaluatedQ.get(0));
	woArmDearmEntity.setArmStatus(con.COMP_STATUS);
	woArmDearmRepo.save(woArmDearmEntity);
	/*if (index1 > 0) {
		currentQuan = evaluatedQ.substring(0, index1);
	}
	int index2 = evaluatedQ.lastIndexOf(",");
	if(index2 > 0){
		unLoadQuan = evaluatedQ.substring(index2+1, evaluatedQ.length());
	}
	if (index1 > 0 && index2 > 0) {
		loadQuan = evaluatedQ.substring(index1+1, index2);
	}
	
	if (currentQuan != null) {
		int current = Integer.parseInt(currentQuan);
		if (loadQuan != null) {
			int load = Integer.parseInt(loadQuan);
					
		}else if(unLoadQuan != null){
			int unload = Integer.parseInt(unLoadQuan);
							
		}
	}*/
			
	//return String.valueOf(evaluateQuan); 
//}
}