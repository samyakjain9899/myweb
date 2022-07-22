package com.workitem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workitem.entity.WorkitemTerminal;
@Repository
public interface WorkitemTerminalRepository extends JpaRepository<WorkitemTerminal,String> {

}
