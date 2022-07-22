package com.sim.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.sim.entity.Customer;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("Select c from Customer c where c.emailAddress =?1 and c.dateOfBirth =?2")
	List<Customer> findByEmailAndDOB(String emailAddress, Date dateOfBirth);

	List<Customer> findByEmailAddress(String emailAddress);

	List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

	List<Customer> findByUniqueId(String getuniqueId);

	

}
