package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.CauseEntity;

@Repository
public interface CauseCodeRepository extends JpaRepository<CauseEntity, String> {
	@Query(value="SELECT * FROM emms_lite.elite_problem_cause_tb", nativeQuery=true)
	public List<CauseEntity> getCause(); 

}
