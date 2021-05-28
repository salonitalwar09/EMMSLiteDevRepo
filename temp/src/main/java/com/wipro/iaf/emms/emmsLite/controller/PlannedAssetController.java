package com.wipro.iaf.emms.emmsLite.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.iaf.emms.emmsLite.Repository.PlannedAssetRepository;
import com.wipro.iaf.emms.emmsLite.entity.ElitePlndAstTb;
import com.wipro.iaf.emms.emmsLite.services.PlannedAssetService;

@RestController
@RequestMapping("/emmsLite")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlannedAssetController {
	
	@Autowired
	private PlannedAssetService plannedAssetService;
	
	@Autowired
	private PlannedAssetRepository plannedAssetRepository;
	
	@GetMapping("/viewAsset")
 public List<ElitePlndAstTb> getPlndAsstDetails()
  {
		System.out.println("1");
	 List<ElitePlndAstTb> plannedAssetBean =new ArrayList<>();
	 
	 plannedAssetBean = plannedAssetService.getPlndAsstDetails();
	System.out.println("2");
	return plannedAssetBean;
	 
 }
		

}
