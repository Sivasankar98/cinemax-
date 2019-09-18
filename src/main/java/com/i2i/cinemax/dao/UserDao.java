package com.i2i.cinemax.dao;
 
import com.i2i.cinemax.model.Address;
import com.i2i.cinemax.model.User;
import com.i2i.cinemax.model.BookingMovie;
import com.i2i.cinemax.exception.CustomException;
import com.i2i.cinemax.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;  
import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.springframework.stereotype.Repository;

/*
 * this class contains the list of Users and the details of Users
 * all CRUD operations are done in this class
 * this class will be accessed by services
 */
@Repository
public class UserDao {
    
    /**
     * Method to register the User and its details
     * @param it get the UserDetails
     */  
    public void insertUser(User userDetail) throws CustomException {
        Session session = null;
        Transaction transaction = null;
        try{   
            session = HibernateUtil.getSessionFactory().openSession(); 
            System.out.println(session);
            transaction = session.beginTransaction();
            session.save(userDetail);
            transaction.commit();
        } catch (HibernateException ex) {
            throw new CustomException("Unable to add " + userDetail.getUserId() + " value" + ex);
        }finally {
            try {
                session.close(); 
            } catch(Exception e) {
                throw new CustomException("Unable to close session");
            }
        }
    } 
    
     public void bookMovie(BookingMovie booking) throws CustomException {
        Session session = null;
        Transaction transaction = null;
        try{    
            session = HibernateUtil.getSessionFactory().openSession(); 
            transaction = session.beginTransaction();
            session.saveOrUpdate(booking);
            transaction.commit();
        } catch (HibernateException ex) {
            throw new CustomException("Unable to book Movie " + ex);
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("Unable to close session");
            }
        }
    } 
    /**
     * Method used to update the detail of the user 
     * @param get the object of the User
     */
    public void updateUserDetail(User user) throws CustomException {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession(); 
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
        } catch(HibernateException exception) { 
             throw new CustomException("Data is too long so not Added,please " + 
                                  "Enter data within 20 character" + exception);
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("Unable to close session");
            }
        }
    } 
       
    /**
     * Method used to display the UserDetail 
     * @return all users in the form of list 
     */
    public List<User> fetchUsers() throws CustomException {
        List<User> users = new ArrayList<User>();
        Session session = null;
        try{    
            session = HibernateUtil.getSessionFactory().openSession(); 
            Query query = session.createQuery("from User");
            users = query.list();
        } catch(HibernateException ex) {
            throw new CustomException("Unable to get all users");
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("Unable to close session");
            }
        }
        return users;        
    }
    
    /**
     * Method used to get the User object
     * @param it get the userId
     * @return it retun the User object  
     */
    public User getUserById(String userId) throws CustomException {
        User user = null;
        Session session = null;
        try{    
            session = HibernateUtil.getSessionFactory().openSession(); 
            Query query = session.createQuery("from User u where u.userId = : userId");
            query.setParameter("userId", userId);
            user = (User) query.uniqueResult();
        } catch(HibernateException ex) {
            throw new CustomException("The user is not registered");
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("Unable to close session");
            }
        }
        return user;        
    }
    
    /** 
     * Method to delete the User by Id
     * @param it get the userId
     * @return the int value 
     */        
    public int deleteUserById(String userId) throws CustomException {
        int noOfRowAffected = 0;
        Transaction transaction = null;
        Session session = null;
        try{    
            session = HibernateUtil.getSessionFactory().openSession(); 
            transaction = session.beginTransaction();
            Query query = session.createQuery("update User u set  " +
                                              "u.status = :status " + 
                                              " where u.userId = :userId");
            query.setBoolean("status", false);
            query.setParameter("userId", userId);
            noOfRowAffected = query.executeUpdate();
            transaction.commit();
        } catch(HibernateException ex) {
            if(null != transaction) {
                transaction.rollback();
            }
            throw new CustomException("Unable to delete the given User");
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("Unable to close session");
            }
        }
        return noOfRowAffected;
    }   

    /**
     * Method to count the number of users
     * @ return the count of users in the dataBase
     */
    public long countUsers() throws CustomException {
        long noOfUser = 0L;
        Session session = null;
        try{  
            session = HibernateUtil.getSessionFactory().openSession(); 
            Query query = session.createQuery("select count(u.userId) from User u ");
            noOfUser = (Long) query.iterate().next();
        } catch(HibernateException ex) {
            throw new CustomException("Unable to count User");
       } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("Unable to close session");
            }
        }
        return noOfUser;        
    }
    
    
    /**
     * Method to count the number of Bookings
     * @ return the count of users in the dataBase
     */
    public long countBookings() throws CustomException {
        long noOfBookings = 0L;
        Session session = null;
        try{  
            session = HibernateUtil.getSessionFactory().openSession(); 
            Query query = session.createQuery("select count(b.bookingId) from BookingMovie b ");
            noOfBookings = (Long) query.iterate().next();
        } catch(HibernateException ex) {
            throw new CustomException("Unable to count Bookings");
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("Unable to close session");
            }
        }
        return noOfBookings;        
    }
}
