package com.wipro.iaf.emms.emmsLite.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.Constants.Constants;
import com.wipro.iaf.emms.emmsLite.Repository.WorkOrderArmDearmRepository;
import com.wipro.iaf.emms.emmsLite.beans.WorkOrderArmDearmResponseBean;
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
	WorkOrderArmDearmResponseBean woArmDearmResponseBean;
	@Autowired
	Constants con;
	
	public List<WorkOrderArmDearmEntity>getAllWOArmDeArming()
	{
		List<WorkOrderArmDearmEntity> sortieList = new ArrayList<>();
		System.out.println("****Reached inside getAllWOArmDeArming Service****");
		if (sortieList != null) {
			System.out.println("****Reached inside getAllWOArmDeArming****sortieList != null****");
			sortieList = woArmDearmRepo.getAllWOArmDeArmRecords();
			if (!sortieList.isEmpty()) {
				woArmDearmResponseBean.setCode(202);
				woArmDearmResponseBean.setStatus("Successful");
				woArmDearmResponseBean.setDescription("All Work Order Arming De-Arming records fetched successfully");
			}else {
				woArmDearmResponseBean.setCode(202);
				woArmDearmResponseBean.setStatus("Successful");
				woArmDearmResponseBean.setDescription("There are no records present for Work Order Arming De-Arming");
			}			
		} 					
		return sortieList;
	}
	
	public List<String>getArmamentItemDDList()
	{
		System.out.println("****Reached inside getArmamentItemDDList****");
		List<String>armamentItemList = new ArrayList<>();		
		if (armamentItemList != null) {
			System.out.println("****Reached inside getArmamentItemDDList****armamentItemList != null");
			armamentItemList = woArmDearmRepo.getItemListForArmItem();
			woArmDearmResponseBean.setCode(202);
			woArmDearmResponseBean.setStatus("Successful");
			woArmDearmResponseBean.setDescription("Armament Item GIG No Lookup Successful");
		} 					
		return armamentItemList;
	}
	
	public String getStationNoForBuildItem(String builditem) {
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
	
	public String getArmDescription(String gigNo) {
		System.out.println("****Reached inside getArmDescription****");
		String armGigNo = woArmDearmRepo.getArmamentDescriptionForGIG(gigNo);
		if (armGigNo != null) {
			System.out.println("****Reached inside getArmDescription****armGigNo != null****");
			return armGigNo; 
		}
		return "";
	}	
	
	public List<String> getValuesForBuildType(String buildType) {
		List<String> buildItemList = new ArrayList<>();
		buildItemList = woArmDearmRepo.getBuildItemListForArmItem(buildType);
		return buildItemList; 
	}
	
	public WorkOrderArmDearmResponseBean addNewBuildItemRow(WorkOrderArmDearmEntity woArmDearmEntity, String workorderId){
		woArmDearmResponseBean.reset();
		if (workorderId!= null && woArmDearmEntity != null) {
			if (woArmDearmEntity.getBuildItem() != null
					&& woArmDearmEntity.getStationNo() != null
					&& woArmDearmEntity.getArmGIGNo() != null) {
				woArmDearmEntity.setWorkorderId(workorderId);
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
		return woArmDearmResponseBean;
	}
	
	public WorkOrderArmDearmResponseBean onLoadClickItem (String armId) {
		StringBuffer str = new StringBuffer();
		int current = 0;
		int load = 0;
		int unload = 0;
		int evaluateQuan = 0;
		Optional<WorkOrderArmDearmEntity> woArmDearmEntityList = woArmDearmRepo.findById(Integer.valueOf(armId));		
		WorkOrderArmDearmEntity woArmDearmEntity = woArmDearmEntityList.get();
		List<WorkOrderArmDearmEntity> woBuildGigSelectiveList = woArmDearmRepo.getBuildItemGigNoRecords(woArmDearmEntity.getBuildItem(),woArmDearmEntity.getArmGIGNo(), woArmDearmEntity.getArmPosition(),woArmDearmEntity.getWorkorderId());
		
		if (woBuildGigSelectiveList != null && woBuildGigSelectiveList.size() > 1) {
			int max = woArmDearmRepo.getMaxArmId();
			System.out.println("********The max value is="+max);
			woBuildGigSelectiveList.sort(Comparator.comparing(WorkOrderArmDearmEntity::getArm_id));
			System.out.println("********woArmDearmPrevious="+woBuildGigSelectiveList.get(woBuildGigSelectiveList.size()-2).getArm_id());
			System.out.println("********woArmDearmCurrent ="+woBuildGigSelectiveList.get(woBuildGigSelectiveList.size()-1).getArm_id());
			WorkOrderArmDearmEntity woArmDearmCurrent = woBuildGigSelectiveList.get(woBuildGigSelectiveList.size()-1);
			WorkOrderArmDearmEntity woArmDearmPrevious = woBuildGigSelectiveList.get(woBuildGigSelectiveList.size()-2);
			if ((woArmDearmPrevious.getEvaluatedQuant() != null && woArmDearmPrevious.getEvaluatedQuant() != 0) && (woArmDearmCurrent.getCurrentQuant() == null || woArmDearmCurrent.getCurrentQuant() == 0)) {
				woArmDearmCurrent.setCurrentQuant(woArmDearmPrevious.getEvaluatedQuant());
				System.out.println("***********Current Quantity="+woArmDearmCurrent.getCurrentQuant());
				woArmDearmRepo.save(woArmDearmCurrent);				
				str.append("Current Quantity Load Successful");
			}
		}
		WorkOrderArmDearmEntity evaluatedQ = woArmDearmRepo.getEvaluatedQuantBuildItem(Integer.valueOf(armId));	
		if (evaluatedQ.getEvaluatedQuant() == null || evaluatedQ.getEvaluatedQuant() == 0 ) {
			if (evaluatedQ.getCurrentQuant() != null) {
				current = evaluatedQ.getCurrentQuant();
			}
			if (evaluatedQ.getLoadQuant() != null) {
				load = evaluatedQ.getLoadQuant();
			}
			if (evaluatedQ.getUnloadQuant() != null) {
				unload = evaluatedQ.getUnloadQuant();
			}			
			if (current !=0) {
				if (load != 0) {
					evaluateQuan = current + load;
				}
				if (unload != 0 && current > unload) {
					evaluateQuan = current - unload;
				}
			}			
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
			woArmDearmResponseBean.setStatus("Evaluated Quantity and Current Quantity and Status Update Failed");
		}
				
		return woArmDearmResponseBean;
	}
	
	public String getUpdatedStatus(WorkOrderArmDearmEntity woArmDearmEntity,String armId) {
		String status = woArmDearmRepo.getUpdatedStatusBuildItem(Integer.valueOf(armId));
		if (status == null || !status.equals(con.COMP_STATUS)) {
			status = con.COMP_STATUS;
			woArmDearmEntity.setArmStatus(con.COMP_STATUS);
			woArmDearmRepo.save(woArmDearmEntity);
		}
		return status;
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