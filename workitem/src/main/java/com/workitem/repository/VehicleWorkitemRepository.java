package com.workitem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.workitem.entity.VehicleWorkitem;

@Repository
public interface VehicleWorkitemRepository extends JpaRepository<VehicleWorkitem,String> {
	
	@Query("Select c from VehicleWorkitem c where c.vehicleNumber=?1")
	Optional<VehicleWorkitem> findByVehicleNumber(String vehicleNumber);

}
