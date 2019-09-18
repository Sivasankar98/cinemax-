package com.i2i.cinemax.dao;

import com.i2i.cinemax.exception.CustomException;
import com.i2i.cinemax.model.Address; 
import com.i2i.cinemax.model.Manager;
import com.i2i.cinemax.model.Theatre;
import com.i2i.cinemax.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;    
import org.hibernate.Transaction;  
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
/**
 * This class contains the list of Users and the details of Users
 * all CRUD operations are done in this class
 * this class will be accessed by services
 */
@Repository
public class TheatreDao {

    /**
     * Method to register the theatre and its detail
     * @param it get the detail of Theatre from the Theatre object 
     */    
    public void insertTheatre(Theatre theatre) throws CustomException {
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession(); 
            transaction = session.beginTransaction();
            session.save(theatre);
            transaction.commit();
        } catch (HibernateException ex) {
            throw new CustomException("Unable to add Theatre value" + ex);
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("The session is not closed" + e);
            }
        }
    }
    
    /**
     * Method to count the Theatre in the Database for genertae the id  
     * @return the count
     */
    public long countTheatre() throws CustomException {
        long noOfTheatres = 0L;
        Session session = null;
        try{  
            session = HibernateUtil.getSessionFactory().openSession(); 
            Query query = session.createQuery("select count(theatre) " +
                                              " from Theatre theatre");
            noOfTheatres = (long) query.iterate().next();
        } catch(HibernateException ex) {
            throw new CustomException("Unable to count the theatre");
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("Unable to close session");
            }
        }
        return noOfTheatres;        
    }  
    
    /**
     * Method to get the all theatres 
     * @return all Theatres in table  in the form of list 
     */
    public List<Theatre> fetchTheatres() throws CustomException {
        List<Theatre> theatres = new ArrayList<Theatre>();
        Session session = null;
        try{   
            session = HibernateUtil.getSessionFactory().openSession(); 
            Query query = session.createQuery("from Theatre");
            theatres = query.list();
        } catch(HibernateException ex) {
            throw new CustomException("Unable to get all theatres");
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("Unable to close session");
            }
        }
        return theatres;        
    }
   
    /**
     * Method to delete Theatre by Theatreid
     * @param it get The theatreId used to delete that theatre 
     * @return the number of rows are affected during deletion in table 
     */
    public int deleteTheatreById(String theatreId) throws CustomException {
        int noOfRowAffected = 0;
        Transaction transaction = null;
        Session session = null;
        try{    
            session = HibernateUtil.getSessionFactory().openSession(); 
            transaction = session.beginTransaction();
            Query query = session.createQuery("update Theatre t set t.status " +
                                              " =: status where t.theatreId " +
                                              " =: theatreId");
            query.setBoolean("status", false);
            query.setParameter("theatreId", theatreId);
            noOfRowAffected = query.executeUpdate();
            transaction.commit();
        } catch(HibernateException ex) {
            if(null != transaction) {
                transaction.rollback();
            }
            throw new CustomException("Unable to delete theatre");
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
     * Method to get the Theatre by using theatre Id 
     * @param it get the theatre id used to get the Theatre 
     * @return that theatre object
     */
    public Theatre fetchTheatreById(String theatreId) throws CustomException {
        Session session = null;
        Theatre theatre;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Theatre t where t.theatreId"+
                                              "=: theatreId");
            query.setParameter("theatreId", theatreId);
            theatre = (Theatre) query.uniqueResult();
        } catch(HibernateException exception) {
            throw new CustomException("Unable to get the theatre ");
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("Unable to close session");
            }
        }
        return theatre;
    }   
    
    /** 
     * Method to update the Theatre Detail
     * @param it get the theatre Object it used to set the updated value 
     */
    public void updateDetail(Theatre theatre) throws CustomException {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession(); 
            transaction = session.beginTransaction();
            session.saveOrUpdate(theatre);
            transaction.commit();
        } catch(HibernateException exception) { 
            exception.printStackTrace();
            throw new CustomException("Data is too long so not Added, please " +
                                  "Enter data within 20 character" + exception);
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("Unable to close session");
            }
        }
    }   
}
