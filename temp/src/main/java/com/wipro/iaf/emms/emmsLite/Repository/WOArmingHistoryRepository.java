package com.wipro.iaf.emms.emmsLite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.WOArmingHistoryEntity;

/**
 * 
 * @author Saloni Talwar
 * Changes done for EMMS Lite Project
 * Created on 26/5/2021
 * Description - This class is the repository for the Arming/De-Arming Screen 
 * under Work Order.
 */

@Repository
public interface WOArmingHistoryRepository extends JpaRepository<WOArmingHistoryEntity, Integer>{

}
