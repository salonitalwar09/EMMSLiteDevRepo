package com.wipro.iaf.emms.emmsLite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.iaf.emms.emmsLite.entity.AssetEntity;

public interface AssetRepository extends JpaRepository<AssetEntity, String> {

}
