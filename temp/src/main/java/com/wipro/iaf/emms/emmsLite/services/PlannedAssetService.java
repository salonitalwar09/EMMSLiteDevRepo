package com.wipro.iaf.emms.emmsLite.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.Repository.PlannedAssetRepository;

import com.wipro.iaf.emms.emmsLite.entity.AssetEntity;


@Service
public class PlannedAssetService {

	@Autowired
	private PlannedAssetRepository plannedAssetRepository;
	
	
	
	
	public List<AssetEntity> getPlndAsstDetails()
	{
		  List <AssetEntity> assetDetails = new ArrayList<>();
		  //List<PlannedAssetBean> assetBean = new ArrayList<PlannedAssetBean>();
		try{
	
	  assetDetails = plannedAssetRepository.getPlndAsstDetails();
	
	 
	  System.out.println("3");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return assetDetails;
	}
}
