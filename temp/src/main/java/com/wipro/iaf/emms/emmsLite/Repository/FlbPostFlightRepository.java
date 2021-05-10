package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.FlbPostFlightEntity;

@Repository
public interface FlbPostFlightRepository extends JpaRepository<FlbPostFlightEntity, Long> {
	@Query(value="SELECT * FROM elite_flb_post_flt_tb WHERE record_id=?1", nativeQuery = true)
	public List<FlbPostFlightEntity> findAllByRecordId(@Param("recordId") String recordId);
}