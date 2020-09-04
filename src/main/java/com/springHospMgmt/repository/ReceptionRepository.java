package com.springHospMgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.springHospMgmt.entity.Reception;

public interface ReceptionRepository extends JpaRepository<Reception, Long>{

	Reception getReceptionByEmail(String email);

	@Modifying
	@Query("update Reception r set r.status = ?1 where r.recepId = ?2")
	void setStatusForRecepId(boolean status, long recepId);

	List<Reception> getReceptionByStatus(boolean status);
}
