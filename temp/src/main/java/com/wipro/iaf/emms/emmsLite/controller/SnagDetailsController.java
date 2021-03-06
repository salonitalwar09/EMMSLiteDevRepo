package com.wipro.iaf.emms.emmsLite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.iaf.emms.emmsLite.entity.RemedyEntity;
import com.wipro.iaf.emms.emmsLite.entity.FailureClassEntity;
import com.wipro.iaf.emms.emmsLite.entity.ProblemEntity;
import com.wipro.iaf.emms.emmsLite.entity.CauseEntity;
import com.wipro.iaf.emms.emmsLite.entity.EliteSngDtlsTb;
import com.wipro.iaf.emms.emmsLite.entity.WorkOrderEntity;
import com.wipro.iaf.emms.emmsLite.services.SnagDetailsService;
import com.wipro.iaf.emms.emmsLite.services.WorkOrderService;


@RestController
@RequestMapping("/emmsLite")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SnagDetailsController {
	
	@Autowired
	SnagDetailsService snagDetailsService;
	
	/*@Autowired
	EliteSngDtlsTb eliteSngDtlsTb;*/
	
	@GetMapping("/getFailureclass")
	public List<FailureClassEntity> getFailure(){
		System.out.println("Inside SnagDetailsController.getFailure()");
		return snagDetailsService.getFailure();
		
	}
	
	@GetMapping("/getProblem")
	public List<ProblemEntity> getProblem(){
		System.out.println("Inside SnagDetailsController.getProblem()");
		return snagDetailsService.getProblem();
		
	}
	
	@GetMapping("/getCause")
	public List<CauseEntity> getCause(){
		System.out.println("Inside SnagDetailsController.getCause()");
		return snagDetailsService.getCause();
		
	}
	
	@GetMapping("/getRemedy")
	public List<RemedyEntity> getRemedy(){
		System.out.println("Inside SnagDetailsController.getRemedy()");
		return snagDetailsService.getRemedy();
		
	}
	
	
	
	

	

}
