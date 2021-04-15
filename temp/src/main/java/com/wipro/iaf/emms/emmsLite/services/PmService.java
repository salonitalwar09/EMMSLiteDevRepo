package com.wipro.iaf.emms.emmsLite.services;

/**
 * @author Shivam
 * Date:: 06 April 2021
 * Description:: PM Service to get all pm values
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.Repository.PmRepository;
import com.wipro.iaf.emms.emmsLite.entity.PmEntity;

@Service
public class PmService {

	@Autowired
	PmRepository pmRepository;

	public List<PmEntity> getAllPM() {
		List<PmEntity> pmList = new ArrayList<>();
		System.out.println("Before PMList:: ");
		try {
			pmList = pmRepository.getAllPm();
		} catch (Exception e) {
			System.out.println("Exception::"+e.getMessage());
		}
		return pmList;
	}

}
