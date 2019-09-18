package com.i2i.cinemax.controller;

import java.io.IOException;  
import java.io.PrintWriter; 
import java.util.ArrayList;
import java.util.HashSet; 
import java.util.List;
import java.util.Scanner;
import java.util.Set;
  
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;     
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;      
import org.springframework.web.servlet.ModelAndView;

import com.i2i.cinemax.model.Movie;
import com.i2i.cinemax.model.Theatre;
import com.i2i.cinemax.model.User;
import com.i2i.cinemax.service.TheatreService;
import com.i2i.cinemax.service.impl.TheatreServiceImpl;
import com.i2i.cinemax.service.MovieService;
import com.i2i.cinemax.service.impl.MovieServiceImpl;
import com.i2i.cinemax.exception.CustomException;
 
/* Java program to register the Movies profile
 * In this we can create the Movie profile and display the profile
 * Update the profile and Delete the profile
 * by using CRUD operation with the help of collections
 * @author K.SIVASANKAR 
 * @version 1.8.0_212
 * since 27-07-2019
 */

@Controller
public class MovieController {
    Scanner input = new Scanner(System.in);
    MovieServiceImpl movieService;

    @Autowired
    public MovieController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }
    
    /**
     * Method used to create an Movie object to store the Movie Detail 
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     * @return movie object
     */
    @RequestMapping("/registerMovie")
    public ModelAndView registerMovie() throws ServletException, IOException {
        Movie movie = new Movie();
        return new ModelAndView("movieForm", "movie", movie);
    }

    /**
     * To create Movie with the data given from user to add in a storage
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     * @return a conformation message to the user
     */
    @RequestMapping("/createMovie")
    public ModelAndView createMovie(@ModelAttribute("movie")Movie movie) 
                               throws ServletException, IOException {
        try {
            String movieId = movieService.generateMovieId();
		    movie.setMovieId(movieId);
		    movie.setStatus(true);
		    movieService.registerMovie(movie);
            return new ModelAndView("successfulPage", "message",
                                    "Movie register Successfully");
        } catch(CustomException e) {
            return new ModelAndView("error", "error", e);
        }   
    }
    
    /**
     * Method used to display the list of Movies 
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     * @return list of Movies
     */
    @RequestMapping("/displayMovies")
     public ModelAndView displayMovies() throws ServletException, IOException {
        try{
            List<Movie> movies = movieService.retrieveMovies();
            return new ModelAndView("viewMovies", "movies", movies);
        } catch (CustomException e) {
            return new ModelAndView("error", "error", e);
        }
    }    
    
    /**
     * Method to get the Movie object from the storage
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     * @return the movie object
     */
    @RequestMapping("/getMovie")
    public ModelAndView getMovie(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
        try {
            String movieId = request.getParameter("movieId");
            Movie movie = movieService.retrieveMovieById(movieId);
            return new ModelAndView("updateMovieForm", "movie", movie);
        } catch(CustomException e) {
            return new ModelAndView("error", "error", e);
        }  
    } 
    
    /**
     * Method to Update the Movie with the data from the user 
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     * @return give a conformation message to user
     */
    @RequestMapping("/updateMovie")
    public ModelAndView updateMovie(@ModelAttribute("movie")Movie movie) 
                                    throws ServletException, IOException {
        try {
            movieService.updateMovieDetail(movie);
            return new ModelAndView("successfulPage", "message",
                                    "Movie Updated Successfully");
        } catch(CustomException e) {
            return new ModelAndView("error", "error", e);
        }   
    }
    
    /**
     * Method used to delete the Movie
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     * @return give a conformation message to user
     */
    @RequestMapping("/deleteMovie")
    public ModelAndView deleteMovie(HttpServletRequest request, 
                             HttpServletResponse response) 
                             throws ServletException, IOException {
        try {
            String movieId = request.getParameter("movieId");
            movieService.deleteMovie(movieId);
            return new ModelAndView("successfulPage", "message",
                                    "Movie Deleted Successfully");
        } catch(CustomException e) {
            return new ModelAndView("error", "error", e);
        }
    } 

    /**
     * Method used to retrieve the list Theatre
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     * @return a list of theatres
     */
    @RequestMapping("/selectTheatres")
    public ModelAndView retrieveTheatres(HttpServletRequest request, 
                                 HttpServletResponse response) 
                                 throws ServletException, IOException {
        String movieId = request.getParameter("movieId");
        try{
            Movie movieDetail = movieService.retrieveMovieById(movieId); 
            HttpSession session = request.getSession(true);
            session.setAttribute("movie", movieDetail);
            List<Theatre> theatres = movieService.retrieveTheatres();
            return new ModelAndView("distribute", "theatres", theatres);
        } catch(CustomException e) {
            return new ModelAndView("error", "error", e);
        }     
    }
   
    /**
     * Method used to distribute the movie to Theatre
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     * @return a conformation message to user
     */ 
    @RequestMapping("/distributeMovie")
     public ModelAndView distributeMovie(HttpServletRequest request, 
                                 HttpServletResponse response) 
                                 throws ServletException, IOException {
        try{
            String theatreId = request.getParameter("theatre");
            Theatre theatre = movieService.retrieveTheatreById(theatreId);
            Movie movie = (Movie)request.getSession(false).
                                                          getAttribute("movie");
            if(null != theatre && null != movie) {
                Set<Theatre> theatres = movie.getTheatres();            
                theatres.add(theatre);
                movie.setTheatres(theatres);
                movieService.registerMovie(movie);
            }
            return new ModelAndView("successfulPage", "message", 
                                        "Movie Successfully distributed");
        } catch(CustomException e) {
            return new ModelAndView("error", "error", e);
        }    
    }
    
    /**
     * Method used to retrieve the list of movie to user selection 
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     * @return a list of movies
     */ 
    @RequestMapping("/selectMovies")
    public ModelAndView selectMovies(HttpServletRequest request, 
                                     HttpServletResponse response) 
                                     throws ServletException, IOException {
        ModelAndView model = new ModelAndView("viewMoviesInTheatres");
        try {
            String userId = request.getParameter("userId");
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", userId);
            List<Movie> movies = movieService.retrieveMovies();
            return new ModelAndView("viewMoviesInTheatres", "movies", movies);
        } catch (CustomException e) {
            return new ModelAndView("error", "error", e);
        }
    }
}
    
