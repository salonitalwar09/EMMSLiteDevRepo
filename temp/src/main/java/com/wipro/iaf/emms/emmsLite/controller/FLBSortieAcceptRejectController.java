package com.wipro.iaf.emms.emmsLite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.iaf.emms.emmsLite.Repository.FLBSortieAccRejRepository;
import com.wipro.iaf.emms.emmsLite.beans.SortieAcceptRejectResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.FLBSortieAcceptRejectEntity;
import com.wipro.iaf.emms.emmsLite.services.FLBSortieAcceptRejectService;

/**
 * 
 * @author Saloni Talwar
 * Changes done for EMMS Lite Project
 * Created on 24/03/2021
 * Description - This class is the controller for the Sortie Accept/Reject Screen 
 * under Flight Log Book (CM). 
 */

@RestController
@RequestMapping("/emmsLite")
@CrossOrigin(origins = "*", allowedHeaders = "*")public class FLBSortieAcceptRejectController {
	
	@Autowired
	private FLBSortieAcceptRejectService flbSortieAcceptRejectService;
	
	@Autowired
	private FLBSortieAccRejRepository flbSortieAccRejRepository;
	
	@Autowired
	private SortieAcceptRejectResponseBean sortieAcceptRejectResponseBean;
	
	@GetMapping("/viewFLBSortie")
	public List<FLBSortieAcceptRejectEntity> getAllFLBSortieList()
	{
		System.out.println("getAllFLBSortieList");
		return flbSortieAcceptRejectService.getAllFlbSortie();
	}
	
	@PostMapping("/saveNewFLBSortie")
	public ResponseEntity<SortieAcceptRejectResponseBean> addNewSortie(@RequestBody FLBSortieAcceptRejectEntity sortieEntity){
		return new ResponseEntity<>(flbSortieAcceptRejectService.addNewSortie(sortieEntity),HttpStatus.OK);
	}
	
	@PutMapping("/updateFLBSortieStatus")
	public ResponseEntity<SortieAcceptRejectResponseBean> updateSortieStatus(@RequestBody FLBSortieAcceptRejectEntity sortieEntity){
		return new ResponseEntity<>(flbSortieAcceptRejectService.updateSortieStatus(sortieEntity),HttpStatus.OK);
	}
}
