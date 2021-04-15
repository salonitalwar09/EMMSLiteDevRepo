package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.wipro.iaf.emms.emmsLite.entity.RemedyEntity;

@Repository
public interface RemedyCodeRepository extends JpaRepository<RemedyEntity, String>{
	
	@Query(value="SELECT * FROM emms_lite.elite_cause_remedy_tb", nativeQuery=true)
	public List<RemedyEntity> getRemedy(); 


}
