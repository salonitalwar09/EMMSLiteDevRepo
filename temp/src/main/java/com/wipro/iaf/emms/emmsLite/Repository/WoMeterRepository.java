package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.LoginEntity;

/**
 * @author Rachit
 *
 */

@Repository
public interface WoMeterRepository extends JpaRepository<LoginEntity,Integer>{
	
	/*@Query(value="SELECT asset.description,asset.serialnum, asset.assetnum from asset where asset.assetid in (SELECT elite_plusasaonoff_tb.assetid from elite_plusasaonoff_tb where elite_plusasaonoff_tb.offtime is null and elite_plusasaonoff_tb.parentassetid is not null)",nativeQuery=true)
	public List<String> getAssetLookupQuery1();*/
	
	@Query(value="select ast.assetnum,"
			+" plus.name as builditem,"
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
			+" and plus.parentassetid is not null",nativeQuery=true)
	public List<String> getAssetLookupQuery();
}
