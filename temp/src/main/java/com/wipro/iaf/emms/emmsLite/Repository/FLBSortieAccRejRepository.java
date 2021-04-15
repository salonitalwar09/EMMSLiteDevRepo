package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.FLBSortieAcceptRejectEntity;

/**
 * 
 * @author Saloni Talwar
 * Changes done for EMMS Lite Project
 * Created on 24/03/2021
 * Description - This class is the repository for the Sortie Accept/Reject functionality 
 * under Flight Log Book (CM). 
 */

@Repository
public interface FLBSortieAccRejRepository extends JpaRepository<FLBSortieAcceptRejectEntity, String>{
	@Query(value = "SELECT * FROM emms_lite.IAF_SORTIEACCEPTANCE", nativeQuery=true)
	public List<FLBSortieAcceptRejectEntity> getAllFLBSortieAccRej();
}
