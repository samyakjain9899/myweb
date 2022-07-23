package com.FTR.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.FTR.DTO.WorkitemDTO;
import com.FTR.Entity.Workitems;


public interface WorkitemRepository extends JpaRepository<Workitems,Integer> {
public Optional<Workitems> findBySourcecountry(String sourcecountry);
//public List<Workitems> findByUserId(Long userId);
public Workitems findByWorkitemId(String workitemId);
@Query("select u from Workitem u where u.userId=?1")
Optional<Workitems> findByUserId(Long userId);

@Query("select u from Workitem u where u.userId=?1")
List<Workitems> findByUserId1(Long userId);
@Transactional
@Modifying
@Query("update Workitem u set u.selectedHarborLocation=?1, u.shippingDate=?2 where u.workitemId=?3")
void updateLocationAndShippingDate(String originHarborLocation, String shippingDate, String workitemId);
}
