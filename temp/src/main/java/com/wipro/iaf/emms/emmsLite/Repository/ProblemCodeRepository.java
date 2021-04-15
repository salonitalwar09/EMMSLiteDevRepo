package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.ProblemEntity;

@Repository
public interface ProblemCodeRepository extends JpaRepository<ProblemEntity, String> {
	@Query(value="SELECT * FROM emms_lite.elite_failure_problem_tb", nativeQuery=true)
	public List<ProblemEntity> getProblem();

}
