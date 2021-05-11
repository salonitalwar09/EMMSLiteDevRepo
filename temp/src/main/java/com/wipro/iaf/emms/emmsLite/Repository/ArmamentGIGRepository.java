package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.ArmGIGEntity;
import com.wipro.iaf.emms.emmsLite.entity.WorkOrderArmDearmEntity;

/**
 * 
 * @author Saloni Talwar
 * Changes done for EMMS Lite Project
 * Created on 11/05/2021
 * Description - This class is the repository for the Arming/De-Arming Screen 
 * under Work Order.
 */
@Repository
public interface ArmamentGIGRepository extends JpaRepository<WorkOrderArmDearmEntity, Integer>{
	@Query(value = "SELECT * FROM emms_lite.elite_item_tb item", nativeQuery=true)
	public List<ArmGIGEntity> getItemListForArmItem();
}