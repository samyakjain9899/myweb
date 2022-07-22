package com.sim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sim.entity.CustomerIdentity;
@Repository
public interface CustomerIdentityRepository extends JpaRepository<CustomerIdentity, Integer> {

	List<CustomerIdentity> findByUniqueId(String getuniqueId);

}
