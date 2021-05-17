package com.wipro.iaf.emms.emmsLite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.PlannedAssetHeaderEntity;

@Repository
public interface PlannedAssetHeaderRepository extends JpaRepository<PlannedAssetHeaderEntity, Integer>{
}
