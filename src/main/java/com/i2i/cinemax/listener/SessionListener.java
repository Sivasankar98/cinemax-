package com.i2i.cinemax.listener;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter; 
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
    LocalDateTime currentDateTime;
   
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        HttpSession session = sessionEvent.getSession();
        System.out.println("Session Id :" + session.getId());
        System.out.println(session.getAttribute("userId"));
        currentDateTime = LocalDateTime.now(); 
        String formatDateTime = currentDateTime.format(dateFormat); 
        System.out.println("Login Time :" + formatDateTime);
    }

    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        HttpSession session = sessionEvent.getSession();
        System.out.println("Session Id :" + session.getId());
        System.out.println(session.getAttribute("userId"));
        currentDateTime = LocalDateTime.now(); 
        String formatDateTime = currentDateTime.format(dateFormat); 
        System.out.println("Logout Time :" + formatDateTime);
    }
	
}
 
 

