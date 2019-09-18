package com.i2i.cinemax.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.i2i.cinemax.util.Util;
import com.i2i.cinemax.model.Theatre;
import com.i2i.cinemax.model.Address;
import com.i2i.cinemax.model.Manager;
import com.i2i.cinemax.dao.TheatreDao;
import com.i2i.cinemax.service.TheatreService;
import com.i2i.cinemax.exception.CustomException;
import org.springframework.stereotype.Service;

/*
 * this class will come under the package of i2i
 * this class contains the business logic
 * In this class, it access TheatreDao and Util class
 */
@Service
public class TheatreServiceImpl implements TheatreService {
    TheatreDao theatreDao;

    public TheatreServiceImpl(TheatreDao theatreDao) {
        this.theatreDao = theatreDao;
    }
  
    /**
     * Method to automatically generate the Theatreid 
     * @return TheatreId
     */     
    public String generateTheatreId() throws CustomException {
        return "TH" + (theatreDao.countTheatre() + 1); 
    }
    
    /**
     * Method to Add the detail of the Theatre
     * @param get the detail of Theatre from theatre pojo class
     */
    public void registerTheatre(Theatre theatreDetail) throws CustomException{
        theatreDao.insertTheatre(theatreDetail);
    }
    
    /**
     * Method to update the detail of Theatre using theatreId
     * @param get the theatreId and updating TheatreDetails from Theatre class
     */ 
    public void editDetail(Theatre updatedTheatre) throws CustomException{
        System.out.println(updatedTheatre);
        System.out.println(updatedTheatre.getTheatreId());
        Theatre theatre = theatreDao.fetchTheatreById(updatedTheatre.getTheatreId());
        theatre.setTheatreName(updatedTheatre.getTheatreName());
        theatre.setTheatreLocation(updatedTheatre.getTheatreLocation());
        theatre.setPhoneNumber(updatedTheatre.getPhoneNumber());
        theatre.setEmailId(updatedTheatre.getEmailId()); 
        Address address = theatre.getAddress().get(0);
        List<Address> addresses = updatedTheatre.getAddress(); 
        Address updatedAddress = addresses.get(0);
        address.setDoorNumber(updatedAddress.getDoorNumber());
        address.setStreetName(updatedAddress.getStreetName());
        address.setAreaName(updatedAddress.getAreaName());
        address.setCityName(updatedAddress.getCityName());
        address.setPinCode(updatedAddress.getPinCode());  
        theatre.setStatus(true);
        theatreDao.updateDetail(theatre);
    }
    
    /**
     * Method to get the all theatres
     * @return all Theatre in the form of list
     */
    public List<Theatre> retrieveTheatres() throws CustomException {
        return theatreDao.fetchTheatres();
    }
     
    /**
     * Method to delete the Theatre by using theatreId
     * @param get the Theatre id
     */
    public void deleteTheatreById(String theatreId) throws CustomException {
        if(0 == theatreDao.deleteTheatreById(theatreId)) {
            throw new CustomException("Theatre is not deleted");
        }
    }
    
    /**
     * Method to check the theatreId is present or not 
     * @param it get the TheatreId
     * @return that particular object
     */
    public Theatre retrieveTheatreById(String theatreId) throws CustomException {
        return theatreDao.fetchTheatreById(theatreId);
    }
}
   
  
