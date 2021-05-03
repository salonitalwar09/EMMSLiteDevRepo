package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.FlbSortieAREntity;

/**
 * @author Lalit Singh Bisht
 */

@Repository
public interface FlbSortieARRepository extends JpaRepository<FlbSortieAREntity, Long>{
	@Query(value = "SELECT * FROM elite_flb_sortie_accept_reject_tb WHERE record_id=?1", nativeQuery=true)
	public List<FlbSortieAREntity> findAllByRecordId(@Param("recordId") String recordId);

	@Query(value = "SELECT * FROM elite_flb_sortie_accept_reject_tb WHERE record_id=?1 AND sortie_num=?2", nativeQuery=true)
	public Optional<FlbSortieAREntity> findBySortieNum(@Param("recordId") String recordId, @Param("sortieNum") String sortieNum);
}
