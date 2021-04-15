package com.wipro.iaf.emms.emmsLite.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.iaf.emms.emmsLite.Constants.Constants;
import com.wipro.iaf.emms.emmsLite.Repository.FLBSortieAccRejRepository;
import com.wipro.iaf.emms.emmsLite.beans.SortieAcceptRejectResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.FLBSortieAcceptRejectEntity;

/**
 * 
 * @author Saloni Talwar
 * Changes done for EMMS Lite Project
 * Created on 24/03/2021
 * Description - This class is the Service class for the Sortie Accept/Reject functionality 
 * under Flight Log Book (CM). 
 */

@Service
public class FLBSortieAcceptRejectService {

	@Autowired
	FLBSortieAccRejRepository flbSortieAccRejRepo;
	@Autowired
	SortieAcceptRejectResponseBean sortieResponseBean;
	@Autowired
	Constants con;
	
	public List<FLBSortieAcceptRejectEntity>getAllFlbSortie()
	{
		List<FLBSortieAcceptRejectEntity> sortieList = new ArrayList<>();
		
		if (sortieList != null) {			
			sortieList = flbSortieAccRejRepo.getAllFLBSortieAccRej();
			sortieResponseBean.setCode(202);
		} 					
		return sortieList;
	}
	
	public SortieAcceptRejectResponseBean addNewSortie(FLBSortieAcceptRejectEntity sortie) {
		sortieResponseBean.reset();
		FLBSortieAcceptRejectEntity sortieEntityForDb=new FLBSortieAcceptRejectEntity();
		if(sortie.getIaf_sortienum().isEmpty()){
			sortieResponseBean.setCode(500);
			sortieResponseBean.setSortieNewStatus("Sortie Number could not be entered");
		}else{
			sortieEntityForDb.setIaf_sortienum(sortie.getIaf_sortienum());
			sortieEntityForDb.setIaf_duration(sortie.getIaf_duration());
			sortieEntityForDb.setIaf_edt(sortie.getIaf_edt());
			sortieEntityForDb.setIaf_etdDate(sortie.getIaf_etdDate());
			sortieEntityForDb.setIaf_fltType(sortie.getIaf_fltType());
			sortieEntityForDb.setReason(sortie.getReason());
			sortieEntityForDb.setStatus("PENDING");
			sortieEntityForDb.setStatusDate(sortie.getStatusDate());
			sortieEntityForDb.setSortieDate(sortie.getSortieDate());
			flbSortieAccRejRepo.save(sortieEntityForDb);
			sortieResponseBean.setCode(202);
			sortieResponseBean.setSortieNewStatus("Sortie Number entered in database");
		}
		return sortieResponseBean;
	}
	
	public SortieAcceptRejectResponseBean updateSortieStatus(FLBSortieAcceptRejectEntity sortie) {
		sortieResponseBean.reset();
		FLBSortieAcceptRejectEntity sortieEntityForDb=new FLBSortieAcceptRejectEntity();
		if(sortie.isSortieAccept()){
			sortieResponseBean.setCode(500);
			sortieResponseBean.setSortieNewStatus("Sortie Number could not be entered");
		}else if (sortie.isSortieReject()){
			sortieEntityForDb.setIaf_sortienum(sortie.getIaf_sortienum());
			sortieEntityForDb.setIaf_duration(sortie.getIaf_duration());
			sortieEntityForDb.setIaf_edt(sortie.getIaf_edt());
			sortieEntityForDb.setIaf_etdDate(sortie.getIaf_etdDate());
			sortieEntityForDb.setIaf_fltType(sortie.getIaf_fltType());
			sortieEntityForDb.setReason(sortie.getReason());
			sortieEntityForDb.setStatus(con.REJECT_STATUS);
			sortieEntityForDb.setStatusDate(sortie.getStatusDate());
			sortieEntityForDb.setSortieDate(sortie.getSortieDate());
			flbSortieAccRejRepo.save(sortieEntityForDb);
			sortieResponseBean.setCode(202);
			sortieResponseBean.setSortieNewStatus("Sortie Number entered in database");
		}
		return sortieResponseBean;
	}	
}
