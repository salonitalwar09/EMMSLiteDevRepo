package com.wipro.iaf.emms.emmsLite.controller;

/**
 * @author Shivam
 * Date:: 06 April 2021
 * Description:: Workorder controller to view workorder, create workorder, change status
 *
 */

import java.util.*;

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

import com.wipro.iaf.emms.emmsLite.Repository.WorkOrderRepository;
import com.wipro.iaf.emms.emmsLite.beans.WorkOrderResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.WorkOrderEntity;
import com.wipro.iaf.emms.emmsLite.services.WorkOrderService;


@RestController
@RequestMapping("/emmsLite")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WorkOrderController {
	@Autowired
	private WorkOrderEntity workorderentity;
	@Autowired
	private WorkOrderService workorderservice;
	@Autowired
	private WorkOrderRepository workOrderRepository;
	@Autowired
	WorkOrderResponseBean workorderResponseBean;


	@GetMapping("/viewWO")
	public List<WorkOrderEntity> getAllWOList()
	{
		System.out.println("getAllWOList");
		return workorderservice.getAllWorkOrder();
	}

	@GetMapping("/getWO/{workorder_id}")
	public ResponseEntity<WorkOrderEntity> getWorkorderById(@PathVariable("workorder_id") Long workOrderID)
	{
		try {
			System.out.println("Workorder based on WOID:: "+workOrderID);
			WorkOrderEntity workOrderSet = workorderservice.workOrderID(workOrderID);
			System.out.println("WorkOrderSet :: ");
			return  new ResponseEntity<>(workOrderSet, HttpStatus.OK);
		} catch (Exception e) {
			return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}

	@PutMapping("/editWO/{workorder_id}")
	public ResponseEntity<WorkOrderResponseBean> editWorkorderById(@PathVariable("workorder_id") Long workOrderID, @RequestBody WorkOrderEntity workorderentity)
	{
		try {
			System.out.println("edit Workorder based on WOID:: "+workOrderID);
			WorkOrderResponseBean workOrderResponseBean= workorderservice.editWorkOrder(workorderentity, workOrderID);
			return  new ResponseEntity<>(workOrderResponseBean, HttpStatus.OK);	
		} catch (Exception e) {
			return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
	@GetMapping("/genWO")
	public ResponseEntity<WorkOrderResponseBean> genWoNum()
	{
		try {
			System.out.println("Generate WoNum Method ");
			WorkOrderResponseBean workOrderResponseBean =workorderservice.genWoNum(workorderentity);
			return  new ResponseEntity<>( workOrderResponseBean, HttpStatus.OK);	
		} catch (Exception e) {
			return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
	@PostMapping("/createWO")
	public ResponseEntity<WorkOrderResponseBean> createWO(@RequestBody WorkOrderEntity workorderentity){
		try {
			System.out.println("Create WorkOrder ::" +workorderentity);
			WorkOrderResponseBean workOrderResponseBean =workorderservice.createWO(workorderentity);
			return new ResponseEntity<>(workOrderResponseBean,HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
}
