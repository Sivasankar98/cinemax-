package com.i2i.cinemax.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.i2i.cinemax.dao.UserDao;
import com.i2i.cinemax.model.User;
import com.i2i.cinemax.model.Address;
import com.i2i.cinemax.service.UserService;
import com.i2i.cinemax.util.Util;
import com.i2i.cinemax.model.Theatre;
import com.i2i.cinemax.model.BookingMovie;
import com.i2i.cinemax.model.Movie;
import com.i2i.cinemax.exception.CustomException;
import com.i2i.cinemax.service.MovieService;
import com.i2i.cinemax.service.impl.MovieServiceImpl;
import com.i2i.cinemax.service.TheatreService;
import com.i2i.cinemax.service.impl.TheatreServiceImpl;
import org.springframework.stereotype.Service;

/*
 *  This class will come under the package of i2i
 *  this class contains the business logic
 *  In this class, it access UserDao and UserUtil class
 */
@Service
public class UserServiceImpl implements UserService {
    UserDao userDao;
    MovieService movieService;
    TheatreService theatreService;
    UserService userService;
    public UserServiceImpl(UserDao userDao, TheatreServiceImpl theatreService,
                           MovieServiceImpl movieService) {
        this.userDao = userDao;
        this.movieService = movieService;
        this.theatreService = theatreService;
    }
  
    /**
     * Method to automatically generate the userid 
     * @return userId
     */      
    public String generateUserId() throws CustomException {
        return "USER" + (userDao.countUsers() + 1); 
    }
    
    /**
     * Method used to validate the User by using userId and Password
     * @param get the User id and Password
     * @return UserRole
     */
     public String AuthenticateUser(String userId, String password) throws CustomException{
         User user = userDao.getUserById(userId); 
         if(null != user) {
             if(user.getPhoneNumber().equals(password)) {
                 if(user.getRole().equals("Admin")) {
                     return "Admin";   
                 } else if(user.getRole().equals("User")) {
                     return "User";
                 }
             }
         }
         throw new CustomException("UserId and Password is Wrong");
     }
    
    /**
     * Method to automatically generate the Bookingid 
     * @return bookingId
     */ 
    public String generateBookingId() throws CustomException {
        return "B" + (userDao.countBookings() + 1); 
    }

    /**
     * Method to Add the detail of the User
     * @param get the detail of User from User pojo class
     */
    public void createUser(User user) throws CustomException{
        userDao.insertUser(user);
    }
    
    public void bookMovie(BookingMovie booking) throws CustomException {
        userDao.bookMovie(booking);
    }
 
    /**
     * Method to delete the user by using UserId
     * @param get the user id
     */
    public void deleteUserById(String userId) throws CustomException {
        if(0 == userDao.deleteUserById(userId)) {
            throw new CustomException("unable to delete User");
        }
    }
     
    /**
     * Method used to update the detail of the user 
     * @param it get the UserDetail
     */
    public void editUserDetail(User updatedUser) throws CustomException {
        User userDetail = userDao.getUserById(updatedUser.getUserId());
        userDetail.setFirstName(updatedUser.getFirstName());
        userDetail.setLastName(updatedUser.getLastName());
        userDetail.setEmailId(updatedUser.getEmailId());
        userDetail.setPhoneNumber(updatedUser.getPhoneNumber()); 
        Address address = userDetail.getAddress().get(1);
        List<Address> addresses = updatedUser.getAddress(); 
        Address updatedAddress = addresses.get(0);
        address.setDoorNumber(updatedAddress.getDoorNumber());
        address.setStreetName(updatedAddress.getStreetName());
        address.setAreaName(updatedAddress.getAreaName());
        address.setCityName(updatedAddress.getCityName());
        address.setPinCode(updatedAddress.getPinCode());  
        userDetail.setStatus(true);
        userDao.updateUserDetail(userDetail);
    }
   
    /**
     * Method to get the List of users
     * @return all User in the form of list
     */
    public List<User> retrieveUsers() throws CustomException {
        return (userDao.fetchUsers());
    }
    
    /**
     * Method to get the User object
     * @param it get the Userid 
     * @return it get the object of User
     */
    public User getUserById(String userId) throws CustomException {
        return (userDao.getUserById(userId));
    }
    
    /**
     * Method to display all movies 
     * @return the list of movies
     */
    public List<Movie> retrieveMovies() throws CustomException {
        return movieService.retrieveMovies();
    }
    
    /**
     * Method to get the movie 
     * @param it get the movie Id this id is used to get that movie
     * @return it return the movie
     */
    public Movie getMovieById(String movieId) throws CustomException {
        return movieService.retrieveMovieById(movieId);
    }
    
    /**
     * Method to get the theatre
     * @param it get the TheatreId is used to get the movie
     * @return it return the theatre
     */
    public Theatre getTheatreById(String theatreId) throws CustomException {
        return theatreService.retrieveTheatreById(theatreId);
    }
    
    /**
     * Method to update the detail of Theatre
     * @param it get the Theatre object is used to set the update values 
     */
    public void editTheatre(Theatre theatre) throws CustomException {
        theatreService.editDetail(theatre);
    }
}
   
  
