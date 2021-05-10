package com.wipro.iaf.emms.emmsLite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.Repository.PlannedAssetHeaderRepository;
import com.wipro.iaf.emms.emmsLite.entity.PlannedAssetHeaderEntity;

@Service
public class HeaderService {
	
	@Autowired
	private PlannedAssetHeaderRepository plannedAssetHeaderRepository;

	public PlannedAssetHeaderEntity getPlannedAssetHeader() {
		// TODO Auto-generated method stub
		return plannedAssetHeaderRepository.findById(1001).get();
	}

}
