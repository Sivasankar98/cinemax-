package com.i2i.cinemax.model;

/*
 * This class is a POJO class, this class set all the details of Managers
 * and also gets the details of Managers
 */
public class Manager {
    private String theatreId;
    private String managerFirstName;
    private String managerLastName;
    private String managerPhoneNumber; 
    private String managerEmailId;
     
    public Manager() {}
    
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
    
    public String getTheatreId() {
        return theatreId;
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
    
    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }
    
}
