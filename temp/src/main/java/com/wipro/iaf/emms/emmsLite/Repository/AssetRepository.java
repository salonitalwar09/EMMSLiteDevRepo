package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.iaf.emms.emmsLite.entity.AssetEntity;


public interface AssetRepository extends JpaRepository<AssetEntity, String> {
	
	@Query(value="SELECT * FROM emms_lite.asset ", nativeQuery=true)
	public List<AssetEntity> getAsset();

}
