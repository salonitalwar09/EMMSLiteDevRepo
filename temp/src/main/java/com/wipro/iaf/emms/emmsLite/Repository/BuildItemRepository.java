package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.BuildItemEntity;
import com.wipro.iaf.emms.emmsLite.entity.WorkOrderArmDearmEntity;

/**
 * 
 * @author Saloni Talwar
 * Changes done for EMMS Lite Project
 * Created on 11/5/2021
 * Description - This class is the repository for the Arming/De-Arming Screen 
 * under Work Order.
 */
@Repository
public interface BuildItemRepository extends JpaRepository<BuildItemEntity, Integer>{
	@Query(value = "SELECT * FROM emms_lite.elite_build_item_tb builditem where builditem.build_type=?1", nativeQuery=true)
	public List<BuildItemEntity> getBuildItemListForArmItem(@Param("build_type") String buildType);
}
