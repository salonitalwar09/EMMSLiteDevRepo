package com.wipro.iaf.emms.emmsLite.controller;

/**
 * @author Shivam
 * Date:: 06 April 2021
 * Description:: Work Type controller to get all Work Type
 *
 */


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.iaf.emms.emmsLite.Repository.WorkTypeRepository;
import com.wipro.iaf.emms.emmsLite.entity.WorkTypeEntity;
import com.wipro.iaf.emms.emmsLite.services.WorkTypeService;



@RestController
@RequestMapping("/emmsLite")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WorkTypeController {

	@Autowired
	WorkTypeEntity worktypEntity;
	@Autowired
	WorkTypeRepository worktypRepository;
	@Autowired
	WorkTypeService worktypService;
	
	public WorkTypeController(WorkTypeRepository worktypRepository){
		this.worktypRepository = worktypRepository;
	}
	
	@GetMapping("/viewWT")
	public List<WorkTypeEntity> getAllWOList()
	{
		System.out.println("getAllWTList");
		return worktypService.getAllWT();
	}
}
