package com.practice.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.DTO.MovieDTO;
import com.practice.Entity.Movie;
import com.practice.Repository.MovieRepository;

@Service("movieservice")
@Transactional
public class MovieService implements MovieServiceI{

	

	private MovieRepository movieRepo;
	

    @Autowired
	public void setMovieRepo(MovieRepository movieRepo) {
		this.movieRepo = movieRepo;
	}

	@Override
	public void add(MovieDTO dto) {
	
		try {
			
			System.out.println("========INSERT EXECUTION======");
			
			//check for unique Movie title
			List<Movie> movieList = movieRepo.findByMovie_Title(dto.getMovie_Title());
			
			if(!movieList.isEmpty()) {
				throw new Exception("Movie already exists || try another");
			}
			//convert DTO TO entity
			Movie movie  = MovieDTO.convertDTOtoEntity(dto);
			movieRepo.save(movie);
			System.out.println("INSERTED SUCCESSFULLY -> "+movie);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		
		
	}

	@Override
	public void searchBasedOnTitle(String title) {
		// TODO Auto-generated method stub
		System.out.println("=========SEARCH RESULT  (Searching for "+title+")==========");
		try {
			
			List<Movie> movieList = movieRepo.findByMovie_TitleLike(title);
			if(movieList.isEmpty()) {
				throw new Exception("Invalid Movie Title");
			}
			movieList.stream().forEach(System.out::println);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
	    
	}

	@Override
	public void updateReleaseDate(LocalDate releaseDate, String movieTitle) {
		// TODO Auto-generated method stub
	   System.out.println("=========UPDATE==========");
		try {
			List<Movie> movieList = movieRepo.findByMovie_Title(movieTitle);	
			if(movieList.isEmpty()) {
				throw new Exception("Invalid");
			}
			
			Integer affected = movieRepo.updateMovieWithGivenReleaseDate(releaseDate, movieTitle);
			System.out.println("total Rows updated "+affected);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteBasedOnMovieTitle(String Title) {
		// TODO Auto-generated method stub
		
		
		try {
		    List<Movie> movieList = movieRepo.findByMovie_Title(Title);	
		    
			if(movieList.isEmpty()) {
				throw new Exception("Movie with given Title not available");
			}
			
			movieRepo.deleteByMovie_Title(Title);
			System.out.println("Deleted movie with title "+Title);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Movie> displayAll() {
		// TODO Auto-generated method stub
		
		//[PENDING WORK] YET TO BE IMPLEMENTED
		return null;
	}

}
