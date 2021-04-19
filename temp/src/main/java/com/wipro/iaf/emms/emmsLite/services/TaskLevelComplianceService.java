/**
 * TaskLevelComplianceService is the Service class to handle Work Order Task Level Compliance
 */
package com.wipro.iaf.emms.emmsLite.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.beans.WorkOrderResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.LoginEntity;
import com.wipro.iaf.emms.emmsLite.entity.PersonEntity;
import com.wipro.iaf.emms.emmsLite.entity.PostFlightDataEntity;
import com.wipro.iaf.emms.emmsLite.entity.TaskLevelComplianceEntity;
//import com.wipro.iaf.emms.emmsLite.entity.TaskLevelComplianceEntity;
import com.wipro.iaf.emms.emmsLite.entity.WorkOrderEntity;
import com.wipro.iaf.emms.emmsLite.Repository.PersonRepository;
import com.wipro.iaf.emms.emmsLite.Repository.TaskLevelComplianceRepository;
//import com.wipro.iaf.emms.emmsLite.Repository.TaskLevelComplianceRepository;
import com.wipro.iaf.emms.emmsLite.Repository.WorkOrderRepository;

/**
 * @author Resham Das
 *
 */

@Service
public class TaskLevelComplianceService {
	@Autowired
	private TaskLevelComplianceRepository taskLevelComplianceRepository;
	/*@Autowired
	private TaskLevelComplianceEntity taskLevelComplianceEntity;*/
	@Autowired
	private WorkOrderRepository workOrderRepository;
	@Autowired
	private WorkOrderEntity workOrderEntity;
	@Autowired
	private PersonRepository personRepository;
	/*@Autowired
	private PersonEntity personEntity;*/

	/*//Service to Fetch All Work Order Data
	public List<WorkOrderEntity> fetchAllWorkOrderDetails() {
		System.out.println("Inside TaskLevelComplianceService getAllWorkOrderDetails: Request reached Service");
		List<WorkOrderEntity> workOrderDetailsList = new ArrayList<>();
		workOrderDetailsList = workOrderRepository.findAll();	
		return workOrderDetailsList;
	}*/

	//Service to Fetch all Technician Details for Service No. Lookup
	public List<PersonEntity> fetchAllTechnicianDetails() {
		System.out.println("Inside TaskLevelComplianceService getAllTechnicianDetails: Request reached Service");
		return personRepository.findAll();
	}

	//Service to Fetch Technician Name from selected Service No.
	//public String fetchPersonName(TaskLevelComplianceEntity inputTaskLevelComplianceEntity, String servicenum) {
	public String fetchPersonName(String servicenum) {
		System.out.println("Inside TaskLevelComplianceService fetchPersonName: Request reached Service");
		System.out.println("Inside TaskLevelComplianceService fetchPersonName: " + "servicenum: " + servicenum);
		return personRepository.findByServiceNo(servicenum);
	}

	//Service to Save Task Level Compliance Row on Save button click
	public TaskLevelComplianceEntity createTaskLevelCompliance(
			String workorderid, TaskLevelComplianceEntity inputTaskLevelComplianceEntity) {
		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance: Request reached Service");
		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance: " + "workorderid: " + workorderid);
		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance: " + "inputTaskLevelComplianceEntity: " + inputTaskLevelComplianceEntity);
		//WorkOrderEntity inputWorkOrderEntity = workOrderRepository.findByWorkOrderId(workorderid);

		//System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance: " + "inputWorkOrderEntity: " + inputWorkOrderEntity.getAsset_num() + " " + inputWorkOrderEntity.getWorkorder_id());
		TaskLevelComplianceEntity taskLevelComplianceEntity= new TaskLevelComplianceEntity();
		
		//taskLevelComplianceEntity.setEliteWorkorderTb(inputWorkOrderEntity);
		taskLevelComplianceEntity.setWorkorderid(workorderid);
		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance:"
				+" Workorder ID: " + workorderid);

		taskLevelComplianceEntity.setTechnicianServicenum(inputTaskLevelComplianceEntity.getTechnicianServicenum());
		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance:"
				+" Technician Service Number: " + inputTaskLevelComplianceEntity.getTechnicianServicenum());

		taskLevelComplianceEntity.setTechnicianName(inputTaskLevelComplianceEntity.getTechnicianName());
		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance:"
				+" Technician Name: " + inputTaskLevelComplianceEntity.getTechnicianName());

		taskLevelComplianceEntity.setTaskDesc(inputTaskLevelComplianceEntity.getTaskDesc());
		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance:"
				+" Task Description: " + inputTaskLevelComplianceEntity.getTaskDesc());

		/*Timestamp complianceTimestamp = new Timestamp(new Date().getTime());
		taskLevelComplianceEntity.setComplianceDte(complianceTimestamp);
		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance:"
				+" Compliance TimeStamp: " + complianceTimestamp);*/

		taskLevelComplianceEntity = taskLevelComplianceRepository.save(taskLevelComplianceEntity);
		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance:"
				+" taskLevelComplianceEntity Saved");
		return taskLevelComplianceEntity;
	}

	//Service to Display Saved Rows onLoad for given WorkOrderId and logged-in servicenum
	public List<TaskLevelComplianceEntity> fetchAllTaskLevelCompliance(String workorderid, LoginEntity loginEntity) {
		System.out.println("Inside TaskLevelComplianceService getAllTaskLevelCompliance: Request reached Service");
		String servicenum = loginEntity.getUserid();
		System.out.println("Inside TaskLevelComplianceService getAllTaskLevelCompliance: " + "workorderid: " + workorderid + ", servicenum: " + servicenum);
		//WorkOrderEntity displayWorkOrderEntity = workOrderRepository.findTlcScreenValues(workorderid);
		//System.out.println("Inside TaskLevelComplianceService getAllTaskLevelCompliance: " + "displayWorkOrderEntity: " + displayWorkOrderEntity);
		List<TaskLevelComplianceEntity> displayTaskLevelComplianceEntityList = taskLevelComplianceRepository.findByLoggedInUser(workorderid, servicenum);
		System.out.println("Inside TaskLevelComplianceService getAllTaskLevelCompliance: " + "displayTaskLevelComplianceEntityList: " + displayTaskLevelComplianceEntityList);
		return displayTaskLevelComplianceEntityList;
		//Map<WorkOrderEntity,List<TaskLevelComplianceEntity>> TaskLevelComplianceMap = new HashMap<WorkOrderEntity,List<TaskLevelComplianceEntity>>();
		//TaskLevelComplianceMap.put(displayWorkOrderEntity, displayTaskLevelComplianceEntityList);
		//return TaskLevelComplianceMap;
		//return taskLevelComplianceRepository.findTlcDetails(workorderid, servicenum);
	}

	//Service to Comply Task Level Compliance Row with Compliance Date update
	//on Comply button click
	public void complyTaskLevelCompliance(String tlcid) {
		System.out.println("Inside TaskLevelComplianceService complyTaskLevelCompliance: Request reached Service");
		TaskLevelComplianceEntity complianceTlcEntity = taskLevelComplianceRepository.findById(tlcid).get();
		System.out.println("Inside TaskLevelComplianceService complyTaskLevelCompliance:"
				+" Task Level Compliance ID under update: " + tlcid);
		Timestamp complianceDte = new Timestamp(System.currentTimeMillis());
		System.out.println("Inside TaskLevelComplianceService complyTaskLevelCompliance:"
				+" Compliance Date for " + tlcid + " : " + complianceDte);
		complianceTlcEntity.setComplianceDte(complianceDte);
		taskLevelComplianceRepository.save(complianceTlcEntity);
	}
}
