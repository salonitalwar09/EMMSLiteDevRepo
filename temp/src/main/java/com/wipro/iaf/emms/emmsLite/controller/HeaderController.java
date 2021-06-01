package com.wipro.iaf.emms.emmsLite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.iaf.emms.emmsLite.entity.PlannedAssetHeaderEntity;
import com.wipro.iaf.emms.emmsLite.services.HeaderService;

/**
 * @author Lalit Singh Bisht
 */

@RequestMapping("/emmsLite/headers")
@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class HeaderController {
	
	@Autowired
	private HeaderService headerService;
	
	@GetMapping("/plannedAsset")
	private PlannedAssetHeaderEntity getPlannedAssetHeader() {
		return this.headerService.getPlannedAssetHeader();
	}
}