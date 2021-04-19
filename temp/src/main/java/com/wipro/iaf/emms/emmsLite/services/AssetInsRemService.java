package com.wipro.iaf.emms.emmsLite.services;

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

	public WorkOrderResponseBean createRemRow(Long workorderID, AssetInsRemEntity assetInsRemEntity){
		System.out.println("create Removal Row for WOID:: "+workorderID);
		assetInsRemEntity.setWorkorderId(workorderID);
		/*
		 * To be used on remove Button click:: Shivam
		 * DateTimeFormatter statusDate= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime now = LocalDateTime.now();
		assetInsRemEntity.setRemovalDate(statusDate.format(now));
		System.out.println("Removal Date:: "+statusDate.format(now));
		 */
		assetInsRemRepository.save(assetInsRemEntity);
		workorderResponseBean.setRemovalRowId(assetInsRemEntity.getInsRemId());
		return workorderResponseBean;
	}

}
