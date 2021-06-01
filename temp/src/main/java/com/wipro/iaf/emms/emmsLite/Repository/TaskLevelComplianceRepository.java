/**
 * TaskLevelComplianceRepository is the Repository class to perform DB handling for Task Level Compliance
 */
package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.PostFlightDataEntity;
import com.wipro.iaf.emms.emmsLite.entity.TaskLevelComplianceEntity;

/**
 * @author Resham Das
 *
 */
@Repository
public interface TaskLevelComplianceRepository extends JpaRepository<TaskLevelComplianceEntity, String>  {

	@Query(value = "SELECT a.tlc_id, b.workorder_id, b.wo_num, b.wo_desc, b.work_type, b.wo_status, a.technician_servicenum, a.technician_name, a.task_desc, a.compliance_dte FROM emms_lite.elite_wo_tlc_tb a, emms_lite.elite_workorder_tb b WHERE a.workorder_id=b.workorder_id AND a.workorder_id=?1 AND a.technician_servicenum=?2", nativeQuery = true)
	public List<TaskLevelComplianceEntity> findTlcDetails(String workorderid, String servicenum);

	@Query(value = "SELECT * FROM emms_lite.elite_wo_tlc_tb WHERE workorder_id=?1 AND technician_servicenum=?2", nativeQuery = true)
	public List<TaskLevelComplianceEntity> findByLoggedInUser(String workorderid, String servicenum);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM emms_lite.elite_wo_tlc_tb WHERE tlc_id=?1", nativeQuery = true)
	public void deleteByTlcId(String tlcid);
	
	@Query(value = "SELECT MAX(TASK_NO) FROM emms_lite.elite_wo_tlc_tb", nativeQuery=true)
	public String getTaskNoCount();
}
