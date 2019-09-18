package com.i2i.cinemax;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.i2i.cinemax.controller.TheatreController;
import com.i2i.cinemax.controller.UserController;
import com.i2i.cinemax.controller.MovieController;
import com.i2i.cinemax.service.MovieService;
import com.i2i.cinemax.service.TheatreService;
import com.i2i.cinemax.service.UserService;
import com.i2i.cinemax.service.impl.MovieServiceImpl;
import com.i2i.cinemax.service.impl.TheatreServiceImpl;
import com.i2i.cinemax.service.impl.UserServiceImpl;
import com.i2i.cinemax.dbconnection.DataBaseConnection;
import com.i2i.cinemax.exception.CustomException;
import com.i2i.cinemax.util.HibernateUtil;
import com.i2i.cinemax.util.Util;
import com.i2i.cinemax.dao.MovieDao;
import com.i2i.cinemax.dao.TheatreDao;
import com.i2i.cinemax.dao.UserDao;
import com.i2i.cinemax.model.Address;
import com.i2i.cinemax.model.Manager;
import com.i2i.cinemax.model.Theatre;
import com.i2i.cinemax.model.Movie;
import com.i2i.cinemax.model.User;
import com.i2i.cinemax.filter.AuthenticationFilter;
import com.i2i.cinemax.listener.SessionListener;
import com.i2i.cinemax.controller.LogoutServlet;




/* Java program to choose to register  the  user or theatre or else
 * movie managament . In this we can create the  profile and display the profile
 * Update the profile and Delete the profile
 * by using CRUD operation with the help of collections
 * @author K.SIVASANKAR 
 * @version 1.8.0_212
 * since 15-07-2019
 */

public class MainController {
    public static void main(String[] args) {
        //UserController userController = new UserController(); 
       // TheatreController theatreController = new TheatreController(); 
       // MovieController movieController = new MovieController();
        HibernateUtil hibernate = new HibernateUtil();
        int optionOfUser;
        System.out.println(); 
        do {
            System.out.println("----------------Welcome----------------");
            System.out.println("Which Management you want to choose ");
            System.out.println("1:Movie Management");
            System.out.println("2:Theatre Management");
            System.out.println("3:User Management");
            System.out.println("4:Exit");
            System.out.println("Enter your option ");
            optionOfUser = getChoice();
            switch(optionOfUser) {
                case 1:
                    /* Call the method movieManagement in class MovieController */
                    //movieController.movieManagement();             
                    break;
                case 2:
                    /* Call the method theatreManagement in class TheatreController */
                  //  theatreController.theatreManagement();                   
                    break;
                case 3:
                    /* Call the method userManagement in class UserController */
                   // userController.userManagement();   
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Enter the valid option");
                    break;
            }
        } while(4 != optionOfUser);
    }
    
    /**
     * Method used to get value from user
     */
    private static int getChoice() {
        Scanner inputReader = new Scanner(System.in);
        int choice = 0;
        try {
            choice = inputReader.nextInt();
            return choice;
        } catch(InputMismatchException e) {
            System.out.println("Please enter the value in Number");
        }
        return 0;
    }
}
