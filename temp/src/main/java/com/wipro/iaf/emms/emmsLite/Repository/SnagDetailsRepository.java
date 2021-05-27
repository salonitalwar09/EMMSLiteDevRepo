package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.wipro.iaf.emms.emmsLite.entity.EliteSngDtlsTb;





@Repository
public interface SnagDetailsRepository extends JpaRepository<EliteSngDtlsTb, String>
{

	@Query(value="SELECT * FROM emms_lite.elite_sng_dtls_tb", nativeQuery=true)
	public List<EliteSngDtlsTb> viewSnag() ;
	



}
