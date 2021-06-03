/**
 * 
 */
package com.wipro.iaf.emms.emmsLite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.iaf.emms.emmsLite.beans.IMeterQueryResponseBean;
import com.wipro.iaf.emms.emmsLite.beans.WoMeterLookupResponse;
import com.wipro.iaf.emms.emmsLite.entity.WoMeterEntity;
import com.wipro.iaf.emms.emmsLite.services.WoMeterService;

/**
 * @author Rachit
 *
 */

@RestController
@RequestMapping("/emmsLite")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WoMeterController {
		
	@Autowired
	private WoMeterService woMeterService;
	
	@GetMapping("/getAssetAndRmBuildItemLookup")
	public ResponseEntity<List<WoMeterLookupResponse>> getAssetDetails(){
		return new ResponseEntity<>(woMeterService.getAssetLookup(0),HttpStatus.OK);		
	}
	
	@GetMapping("/getInstallBuildItemLookup")
	public ResponseEntity<List<WoMeterLookupResponse>> getInstallBuildItemLookup(){
		return new ResponseEntity<>(woMeterService.getAssetLookup(1),HttpStatus.OK);		
	}
	
	@PostMapping("/saveMeterDetails/{workOrderId}")
	public ResponseEntity<WoMeterLookupResponse> saveMeterDetails(@PathVariable Long workOrderId, @RequestBody WoMeterEntity woMeterInput){
		return new ResponseEntity<>(woMeterService.saveMeterDetails(workOrderId,woMeterInput),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteMeterDetails/{woMeterId}")
	public ResponseEntity<WoMeterLookupResponse> deleteMeterDetails(@PathVariable int woMeterId){
		return new ResponseEntity<>(woMeterService.deleteMeterDetails(woMeterId),HttpStatus.OK);
	}
	
	@GetMapping("/getMeterLookupById/{assetNum}")
	public ResponseEntity<List<IMeterQueryResponseBean>> getMeterLookupById(@PathVariable String assetNum){
		System.out.println("AssetNum="+assetNum);
		return new ResponseEntity<>(woMeterService.getMeterLookupById(assetNum),HttpStatus.OK);		
	}
	
	@GetMapping("/getMeterByWorkOrderId/{workOrderId}")
	public ResponseEntity<List<WoMeterEntity>> getMeterById(@PathVariable Long workOrderId){
		return new ResponseEntity<>(woMeterService.getMeterById(workOrderId),HttpStatus.OK);		
	}
	
}
