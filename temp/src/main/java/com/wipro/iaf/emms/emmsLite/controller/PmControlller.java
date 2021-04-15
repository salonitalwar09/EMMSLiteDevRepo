package com.wipro.iaf.emms.emmsLite.controller;

/**
 * @author Shivam
 * Date:: 06 April 2021
 * Description:: PM controller to get all pm values
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.iaf.emms.emmsLite.Repository.PmRepository;
import com.wipro.iaf.emms.emmsLite.entity.PmEntity;
import com.wipro.iaf.emms.emmsLite.services.PmService;


@RestController
@RequestMapping("/emmsLite")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PmControlller {

	@Autowired
	PmService pmService;
	@Autowired
	PmRepository pmRepository;

	public PmControlller(PmRepository pmRepository){
		this.pmRepository = pmRepository;
	}
		@GetMapping("/viewPM")
		public List<PmEntity> getAllPMList()
		{
			System.out.println("getAllPMList");
			return pmService.getAllPM();
		}
	}

