package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.FailureClassEntity;

@Repository
public interface FailureClassRepository extends JpaRepository<FailureClassEntity, String>{

	@Query(value="SELECT * FROM emms_lite.elite_failure_class_tb", nativeQuery=true)
	public List<FailureClassEntity> getFailure();

}
