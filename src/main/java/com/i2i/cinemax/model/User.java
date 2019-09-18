package com.i2i.cinemax.model;


import java.util.Set;
import java.util.List;

import com.i2i.cinemax.model.Address;

/*
 * This class is a POJO class, this class set all the details of User
 * and also gets the details of Users
 */

public class User {
    private String phoneNumber;
    private String userId;
    private String firstName;
    private String lastName;
    private String emailId;
    private boolean status;
    private String role;
    private List<Address> address;
    private Set<BookingMovie> bookings;
   
    /* Using getter and setter method */

    public User() { }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getUserId() {
        return userId; 
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    public String getEmailId() {
        return emailId;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public boolean getStatus() {
        return status;
    }
    
    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Address> getAddress() {
        return address;
    }
    
      
    public void setBookings(Set<BookingMovie> bookings) {
        this.bookings = bookings;
    }
    
    public Set<BookingMovie> getBookings() {
        return bookings;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getRole() {
        return role;
    }
    
    public String toString() {
        return (getUserId() + "\t" + getFirstName() + "\t"
               + getLastName() + "\t" + getPhoneNumber() + "\t" 
               + getEmailId() + "\t" + getRole());  
    }
}
    
