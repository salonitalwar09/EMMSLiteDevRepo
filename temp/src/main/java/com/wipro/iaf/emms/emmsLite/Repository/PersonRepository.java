package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer>{
	
	@Query(value = "SELECT name FROM emms_lite.elite_person_tb WHERE servicenum=?1", nativeQuery = true)
	public String findByServiceNo(@Param("servicenum") String servicenum);
}
