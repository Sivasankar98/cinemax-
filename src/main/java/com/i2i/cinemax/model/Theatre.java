package com.i2i.cinemax.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.i2i.cinemax.model.Address;
import com.i2i.cinemax.model.Movie;



/**
 * this class is a POJO class, this class set all the details of Theatres
 * and also gets the details of Theatres
 */

public class Theatre {
    private String phoneNumber;
    private String theatreId;
    private String theatreName;
    private String emailId;
    private String theatreLocation;
    private String managerFirstName;
    private String managerLastName;
    private String managerPhoneNumber; 
    private String managerEmailId;
    private boolean status;
    private List<Address> address;
    private List<Movie> movies;
    private Set<BookingMovie> bookings;
    
    /**
     * Getter and setter method
     */
      
    public Theatre() {}
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getTheatreId() {
        return theatreId; 
    }
    
    public String getTheatreName() {
        return theatreName;
    }
    
    public String getEmailId() {
        return emailId;
    }
    
    public String getTheatreLocation() {
        return theatreLocation;
    }
    
    public boolean getStatus() {
        return status;
    }
 
    public List<Address> getAddress() {
        return address;
    }

  
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }
     
    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    public void setTheatreLocation(String theatreLocation) {
        this.theatreLocation = theatreLocation;
    }
        
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void setAddress(List<Address> address) {
        this.address = address;
    }
    
   

    /**
     * getter setter method for manager details
     */
    
    public String getManagerFirstName() {
        return managerFirstName;
    }
    
    public String getManagerLastName() {
        return managerLastName;    
    }
    
    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }
    
    public String getManagerEmailId() {
        return managerEmailId;
    }
    
   
    public void setManagerFirstName(String managerFirstName) {
        this.managerFirstName = managerFirstName;
    }
    
    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }
    
    public void setManagerPhoneNumber(String managerPhoneNumber) {
        this.managerPhoneNumber = managerPhoneNumber;
    }
    
    public void setManagerEmailId(String managerEmailId) {
        this.managerEmailId = managerEmailId;
    }
    
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
    public List<Movie> getMovies() {
        return movies;
    }
    
    public void setBookings(Set<BookingMovie> bookings) {
        this.bookings = bookings;
    }
    
    public Set<BookingMovie> getBookings() {
        return bookings;
    }
   
  
    public String toString() {
        return (getTheatreId() + "\t" + getTheatreName() + "\t"
               + getTheatreLocation() + "\t" + getPhoneNumber() + "\t" + getEmailId() + "\t"); 
    }
}
    
