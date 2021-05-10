package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.beans.IMeterQueryResponseBean;
import com.wipro.iaf.emms.emmsLite.entity.WoMeterEntity;

/**
 * @author Rachit
 *
 */

@Repository
public interface WoMeterRepository extends JpaRepository<WoMeterEntity,Integer>{

	@Query(value="select ast.assetnum,"
			+" plus.name as builditem,"
			+" plus.POSITION,"
			+" plus.LCN,"
			+" ast.SERIALNUM,"
			+" ast.description,"
			+" ast.assetid as assetid,"
			+" cat.item as partNumber,"
			+" cat.description as partDescription"	
			+" from elite_PLUSASAONOFF_tb plus "
			+" join asset ast"
			+" on plus.assetid = ast.assetid"
			+" join plusacacat cat"
			+" on ast.assetid = cat.plusacacatid"
			+" where plus.offtime is null"
			+" and plus.parentassetid is not null and plus.ontime is not null",nativeQuery=true)
	public List<String> getAssetLookupQuery();
	
	@Query(value="select ast.assetnum,"
			+" plus.name as builditem,"
			+" plus.POSITION,"
			+" plus.LCN,"
			+" ast.SERIALNUM,"
			+" ast.description,"
			+" ast.assetid as assetid,"
			+" cat.item as partNumber,"
			+" cat.description as partDescription"	
			+" from elite_PLUSASAONOFF_tb plus "
			+" join asset ast"
			+" on plus.assetid = ast.assetid"
			+" join plusacacat cat"
			+" on ast.assetid = cat.plusacacatid"
			+" where plus.offtime is null"
			+" and plus.parentassetid is null and plus.ontime is not null",nativeQuery=true)
	public List<String> getInstallBuildItemLookup();
	
	@Query(value="select ast.assetnum as meterpartNumber_meterLookup,"
			+" plus.name as builditem,"
			+" ast.SERIALNUM,"
			+" ast.description as assetDescription,"
			+" cat.item as partNumber,"
			+" cat.description as Description_Meter"
			+" from elite_PLUSASAONOFF_tb plus "
			+" join asset ast"
			+" on plus.assetid = ast.assetid"
			+" join plusacacat cat"
			+" on ast.assetid = cat.plusacacatid"
			+" where plus.assetid=?1",nativeQuery=true)
	public IMeterQueryResponseBean getMeterLookupQueryById(@Param("assetId") String assetid);

	@Query(value="select * from elite_wo_meter_tb woMeter"
			+ " where woMeter.work_order_id=?1",nativeQuery=true)
	public List<WoMeterEntity> findMeterDetailsById(@Param("workOrderId")Long workOrderId);
}
