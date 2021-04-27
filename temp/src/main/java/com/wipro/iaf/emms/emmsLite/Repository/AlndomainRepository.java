package com.wipro.iaf.emms.emmsLite.Repository;

/**
 * @author Shivam
 * Date:: 19 April 2021
 * Description:: ALNDOMAIN Table Repository
 *
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.iaf.emms.emmsLite.entity.AlndomainEntity;

public interface AlndomainRepository extends JpaRepository<AlndomainEntity, Long> {

	//Query to get all the jobtypes from alndomain table:: Shivam	
	@Query(value = "SELECT * FROM elite.elite_aln_domain_tb where elite_aln_domain_tb.domain_id='IAF_JPTYPE'" , nativeQuery=true)
	public List<AlndomainEntity> getJobType();

	//Query to get all the Removal Reasons from alndomain table:: Shivam
	@Query(value = "SELECT * FROM elite.elite_aln_domain_tb where elite_aln_domain_tb.domain_id='IAF_REMREASON'" , nativeQuery=true)
	public List<AlndomainEntity> getRemReason();

	//Query to get all the Removal Type from alndomain table:: Shivam
	@Query(value = "SELECT * FROM elite.elite_aln_domain_tb where elite_aln_domain_tb.domain_id='IAF_REMTYPE'" , nativeQuery=true)
	public List<AlndomainEntity> getRemType();
}
