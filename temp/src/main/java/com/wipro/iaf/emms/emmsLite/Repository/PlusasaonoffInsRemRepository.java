package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.iaf.emms.emmsLite.entity.PlusasaonoffInsRemEntity;

/**
 * @author Shivam
 * Date:: 05 April 2021
 * Description::Repository to Generate and maintain running ID records across various modules
 *
 */
// emms_lite Replaced with elite:: Shivam
@Repository
public interface PlusasaonoffInsRemRepository extends JpaRepository<PlusasaonoffInsRemEntity, String>{
	
	/*@Query(value = "SELECT * FROM elite.elite_plusasaonoff_tb plus where plus.NAME=? and plus.LABEL=? and plus.LCN=?;", nativeQuery=true)
	public List<PlusasaonoffInsRemEntity> getPlusasaonoffRecord(String NAME, String LABEL, String LCN);*/
	
	@Query(value = "SELECT * FROM elite.elite_plusasaonoff_tb plus where "
			+ "plus.NAME=? "
			+ "and plus.LABEL=? "
			+ "and plus.LCN=? "
			+ "and plus.ONTIME IS NOT NULL "
			+ "and plus.OFFTIME IS NULL "
			+ "and (plus.PARENTASSETID IS NULL or plus.ASSETID IS NULL) ;", nativeQuery=true)
	public List<PlusasaonoffInsRemEntity> getPlusasaonoffInstallRecord(String NAME, String LABEL, String LCN);
	
	@Query(value = "SELECT * FROM elite.elite_plusasaonoff_tb plus where "
			+ "plus.NAME=? "
			+ "and plus.LABEL=? "
			+ "and plus.LCN=? "
			+ "and plus.ONTIME IS NOT NULL "
			+ "and plus.OFFTIME IS NULL "
			+ "and plus.PARENTASSETID IS NOT NULL "
			+ "and plus.ASSETID IS NOT NULL ;", nativeQuery=true)
	public List<PlusasaonoffInsRemEntity> getPlusasaonoffRemoveRecord(String NAME, String LABEL, String LCN);
	
	//public String getPlusasaonoffRecord();
	
	@Transactional
	@Modifying
	@Query(value = "update elite.elite_plusasaonoff_tb plus set plus.OFFTIME=? where plus.PLUSASAONOFFID=?;", nativeQuery=true)
	public void updateOffTimeInstall(String offTime, Long plusasaonoffId);
	
	@Transactional
	@Modifying
	@Query(value = "update elite.elite_plusasaonoff_tb plus set plus.OFFTIME=?, plus.TYPE=? where plus.PLUSASAONOFFID=?;", nativeQuery=true)
	public void updateOffTimeRemove(String offTime,String type, Long plusasaonoffId);
	
	@Transactional
	@Modifying
	@Query(value = "insert into elite.elite_plusasaonoff_tb (LABEL, POSITION, NAME, LCN, ALC, "
			+ "ONTIME, OFFTIME, ASSETID, PARENTASSETID, "
			+ "NONSERIALIZED, ORGID, SITEID, TYPE) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", nativeQuery=true)
	public void insertRemoveRowsAssetId(String label,String position, String name, String lcn, String acl, String ontime,
			String offtime, Long assetid, Long parentassetid, String nonserialized, String orgid, String siteid, String type);
	
	@Transactional
	@Modifying
	@Query(value = "insert into elite.elite_plusasaonoff_tb (LABEL, POSITION, NAME, LCN, ALC, "
			+ "ONTIME, OFFTIME, ASSETID, PARENTASSETID, "
			+ "NONSERIALIZED, ORGID, SITEID, TYPE) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", nativeQuery=true)
	public void insertRemoveRowsParentAssetId(String label,String position, String name, String lcn, String acl, String ontime,
			String offtime, Long assetid, Long parentassetid, String nonserialized, String orgid, String siteid, String type);
	

}
