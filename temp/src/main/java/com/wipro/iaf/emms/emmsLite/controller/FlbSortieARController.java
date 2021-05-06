package com.wipro.iaf.emms.emmsLite.controller;

import java.util.List;

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

import com.wipro.iaf.emms.emmsLite.beans.CommonResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.FlbSortieAREntity;
import com.wipro.iaf.emms.emmsLite.services.FlbSortieARService;


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
	private List<FlbSortieAREntity> allSorties(@PathVariable("recordId") String recordId) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++Inside allSorties++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Record Id provided in path: " + recordId);
		System.out.println("++++++++++++++++++++++++++++++++++++++++end of allSorties++++++++++++++++++++++++++++++++++++++++");
		return fLBSortieARService.findByRecordId(recordId);
	}
	
	@PostMapping("/create/{recordId}")
	private FlbSortieAREntity createSortie(@RequestBody FlbSortieAREntity newRow, @PathVariable("recordId") String recordId) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++Inside createSortie++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Record Id provided in path: " + recordId);		
		System.out.println("++++++++++++++++++++++++++++++++++++++++end of createSortie++++++++++++++++++++++++++++++++++++++++");
		return fLBSortieARService.createSortie(recordId, newRow);
	}
	
	@PutMapping("/save/{recordId}")
	private void saveSorties(@RequestBody List<FlbSortieAREntity> sortieList, @PathVariable("recordId") String recordId) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++Inside saveSorties++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Record Id provided in path: " + recordId);
		fLBSortieARService.saveSorties(recordId, sortieList);
		System.out.println("++++++++++++++++++++++++++++++++++++++++end of saveSorties++++++++++++++++++++++++++++++++++++++++");
	}
}