package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.AssetInsRemEntity;

/**
 * @author Shivam
 * Date:: 19 April 2021
 * Description:: Asset Install Remove Repository
 *
 */

@Repository
public interface AssetInsRemRepository extends JpaRepository<AssetInsRemEntity, Long> {
	@Query(value = "SELECT * FROM elite.elite_ir_tb where elite_ir_tb.workorder_id=?1" , nativeQuery=true)
	public List<AssetInsRemEntity> getAllAssetRemRecordByWoId(Long workorderId);
	
	@Query(value = "SELECT * FROM elite.elite_ir_tb where elite_ir_tb.ir_id=?1" , nativeQuery=true)
	public AssetInsRemEntity insRemRecordById(Long irId);

}
