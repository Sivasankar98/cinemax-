package com.i2i.cinemax.controller;

import java.io.IOException;  
import java.io.PrintWriter; 
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.RequestDispatcher;
   
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.i2i.cinemax.model.Address;
import com.i2i.cinemax.model.Theatre;
import com.i2i.cinemax.model.Movie;
import com.i2i.cinemax.service.impl.TheatreServiceImpl;
import com.i2i.cinemax.service.TheatreService;
import com.i2i.cinemax.exception.CustomException;

/* Java program to register the Theatre profile
 * In this we can create the Theatre profile and display the profile
 * Update the profile and Delete the profile
 * by using CRUD operation with the help of Jsp and Servlet
 * @author K.SIVASANKAR 
 * @version 1.8.0_212
 * since 26-08-2019
 */

@Controller
public class TheatreController  { 

    Scanner inputReader = new Scanner(System.in);
    TheatreServiceImpl theatreService;

    @Autowired
    public TheatreController(TheatreServiceImpl theatreService) {
        this.theatreService = theatreService;
    }

    /**
     * Method used to create an theatre object to store the Theatre Detail 
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     * @return theatre object
     */
    @RequestMapping("/registerTheatre")
    public ModelAndView registerTheatre(HttpServletRequest request, 
                                        HttpServletResponse response) 
                                        throws ServletException, IOException {
        Theatre theatre = new Theatre();
        return new ModelAndView("theatreForm", "theatre", theatre);
    }  

    /**
     * To Add an Theatre with the data given from user to add in a storage
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     */
    @RequestMapping("/createTheatre")
    public ModelAndView createTheatre(HttpServletRequest request, 
                                      HttpServletResponse response, 
                                      @ModelAttribute("theatre")Theatre theatre)
                                      throws ServletException, IOException {
        List<Address> addresses = new ArrayList<Address>();
        try {
            theatre.setTheatreId(theatreService.generateTheatreId());
            theatre.setStatus(true);
            Address address = new Address();
            address.setDoorNumber(request.getParameter("doorNumber"));
            address.setStreetName(request.getParameter("streetName"));
            address.setAreaName(request.getParameter("areaName"));
            address.setCityName(request.getParameter("cityName"));
            address.setPinCode(request.getParameter("pincode")); 
            addresses.add(address);
            theatre.setAddress(addresses);
            theatreService.registerTheatre(theatre);
            return new ModelAndView("theatreSuccessfulPage", "message", 
                                    "Theatre Register Successfully");
        } catch (CustomException e) {
            return new ModelAndView("error", "error", e);
        }
    }
    
    /**
     * Method used to display the list of theatres 
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     * @return list of theatres
     */
    @RequestMapping("/displayTheatres")
    public ModelAndView displayTheatres() throws ServletException, IOException {
        try{
            List<Theatre> theatres = theatreService.retrieveTheatres();
            return new ModelAndView("viewTheatres", "theatres", theatres);
        } catch (CustomException e) {
            return new ModelAndView("error", "error", e);
        }
    }   
    
    /**
     * Method to get the Theatre from the storage
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     * @return the theatre object
     */
    @RequestMapping("/getTheatre")
    public ModelAndView getTheatre(HttpServletRequest request, 
                            HttpServletResponse response) 
                            throws ServletException, IOException {
        try {
            String theatreId = request.getParameter("theatreId");
            Theatre theatreDetail = theatreService.
                                               retrieveTheatreById(theatreId);
            return new ModelAndView("updateTheatreForm", "theatre", 
                                    theatreDetail);
        } catch(CustomException e) {
            return new ModelAndView("error", "error", e);
        } 
    }  

    /**
     * Method to Update the Theatre with the data from the user 
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     * @return give a conformation message to user
     */
    @RequestMapping("/updateTheatre")
    public ModelAndView updateTheatre(HttpServletRequest request, 
                                      HttpServletResponse response, 
                                      @ModelAttribute("theatre")Theatre theatre) 
                                      throws ServletException, IOException {
        try {
            List<Address> addresses = new ArrayList<Address>();
            Address address = new Address();
            address.setDoorNumber(request.getParameter("doorNumber"));
            address.setStreetName(request.getParameter("streetName"));
            address.setAreaName(request.getParameter("areaName"));
            address.setCityName(request.getParameter("cityName"));
            address.setPinCode(request.getParameter("pincode"));
            addresses.add(address);
            theatre.setAddress(addresses);
            theatreService.editDetail(theatre); 
            return new ModelAndView("theatreSuccessfulPage", "message", 
                                    "Theatre Updated Successfully");
        } catch(CustomException e) {
            return new ModelAndView("error", "error", e);
        }   
    }
  
    /**
     * Method used to delete the Theatre
     * @param request-To get request from an user to do an operation
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from user
     *     and response for an user
     * @return give a conformation message to user
     */
    @RequestMapping("/deleteTheatre")
    public ModelAndView deleteTheatre(HttpServletRequest request, 
                               HttpServletResponse response) 
                               throws ServletException, IOException {
        try {
            String theatreId = request.getParameter("theatreId");
            theatreService.deleteTheatreById(theatreId);
            return new ModelAndView("theatreSuccessfulPage", "message", 
                                    "Theatre Deleted Successfully");
        } catch(CustomException e) {
            return new ModelAndView("error", "error", e);    
        }
    }
     
}
