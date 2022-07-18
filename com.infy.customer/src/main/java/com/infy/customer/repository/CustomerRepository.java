package com.infy.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infy.customer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	@Query("select cust from Customer cust where cust.emailAddress = ?1")
	public Optional<Customer> getCustomerByEmail(String email);
	
	@Query("select cust from Customer cust where cust.firstName = ?1 and cust.lastName = ?2")
	public Optional<Customer> getCustomerByFirstNameAndLastName(String firstName, String lastName);

}
