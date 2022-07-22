package com.workitem.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.workitem.entity.Workitem;


@Repository
public interface WorkitemRepository extends JpaRepository<Workitem,String> {
	@Query("select u from Workitem u where u.userId=?1")
	Optional<Workitem> findByUserId(Long userId);
	
	@Query("select u from Workitem u where u.userId=?1")
	List<Workitem> findByUserId1(Long userId);
	@Transactional
	@Modifying
	@Query("update Workitem u set u.selectedHarborLocation=?1, u.shippingDate=?2 where u.workitemId=?3")
	void updateLocationAndShippingDate(String selectedHarborLocation,LocalDate shippingDate, String workitemId);
}
