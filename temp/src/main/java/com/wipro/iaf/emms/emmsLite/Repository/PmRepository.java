package com.wipro.iaf.emms.emmsLite.Repository;

/**
 * @author Shivam
 * Date:: 06 April 2021
 * Description:: PM Repository to get all pm values
 *
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.iaf.emms.emmsLite.entity.PmEntity;

public interface PmRepository extends JpaRepository<PmEntity, String>{
	
	@Query(value = "SELECT * FROM emms_lite.elite_pm_tb", nativeQuery=true)
	public List<PmEntity> getAllPm();

}
