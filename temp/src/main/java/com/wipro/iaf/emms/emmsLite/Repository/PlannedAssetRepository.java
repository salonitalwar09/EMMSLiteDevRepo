package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.wipro.iaf.emms.emmsLite.entity.AssetEntity;

@Repository
public interface PlannedAssetRepository extends JpaRepository<AssetEntity, String>{

	
	@Query(value="SELECT * FROM emms_lite.Asset", nativeQuery=true)
	public List<AssetEntity> getPlndAsstDetails();
	
	
}
