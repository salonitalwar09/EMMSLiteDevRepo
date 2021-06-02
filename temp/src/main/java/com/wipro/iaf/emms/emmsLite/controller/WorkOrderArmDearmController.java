package com.wipro.iaf.emms.emmsLite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.iaf.emms.emmsLite.beans.WorkOrderArmDearmResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.ArmGIGEntity;
import com.wipro.iaf.emms.emmsLite.entity.ArmingAssetEntity;
import com.wipro.iaf.emms.emmsLite.entity.BuildItemEntity;
import com.wipro.iaf.emms.emmsLite.entity.WorkOrderArmDearmEntity;
import com.wipro.iaf.emms.emmsLite.services.WorkOrderArmDeArmService;

/**
 * 
 * @author Saloni Talwar
 * Changes done for EMMS Lite Project
 * Created on 06/04/2021
 * Description - This class is the controller for the Arming/De-Arming Screen 
 * under Work Order. 
 */

@RestController
@RequestMapping("/emmsLite")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WorkOrderArmDearmController {

	@Autowired
	private WorkOrderArmDeArmService workOrderArmDeArmService;
	
	/**
	 * Method to view all the entries for the Arming/De-Arming for a particular Work Order of type A-REM 
	 * applicable for unloading only.
	 * @param workOrderId
	 * @return
	 */
	@GetMapping("/viewWODeArmUnload/{assetNum}")
	public List<ArmingAssetEntity> getEnteriesForUnload(@PathVariable("assetNum")String assetNum)
	{
		System.out.println("++++++Begin viewWODearmUnload+++Controller++++FOR UNLOAD");
		return workOrderArmDeArmService.getAllWOUnloadRecords(assetNum);
	}
	
	/**
	 * Method to view the Armament Item list/GIG No. list
	 * @return ArmGIGEntity
	 */
	@GetMapping("/viewArmamentItemDD")
	public List<ArmGIGEntity> getArmamentItemList()
	{
		System.out.println("getArmamentItemList");
		return workOrderArmDeArmService.getArmamentItemDDList();
	}
	
	/**
	 * Method to view the build item list that are of type Hard Point
	 * @return BuildItemEntity
	 */
	@GetMapping("/viewBuildItem")
	public List<BuildItemEntity> getValuesForBuildType()
	{
		System.out.println("getValuesForBuildType");
		return workOrderArmDeArmService.getValuesForBuildType();
	}
			
	/**
	 * Method to save the complete row of the Arming/DeArming and calculate the current quantity
	 * @param woArmDearmEntity
	 * @param workorderId
	 * @param arm_id
	 * @return WorkOrderArmDearmEntity
	 */
	@PostMapping("/saveNewRowBuildItem/{workOrderId}")
	public ResponseEntity<WorkOrderArmDearmEntity> saveCurrentQuantity(@RequestBody WorkOrderArmDearmEntity woArmDearmEntity, @PathVariable("workOrderId") String workorderId){
		try {
			System.out.println("++++++++Inside saveCurrentQuantity Controller+++WORKORDERID:: "+workorderId);			
			return  new ResponseEntity<>(workOrderArmDeArmService.saveCurrentQuantityForRow(woArmDearmEntity, workorderId), HttpStatus.OK);
		} catch (Exception e) {
			return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
	
	/**
	 * Method to save the complete row of the Arming/DeArming for loading asset in the A-CON/A-FIT Work Order type.
	 * It calculates the evaluated quantity and enters the values in database with status as 'NEW'.
	 * It also updates the 'ASSET' table with the new entry.
	 * @param woArmDearmEntity
	 * @param workorderId
	 * @return WorkOrderArmDearmEntity
	 */
	@PostMapping("/saveNewRowForLoad/{workOrderId}/{assetNum}")
	public ResponseEntity<WorkOrderArmDearmEntity> saveControllerForLoad(@RequestBody WorkOrderArmDearmEntity woArmDearmEntity, @PathVariable("workOrderId") String workorderId, @PathVariable("assetNum")String assetNum){
		try {
			System.out.println("++++++++Inside saveCurrentRowForLoad Controller+++WORKORDERID:: "+workorderId);			
			return  new ResponseEntity<>(workOrderArmDeArmService.saveLoadandUnloadRow(woArmDearmEntity, workorderId, assetNum), HttpStatus.OK);
		} catch (Exception e) {
			return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
	
	/**
	 * Method to calculate the evaluated quantity and update status for Build Item of the Arming/DeArming
	 * @param workOrderArmDearmEntity
	 * @param workorderId
	 * @return WorkOrderArmDearmEntity
	 */
	@PostMapping("/onLoadClick/{workorderId}/{assetNum}")	
	public ResponseEntity<WorkOrderArmDearmEntity> onLoadClick(@RequestBody WorkOrderArmDearmEntity workOrderArmDearmEntity,@PathVariable("workorderId")String workorderId,@PathVariable("assetNum")String assetNum)
	{
		try {
			System.out.println("++++++++Inside onLoadClick Controller+++WORKORDERID:: "+workorderId+"+++++ASSETNUM:: "+assetNum);			
			return  new ResponseEntity<>(workOrderArmDeArmService.onLoadClickItem(workOrderArmDearmEntity,workorderId,assetNum), HttpStatus.OK);
		} catch (Exception e) {
			return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}	
	}
	
	/**
	 * Method to delete the evaluated quantity of the Arming/DeArming
	 * @param arm_id
	 * @return WorkOrderArmDearmResponseBean
	 */ 
	@PutMapping("/deleteBuildItemRow/{armidpk}")
	public ResponseEntity<WorkOrderArmDearmResponseBean> deleteBuildItemRow(@PathVariable("armidpk")String arm_id){
		return new ResponseEntity<>(workOrderArmDeArmService.deleteBuildItem(arm_id),HttpStatus.OK);
	}
	
	/**
	 * Method to view all the entries for the Arming/De-Arming for a particular Work Order
	 * @param workOrderId
	 * @return
	 */
	/*@GetMapping("/viewWOArmDeArm/{workOrderId}")
	public List<WorkOrderArmDearmEntity> getWOArmDearmEntityList(@PathVariable("workOrderId")String workOrderId)
	{
		System.out.println("getWOArmDearmEntityList");
		return workOrderArmDeArmService.getAllWOArmDeArming(workOrderId);
	}*/
}
