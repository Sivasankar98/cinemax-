package com.i2i.cinemax.controller;

import java.io.IOException;   
import java.io.PrintWriter; 
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;    
import org.springframework.web.bind.annotation.ModelAttribute;   
import org.springframework.web.bind.annotation.RequestMapping;    

import com.i2i.cinemax.model.Address;
import com.i2i.cinemax.model.Movie;
import com.i2i.cinemax.model.BookingMovie;
import com.i2i.cinemax.model.User;
import com.i2i.cinemax.model.Theatre;
import com.i2i.cinemax.service.impl.UserServiceImpl;
import com.i2i.cinemax.service.UserService; 
import com.i2i.cinemax.exception.CustomException;

/** 
 * Java program to register the User profile
 * In this we can create the user profile and display the profile
 * Update the profile and Delete the profile
 * by using CRUD operation with the help of Jsp and Servlet
 * @author K.SIVASANKAR 
 * @version 1.8.0_212
 * since 05-07-2019
 */

@Controller
public class UserController { 
    UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    /**
     * To Validate User using the userId and Password 
     *
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     * @return it redirect to another page
     */
    @RequestMapping("/login")
    public ModelAndView validateUser(HttpServletRequest request,
                                     HttpServletResponse response) 
                                     throws ServletException, IOException {
        ModelAndView model = new ModelAndView();
        String userId = request.getParameter("userId");
        String password = request.getParameter("Password");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        try {
        String userRole = userService.AuthenticateUser(userId, password);
      
            if(userRole.equals("Admin")) {
                HttpSession session = request.getSession();
                session.setAttribute("userId", userId);
                model.setViewName("cinemax");
                return model;
            } else if(userRole.equals("User")) {
                HttpSession session = request.getSession();
                session.setAttribute("userId", userId);
                User user = userService.getUserById(userId);
                model.addObject("user", user);
                model.setViewName("userPage");
                return model;
            } else {
                out.println("<font color=red>Either " +
                            "user name or password is wrong.</font>");
            }
        } catch (CustomException exception) {
            return new ModelAndView("error", "error", exception);   
        } 
        return model;
    }
    
    /**
     * Method used to create an User object to store the User Detail 
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     * @return user object
     */
    @RequestMapping("/registerUser")
    public ModelAndView registerUser(HttpServletRequest request, 
                                     HttpServletResponse response) 
                                     throws ServletException, IOException {
        User user = new User();
        return new ModelAndView("userForm", "user", user);
    }
  
    /**
     * To Add an user with the data given from user to add in a storage
     *
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *      and response for an user
     */
    @RequestMapping("/createUser")
    public ModelAndView createUser(HttpServletRequest request, 
                          HttpServletResponse response, @ModelAttribute("user")User userDetail)
                          throws ServletException, IOException {
        List<Address> addresses = new ArrayList<Address>();
        ModelAndView model = new ModelAndView("userSuccessfulPage");
        try {
            userDetail.setUserId(userService.generateUserId());
            userDetail.setStatus(true);
            Address address = new Address();
            address.setDoorNumber(request.getParameter("permanentDoorNumber"));
            address.setStreetName(request.getParameter("permanentStreetName"));
            address.setAreaName(request.getParameter("permanentAreaName"));
            address.setCityName(request.getParameter("permanentCityName"));
            address.setPinCode(request.getParameter("permanentPincode")); 
            addresses.add(address);
            address = new Address();
            address.setDoorNumber(request.getParameter("presentDoorNumber"));
            address.setStreetName(request.getParameter("presentStreetName"));
            address.setAreaName(request.getParameter("presentAreaName"));
            address.setCityName(request.getParameter("presentCityName"));
            address.setPinCode(request.getParameter("presentPincode")); 
            addresses.add(address);
            userDetail.setAddress(addresses);
            userDetail.setRole("User");
            userService.createUser(userDetail);
            model.addObject("message", "User Register Successfully");
            return model;
        } catch (CustomException e) {
            return new ModelAndView("error", "error", e);
        }
    }
     
    /**
     * Method used to display the list of users 
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     * @return it viewuser page
     */
    @RequestMapping("/displayUser")
    public ModelAndView displayUser() throws ServletException, IOException {   
        try {
            List<User> users = userService.retrieveUsers();  
            return new ModelAndView("viewUsers", "users", users);
        } catch(CustomException e) {
            return new ModelAndView("error", "error", e);
        }
    }
    
    /**
     * Method used to delete the user
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     */
    @RequestMapping("/deleteUser")
    public ModelAndView deleteUser(HttpServletRequest request, 
                                   HttpServletResponse response) 
                                   throws ServletException, IOException {
        try {
            String userId = request.getParameter("userId");
            userService.deleteUserById(userId);
            return new ModelAndView("userSuccessfulPage", "message", 
                                    "User deleted successfully");   
        } catch(CustomException e) {
            return new ModelAndView("error", "error", e);    
        }  
    }
    
    /**
     * Method to get the User from the storage
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     */
    @RequestMapping("/getUser")
    public ModelAndView getUser(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
        try {
        String userId = request.getParameter("userId");
        User user = userService.getUserById(userId);
        return new ModelAndView("updateUserForm", "user", user);
        } catch(CustomException e) {
            return new ModelAndView("error", "error", e);
        }  
    } 
    
    /**
     * Method to Update the User with the data from the user 
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     */
    @RequestMapping("/updateUser")
    public ModelAndView updateUser(HttpServletRequest request, 
                             HttpServletResponse response, @ModelAttribute("user")User user) 
                             throws ServletException, IOException {
        try {
            List<Address> addresses = new ArrayList<Address>();
            Address address = new Address();
            address.setDoorNumber(request.getParameter("presentDoorNumber"));
            address.setStreetName(request.getParameter("presentStreetName"));
            address.setAreaName(request.getParameter("presentAreaName"));
            address.setCityName(request.getParameter("presentCityName"));
            address.setPinCode(request.getParameter("presentPincode"));
            addresses.add(address);
            user.setAddress(addresses);
            userService.editUserDetail(user); 
            return new ModelAndView("userSuccessfulPage", "message", 
                                    "User updated successfully");   
        } catch(CustomException e) {
            return new ModelAndView("error", "error", e);
        }   
    }
    
    /**
     * Method to book the movie ticket for the User 
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     */
    @RequestMapping("/bookingMovie")
    public ModelAndView bookingMovie(HttpServletRequest request, 
                              HttpServletResponse response) 
                              throws ServletException, IOException {
        Movie selectedMovie = null;
        Theatre selectedTheatre = null;
        try {
            String userId = (String)request.getSession(false).getAttribute("userId");
            User user = userService.getUserById(userId);
            Set<BookingMovie> bookings = user.getBookings();
            BookingMovie booking = new BookingMovie();
            String theatreId = request.getParameter("theatreId");
            String movieId = request.getParameter("movieId");
            List<Movie> movies = userService.retrieveMovies();
            for(Movie movie : movies) {
                if(movie.getMovieId().equals(movieId)) {
                    selectedMovie = movie;
                    break;
                }
            }
            Set<Theatre> theatres = selectedMovie.getTheatres();
            for(Theatre theatre : theatres) {
                if(theatre.getTheatreId().equals(theatreId)) {
                    selectedTheatre = theatre;
                    break;
                }
            } 
            booking.setMovie(selectedMovie);
            booking.setTheatre(selectedTheatre);
            String bookingId = userService.generateBookingId();
            booking.setBookingId(bookingId);
            booking.setUser(user);
            bookings.add(booking);
            user.setBookings(bookings);
            System.out.println(user);
            userService.editUserDetail(user);
            return new ModelAndView("userSuccessfulPage", "message", 
                                    "Ticket Booked Enjoy your show");   
        } catch(CustomException e) {
            return new ModelAndView("error", "error", e);
        } 
    } 
}
