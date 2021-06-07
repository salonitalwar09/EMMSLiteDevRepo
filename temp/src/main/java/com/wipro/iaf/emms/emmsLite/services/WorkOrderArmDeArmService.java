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
import com.wipro.iaf.emms.emmsLite.Repository.WOArmingAssetRepository;
import com.wipro.iaf.emms.emmsLite.Repository.WOArmingHistoryRepository;
import com.wipro.iaf.emms.emmsLite.Repository.WorkOrderArmDearmRepository;
import com.wipro.iaf.emms.emmsLite.beans.WorkOrderArmDearmResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.ArmGIGEntity;
import com.wipro.iaf.emms.emmsLite.entity.ArmingAssetEntity;
import com.wipro.iaf.emms.emmsLite.entity.BuildItemEntity;
import com.wipro.iaf.emms.emmsLite.entity.WOArmingHistoryEntity;
import com.wipro.iaf.emms.emmsLite.entity.WorkOrderArmDearmEntity;
import com.wipro.iaf.emms.emmsLite.entity.WorkTypeEntity;

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
	WOArmingAssetRepository woArmDearmAssetRepo;
	@Autowired
	WOArmingHistoryRepository woArmingHistoryRepo;
	@Autowired
	WorkOrderArmDearmResponseBean woArmDearmResponseBean;
	@Autowired
	Constants con;
	@Autowired
	ArmingAssetEntity armingAssetEntity;
	
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
	
	/**
	 * This method allows user to enter the Load quantity for new rows which will be entered in ASSET table as well
	 * and also previously entered rows are displayed.
	 * @param assetNum
	 * @return
	 */
	public List<WorkOrderArmDearmEntity> getAllWOLoadRecords(String assetNum, String workOrderId) {
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
	
	/**
	 * This method allows user to view all the entries in the Arming/De-Arming ASSET table corresponding to a  
	 * particular ASSET Number where the current quantity of the asset is greater than 0.
	 * User can then enter the unload quantity for the entries that are returned from the above table on view.
	 * @param assetNum
	 * @return
	 */
	public List<WorkOrderArmDearmEntity> getAllWOUnloadRecords(String assetNum, String workOrderId) {
		List<ArmingAssetEntity> deArmAssetList = new ArrayList<>();
		List<WorkOrderArmDearmEntity> armingList = new ArrayList<>();
		ArmingAssetEntity assetEntity;
		WorkOrderArmDearmEntity armDearmEntity = new WorkOrderArmDearmEntity();
		List<WorkOrderArmDearmEntity> woArmDearmEntityList = new ArrayList<>(); 
		if (assetNum != null && workOrderId != null) {
			woArmDearmEntityList = woArmDearmRepo.getAllWOArmDeArmRecords(workOrderId);
			System.out.println("+++++++++++++Inside getAllWOUnloadRecords+++++++++++++");
		
			try {
				deArmAssetList = woArmDearmAssetRepo.getAllWODeArmAssetRecords(assetNum);
				if (deArmAssetList != null) {
					for (int i=0; i < deArmAssetList.size(); i++) {
						assetEntity = deArmAssetList.get(i);
						if (woArmDearmEntityList != null) {
							if (!assetPresentInArming(assetNum, assetEntity, woArmDearmEntityList)) {
								armDearmEntity.setBuildItem(assetEntity.getBuildItem());
								armDearmEntity.setArmGIGNo(assetEntity.getArmGIGNo());
								armDearmEntity.setArmPosition(assetEntity.getArmPosition());
								armDearmEntity.setCurrentQuant(assetEntity.getCurrentQuant());
								armDearmEntity.setLotNo(assetEntity.getLotNo());
								armDearmEntity.setArmPosition(assetEntity.getArmPosition());
								armDearmEntity.setPartNo(assetEntity.getPartNo());
								armDearmEntity.setStationNo(assetEntity.getStationNo());
								armDearmEntity.setSerialNo(assetEntity.getSerialNo());
								woArmDearmEntityList.add(armDearmEntity);
							}
						}else {
							armDearmEntity.setBuildItem(assetEntity.getBuildItem());
							armDearmEntity.setArmGIGNo(assetEntity.getArmGIGNo());
							armDearmEntity.setArmPosition(assetEntity.getArmPosition());
							armDearmEntity.setCurrentQuant(assetEntity.getCurrentQuant());
							armDearmEntity.setLotNo(assetEntity.getLotNo());
							armDearmEntity.setArmPosition(assetEntity.getArmPosition());
							armDearmEntity.setPartNo(assetEntity.getPartNo());
							armDearmEntity.setStationNo(assetEntity.getStationNo());
							armDearmEntity.setSerialNo(assetEntity.getSerialNo());
							armingList.add(armDearmEntity);
						}
					}
					
					if (woArmDearmEntityList != null) {
						return woArmDearmEntityList;
					}else {
						return armingList;
					}
				}else {
					if (woArmDearmEntityList != null) {
						return woArmDearmEntityList;
					}
				}
			}catch(Exception e) {
					System.out.println("Error occured while Arming De-Arming data from repository");
					System.out.println(e.getMessage());
			}
		}
		return woArmDearmEntityList;
	}
	
	public boolean assetPresentInArming(String assetNum, ArmingAssetEntity assetEntity, List<WorkOrderArmDearmEntity> armingEntityList) {
		WorkOrderArmDearmEntity armDearmEntity = new WorkOrderArmDearmEntity();
		if (assetEntity.getAssetNum().equals(assetNum)) {
			for (int i=0; i < armingEntityList.size(); i++ ) {
				armDearmEntity = armingEntityList.get(i);
				if (assetEntity.getBuildItem().equals(armDearmEntity.getBuildItem())
						&& assetEntity.getArmGIGNo().equals(armDearmEntity.getArmGIGNo())
						&& assetEntity.getStationNo().equals(armDearmEntity.getStationNo())) {
					return true;
				}
			}
		}
		return false;
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
	
	public WorkOrderArmDearmEntity saveCurrentQuantityForRow(WorkOrderArmDearmEntity woArmDearmEntity, String workorderId){
		System.out.println("+++++++++++++Inside saveCurrentQuantityForRow+++++++++++++");
		woArmDearmResponseBean.reset();		
		StringBuffer str = new StringBuffer();
		List<WorkOrderArmDearmEntity> woBuildGigSelectiveList = new ArrayList<>(); 			
		if (workorderId!= null && woArmDearmEntity != null) {
			if (woArmDearmEntity.getBuildItem() != null
					&& woArmDearmEntity.getArmPosition() != null
					&& woArmDearmEntity.getArmGIGNo() != null) {
				System.out.println("+++++++++++++Inside saveCurrentQuantityForRow+++++++No value is null++++++");
				woArmDearmEntity.setWorkorderId(workorderId);
				woArmDearmEntity.setArmStatus("NEW");
				try {
					woBuildGigSelectiveList = woArmDearmRepo.getBuildItemGigNoRecords(woArmDearmEntity.getBuildItem(),woArmDearmEntity.getArmGIGNo(), woArmDearmEntity.getArmPosition(),workorderId);					
				}catch(Exception e){
					System.out.println("Error occured while Arming De-Arming data for specific Build Item,GIG NO.,ARM POSITION from repository");
					System.out.println(e.getMessage());
				}
				if (woBuildGigSelectiveList != null && woBuildGigSelectiveList.size() > 0) {
					System.out.println("+++++++++++++Inside saveCurrentQuantityForRow++++++woBuildGigSelectiveList>1+++++++");										
					woBuildGigSelectiveList.sort(Comparator.comparing(WorkOrderArmDearmEntity::getArm_id));										
					WorkOrderArmDearmEntity woArmDearmPrevious = woBuildGigSelectiveList.get(woBuildGigSelectiveList.size()-1);					
					if (woArmDearmPrevious != null && (woArmDearmPrevious.getEvaluatedQuant() != null && woArmDearmPrevious.getEvaluatedQuant() != 0) && (woArmDearmEntity.getCurrentQuant() == null || woArmDearmEntity.getCurrentQuant() == 0)) {
						System.out.println("+++++++++++++Inside getValuesForBuildType+++++PREVIOUS VALUE++++++++"+woBuildGigSelectiveList.get(woBuildGigSelectiveList.size()-1).getArm_id());						
						woArmDearmEntity.setCurrentQuant(woArmDearmPrevious.getEvaluatedQuant());
						System.out.println("+++++++++++++Inside getValuesForBuildType+++++CURRENT QUANTITY IS SET TO++++++++"+woArmDearmEntity.getCurrentQuant());			
						str.append("Current Quantity Load Successful");
					}else {
						woArmDearmEntity.setCurrentQuant(0);
						System.out.println("+++++++++++++Inside getValuesForBuildType+++++CURRENT QUANTITY IS SET TO++++++++"+woArmDearmEntity.getCurrentQuant());
					}
				}else {
					woArmDearmEntity.setCurrentQuant(0);
					System.out.println("+++++++++++++Inside getValuesForBuildType+++++CURRENT QUANTITY IS SET TO++++++++"+woArmDearmEntity.getCurrentQuant());
				}
					
					if (!str.equals(null)) {
						woArmDearmResponseBean.setCode(202);		
						woArmDearmResponseBean.setStatus(str.toString());
					} else {
						woArmDearmResponseBean.setCode(500);		
						woArmDearmResponseBean.setStatus("Current Quantity Update Failed");
					}
					//woArmDearmRepo.save(woArmDearmEntity);
					woArmDearmResponseBean.setCode(202);
					woArmDearmResponseBean.setStatus("Database Addition Successful");
					woArmDearmResponseBean.setAddArmStatus("New Build Item has been added successfully");
				}			
			}else {
				woArmDearmResponseBean.setCode(500);
				woArmDearmResponseBean.setStatus("Database Addition was not Successful");
				woArmDearmResponseBean.setAddArmStatus("New Build Item Addition Failed");
			}
			System.out.println("+++++++++++++End of addNewBuildItemRow+++++++++++++");
		return woArmDearmEntity;
	}
	
	public WorkOrderArmDearmEntity saveLoadandUnloadRow(WorkOrderArmDearmEntity woArmDearmEntity, String workorderId, String assetNum){
		System.out.println("+++++++++++++Start of saveLoadandUnloadRow+++++++++++++");
		int current = 0;
		int unload = 0;
		int evaluated =0;
		Optional<WorkOrderArmDearmEntity> woArmDearmEntityList = null;
		WorkOrderArmDearmEntity woArmDearmEntityFromDB = null;
		List<WorkOrderArmDearmEntity> woBuildGigSelectiveList = new ArrayList<>(); 
		if (workorderId!= null && woArmDearmEntity != null) {
			if (woArmDearmEntity.getBuildItem() != null
					&& woArmDearmEntity.getStationNo() != null
					&& woArmDearmEntity.getArmGIGNo() != null) {
				System.out.println("+++++++++++++Inside saveLoadandUnloadRow+++++++No value is null++++++");
				woArmDearmEntity.setWorkorderId(workorderId);
				woArmDearmEntity.setArmStatus("NEW");
				if (woArmDearmEntity.getArm_id() != null) {
					woArmDearmEntityList = woArmDearmRepo.findById(Integer.valueOf(woArmDearmEntity.getArm_id()));
					if (woArmDearmEntityList != null) {
						woArmDearmEntityFromDB = woArmDearmEntityList.get();
					}
				}
				
				if (woArmDearmEntity.getLoadQuant() != null && woArmDearmEntity.getLoadQuant() != 0) {
					woArmDearmEntity.setCurrentQuant(0);				
					System.out.println("+++++++++++++Inside saveLoadandUnloadRow+++++++LOAD QUANT IS NOT NULL OR 0++++++");											
					if (woArmDearmEntityFromDB != null) {
						System.out.println("+++++++++++++Inside saveLoadandUnloadRow+++++++ROW ALREADY EXISTS++++++"+woArmDearmEntity.getArm_id());
						System.out.println("+++++++++++++Inside saveLoadandUnloadRow+++++++ROW DATA PRESENT++++++");
						woArmDearmEntityFromDB.setArmDescription(woArmDearmEntity.getArmDescription());
						woArmDearmEntityFromDB.setArmGIGNo(woArmDearmEntity.getArmGIGNo());
						woArmDearmEntityFromDB.setArmPosition(woArmDearmEntity.getArmPosition());
						woArmDearmEntityFromDB.setArmRemarks(woArmDearmEntity.getArmRemarks());
						woArmDearmEntityFromDB.setBuildItem(woArmDearmEntity.getBuildItem());
						woArmDearmEntityFromDB.setCurrentQuant(0);
						woArmDearmEntityFromDB.setEvaluatedQuant(woArmDearmEntity.getLoadQuant());
						woArmDearmEntityFromDB.setLotNo(woArmDearmEntity.getLotNo());
						woArmDearmEntityFromDB.setStationNo(woArmDearmEntity.getStationNo());
						woArmDearmEntityFromDB.setSerialNo(woArmDearmEntity.getSerialNo());
						woArmDearmEntityFromDB.setLoadQuant(woArmDearmEntity.getLoadQuant());
						woArmDearmRepo.save(woArmDearmEntityFromDB);
						System.out.println("+++++++++++++Inside saveLoadandUnloadRow+++++++EXISTING ROW UPDATED++++++");
					}else {
						try {
							woBuildGigSelectiveList = woArmDearmRepo.getBuildItemGigNoRecords(woArmDearmEntity.getBuildItem(),woArmDearmEntity.getArmGIGNo(), woArmDearmEntity.getStationNo(),workorderId);
							if (woBuildGigSelectiveList != null && woBuildGigSelectiveList.size() > 0) {
								return null;
							}
						}catch(Exception e){
							System.out.println("Error occured while Arming De-Arming data for specific Build Item,GIG NO.,ARM POSITION from repository");
							System.out.println(e.getMessage());
						}
					System.out.println("+++++++++++++Inside saveLoadandUnloadRow+++NEW ROW INSERTING+++LOADING++++++"+woArmDearmEntity.getLoadQuant());
					woArmDearmEntity.setEvaluatedQuant(woArmDearmEntity.getLoadQuant());
					woArmDearmRepo.save(woArmDearmEntity);
				}											
			}else if (woArmDearmEntity.getUnloadQuant() != null && woArmDearmEntity.getUnloadQuant() != 0) {
				System.out.println("+++++++++++++Inside saveLoadandUnloadRow+++++++UN LOAD QUANT IS NOT NULL OR 0++++++");
				if (woArmDearmEntity.getCurrentQuant() != null) {
					current = woArmDearmEntity.getCurrentQuant();
					System.out.println("+++++++++++++Inside saveLoadandUnloadRow+++++++CURRENT QUANT++++++"+current);
				}
				if (woArmDearmEntity.getUnloadQuant() != null) {
					unload = woArmDearmEntity.getUnloadQuant();
					System.out.println("+++++++++++++Inside saveLoadandUnloadRow+++++++UNLOAD QUANT++++++"+unload);
				}
				if (unload != 0 && current > unload) {
					System.out.println("+++++++++++++Inside saveLoadandUnloadRow+++++++UNLOAD QUANT NOT 0++++ROW ALREADY EXISTS++++"+unload);
					evaluated = current - unload;
					if (woArmDearmEntityFromDB != null) {
						System.out.println("+++++++++++++Inside saveLoadandUnloadRow+++ROW ALREADY EXISTS++++EVALUATED QUANT FOR UNLOADING++++++"+evaluated);
						woArmDearmEntity.setEvaluatedQuant(evaluated);
						woArmDearmRepo.updateArmingDeArmingEntry(String.valueOf(unload), String.valueOf(evaluated), String.valueOf(woArmDearmEntity.getArm_id()));
						System.out.println("+++++++++++++Inside saveLoadandUnloadRow+++++++EXISTING ROW UPDATED FOR UNLOAD++++++");
					}else {
						System.out.println("+++++++++++++Inside saveLoadandUnloadRow+++++++NEW ROW BEING ADDED FOR UNLOAD++++++"+unload);
						woArmDearmEntity.setEvaluatedQuant(evaluated);
						woArmDearmRepo.save(woArmDearmEntity);
						System.out.println("+++++++++++++Inside saveLoadandUnloadRow+++++++NEW ROW ADDED FOR UNLOAD++++++");
					}
				}
				}
			}
		}
		System.out.println("+++++++++++++End of saveLoadandUnloadRow+++++++++++++");
		return woArmDearmEntity;
	}
	
	/**
	 * Method to change the status to 'COMPLETED' for a row and update the same in the database. 
	 * @param workOrderArmDearmEntity
	 * @param workorderId
	 * @return
	 */
	public WorkOrderArmDearmEntity onLoadClickItem (WorkOrderArmDearmEntity workOrderArmDearmEntity, String workorderId, String assetNum) {
		System.out.println("+++++++++++++Inside onLoadClickItem+++++++++++++");
		StringBuffer str = new StringBuffer();
		if (workOrderArmDearmEntity != null && workorderId != null && workOrderArmDearmEntity.getArm_id() != null) {
			Optional<WorkOrderArmDearmEntity> woArmDearmEntityList = woArmDearmRepo.findById(workOrderArmDearmEntity.getArm_id());		
			WorkOrderArmDearmEntity woArmDearmEntity = woArmDearmEntityList.get();
			if (woArmDearmEntity != null) {
				System.out.println("+++++++++++++Inside onLoadClickItem+++++++woArmDearmEntity IS NOT NULL++++++");
				if (woArmDearmEntity.getArmStatus() != null && !woArmDearmEntity.getArmStatus().equals(con.COMP_STATUS)) {
					System.out.println("+++++++++++++Inside onLoadClickItem+++++++SETTING ARM STATUS++++++");
					woArmDearmEntity.setArmStatus(con.COMP_STATUS);
					str.append("Status Update to COMPLETED Successful");
				}
				woArmDearmRepo.save(woArmDearmEntity);
				
				if (assetNum != null ) {
					System.out.println("+++++++++++++Inside onLoadClickItem+++++++ASSETNUM NOT NULL++++++");
					if (workOrderArmDearmEntity.getUnloadQuant() != 0 && workOrderArmDearmEntity.getUnloadQuant() != null) {
						System.out.println("+++++++++++++Inside onLoadClickItem+++++++UNLOAD TYPE OF BUILD ITEM++++++");
						List<ArmingAssetEntity> armingAssetEntity = woArmDearmAssetRepo.getAssetRecord(woArmDearmEntity.getBuildItem(),woArmDearmEntity.getArmGIGNo(), woArmDearmEntity.getStationNo(), assetNum);
						if (armingAssetEntity != null && armingAssetEntity.get(0) != null) {
							System.out.println("+++++++++++++Inside onLoadClickItem+++++++armingAssetEntity.get(0) IS NOT NULL++++++");
							ArmingAssetEntity armAsset = armingAssetEntity.get(0);
							if (woArmDearmEntity.getEvaluatedQuant() != 0) {
								System.out.println("+++++++++++++Inside onLoadClickItem+++++++EVALUATED IS NOT ZERO++++++");
								armAsset.setCurrentQuant(woArmDearmEntity.getEvaluatedQuant());
								woArmDearmAssetRepo.save(armAsset);
							}else {
								System.out.println("+++++++++++++Inside onLoadClickItem+++++++EVALUATED IS ZERO++++++");
								armAsset.setCurrentQuant(0);
								WOArmingHistoryEntity armingHistoryEntity = new WOArmingHistoryEntity();
								armingHistoryEntity.setArmGIGNo(armAsset.getArmGIGNo());
								armingHistoryEntity.setArmPosition(armAsset.getArmPosition());
								armingHistoryEntity.setAssetNum(armAsset.getAssetNum());
								armingHistoryEntity.setBuildItem(armAsset.getBuildItem());
								armingHistoryEntity.setCurrentQuant(0);
								armingHistoryEntity.setLotNo(armAsset.getLotNo());
								armingHistoryEntity.setPartNo(armAsset.getPartNo());
								armingHistoryEntity.setSerialNo(armAsset.getSerialNo());
								armingHistoryEntity.setStationNo(armAsset.getStationNo());
								woArmingHistoryRepo.save(armingHistoryEntity);
								woArmDearmAssetRepo.deleteById(armAsset.getArmingAssetId());
								System.out.println("+++++++++++++Inside onLoadClickItem+++++++ROW SAVED IN HISTORY AND REMOVED FROM ASSET++++++");
							}
						}
					}else if (workOrderArmDearmEntity.getLoadQuant() != null && workOrderArmDearmEntity.getLoadQuant() != 0) {
						System.out.println("+++++++++++++Inside onLoadClickItem+++++++LOAD TYPE OF BUILD ITEM++++++");
						ArmingAssetEntity armAssetLoad = new ArmingAssetEntity();
						armAssetLoad.setArmGIGNo(workOrderArmDearmEntity.getArmGIGNo());
						armAssetLoad.setArmPosition(workOrderArmDearmEntity.getArmPosition());
						armAssetLoad.setAssetNum(assetNum);
						armAssetLoad.setBuildItem(workOrderArmDearmEntity.getBuildItem());
						armAssetLoad.setCurrentQuant(workOrderArmDearmEntity.getLoadQuant());
						armAssetLoad.setLotNo(workOrderArmDearmEntity.getLotNo());
						armAssetLoad.setPartNo(workOrderArmDearmEntity.getPartNo());
						armAssetLoad.setSerialNo(workOrderArmDearmEntity.getSerialNo());
						armAssetLoad.setStationNo(workOrderArmDearmEntity.getStationNo());
						System.out.println("+++++++++++++Inside onLoadClickItem+++++++NEW ROW INSERTED IN ASSET TABLE++++++");
					}
				}
			}		
		}
		if (!str.equals(null)) {
			woArmDearmResponseBean.setCode(202);		
			woArmDearmResponseBean.setStatus(str.toString());
		} else {
			woArmDearmResponseBean.setCode(500);		
			woArmDearmResponseBean.setStatus("Status Update Failed");
		}
		System.out.println("+++++++++++++End of onLoadClickItem+++++++++++++");	
		return workOrderArmDearmEntity;
	}
	
	/**
	 * This method deletes the entry for a particular build item row in database.
	 * @param arm_id
	 * @param assetNum
	 * @return
	 */
	public WorkOrderArmDearmResponseBean deleteBuildItem(String arm_id, String assetNum) {
		System.out.println("++++++++++++++++Inside deleteBuildItem++++++++++++++++");
		woArmDearmResponseBean.reset();
		List<ArmingAssetEntity> assetList= new ArrayList<>();
		int unloadQuant = 0;
		if (arm_id != null && assetNum != null) {
			System.out.println("++++++++++++++++Inside deleteBuildItem++++++++++NO PARAM IS NULL++++++");
			Optional<WorkOrderArmDearmEntity> woArmDearmEntityList = woArmDearmRepo.findById(Integer.valueOf(arm_id));
			WorkOrderArmDearmEntity woArmDearmEntity = woArmDearmEntityList.get();
			if (woArmDearmEntity != null) {
				System.out.println("++++++++++++++++Inside deleteBuildItem++++++++++RECORD FOUND IN ARMING DEARMING TABLE++++++");
				if (woArmDearmEntity.getLoadQuant() != null && woArmDearmEntity.getLoadQuant() != 0) { //If it is a build item for LOAD
					System.out.println("++++++++++++++++Inside deleteBuildItem++++++++++FOR LOADING RECORD++++++");
					woArmDearmRepo.deleteById(Integer.valueOf(arm_id));
				}else if (woArmDearmEntity.getUnloadQuant() != null && woArmDearmEntity.getUnloadQuant() != 0) { //If it is a build item for UNLOAD
					System.out.println("++++++++++++++++Inside deleteBuildItem++++++++++FOR UNLOADING RECORD++++++");
					unloadQuant = woArmDearmEntity.getUnloadQuant();
					System.out.println("++++++++++++++++Inside deleteBuildItem++++++++++FOR UNLOADING RECORD++++++UNLOAD QUANT="+unloadQuant);
					woArmDearmRepo.deleteById(Integer.valueOf(arm_id));
					System.out.println("++++++++++++++++Inside deleteBuildItem++++++++++FOR UNLOADING RECORD++++++DELETED IN ARMING DEARMING TABLE++++++++");
					assetList = woArmDearmAssetRepo.getAssetRecord(woArmDearmEntity.getBuildItem(),woArmDearmEntity.getArmGIGNo(),woArmDearmEntity.getStationNo(),assetNum);
					if (assetList != null) {
						System.out.println("++++++++++++++++Inside deleteBuildItem++++++++++FOR UNLOADING RECORD++++++RECORD FOUND IN ASSET TABLE++++++++");
						ArmingAssetEntity assetEntity = assetList.get(0);
						unloadQuant = unloadQuant+assetEntity.getCurrentQuant();
						System.out.println("++++++++++++++++Inside deleteBuildItem++++++++++FOR UNLOADING RECORD++++++FINAL UNLOAD QUANT="+unloadQuant);
						assetEntity.setCurrentQuant(unloadQuant);
						woArmDearmAssetRepo.save(assetEntity);
						System.out.println("++++++++++++++++Inside deleteBuildItem++++++++++FOR UNLOADING RECORD++++++RECORD[CQ] UPDATED IN ASSET TABLE");
					}
				}
			}			
			woArmDearmResponseBean.setCode(202);
			woArmDearmResponseBean.setStatus("Database Deletion Successful");
			woArmDearmResponseBean.setAddArmStatus("Build Item has been deleted successfully");
		}
		System.out.println("++++++++++++++++END deleteBuildItem++++++++++++++++");
		return woArmDearmResponseBean;
	}
	
	/**
	 * Method to calculate the Evaluated Quantity for a row and change the status to 'COMPLETED' 
	 * for the same in the database. Updates the Current Quantity in the Arming/De-Arming to the 
	 * above calculated Evaluated Quantity for a particular Build Item,Station No and Armament/GIG No.
	 * @param workOrderArmDearmEntity
	 * @param workorderId
	 * @return
	 */
/*	public WorkOrderArmDearmEntity onLoadClickItem (WorkOrderArmDearmEntity workOrderArmDearmEntity, String workorderId, String assetNum) {
		System.out.println("+++++++++++++Inside onLoadClickItem+++++++++++++");
		StringBuffer str = new StringBuffer();
		int current = 0;
		int load = 0;
		int unload = 0;
		int evaluated =0;
		if (workOrderArmDearmEntity != null) {
			Optional<WorkOrderArmDearmEntity> woArmDearmEntityList = woArmDearmRepo.findById(Integer.valueOf(workOrderArmDearmEntity.getArm_id()));		
			WorkOrderArmDearmEntity woArmDearmEntity = woArmDearmEntityList.get();
			if (woArmDearmEntity != null) {
				System.out.println("+++++++++++++Inside onLoadClickItem+++++++woArmDearmEntity IS NOT NULL++++++");
				if (woArmDearmEntity.getCurrentQuant() != null) {
					//current = workOrderArmDearmEntity.getCurrentQuant();
					current = woArmDearmEntity.getCurrentQuant();
					System.out.println("+++++++++++++Inside onLoadClickItem+++++++CURRENT QUANT++++++"+current);
				}
				if (woArmDearmEntity.getLoadQuant() != null) {
					//load = workOrderArmDearmEntity.getLoadQuant();
					load = woArmDearmEntity.getLoadQuant();
					System.out.println("+++++++++++++Inside onLoadClickItem+++++++LOAD QUANT++++++"+load);
				}
				if (woArmDearmEntity.getUnloadQuant() != null) {
					//unload = workOrderArmDearmEntity.getUnloadQuant();
					unload = woArmDearmEntity.getUnloadQuant();
					System.out.println("+++++++++++++Inside onLoadClickItem+++++++UNLOAD QUANT++++++"+unload);
				}
				if (woArmDearmEntity.getEvaluatedQuant() != null) {
					evaluated = workOrderArmDearmEntity.getEvaluatedQuant();
					System.out.println("+++++++++++++Inside onLoadClickItem+++++++EVALUATED QUANT++++++"+evaluated);
				}
				if (load != 0) {
					evaluated = current + load;
				}
				if (unload != 0 && current > unload) {
					System.out.println("+++++++++++++Inside onLoadClickItem+++++++UNLOAD QUANT NOT 0++++++"+unload);
					evaluated = current - unload;
					System.out.println("+++++++++++++Inside onLoadClickItem+++++++EVALUATED QUANT FOR UNLOADING++++++"+evaluated);
					if (assetNum != null ) {
						System.out.println("+++++++++++++Inside onLoadClickItem+++++++ASSETNUM NOT NULL++++++");
						List<ArmingAssetEntity> armingAssetEntity = woArmDearmAssetRepo.getAssetRecord(woArmDearmEntity.getBuildItem(),woArmDearmEntity.getArmGIGNo(), woArmDearmEntity.getStationNo(), assetNum);
						if (armingAssetEntity != null && armingAssetEntity.get(0) != null) {
							System.out.println("+++++++++++++Inside onLoadClickItem+++++++armingAssetEntity.get(0) IS NOT NULL++++++");
							ArmingAssetEntity armAsset = armingAssetEntity.get(0);
							if (evaluated != 0) {
								System.out.println("+++++++++++++Inside onLoadClickItem+++++++EVALUATED IS NOT ZERO++++++");
								armAsset.setCurrentQuant(evaluated);
								woArmDearmAssetRepo.save(armAsset);
							}else {
								System.out.println("+++++++++++++Inside onLoadClickItem+++++++EVALUATED IS ZERO++++++");
								armAsset.setCurrentQuant(0);
								WOArmingHistoryEntity armingHistoryEntity = new WOArmingHistoryEntity();
								armingHistoryEntity.setArmGIGNo(armAsset.getArmGIGNo());
								armingHistoryEntity.setArmPosition(armAsset.getArmPosition());
								armingHistoryEntity.setAssetNum(armAsset.getAssetNum());
								armingHistoryEntity.setBuildItem(armAsset.getBuildItem());
								armingHistoryEntity.setCurrentQuant(0);
								armingHistoryEntity.setLotNo(armAsset.getLotNo());
								armingHistoryEntity.setPartNo(armAsset.getPartNo());
								armingHistoryEntity.setSerialNo(armAsset.getSerialNo());
								armingHistoryEntity.setStationNo(armAsset.getStationNo());
								woArmingHistoryRepo.save(armingHistoryEntity);
								woArmDearmAssetRepo.deleteById(armAsset.getArmingAssetId());
							}
						}							
					}
				}
				System.out.println("+++++++++++++Inside onLoadClickItem+++++++BEFORE SETTING EVAL QUANT++++++"+unload);
				woArmDearmEntity.setEvaluatedQuant(evaluated);
				if (woArmDearmEntity.getArmStatus() != null && !woArmDearmEntity.getArmStatus().equals(con.COMP_STATUS)) {
					System.out.println("+++++++++++++Inside onLoadClickItem+++++++SETTING ARM STATUS++++++"+unload);
					woArmDearmEntity.setArmStatus(con.COMP_STATUS);
					str.append("Status Update to COMPLETED Successful");
				}
				woArmDearmRepo.save(woArmDearmEntity);
			}		
			str.append("Evaluated Quantity Load Successful");
			}
		if (!str.equals(null)) {
			woArmDearmResponseBean.setCode(202);		
			woArmDearmResponseBean.setStatus(str.toString());
		} else {
			woArmDearmResponseBean.setCode(500);		
			woArmDearmResponseBean.setStatus("Evaluated Quantity and Status Update Failed");
		}
		System.out.println("+++++++++++++End of onLoadClickItem+++++++++++++");	
		return workOrderArmDearmEntity;
	} */
	
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
	
	/*	public WorkOrderArmDearmResponseBean addNewBuildItemRow(WorkOrderArmDearmEntity woArmDearmEntity, String workorderId,String arm_id){
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
}*/

/*public WorkOrderArmDearmResponseBean onLoadClickItem (String armId) {
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
}*/
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
}