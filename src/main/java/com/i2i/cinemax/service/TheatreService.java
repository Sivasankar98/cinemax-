package com.i2i.cinemax.service;

import java.util.List;
import com.i2i.cinemax.model.Movie;
import com.i2i.cinemax.model.Manager;
import com.i2i.cinemax.model.Address;
import com.i2i.cinemax.model.Theatre;
import com.i2i.cinemax.exception.CustomException;

public interface TheatreService {
    /**
     * Method to generate Theatreid
     */
    String generateTheatreId() throws CustomException;

    /**
     * Method to add details of Theatre 
     */  
    void registerTheatre(Theatre theatreDetail) throws CustomException; 
           
    /**
     * Method to update the detail of the theatre using theatreId 
     */
    void editDetail(Theatre theatreDetail) throws CustomException;
    
    /**
     * Method to get the entire theatre details in the list
     */
   List<Theatre> retrieveTheatres() throws CustomException;
    
    /**
     * Method to delete the Theatre and its detail by theatreId
     */
    void deleteTheatreById(String TheatreId) throws CustomException;
    
    /**
     * Method to check the TheatreId and return the particular object
     */
    Theatre retrieveTheatreById(String theatreId) throws CustomException;
}
