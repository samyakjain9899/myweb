package com.practice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.Entity.Director;


@Repository("directorRepository")
public interface DirectorRepository  extends JpaRepository<Director,Integer>{

	
	  public Director findByFirstName(String name);
	  
}
