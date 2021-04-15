/**
 * PostFlightDataRepository is the Repository class to handle Post Flight Data Screen
 */

/**
 * @author Resham Das
 *
 */
package com.wipro.iaf.emms.emmsLite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.iaf.emms.emmsLite.entity.PostFlightDataEntity;

@Repository
public interface PostFlightDataRepository extends JpaRepository<PostFlightDataEntity, String> {
	/*@Query(value = "SELECT * FROM emms_lite.plusafltdata", nativeQuery=true)
	public List<PostFlightDataEntity> getAllPostFlightData();*/

	@Query(value = "SELECT MAX(PLUSAFLTDATAID) FROM emms_lite.plusafltdata", nativeQuery=true)
	public String getPostFlightDataCount();

	@Query(value = "SELECT POSTFLIGHTDATAID FROM emms_lite.runningid where id='1'", nativeQuery=true)
	public String findPostFlightDataCounter();

	@Transactional
	@Modifying
	@Query(value = "update emms_lite.runningid set postflightdataid=postflightdataid+1 where id='1';", nativeQuery=true)
	public void updatePostFlightDataCounter();
	
	@Transactional
	@Modifying
	@Query(value = "update emms_lite.runningid set postflightdataid=1 where id='1';", nativeQuery=true)
	public void updateFirstPostFlightDataCounter();
}
