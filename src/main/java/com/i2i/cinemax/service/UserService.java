package com.i2i.cinemax.service;

import java.util.List;
import com.i2i.cinemax.model.User;
import com.i2i.cinemax.model.Address;
import com.i2i.cinemax.model.Theatre;
import com.i2i.cinemax.model.BookingMovie;
import com.i2i.cinemax.model.Movie;
import com.i2i.cinemax.service.MovieService;
import com.i2i.cinemax.service.impl.MovieServiceImpl;
import com.i2i.cinemax.exception.CustomException;

public interface UserService {
  
    /**
     * Method to generate Userid
     */    
    String generateUserId() throws CustomException;
    
    /**
     * Method to add details of User 
     */  
    void createUser(User person)  throws CustomException;
    
    void bookMovie(BookingMovie booking) throws CustomException;
    String AuthenticateUser(String UserId, String Password) throws CustomException;
    /**
     * Method to delete the User and its detail by userId
     */
    void deleteUserById(String userId) throws CustomException ;
    
    /**
     * Method to update the detail of the User using userId 
     */
    void editUserDetail(User updatedUser) throws CustomException ;
    
    /**
     * Method to get the entire User details in the list
     */
    List<User> retrieveUsers() throws CustomException;
    
    /**
     * Method to get the User object 
     */     
    User getUserById(String userId) throws CustomException; 
    
    /**
     * Method to display the all movies
     */
    List<Movie> retrieveMovies() throws CustomException;
  
    /**
     * Method to get Movie by using movieId
     */  
    Movie getMovieById(String movieId) throws CustomException;
    
    /**
     * Methos to get Theatre by using TheatreId
     */
    Theatre getTheatreById(String theatreId) throws CustomException;
    
    /**
     * Method to generate booking Id 
     */
    String generateBookingId() throws CustomException;
 
    /**
     * Method to update Theatre Detail
     */
    void editTheatre(Theatre theatre) throws CustomException;
}
