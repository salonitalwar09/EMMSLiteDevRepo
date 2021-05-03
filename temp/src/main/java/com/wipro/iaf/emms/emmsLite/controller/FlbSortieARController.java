package com.wipro.iaf.emms.emmsLite.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.iaf.emms.emmsLite.Repository.FlbSortieARRepository;
import com.wipro.iaf.emms.emmsLite.beans.CommonResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.FlbSortieAREntity;
import com.wipro.iaf.emms.emmsLite.services.FlbSortieARService;

import javassist.expr.NewArray;

/**
 * @author Lalit Singh Bisht
 */

@RestController
@RequestMapping("/emmsLite/flb/sorties")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FlbSortieARController {
	@Autowired
	private FlbSortieARService fLBSortieARService;
	
	@GetMapping("/all/{recordId}")
	private ResponseEntity<List<FlbSortieAREntity>> allSorties(@PathVariable("recordId") String recordId) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++Inside allSorties++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Record Id provided in path: " + recordId);
		
		// Code starts here
		List<FlbSortieAREntity> sortieList = fLBSortieARService.findByRecordId(recordId);
		System.out.println("Sortie List Fetched: " + sortieList);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++end of allSorties++++++++++++++++++++++++++++++++++++++++");
		return new ResponseEntity<>(sortieList, HttpStatus.OK);
	}
	
	@PostMapping("/create/{recordId}")
	private ResponseEntity<CommonResponseBean> createSortie(@RequestBody FlbSortieAREntity newRow, @PathVariable("recordId") String recordId) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++Inside createSortie++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Record Id provided in path: " + recordId);
		
		// Code starts here
		CommonResponseBean response = fLBSortieARService.createSortie(recordId, newRow);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++end of createSortie++++++++++++++++++++++++++++++++++++++++");
		return new ResponseEntity<>(response, response.getStatus());
	}
	
	@PutMapping("/save/{recordId}")
	private ResponseEntity<CommonResponseBean> saveSorties(@RequestBody List<FlbSortieAREntity> sortieList, @PathVariable("recordId") String recordId) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++Inside saveSorties++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Record Id provided in path: " + recordId);
		
		// Code starts here
		CommonResponseBean response = fLBSortieARService.saveSorties(recordId, sortieList);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++end of saveSorties++++++++++++++++++++++++++++++++++++++++");
		return new ResponseEntity<>(response, response.getStatus());
	}
}