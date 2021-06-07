package com.wipro.iaf.emms.emmsLite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.iaf.emms.emmsLite.entity.FlbPostFlightEntity;
import com.wipro.iaf.emms.emmsLite.services.FlbPostFlightService;

@RestController
@RequestMapping("/emmsLite/flb/postFlight")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FlbPostFlightController {
	@Autowired
	private FlbPostFlightService flbPostFlightService;
	
	@GetMapping("/all/{recordId}")
	private List<FlbPostFlightEntity> allPostFlights(@PathVariable("recordId") String recordId) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++Inside allPostFlights++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Record Id provided in path: " + recordId);
		System.out.println("++++++++++++++++++++++++++++++++++++++++end of allSorties++++++++++++++++++++++++++++++++++++++++");
		return flbPostFlightService.findByRecordId(recordId);
	}
	
	@PostMapping("/create/{recordId}")
	private FlbPostFlightEntity createPostFlightData(@RequestBody FlbPostFlightEntity newRow , @PathVariable("recordId") String recordId) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++Inside createPostFlightData++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Record Id provided in path: " + recordId);
		System.out.println("++++++++++++++++++++++++++++++++++++++++end of createPostFlightData++++++++++++++++++++++++++++++++++++++++");
		return flbPostFlightService.createPostFlightData(recordId, newRow);
	}
	
	@PutMapping("/save/{recordId}")
	private void postFlight(@RequestBody List<FlbPostFlightEntity> postFlightList, @PathVariable("recordId") String recordId) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++Inside saveSorties++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Record Id provided in path: " + recordId);
		
		// Code starts here
		flbPostFlightService.savePostFlightData(recordId, postFlightList);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++end of saveSorties++++++++++++++++++++++++++++++++++++++++");
	}
}
