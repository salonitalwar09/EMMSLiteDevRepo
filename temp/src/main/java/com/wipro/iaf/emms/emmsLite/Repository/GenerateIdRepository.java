package com.wipro.iaf.emms.emmsLite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.iaf.emms.emmsLite.entity.GenerateIdEntity;
/**
 * @author Shivam
 * Date:: 05 April 2021
 * Description::Repository to Generate and maintain running ID records across various modules
 *
 */
@Repository
public interface GenerateIdRepository extends JpaRepository<GenerateIdEntity, String> {
	@Query(value = "SELECT MAX(gentb.KEY) FROM emms_lite.elite_generate_id_tb gentb where gentb.property_name=?;", nativeQuery=true)
	public int getKeyValue(String key);
	
	@Query(value = "SELECT gentb.prefix FROM emms_lite.elite_generate_id_tb gentb where gentb.property_name=?;", nativeQuery=true)
	public String getPrefix(String key);
	
	@Transactional
	@Modifying
	@Query(value = "update emms_lite.elite_generate_id_tb gentb set gentb.KEY=1 where gentb.property_name=?;", nativeQuery=true)
	public void generateKeyCounter(String key);
	
	@Transactional
	@Modifying
	@Query(value = "update emms_lite.elite_generate_id_tb gentb set gentb.KEY=gentb.KEY+1 where gentb.property_name=?;", nativeQuery=true)
	public void updateKeyCounter(String key);

}
