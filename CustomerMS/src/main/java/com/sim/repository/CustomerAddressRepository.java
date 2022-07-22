package com.sim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sim.entity.CustomerAddress;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {

	List<CustomerAddress> findByAddress(String address);

	@Modifying
	@Query(value="update CustomerAddress ca  set ca.address = ?1,ca.city = ?2,ca.pincode = ?3,ca.state = ?4  where ca.addressId= ?5" )
	public Integer UpdateAddress(String address, String city, String pincode, String state, Integer addressId);
	

}
