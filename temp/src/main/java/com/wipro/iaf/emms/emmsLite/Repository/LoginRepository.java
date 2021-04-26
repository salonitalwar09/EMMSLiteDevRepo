package com.wipro.iaf.emms.emmsLite.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.iaf.emms.emmsLite.entity.LoginEntity;

/**
 * @author Rachit
 *
 */

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity,String>{
	
	@Transactional
	@Query(value="SELECT login.password from LOGIN login where login.userid=?1",nativeQuery=true)
	String checkPassword(@Param("userId") String userId);
	
	@Transactional
	@Query(value="SELECT login.userid from LOGIN login where login.userid=?1",nativeQuery=true)
	String checkUserId(@Param("userId") String userId);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE LOGIN login set login.password=?1 where login.userid=?2",nativeQuery=true)
	String updatePasswordForId(@Param("password") String UpdatePassword, @Param("userid") String userid);
}
