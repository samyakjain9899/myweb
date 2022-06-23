package com.practice.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.practice.DTO.MovieDTO;
import com.practice.Entity.Movie;

public interface MovieServiceI {

	
	//Add,searchBasedOnTitle or else Invalid Title,updateReleaseDate,deleteBasedOnMovieTitle,displayAllMovies
     void add(MovieDTO dto);
     void  searchBasedOnTitle(String title);
     void updateReleaseDate(LocalDate releaseDate,String movieTitle);
     void deleteBasedOnMovieTitle(String Title);
     List<Movie> displayAll();
    
}
