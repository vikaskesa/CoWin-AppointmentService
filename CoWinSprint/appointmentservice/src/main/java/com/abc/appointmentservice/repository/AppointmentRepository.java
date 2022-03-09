package com.abc.appointmentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.appointmentservice.entity.AppointmentEntity;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity,Integer> {
//public AppointmentEntity findByProductName(String productName);
	
	//@Query("Select a from AppointmentEntity a where a.AppointmentCategory = :acategory")
	//public List<AppointmentEntity> findProductByCategory(@Param("pcategory") String category);	

}
