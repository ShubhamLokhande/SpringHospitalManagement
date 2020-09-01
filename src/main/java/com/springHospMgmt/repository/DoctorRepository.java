package com.springHospMgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springHospMgmt.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	Doctor getDoctorByEmail(String email);

	@Modifying
	@Query("update Doctor d set d.status = ?1 where d.doctorId = ?2")
	void setStatusForDoctorId(boolean status, Long doctorId);

	List<Doctor> getDoctorByStatus(boolean status);
	
}
