package com.wipro.iaf.emms.emmsLite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.ArmingAssetEntity;

/**
 * 
 * @author Saloni Talwar
 * Changes done for EMMS Lite Project
 * Created on 23/05/2021
 * Description - This class is the repository for the Arming/De-Arming Asset Table.
 */

@Repository
public interface WOArmingAssetRepository extends JpaRepository<ArmingAssetEntity, Integer>{

}
