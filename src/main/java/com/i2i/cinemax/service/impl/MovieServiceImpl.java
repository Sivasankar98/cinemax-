package com.i2i.cinemax.service.impl;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import com.i2i.cinemax.util.Util;
import com.i2i.cinemax.dao.MovieDao;
import com.i2i.cinemax.service.MovieService;
import com.i2i.cinemax.model.Movie;
import com.i2i.cinemax.model.Theatre;

import com.i2i.cinemax.service.impl.TheatreServiceImpl;
import com.i2i.cinemax.service.TheatreService;
import com.i2i.cinemax.exception.CustomException;

import org.springframework.stereotype.Service;

    /*
     * this class will come under the package of i2i
     * this class contains the business logic
     * In this class, it access movieDao and Util class
     */

@Service
public class MovieServiceImpl implements MovieService {
    MovieDao movieDao;
    TheatreService theatreService;

    public MovieServiceImpl(MovieDao movieDao, TheatreServiceImpl theatreService) {
        this.movieDao = movieDao;
        this.theatreService = theatreService;
    }
   
    /**
     * method to add the detail of the movie 
     * @param it get the value from the Movie pojo
     */
    public void registerMovie(Movie movie) throws CustomException{
        movieDao.insertMovie(movie);
    }
    
    /**
     * method to generate movie Id
     * return movieId
     */
    public String generateMovieId() throws CustomException{
         return "M" + (movieDao.countMovie()+1); 
    }

    /**
     * Method to check the given theatreId in the theatre table
     * @param get the value of theatre Id
     * @return boolean value 
     */
    public Theatre retrieveTheatreById(String theatreId) throws CustomException {
        return theatreService.retrieveTheatreById(theatreId);
    } 
    
    /**
     * Method to check the movieId in the Movie Table
     * @param it get the movieid
     * @return boolean for the given input
     */
    public Movie retrieveMovieById(String movieId) throws CustomException {
        return movieDao.getMovieById(movieId);
    } 
 
    /**
     * Method to get all movies 
     * Return all movies in form of list
     */
    public List<Movie> retrieveMovies() throws CustomException{
        return (movieDao.fetchMovies());
    }
    
    /**
     * Method to delete the movie by using movieId
     * @param get the movieId   
     */
    public void deleteMovie(String movieId) throws CustomException {
        if(0 == movieDao.deleteMovieById(movieId)) {
            throw new CustomException("Unable to delete Movie");
        }
    }
    
    /**
     * Method to update the detail of movie
     * @params it get the Movie pojo class and also get the movieId
     */
    public void updateMovieDetail(Movie updateMovie) throws CustomException{
        Movie movie = movieDao.getMovieById(updateMovie.getMovieId());
        movie.setMovieName(updateMovie.getMovieName());
        movie.setLanguage(updateMovie.getLanguage());
        movie.setShowDate(updateMovie.getShowDate());
        movie.setDirectorName(updateMovie.getDirectorName());
        movie.setStatus(true);
        movieDao.updateMovieDetail(movie);
    } 
    
    /**
     * Method to Add theatre with the Movie
     */
    public void registerTheatre(Theatre theatreDetail) throws CustomException {
        theatreService.editDetail(theatreDetail);
    }
    
    /**
     * Method to get all theatres 
     */
    public List<Theatre> retrieveTheatres() throws CustomException {
        return theatreService.retrieveTheatres();
    }
}
