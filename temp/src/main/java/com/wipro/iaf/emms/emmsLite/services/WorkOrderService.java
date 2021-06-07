package com.wipro.iaf.emms.emmsLite.services;

/**
 * @author Shivam
 * Date:: 06 April 2021
 * Description:: Workorder Service to view workorder, create workorder, change status
 *
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.Constants.Constants;
import com.wipro.iaf.emms.emmsLite.Repository.GenerateIdRepository;
import com.wipro.iaf.emms.emmsLite.Repository.WorkOrderRepository;
import com.wipro.iaf.emms.emmsLite.beans.WorkOrderResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.GenerateIdEntity;
import com.wipro.iaf.emms.emmsLite.entity.WorkOrderEntity;

@Service
public class WorkOrderService {
	@Autowired
	WorkOrderRepository workorderRepsitory;
	WorkOrderEntity workorderentity;
	@Autowired
	GenerateIdEntity generateidentity;
	@Autowired
	GenerateIdService generateidservice;
	@Autowired
	Constants constants;
	@Autowired
	WorkOrderResponseBean workorderResponseBean;
	@Autowired
	GenerateIdRepository generateidrepository;


	public List<WorkOrderEntity>getAllWorkOrder()
	{	
		List<WorkOrderEntity> workOrderList = new ArrayList<>();
		try {
			System.out.println("getAllWorkOrder try:: ");
			workOrderList = workorderRepsitory.getAllWorkOrders();
		} catch (Exception e) {
			System.out.println("Exception::"+e.getMessage());
		}
		return workOrderList;
	}

	public WorkOrderEntity workOrderID(Long workOrderID){
		System.out.println("workOrderID Try:: "+workOrderID);
		Optional<WorkOrderEntity> workorderID = workorderRepsitory.findById(workOrderID);
		System.out.println("WorkOrderSet Details::  "+workorderID.get().toString());
		return workorderID.get();
	}

	public WorkOrderResponseBean editWorkOrder(WorkOrderEntity workorderentity, Long workOrderID)
	{
		Optional<WorkOrderEntity> workorderID= workorderRepsitory.findById(workOrderID);
		System.out.println("Obtained WOID"+workorderID.toString());
		WorkOrderEntity woEntity = workorderID.get();
		System.out.println("Status::"+workorderentity.getWo_status());
		DateTimeFormatter closeWoDate= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Current Date:: "+closeWoDate.format(now)	);
		woEntity.setClosure_date(closeWoDate.format(now));
		woEntity.setClosed_by(workorderentity.getClosed_by());
		woEntity.setWo_status(workorderentity.getWo_status());
		workorderRepsitory.save(woEntity);
		workorderResponseBean.setCode(200);
		return workorderResponseBean;
	}

	public WorkOrderResponseBean genWoNum(WorkOrderEntity workorderentity){
		try {
			System.out.println("genWoNum method");
			String key= constants.woNum;
			int Generatedkey = generateidservice.keyValue(key);
			System.out.println("Generatedkey:: "+Generatedkey);
			String prefix = generateidservice.getPrefix(key);
			System.out.println("prefix for Create WorkOrder is:: "+prefix);
			System.out.println("Generated/Updated Key:: "+key);	
			System.out.println("WoNum:: "+prefix+"-"+Generatedkey);
			workorderentity.setWo_num(prefix+"-"+Generatedkey);
			workorderResponseBean.setWonum(workorderentity.getWo_num());
			return workorderResponseBean;
		} catch (Exception e) {
			System.out.println("Exception Occured While WoNum Generation "+e.getMessage());
			return workorderResponseBean;
		}

	}

	public WorkOrderResponseBean createWO(WorkOrderEntity workorderentity){
		try {
			String key= constants.woNum;
			generateidrepository.updateKeyCounter(key);//Set incremneted Wo-Num Counter in Db:: Shivam
			String prefix = generateidservice.getPrefix(key);
			workorderentity.setDet_id(prefix);
		} catch (Exception e) {
			System.out.println("Exception:: "+e.getMessage());
		}
		System.out.println("AssetNum:: "+workorderentity.getAsset_num());
		System.out.println("PM:: "+workorderentity.getPm());
		workorderentity.setWo_status("APPR");
		DateTimeFormatter createCloseWoDate= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Current Date:: "+createCloseWoDate.format(now));
		workorderentity.setCreation_date(createCloseWoDate.format(now));
		/*Closure date also to be updated as created date during 
		create wo as per gaurav singh chauhan req:: Shivam*/
		workorderentity.setClosure_date(createCloseWoDate.format(now));
		System.out.println("Serial Num:: "+workorderentity.getSerial_num());
		System.out.println("Asset Description:: "+workorderentity.getAsset_desc());
		//workorderentity.setCreated_by("801002");
		workorderentity = workorderRepsitory.save(workorderentity);
		System.out.println("After save");
		workorderResponseBean.setCode(200);
		return workorderResponseBean;
	}

}


