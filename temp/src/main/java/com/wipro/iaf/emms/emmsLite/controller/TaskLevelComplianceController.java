/**
 * TaskLevelComplianceController is the Controller class to handle screen for Work Order Task Level Compliance
 */
package com.wipro.iaf.emms.emmsLite.controller;

import java.util.List;
import java.util.Map;

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

import com.wipro.iaf.emms.emmsLite.Repository.PostFlightDataRepository;
import com.wipro.iaf.emms.emmsLite.Repository.TaskLevelComplianceRepository;
import com.wipro.iaf.emms.emmsLite.beans.WorkOrderResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.LoginEntity;
import com.wipro.iaf.emms.emmsLite.entity.PersonEntity;
import com.wipro.iaf.emms.emmsLite.entity.PostFlightDataEntity;
import com.wipro.iaf.emms.emmsLite.entity.TaskLevelComplianceEntity;
import com.wipro.iaf.emms.emmsLite.entity.WorkOrderEntity;
import com.wipro.iaf.emms.emmsLite.services.TaskLevelComplianceService;
import com.wipro.iaf.emms.emmsLite.services.WorkOrderService;

/**
 * @author Resham Das
 *
 */

@RestController
@RequestMapping("/emmsLite")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskLevelComplianceController {
	@Autowired
	private TaskLevelComplianceService taskLevelComplianceService;
	@Autowired
	private TaskLevelComplianceRepository taskLevelComplianceRepository;
	/*@Autowired
	private TaskLevelComplianceEntity taskLevelComplianceEntity;*/
	@Autowired
	private WorkOrderService workOrderService;
	@Autowired
	private WorkOrderEntity workOrderEntity;
	/*@Autowired
	private PersonEntity personEntity;*/
	
	/*@GetMapping("/fetchWorkOrderDetails")
	public List<WorkOrderEntity> getAllWorkOrderDetailsList()
	{
		System.out.println("Inside TaskLevelComplianceController getAllWorkOrderDetailsList: Request reached /emmsLite/fetchWorkOrderDetails Controller");
		return workOrderService.getAllWO();
	}*/
	
	@GetMapping("/fetchTechnicianDetails")
	public List<PersonEntity> fetchAllTechnicianDetails()
	{
		System.out.println("Inside TaskLevelComplianceController getAllTechnicianDetails: Request reached /emmsLite/fetchTechnicianDetails Controller");
		return taskLevelComplianceService.fetchAllTechnicianDetails();
	}
	
	@GetMapping("/fetchTechnicianName/{servicenum}")
	//public String fetchTechnicianName(@PathVariable("servicenum") String servicenum, @RequestBody TaskLevelComplianceEntity inputTaskLevelComplianceEntity)
	public String fetchTechnicianName(@PathVariable("servicenum") String servicenum)
	{
		System.out.println("Inside TaskLevelComplianceController getAllPersonDetailsList: Request reached /emmsLite/fetchTechnicianName Controller");
		return taskLevelComplianceService.fetchPersonName(servicenum);
	}
	
	@PostMapping("/createTaskLevelCompliance/{workorderid}")
	public ResponseEntity<String> createTaskLevelCompliance(@PathVariable("workorderid") String workorderid, @RequestBody TaskLevelComplianceEntity inputTaskLevelComplianceEntity){
		System.out.println("Inside TaskLevelComplianceController createTaskLevelCompliance: Request reached /emmsLite/createTaskLevelCompliance Controller");
		try {
			TaskLevelComplianceEntity taskLevelComplianceEntity = taskLevelComplianceService.createTaskLevelCompliance(workorderid, inputTaskLevelComplianceEntity);
			System.out.println("Inside TaskLevelComplianceController createTaskLevelCompliance: TaskLevelCompliance created successfully");
			return new ResponseEntity<>("TaskLevelCompliance Created",HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Inside TaskLevelComplianceController createTaskLevelCompliance: TaskLevelCompliance creation failed");
			return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
		}
	}
	
	@PutMapping("/complyTaskLevelCompliance/{tlcid}")
	public ResponseEntity<String> complyTaskLevelCompliance(@PathVariable("tlcid") String tlcid)
	{
		try {
			System.out.println("Inside TaskLevelComplianceController complyTaskLevelCompliance: Request reached /emmsLite/complyTaskLevelCompliance Controller");
			taskLevelComplianceService.complyTaskLevelCompliance(tlcid);
			System.out.println("Inside TaskLevelComplianceController complyTaskLevelCompliance: TaskLevelCompliance complied successfully");
			return new ResponseEntity<>("TaskLevelCompliance Complied",HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Inside TaskLevelComplianceController complyTaskLevelCompliance: TaskLevelCompliance comply failed");
			return  new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping("/fetchTaskLevelComplianceDetails/{workorderid}")
	//public List<TaskLevelComplianceEntity> fetchAssignedTaskLevelComplianceist(@PathVariable("workorderid") String workorderid, @RequestBody TaskLevelComplianceEntity taskLevelComplianceEntity)
	public List<TaskLevelComplianceEntity> fetchAssignedTaskLevelComplianceist(@PathVariable("workorderid") String workorderid, @RequestBody LoginEntity loginEntity)
	{
		System.out.println("Inside TaskLevelComplianceController fetchTaskLevelComplianceDetails: Request reached /emmsLite/fetchTaskLevelComplianceDetails Controller");
		//String servicenum = "00002";
		//System.out.println("Inside TaskLevelComplianceController fetchTaskLevelComplianceDetails: " + "Service No. of Requestor: " + servicenum);
		return taskLevelComplianceService.fetchAllTaskLevelCompliance(workorderid, loginEntity);
	}
}
