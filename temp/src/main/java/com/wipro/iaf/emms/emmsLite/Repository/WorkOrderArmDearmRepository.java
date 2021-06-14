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
	@Query(value = "SELECT * FROM emms_lite.elite_wo_armdearm_tb armdearm where armdearm.workorder_id=?1", nativeQuery=true)
	public List<WorkOrderArmDearmEntity> getAllWOArmDeArmRecords(@Param("workorder_id") String workorderid);
	
	@Query(value = "SELECT * FROM emms_lite.elite_wo_armdearm_tb armdearm where armdearm.BUILD_ITEM=?1 and armdearm.ARM_GIGNO=?2 and armdearm.STATION_NO=?3 and armdearm.WORKORDER_ID=?4", nativeQuery=true)
	public List<WorkOrderArmDearmEntity> getBuildItemGigNoRecords(@Param("BUILD_ITEM") String buildItem, @Param("ARM_GIGNO") String armGIGNo,@Param("STATION_NO") String stationNo, @Param("WORKORDER_ID") String workOrderId);
	
	@Query(value = "UPDATE TABLE emms_lite.elite_wo_armdearm_tb armdearm set armdearm.unload_quant=?1 ,armdearm.evaluated_quant=?2 where armdearm.armid_pk=?3", nativeQuery=true)
	public List<WorkOrderArmDearmEntity> updateArmingDeArmingEntry(@Param("unload_quant") String unloadQuant, @Param("evaluated_quant") String evaluatedQuant,@Param("armid_pk") String armId);
	
	//@Query(value = "SELECT item.ARM_DESCRIPTION FROM emms_lite.elite_item_tb item where item.ARM_GIGNO=?1", nativeQuery=true)
	//public String getArmamentDescriptionForGIG(@Param("ARM_GIGNO") String armGIGNo);
	
	//@Query(value = "SELECT builditem.POSITION FROM emms_lite.elite_build_item_tb builditem where builditem.BUILDITEMID=?1", nativeQuery=true)
	//public String getBuildItemPositionForBuildItem(@Param("BUILDITEMID") String buildItem);
	
	@Query(value = "SELECT * FROM emms_lite.elite_wo_armdearm_tb armdearm where armdearm.ARMID_PK=?1", nativeQuery=true)
	public WorkOrderArmDearmEntity getEvaluatedQuantBuildItem(@Param("armid_pk") Integer arm_id);
	
	@Query(value = "SELECT armdearm.ARM_STATUS FROM emms_lite.elite_wo_armdearm_tb armdearm where armdearm.ARMID_PK=?1", nativeQuery=true)
	public String getUpdatedStatusBuildItem(@Param("armid_pk") Integer arm_id);
	
	@Query(value = "DELETE FROM emms_lite.elite_wo_armdearm_tb armdearm where armdearm.ARMID_PK=?1", nativeQuery=true)
	public String deleteBuildItem(@Param("armid_pk") Integer arm_id);
	
	@Query(value = "SELECT MAX(ARMID_PK) FROM emms_lite.elite_wo_armdearm_tb armdearm", nativeQuery=true)
	public int getMaxArmId();
}
