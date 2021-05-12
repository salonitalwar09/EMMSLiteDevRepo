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
import com.wipro.iaf.emms.emmsLite.entity.AssetInsRemEntity;
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
	
	//To view all the entries for the Arming/De-Arming for a particular WO
	@GetMapping("/viewWOArmDeArm/{workOrderId}")
	public List<WorkOrderArmDearmEntity> getWOArmDearmEntityList(@PathVariable("workOrderId")String workOrderId)
	{
		System.out.println("getWOArmDearmEntityList");
		return workOrderArmDeArmService.getAllWOArmDeArming(workOrderId);
	}
	
	//To view the Armament Item list/GIG No. list
	@GetMapping("/viewArmamentItemDD")
	public List<ArmGIGEntity> getArmamentItemList()
	{
		System.out.println("getArmamentItemList");
		return workOrderArmDeArmService.getArmamentItemDDList();
	}
	
	//To view the Armament Description for a particular hard point build item
/*	@GetMapping("/viewArmDesc/{armamentNo}")
	public String getArmamentDescription(@PathVariable("armamentNo") String armGIGNo)
	{
		System.out.println("getArmamentDescription");
		return workOrderArmDeArmService.getArmDescription(armGIGNo);
	}
*/
	//To view the build item list that are of type Hard Point
	@GetMapping("/viewBuildItem")
	public List<BuildItemEntity> getValuesForBuildType()
	{
		System.out.println("getValuesForBuildType");
		return workOrderArmDeArmService.getValuesForBuildType();
	}
	
	//To view the station no for a particular hard point build item
/*	@GetMapping("/viewStationNo/{buildItem}")
	public String getStationNoValue(@PathVariable("buildItem") String builditem)
	{
		System.out.println("getStationNoList");
		return workOrderArmDeArmService.getStationNoForBuildItem(builditem);
	}
*/			
	//To save the complete row of the Arming/DeArming and calculate the current quantity
	@PostMapping("/saveNewRowBuildItem/{workOrderId}/{armpk_id}")
	public WorkOrderArmDearmEntity saveCurrentQuantity(@RequestBody WorkOrderArmDearmEntity woArmDearmEntity, @PathVariable("workOrderId") String workorderId, @PathVariable("armpk_id") String arm_id){
		return workOrderArmDeArmService.saveCurrentQuantityForRow(woArmDearmEntity, workorderId);
	}
	
	//To calculate the evaluated quantity and update status for Build Item of the Arming/DeArming
	@GetMapping("/onLoadClick/{workorderId}")	
	public WorkOrderArmDearmEntity onLoadClick(@RequestBody WorkOrderArmDearmEntity workOrderArmDearmEntity,@PathVariable("workorderId")String workorderId)
	{
		System.out.println("onLoadClick");
		return workOrderArmDeArmService.onLoadClickItem(workOrderArmDearmEntity,workorderId);	
	}
	
	//To delete the evaluated quantity of the Arming/DeArming
	@PutMapping("/deleteBuildItemRow/{armidpk}")
	public ResponseEntity<WorkOrderArmDearmResponseBean> deleteBuildItemRow(@PathVariable("armidpk")String arm_id){
		return new ResponseEntity<>(workOrderArmDeArmService.deleteBuildItem(arm_id),HttpStatus.OK);
	}
}
