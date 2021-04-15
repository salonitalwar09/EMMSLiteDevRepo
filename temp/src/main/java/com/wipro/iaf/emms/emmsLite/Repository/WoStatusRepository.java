package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.wipro.iaf.emms.emmsLite.entity.WoStatusEntity;

@Repository
public interface WoStatusRepository extends JpaRepository<WoStatusEntity, String> {

	@Query(value = "SELECT * FROM emms_lite.worktype", nativeQuery=true)
	public List<WoStatusEntity> getAllWoStatus();
	
}
