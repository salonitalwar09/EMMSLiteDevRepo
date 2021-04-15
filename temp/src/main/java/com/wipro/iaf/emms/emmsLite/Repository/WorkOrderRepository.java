package com.wipro.iaf.emms.emmsLite.Repository;

/**
 * @author Shivam
 * Date:: 06 April 2021
 * Description:: Workorder Repository to view workorder, create workorder, change status
 *
 */


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.WorkOrderEntity;

@Repository
public interface WorkOrderRepository  extends JpaRepository<WorkOrderEntity, Long>{
	@Query(value = "SELECT * FROM emms_lite.elite_workorder_tb", nativeQuery=true)
	public List<WorkOrderEntity> getAllWorkOrders();


	@Query(value = "SELECT wonumid FROM emms_lite.runningid where id='1'", nativeQuery=true)
	public int findWoNumCounter();

	/*@Query(value = "SELECT * FROM emms_lite.elite_workorder_tb where workorder_id=?1", nativeQuery=true)
	public List<WorkOrderEntity> findWorkOrderByID();*/
}

