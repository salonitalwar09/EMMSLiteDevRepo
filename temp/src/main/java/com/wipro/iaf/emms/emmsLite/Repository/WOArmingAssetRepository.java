package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.ArmingAssetEntity;

/**
 * 
 * @author Saloni Talwar
 * Changes done for EMMS Lite Project
 * Created on 23/05/2021
 * Description - This class is the repository for the Arming/De-Arming Asset Table.
 */

@Repository
public interface WOArmingAssetRepository extends JpaRepository<ArmingAssetEntity, Integer>{
	@Query(value = "SELECT * FROM emms_lite.elite_armdearm_asset_tb armasset where armasset.ASSET_NUM = ?1 and armasset.CURRENT_QUANT > 0", nativeQuery=true)
	public List<ArmingAssetEntity> getAllWODeArmAssetRecords(@Param("ASSET_NUM") String assetNum);

	@Query(value = "SELECT * FROM emms_lite.elite_armdearm_asset_tb armasset where armasset.BUILD_ITEM=?1 and armasset.ARM_GIGNO=?2 and armasset.STATION_NO=?3 and armasset.ASSET_NUM=?4", nativeQuery=true)
	public List<ArmingAssetEntity> getAssetRecord(@Param("BUILD_ITEM") String buildItem, @Param("ARM_GIGNO") String armGIGNo,@Param("STATION_NO") String stationNo, @Param("ASSET_NUM") String assetNum);
}
