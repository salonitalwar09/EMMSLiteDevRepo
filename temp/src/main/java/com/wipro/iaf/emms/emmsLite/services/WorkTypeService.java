package com.wipro.iaf.emms.emmsLite.services;

/**
 * @author Shivam
 * Date:: 06 April 2021
 * Description:: Work Type Service to get all Work Type
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.Repository.WorkTypeRepository;
import com.wipro.iaf.emms.emmsLite.entity.WorkOrderEntity;
import com.wipro.iaf.emms.emmsLite.entity.WorkTypeEntity;

@Service
public class WorkTypeService {
	@Autowired
	WorkTypeEntity worktypEntity;
	@Autowired
	WorkTypeRepository worktypRepository;


	public List<WorkTypeEntity> getAllWT() {
			List<WorkTypeEntity> wtList = new ArrayList<>();
			System.out.println("Before Try::");
			try {
				wtList = worktypRepository.getAllWorkType();
			} catch (Exception e) {
				System.out.println("Exception::"+e.getMessage());
			}
			return wtList;

}

}