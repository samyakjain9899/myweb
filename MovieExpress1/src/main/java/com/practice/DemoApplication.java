package com.practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import com.practice.DTO.DirectorDTO;
import com.practice.DTO.MovieDTO;
import com.practice.Service.MovieService;

@SpringBootApplication
public class DemoApplication {


	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AbstractApplicationContext context = (AbstractApplicationContext)SpringApplication.run(DemoApplication.class, args);
	    
		
		MovieService service = (MovieService)context.getBean("movieservice");
		//Insert 
		MovieDTO dto = new MovieDTO("firstmovie",LocalDate.now(),LocalDateTime.now());
		MovieDTO dto1 = new MovieDTO("Secondmovie",LocalDate.now(),LocalDateTime.now());
		MovieDTO dto2 = new MovieDTO("Thirdmovie",LocalDate.now(),LocalDateTime.now());
		MovieDTO dto3 = new MovieDTO("fourthmovie",LocalDate.now(),LocalDateTime.now());
		MovieDTO dto4 = new MovieDTO("fifthmovie",LocalDate.now(),LocalDateTime.now());
		List<DirectorDTO> directorList = Arrays.asList(
				new DirectorDTO("dirfirst", "lafirst", "pune","dirf@infosys.com",9876678310L),
				new DirectorDTO("dirsecond","lasecond","mysore","dirs@infosys.com",9089896454L),
				new DirectorDTO("dirsthirs","lasthird","kolkata","dirt@infosys.com",9097352454L)
				);
	
		System.out.println(" ============================================================================================");
		System.out.println(" adding new entries in movie table");
		service.add(dto,directorList); 
		service.add(dto1,directorList); 
		service.add(dto2,directorList); 
		service.add(dto3,directorList); 
		service.add(dto4,directorList); 
		//this automates mapping of DIRECTORS IN MOVIE
		System.out.println(" ============================================================================================");

		System.out.println(" sarching movie based on movie title");
        service.searchBasedOnTitle("firstmovie");
		System.out.println(" ============================================================================================");

        System.out.println(" updating release date for existing movie");
        service.updateReleaseDate(LocalDate.of(2024, 6, 1), "secondmovie");
		System.out.println(" ============================================================================================");

        System.out.println("getting directors based on movie title");
        service.getDirectorListFromTitle("thirdmovie");
        
		System.out.println(" ============================================================================================");

        System.out.println("Getting movies from director name");
        service.getMovieListFromDirectorName("dirsecond");
		System.out.println(" ============================================================================================");

        System.out.println(" removing movie based on movie title");
        service.deleteBasedOnMovieTitle("fourthmovie");
		System.out.println(" ============================================================================================");

        
        System.out.println("Getting all movies");
        System.out.println(service.displayAll().toString());      
		System.out.println(" ============================================================================================");


	}

}
