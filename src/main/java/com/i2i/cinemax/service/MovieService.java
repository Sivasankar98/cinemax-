package com.i2i.cinemax.service;

import java.util.List;
import java.util.Set;
import com.i2i.cinemax.model.Movie;
import com.i2i.cinemax.model.Theatre;
import com.i2i.cinemax.exception.CustomException;

public interface MovieService{
    
    /**  
     * Method to add movies 
     */
    public void registerMovie(Movie movie) throws CustomException;
    
    /**
     * method to check theatreId is exists or not
     */
    Theatre retrieveTheatreById(String theatreId) throws CustomException;
    
    /**
     * method to get the existing movies 
     */
    List<Movie> retrieveMovies() throws CustomException;
    
    /**
     * method to generate movie Id
     */
    String generateMovieId() throws CustomException;
      
    /**
     * method to check the movie Id is existing or not
     */
    Movie retrieveMovieById(String movieId) throws CustomException; 
    
    /**
     * method to delete movie 
     */
    void deleteMovie(String movieId) throws CustomException;
    
    /**
     * method to updateDetail of the given Movie
     */
    void updateMovieDetail(Movie movie) throws CustomException; 
    
    /**
     * Method to add the movie with the theatre
     */
    void registerTheatre(Theatre theatreDetail) throws CustomException;
    
    /**
     * Method to get all theatres
     */
    List<Theatre> retrieveTheatres() throws CustomException;
     
}
