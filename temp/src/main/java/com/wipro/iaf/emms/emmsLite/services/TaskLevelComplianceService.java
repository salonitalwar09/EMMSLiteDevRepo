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
	@Autowired
	private WorkOrderRepository workOrderRepository;
	@Autowired
	private WorkOrderEntity workOrderEntity;
	@Autowired
	private PersonRepository personRepository;

	//Service to Fetch all Technician Details for Service No. Lookup
	public List<PersonEntity> fetchAllTechnicianDetails() {
		System.out.println("Inside TaskLevelComplianceService fetchAllTechnicianDetails: Request reached Service");
		return personRepository.findAll();
	}

	//Service to Fetch Technician Name from selected Service No.
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

		//taskLevelComplianceEntity.setWorkorderid(workorderid);
		inputTaskLevelComplianceEntity.setWorkorderid(workorderid);
		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance:"
				+" Workorder ID: " + workorderid);

		Timestamp createDte = new Timestamp(System.currentTimeMillis());
		inputTaskLevelComplianceEntity.setCreateDte(createDte);
		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance:"
				+" Create Date: " + createDte);

		//Logic to auto increment Task No. in factor of 10
		String taskNo = "" + findTaskNoCounter();
		inputTaskLevelComplianceEntity.setTaskNo(taskNo);
		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance:"
				+" Task No.: " + taskNo);

		//taskLevelComplianceEntity.setTechnicianServicenum(inputTaskLevelComplianceEntity.getTechnicianServicenum());
		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance:"
				+" Technician Service Number: " + inputTaskLevelComplianceEntity.getTechnicianServicenum());

		//taskLevelComplianceEntity.setTechnicianName(inputTaskLevelComplianceEntity.getTechnicianName());
		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance:"
				+" Technician Name: " + inputTaskLevelComplianceEntity.getTechnicianName());

		//taskLevelComplianceEntity.setTaskDesc(inputTaskLevelComplianceEntity.getTaskDesc());
		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance:"
				+" Task Description: " + inputTaskLevelComplianceEntity.getTaskDesc());

		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance:"
				+" Created By: " + inputTaskLevelComplianceEntity.getCreatedBy());

		TaskLevelComplianceEntity taskLevelComplianceEntity = taskLevelComplianceRepository.save(inputTaskLevelComplianceEntity);
		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance:"
				+" taskLevelComplianceEntity: " + taskLevelComplianceEntity);
		System.out.println("Inside TaskLevelComplianceService createTaskLevelCompliance:"
				+" taskLevelComplianceEntity Saved");
		return taskLevelComplianceEntity;
	}

	//Service to Display Saved Rows onLoad for given WorkOrderId and logged-in servicenum
	public List<TaskLevelComplianceEntity> fetchAllTaskLevelCompliance(String workorderid, String userid) {
		System.out.println("Inside TaskLevelComplianceService fetchAllTaskLevelCompliance: Request reached Service");
		String servicenum = userid;
		System.out.println("Inside TaskLevelComplianceService fetchAllTaskLevelCompliance: " + "workorderid: " + workorderid + ", servicenum: " + servicenum);
		List<TaskLevelComplianceEntity> displayTaskLevelComplianceEntityList = taskLevelComplianceRepository.findByLoggedInUser(workorderid, servicenum);
		System.out.println("Inside TaskLevelComplianceService fetchAllTaskLevelCompliance: " + "displayTaskLevelComplianceEntityList: " + displayTaskLevelComplianceEntityList);
		return displayTaskLevelComplianceEntityList;
	}

	//Service to Comply Task Level Compliance Row with Compliance Date update
	//on Comply button click
	public TaskLevelComplianceEntity complyTaskLevelCompliance(String tlcid, String userid) {
		System.out.println("Inside TaskLevelComplianceService complyTaskLevelCompliance: Request reached Service");
		TaskLevelComplianceEntity complianceTlcEntity = taskLevelComplianceRepository.findById(tlcid).get();
		System.out.println("Inside TaskLevelComplianceService complyTaskLevelCompliance:"
				+" Task Level Compliance ID under update: " + tlcid);

		Timestamp complianceDte = new Timestamp(System.currentTimeMillis());
		System.out.println("Inside TaskLevelComplianceService complyTaskLevelCompliance:"
				+" Compliance Date for " + tlcid + " : " + complianceDte);
		complianceTlcEntity.setComplianceDte(complianceDte);

		System.out.println("Inside TaskLevelComplianceService complyTaskLevelCompliance:"
				+" Complied By: " + userid);
		complianceTlcEntity.setCompliedBy(userid);

		taskLevelComplianceRepository.save(complianceTlcEntity);
		return complianceTlcEntity;
	}

	//Service to Delete Task Level Compliance Row on Delete button click
	public void deleteTaskLevelCompliance(String tlcid) {
		System.out.println("Inside TaskLevelComplianceService deleteTaskLevelCompliance: Request reached Service");
		taskLevelComplianceRepository.deleteByTlcId(tlcid);
	}

	//Service Utility to set Task Number (taskNo) as factor of 10 with max check on table 
	//or start with 10 in case of no previous entry
	private int findTaskNoCounter() {
		System.out.println("Inside TaskLevelComplianceService findTaskNoCounter: Request reached Service");
		int nextTaskNoCounter=0;
		String maxValueTaskNo = null;

		maxValueTaskNo=taskLevelComplianceRepository.getTaskNoCount();
		System.out.println("Inside TaskLevelComplianceService findTaskNoCounter: "
				+ "maxValueTaskNo: " + maxValueTaskNo);

		if(maxValueTaskNo!=null){
			System.out.println("Inside TaskLevelComplianceService findTaskNoCounter: "
					+ "maxValueTaskNo is not null");
			nextTaskNoCounter=Integer.parseInt(maxValueTaskNo)+10;
		}
		else {
			System.out.println("Inside TaskLevelComplianceService findTaskNoCounter: "
					+ "maxValueTaskNo is null");
			nextTaskNoCounter=10;
		}
		System.out.println("Inside TaskLevelComplianceService findTaskNoCounter:"
				+" nextTaskNoCounter = " + nextTaskNoCounter);
		return nextTaskNoCounter;
	}
}
