package com.i2i.cinemax.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import com.i2i.cinemax.model.Theatre;

/**
 * this class Movie is used to set and get the movie detail and its value
 */
public class Movie {
    
    private String movieName;
   
    private String showDate;
    
    private String language;
    
    private boolean status;
    private String movieId;
    private String directorName;
    private Set<Theatre> theatres;
    private Set<BookingMovie> bookings;

    public Movie() {}
    
    //used getter and setter method 
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    
  

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }
    
  
    
    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
   
  
     
    public void setLanguage(String language) {
        this.language = language;
    }

   
    
    public void setTheatres(Set<Theatre> theatres) {
        this.theatres = theatres;
    }
    
    public Set<Theatre> getTheatres() {
        return theatres;
    }
    
    
    public String getMovieId() {
        return movieId;
    }
    
    public String getMovieName() {
        return movieName;
    }
    
    
    public String getShowDate() {
        return showDate;
    }

    public boolean getStatus() {
        return status;
    }
     
    public String getLanguage() {
        return language;
    }
    
    
    
    public String getDirectorName() {
        return directorName;
    }
    
    public void setBookings(Set<BookingMovie> bookings) {
        this.bookings = bookings;
    }
    
    public Set<BookingMovie> getBookings() {
        return bookings;
    }
   
    
    
   public String toString() {
       return (  "\t" + getMovieId() + "\t" + getMovieName() +
                "\t" + getLanguage() + 
                "\t" + getShowDate() + "\t" + getStatus() + "\t" + getDirectorName() );
   }
}
