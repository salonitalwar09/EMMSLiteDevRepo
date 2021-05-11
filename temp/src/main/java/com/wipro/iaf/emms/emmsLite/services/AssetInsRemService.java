package com.wipro.iaf.emms.emmsLite.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.Repository.AssetInsRemRepository;
import com.wipro.iaf.emms.emmsLite.beans.WorkOrderResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.AssetInsRemEntity;

/**
 * @author Shivam
 * Date:: 19 April 2021
 * Description:: Asset Install Remove Service
 *
 */

@Service
public class AssetInsRemService {

	@Autowired
	AssetInsRemEntity assetInsRemEntity;
	@Autowired
	AssetInsRemRepository assetInsRemRepository;
	@Autowired
	WorkOrderResponseBean workorderResponseBean;

	public List <AssetInsRemEntity>assetRemSet(Long workorderId){
		List<AssetInsRemEntity> assetRemList = new ArrayList<>();
		try {
			System.out.println("Asset Remove List Serivce:: ");
			assetRemList = assetInsRemRepository.getAllAssetRemRecordByWoId(workorderId);
			return assetRemList;
		} catch (Exception e) {
			System.out.println("into Catch Block:: "+e.getMessage());
			return assetRemList;
		}
	}

	public WorkOrderResponseBean createInsRemRow(Long workorderID, AssetInsRemEntity assetInsRemEntity){
		System.out.println("create Install / Removal Row for WOID:: "+workorderID);
		assetInsRemEntity.setWorkorderId(workorderID);
		/*
		 * Doubt:: To be used on install/remove Button click or while Record Save:: Shivam
		 * 
		 * */
		DateTimeFormatter statusDate= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime now = LocalDateTime.now();
		assetInsRemEntity.setRemInsDate(statusDate.format(now));
		System.out.println("Install/Removal Date:: "+statusDate.format(now));
		assetInsRemEntity.setRemInsBy("801002");
		assetInsRemEntity.setStatus("Pending");
		assetInsRemRepository.save(assetInsRemEntity);
		workorderResponseBean.setinsRemRowId(assetInsRemEntity.getInsRemId());
		return workorderResponseBean;
	}

}
