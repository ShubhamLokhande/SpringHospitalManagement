package com.springHospMgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.springHospMgmt.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User getUserByEmail(String email);

	@Modifying
	@Query("update User u set u.status = ?1 where u.userId = ?2")
	void setStatusForUserId(boolean status, long userId);

	List<User> getUserByStatus(boolean status);

}
