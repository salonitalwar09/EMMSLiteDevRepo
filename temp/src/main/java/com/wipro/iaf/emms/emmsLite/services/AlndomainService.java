package com.wipro.iaf.emms.emmsLite.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.Repository.AlndomainRepository;
import com.wipro.iaf.emms.emmsLite.entity.AlndomainEntity;

/**
 * @author Shivam
 * Date:: 19 April 2021
 * Description:: Alndomain Service
 *
 */

@Service
public class AlndomainService {

	@Autowired
	AlndomainEntity alndomainEntity;
	@Autowired
	AlndomainRepository alndomainRepository;

	/*Not Required to be fetch from DB, We will fetch Hardcoded values:: Shivam
	 * 
	 * public List<AlndomainEntity> jobTypeSet(){
		List<AlndomainEntity> jobTypeList = new ArrayList();
		try {
			System.out.println("Job Type List Try Block::");
			jobTypeList = alndomainRepository.getJobType();
			return jobTypeList;
		} catch (Exception e) {
			System.out.println("Job Type List Catch:: "+e.getMessage());
			return jobTypeList;
		}
	}
	public List<AlndomainEntity> remTypeSet(){
		List<AlndomainEntity> remTypeList = new ArrayList();
		try {
			System.out.println("Removal Type List Try Block::");
			remTypeList = alndomainRepository.getRemType();
			return remTypeList;
		} catch (Exception e) {
			System.out.println("Removal Type List Catch:: "+e.getMessage());
			return remTypeList;
		}
	}*/
	public List<AlndomainEntity> RemReasonSet(){
		List<AlndomainEntity> RemReasonList = new ArrayList();
		try {
			System.out.println("Removal Reason Try Block::");
			RemReasonList = alndomainRepository.getRemReason();
			return RemReasonList;
		} catch (Exception e) {
			System.out.println("Removal Reason List Catch:: "+e.getMessage());
			return RemReasonList;
		}
	}
}
