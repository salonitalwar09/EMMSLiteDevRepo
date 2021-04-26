package com.wipro.iaf.emms.emmsLite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.iaf.emms.emmsLite.beans.CommonResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.FlbPostFlightEntity;
import com.wipro.iaf.emms.emmsLite.entity.FlbSortieAREntity;
import com.wipro.iaf.emms.emmsLite.services.FlbPostFlightService;

@RestController
@RequestMapping("/emmsLite/flb/postFlight")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FlbPostFlightController {
	@Autowired
	private FlbPostFlightService flbPostFlightService;
	
	@GetMapping("/all/{recordId}")
	private ResponseEntity<List<FlbPostFlightEntity>> allPostFlights(@PathVariable("recordId") String recordId) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++Inside allPostFlights++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Record Id provided in path: " + recordId);
		
		// Code starts here
		List<FlbPostFlightEntity> postFlightList = flbPostFlightService.findByRecordId(recordId);
		System.out.println("Sortie List Fetched: " + postFlightList);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++end of allSorties++++++++++++++++++++++++++++++++++++++++");
		return new ResponseEntity<>(postFlightList, HttpStatus.OK);
	}
	
	@PostMapping("/create/{recordId}")
	private ResponseEntity<CommonResponseBean> createPostFlightData(@RequestBody FlbPostFlightEntity newRow , @PathVariable("recordId") String recordId) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++Inside createPostFlightData++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Record Id provided in path: " + recordId);
		
		// Code starts here
		CommonResponseBean response = flbPostFlightService.createPostFlightData(recordId, newRow);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++end of createPostFlightData++++++++++++++++++++++++++++++++++++++++");
		return new ResponseEntity<>(response, response.getStatus());
	}
}
