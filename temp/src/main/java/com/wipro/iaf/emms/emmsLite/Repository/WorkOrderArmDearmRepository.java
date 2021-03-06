package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.WorkOrderArmDearmEntity;

/**
 * 
 * @author Saloni Talwar
 * Changes done for EMMS Lite Project
 * Created on 06/04/2021
 * Description - This class is the repository for the Arming/De-Arming Screen 
 * under Work Order.
 */

@Repository
public interface WorkOrderArmDearmRepository extends JpaRepository<WorkOrderArmDearmEntity, Integer>{
	@Query(value = "SELECT * FROM emms_lite.elite_wo_armdearm_tb", nativeQuery=true)
	public List<WorkOrderArmDearmEntity> getAllWOArmDeArmRecords();
	
	@Query(value = "SELECT * FROM emms_lite.elite_wo_armdearm_tb armdearm where armdearm.BUILD_ITEM=?1 and armdearm.ARM_GIGNO=?2", nativeQuery=true)
	public List<WorkOrderArmDearmEntity> getBuildItemGigNoRecords(@Param("BUILD_ITEM") String buildItem, @Param("ARM_GIGNO") String armGIGNo);
	
	@Query(value = "SELECT item.itemnum FROM emms_lite.elite_item_tb item", nativeQuery=true)
	public List<String> getItemListForArmItem();
	
	@Query(value = "SELECT builditem.BUILDITEMID FROM emms_lite.elite_build_item_tb builditem where builditem.build_type=?1", nativeQuery=true)
	public List<String> getBuildItemListForArmItem(@Param("build_type") String buildType);
	
	@Query(value = "SELECT builditem.POSITION FROM emms_lite.elite_build_item_tb builditem where builditem.BUILDITEMID=?1", nativeQuery=true)
	public String getBuildItemPositionForBuildItem(@Param("BUILDITEMID") String buildItem);
	
	@Query(value = "SELECT builditem.ARM_DESCRIPTION FROM emms_lite.elite_build_item_tb builditem where builditem.ARM_GIGNO=?1", nativeQuery=true)
	public String getArmamentDescriptionForGIG(@Param("ARM_GIGNO") String armGIGNo);
	
	@Query(value = "SELECT * FROM emms_lite.elite_wo_armdearm_tb armdearm where armdearm.ARMID_PK=?1", nativeQuery=true)
	public WorkOrderArmDearmEntity getEvaluatedQuantBuildItem(@Param("armid_pk") Integer arm_id);
	
	@Query(value = "SELECT armdearm.ARM_STATUS FROM emms_lite.elite_wo_armdearm_tb armdearm where armdearm.ARMID_PK=?1", nativeQuery=true)
	public String getUpdatedStatusBuildItem(@Param("armid_pk") Integer arm_id);
	
	@Query(value = "DELETE FROM emms_lite.elite_wo_armdearm_tb armdearm where armdearm.ARMID_PK=?1", nativeQuery=true)
	public String deleteBuildItem(@Param("armid_pk") Integer arm_id);
}
