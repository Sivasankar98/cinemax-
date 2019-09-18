package com.i2i.cinemax.model;
 
import java.util.Set;

import com.i2i.cinemax.model.User;
import com.i2i.cinemax.model.Theatre;
import com.i2i.cinemax.model.Movie;
import com.i2i.cinemax.model.Address;

public class BookingMovie {
    private User user;
    private Theatre theatre;
    private Movie movie;
    private String bookingId;
    
    public BookingMovie() {}
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
    
    public Theatre getTheatre() {
        return theatre;
    }
    
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    public Movie getMovie() {
        return movie;
    }
    
    
    
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
    
    public String getBookingId() {
        return bookingId;
    }
    
    public String toString() {
        return (getUser() + "\t" + getMovie() + "\t" + getTheatre() + "\t" 
                + getBookingId());
    }
}
