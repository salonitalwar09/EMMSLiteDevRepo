package com.wipro.iaf.emms.emmsLite.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.Constants.Constants;
import com.wipro.iaf.emms.emmsLite.Repository.AssetRepository;
import com.wipro.iaf.emms.emmsLite.Repository.CauseCodeRepository;
import com.wipro.iaf.emms.emmsLite.Repository.FailureClassRepository;
import com.wipro.iaf.emms.emmsLite.Repository.ProblemCodeRepository;
import com.wipro.iaf.emms.emmsLite.Repository.RemedyCodeRepository;
import com.wipro.iaf.emms.emmsLite.Repository.SnagDetailsRepository;
import com.wipro.iaf.emms.emmsLite.entity.AssetEntity;
import com.wipro.iaf.emms.emmsLite.entity.EliteSngDtlsTb;
import com.wipro.iaf.emms.emmsLite.entity.RemedyEntity;
import com.wipro.iaf.emms.emmsLite.entity.FailureClassEntity;
import com.wipro.iaf.emms.emmsLite.entity.ProblemEntity;
import com.wipro.iaf.emms.emmsLite.entity.CauseEntity;

@Service
public class SnagDetailsService {
	
	@Autowired
 public FailureClassRepository failureClassRepository;
	
	@Autowired
	public ProblemCodeRepository problemCodeRepository;
	
	@Autowired
	public CauseCodeRepository causeCodeRepository;
	
	@Autowired
	public RemedyCodeRepository remedyCodeRepository;
	
	@Autowired
	GenerateIdService generateidservice;
	
	@Autowired
	SnagDetailsRepository snagDetailsRepository;
	
	@Autowired
	AssetRepository assetRepository;
	
	
	@Autowired
	Constants constants;
	
	
	public List<FailureClassEntity> getFailure() {
		List<FailureClassEntity> failureList = new ArrayList<>();
		try{
			failureList= failureClassRepository.getFailure();
		}
		
		catch(Exception e)
		{
			System.out.println("Exception in SnagDetailsService.getFailure() : "+ e.toString());
		}
		// TODO Auto-generated method stub
		return failureList;
	}

	public List<ProblemEntity> getProblem() {
		// TODO Auto-generated method stub
		List<ProblemEntity> problemList = new ArrayList<>();
		try{
			problemList= problemCodeRepository.getProblem();
		}
		
		catch(Exception e)
		{
			System.out.println("Exception in SnagDetailsService.getProblem() : "+ e.toString());
		}
		return problemList;
	}

	public List<CauseEntity> getCause() {
		// TODO Auto-generated method stub
		List<CauseEntity> causeList = new ArrayList<>();
		try{
			causeList= causeCodeRepository.getCause();
			
			
		}
		
		catch(Exception e)
		{
			System.out.println("Exception in SnagDetailsService.getCause() : "+ e.toString());
		}
		return causeList;
		
	}

	public List<RemedyEntity> getRemedy() {
		// TODO Auto-generated method stub
		
		List<RemedyEntity> remedyList = new ArrayList<>();
		try{
			remedyList= remedyCodeRepository.getRemedy();
		}
		
		catch(Exception e)
		{
			System.out.println("Exception in SnagDetailsService.getRemedy() : "+ e.toString());
		}
		return remedyList;
		
		
	}
	public List<AssetEntity> getAsset() {
		// TODO Auto-generated method stub
		List<AssetEntity> AssetList = new ArrayList<>();
		try{
			AssetList= assetRepository.getAsset();
		}
		
		catch(Exception e)
		{
			System.out.println("Exception in SnagDetailsService.getAsset() : "+ e.toString());
		}
		return AssetList;
	}

	

	public List<EliteSngDtlsTb> viewSnag() {
		// TODO Auto-generated method stub
		List<EliteSngDtlsTb> snagList = new ArrayList<>();
		
			try{
				snagList= snagDetailsRepository.viewSnag();
			}
			
			catch(Exception e)
			{
				System.out.println("Exception in SnagDetailsService.viewSnag() : "+ e.toString());
				e.printStackTrace();
			}
			return snagList;
		
	}

}
