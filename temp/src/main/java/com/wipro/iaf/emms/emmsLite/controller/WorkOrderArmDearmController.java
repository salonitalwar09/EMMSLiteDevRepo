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

import com.wipro.iaf.emms.emmsLite.Repository.WorkOrderArmDearmRepository;
import com.wipro.iaf.emms.emmsLite.beans.WorkOrderArmDearmResponseBean;
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
	
	@Autowired
	private WorkOrderArmDearmRepository workOrderArmDearmRepo;
	
	@Autowired
	private WorkOrderArmDearmResponseBean woArmDearmResponseBean;
	
	//To view all the entries for the Arming/De-Arming for a particular WO
	@GetMapping("/viewWOArmDeArm")
	public List<WorkOrderArmDearmEntity> getWOArmDearmEntityList()
	{
		System.out.println("getWOArmDearmEntityList");
		return workOrderArmDeArmService.getAllWOArmDeArming();
	}
	
	//To view the Armament Item list/GIG No. list
	@GetMapping("/viewArmamentItemDD")
	public List<String> getArmamentItemList()
	{
		System.out.println("getArmamentItemList");
		return workOrderArmDeArmService.getArmamentItemDDList();
	}
	
	//To view the Armament Description for a particular hard point build item
	@GetMapping("/viewArmDesc/{armamentNo}")
	public String getArmamentDescription(@PathVariable("armamentNo") String armGIGNo)
	{
		System.out.println("getArmamentDescription");
		return workOrderArmDeArmService.getArmDescription(armGIGNo);
	}
	
	//To view the build item list that are of type Hard Point
	@GetMapping("/viewBuildItem/{buildItemType}")
	public List<String> getValuesForBuildType(@PathVariable("buildItemType") String buildType)
	{
		System.out.println("getValuesForBuildType");
		return workOrderArmDeArmService.getValuesForBuildType(buildType);
	}
	
	//To view the station no for a particular hard point build item
	@GetMapping("/viewStationNo/{buildItem}")
	public String getStationNoValue(@PathVariable("buildItem") String builditem)
	{
		System.out.println("getStationNoList");
		return workOrderArmDeArmService.getStationNoForBuildItem(builditem);
	}
			
	//To save the complete row of the Arming/DeArming
	@PostMapping("/saveNewRowBuildItem/{workOrderId}")
	public ResponseEntity<WorkOrderArmDearmResponseBean> addNewBuildItem(@RequestBody WorkOrderArmDearmEntity woArmDearmEntity, @PathVariable("workOrderId") String workorderId){
		return new ResponseEntity<>(workOrderArmDeArmService.addNewBuildItemRow(woArmDearmEntity, workorderId),HttpStatus.OK);
	}
	
	//To calculate the evaluated quantity and update status for Build Item of the Arming/DeArming
	@GetMapping("/onLoadClick/{armId}")	
	public ResponseEntity<WorkOrderArmDearmResponseBean> onLoadClick(@PathVariable("armId")String arm_Id)
	{
		System.out.println("onLoadClick");
		return new ResponseEntity<>(workOrderArmDeArmService.onLoadClickItem(arm_Id),HttpStatus.OK);	
	}
	
	//To delete the evaluated quantity of the Arming/DeArming
	@PutMapping("/deleteBuildItemRow/{armidpk}")
	public ResponseEntity<WorkOrderArmDearmResponseBean> deleteBuildItemRow(@PathVariable("armidpk")String arm_id){
		return new ResponseEntity<>(workOrderArmDeArmService.deleteBuildItem(arm_id),HttpStatus.OK);
	}
}
