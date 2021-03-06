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
		DateTimeFormatter statusDate= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Current Date:: "+statusDate.format(now)	);
		woEntity.setClosure_date(statusDate.format(now));
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
			String prefix = generateidservice.getPrefix(key);
			workorderentity.setDet_id(prefix);
		} catch (Exception e) {
			System.out.println("Exception:: "+e.getMessage());
		}
		System.out.println("AssetNum:: "+workorderentity.getAsset_num());
		System.out.println("PM:: "+workorderentity.getPm());
		workorderentity.setWo_status("APPR");
		DateTimeFormatter statusDate= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Current Date:: "+statusDate.format(now)	);
		workorderentity.setClosure_date(statusDate.format(now));
		System.out.println("Serial Num:: "+workorderentity.getSerial_num());
		workorderentity = workorderRepsitory.save(workorderentity);
		System.out.println("After save");
		workorderResponseBean.setCode(200);
		return workorderResponseBean;
	}

}


