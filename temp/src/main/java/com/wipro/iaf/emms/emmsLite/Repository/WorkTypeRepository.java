package com.wipro.iaf.emms.emmsLite.Repository;

/**
 * @author Shivam
 * Date:: 06 April 2021
 * Description:: Work Type Repository to get all Work Type
 *
 */

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.iaf.emms.emmsLite.entity.WorkOrderEntity;
import com.wipro.iaf.emms.emmsLite.entity.WorkTypeEntity;

@Repository
public interface WorkTypeRepository extends JpaRepository<WorkTypeEntity, String>{

	@Query(value = "SELECT * FROM emms_lite.elite_work_type", nativeQuery=true)
	public List<WorkTypeEntity> getAllWorkType();
	
}
