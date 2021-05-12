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
	@Autowired
	private WorkOrderService workOrderService;
	@Autowired
	private WorkOrderEntity workOrderEntity;

	@GetMapping("/fetchTechnicianDetails")
	public List<PersonEntity> fetchAllTechnicianDetails()
	{
		System.out.println("Inside TaskLevelComplianceController fetchAllTechnicianDetails: Request reached /emmsLite/fetchTechnicianDetails Controller");
		return taskLevelComplianceService.fetchAllTechnicianDetails();
	}

	@GetMapping("/fetchTechnicianName/{servicenum}")
	public String fetchTechnicianName(@PathVariable("servicenum") String servicenum)
	{
		System.out.println("Inside TaskLevelComplianceController fetchTechnicianName: Request reached /emmsLite/fetchTechnicianName Controller");
		return taskLevelComplianceService.fetchPersonName(servicenum);
	}

	@PostMapping("/createTaskLevelCompliance/{workorderid}")
	public ResponseEntity<TaskLevelComplianceEntity> createTaskLevelCompliance(@PathVariable("workorderid") String workorderid, @RequestBody TaskLevelComplianceEntity inputTaskLevelComplianceEntity){
		System.out.println("Inside TaskLevelComplianceController createTaskLevelCompliance: Request reached /emmsLite/createTaskLevelCompliance Controller");
		System.out.println("Inside TaskLevelComplianceController createTaskLevelCompliance: " + "inputTaskLevelComplianceEntity: " + inputTaskLevelComplianceEntity);
		try {
			TaskLevelComplianceEntity taskLevelComplianceEntity = taskLevelComplianceService.createTaskLevelCompliance(workorderid, inputTaskLevelComplianceEntity);
			System.out.println("Inside TaskLevelComplianceController createTaskLevelCompliance: TaskLevelCompliance created successfully");
			return new ResponseEntity<>(taskLevelComplianceEntity,HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Inside TaskLevelComplianceController createTaskLevelCompliance: TaskLevelCompliance creation failed");
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}

	@PutMapping("/complyTaskLevelCompliance/{tlcid}")
	public ResponseEntity<TaskLevelComplianceEntity> complyTaskLevelCompliance(@PathVariable("tlcid") String tlcid, @RequestBody String userid)
	{
		TaskLevelComplianceEntity taskLevelComplianceEntity;
		try {
			System.out.println("Inside TaskLevelComplianceController complyTaskLevelCompliance: Request reached /emmsLite/complyTaskLevelCompliance Controller");
			System.out.println("Inside TaskLevelComplianceController complyTaskLevelCompliance: " + "userid: " + userid);
			taskLevelComplianceEntity = taskLevelComplianceService.complyTaskLevelCompliance(tlcid, userid);
			System.out.println("Inside TaskLevelComplianceController complyTaskLevelCompliance: TaskLevelCompliance complied successfully");
			System.out.println("Inside TaskLevelComplianceController complyTaskLevelCompliance: " + "taskLevelComplianceEntity: " + taskLevelComplianceEntity);
			return new ResponseEntity<>(taskLevelComplianceEntity,HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Inside TaskLevelComplianceController complyTaskLevelCompliance: TaskLevelCompliance comply failed");
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}

	@PostMapping("/fetchTaskLevelComplianceDetails/{workorderid}")
	public List<TaskLevelComplianceEntity> fetchAssignedTaskLevelComplianceist(@PathVariable("workorderid") String workorderid, @RequestBody String userid)
	{
		System.out.println("Inside TaskLevelComplianceController fetchTaskLevelComplianceDetails: Request reached /emmsLite/fetchTaskLevelComplianceDetails Controller");
		return taskLevelComplianceService.fetchAllTaskLevelCompliance(workorderid, userid);
	}

	@GetMapping("/deleteTaskLevelCompliance/{tlcid}")
	public ResponseEntity<String> deleteTaskLevelCompliance(@PathVariable("tlcid") String tlcid)
	{
		try {
			System.out.println("Inside TaskLevelComplianceController deleteTaskLevelCompliance: Request reached /emmsLite/deleteTaskLevelCompliance Controller");
			taskLevelComplianceService.deleteTaskLevelCompliance(tlcid);
			System.out.println("Inside TaskLevelComplianceController deleteTaskLevelCompliance: TaskLevelCompliance deleted successfully");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Inside TaskLevelComplianceController deleteTaskLevelCompliance: TaskLevelCompliance deletion failed");
			return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
}
