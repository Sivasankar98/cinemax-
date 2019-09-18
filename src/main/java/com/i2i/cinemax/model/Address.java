package com.i2i.cinemax.model;

import java.util.Set;
import com.i2i.cinemax.model.User;
/**
 * this POJO class is to set the user address in Address type
 * and also gets the address in Address type 
 */

public class Address {
  
    private String doorNumber;
    private String streetName;
    private String areaName;
    private String cityName;
    private String pinCode;
    private int id;
    private Set<BookingMovie> bookings;

   // private Date registeredDate;
   // private Date updatedDate;
    
    /* using getter and setter method */
    
    public Address() { }
    
    public int getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }  
   
    public String getDoorNumber() {
        return doorNumber;
    }
    
    public String getAreaName() {
        return areaName;
    }
    
    public String getCityName() {
        return cityName;
    }
    
    public String getPinCode() {
        return pinCode;
    }

 /*   public Date getregisteredDate() {
        return registeredDate;
    }

    public Date getupdatedDate() {
        return updatedDate;
    }*/ 
  
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;    
    } 
    
   public void setId(int id) {
        this.id = id;    
    } 
    
    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    } 
   
       
    public void setBookings(Set<BookingMovie> bookings) {
        this.bookings = bookings;
    }
    
    public Set<BookingMovie> getBookings() {
        return bookings;
    }

  
    
    
  /*  public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
    
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
*/    
    public String toString() {
        return (getId() + "\t " + getStreetName() + "\t" + getAreaName() + "\t"
               + getCityName() + "\t" + getPinCode() + "\t");
    }
}
