package com.i2i.cinemax.dao;

import com.i2i.cinemax.exception.CustomException;
import com.i2i.cinemax.model.Movie;
import com.i2i.cinemax.util.HibernateUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;    
import org.hibernate.Transaction;  
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * This class contains the list of Movies and the details of movies
 * all CRUD operations are done in this class
 */
@Repository
public class MovieDao {
    
    /**
     * Method to register the movie and its details
     * @param it get the detail of movie from the Movie pojo class
     */  
    public void insertMovie(Movie movie) throws CustomException {
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession(); 
            transaction = session.beginTransaction();
            session.saveOrUpdate(movie);
            transaction.commit();
        } catch (HibernateException ex) {
            throw new CustomException("Unable to distribute movie, because this match is already paired " );
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("Unable to close session");
            }
        }
    }
    
    /**
     * Method to get the entire detail of movie from the database
     * @return it returns the entire movie in form of list
     */
    public List<Movie> fetchMovies() throws CustomException {
        List<Movie> movies = new ArrayList<Movie>();
        Session session = null;
        try{   
            session = HibernateUtil.getSessionFactory().openSession(); 
            Query query = session.createQuery("from Movie");
            movies = query.list();
        } catch(HibernateException ex) {
            throw new CustomException("Unable to get all movies");
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("Unable to close session");
            }
        }
        return movies;        
    }
    
    /**
     * Method to count the MoviesId for generate movieId
     * @return the int count value  
     */
    public long countMovie() throws CustomException {
        long noOfMovie = 0L;   
        Session session = null;
        try {    
            session = HibernateUtil.getSessionFactory().openSession(); 
            Query query = session.createQuery("select count(m) from Movie m");
            noOfMovie = (long) query.uniqueResult();
        } catch(HibernateException ex) {
            throw new CustomException("Unable to count Movies" + ex);
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("Unable to close session");
            }
        }
        return noOfMovie;        
    }  
    
    
    /**
     * Method to update the status of movie in the database
     * @param get the movie Id for update
     */   
    public int updateMovieStatus(String movieId) throws CustomException {
        int noOfRowAffected = 0;
        Transaction transaction = null;
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession(); 
            transaction = session.beginTransaction();
            Query query = session.createQuery("update Movie set status " +
                                       " = : status where movie_id = :movieId");
            query.setBoolean("status", true);
            query.setParameter("movieId", movieId);
            noOfRowAffected = query.executeUpdate();
            transaction.commit();
        } catch(HibernateException ex) {
            if(null != transaction) {
                transaction.rollback();
            }
            throw new CustomException("Unable to update movie status " + ex);
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
     * Method used to check the given movie id in the existing movies
     * @param get the movieId
     * @return the equvialent boolean value for given input
     */
    public Movie getMovieById(String movieId) throws CustomException {
        Session session = null;
        Movie movieDetail;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Movie m where  " + 
                                              "m.movieId = :movieId");
            query.setParameter("movieId", movieId);
            movieDetail = (Movie) query.uniqueResult();
        } catch(HibernateException exception) {
            throw new CustomException("Unable to get the movie");
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("Unable to close session");
            }
        }
        return movieDetail;
    }   
    
    /**
     * Method to delete the movie by using movieId
     * @param get the movieId used to delete that user 
     * @return number of affected in the table in integer value 
     */
    public int deleteMovieById(String movieId) throws CustomException{
        int noOfRowAffected = 0;
        Transaction transaction = null;
        Session session = null;
        try{    
            session = HibernateUtil.getSessionFactory().openSession(); 
            transaction = session.beginTransaction();
            Query query = session.createQuery("update Movie m set m.status = :status"
                                              + " where m.movieId = :movieId");
            query.setBoolean("status", false);
            query.setParameter("movieId", movieId);
            noOfRowAffected = query.executeUpdate();
            transaction.commit();
        } catch(HibernateException ex) {
            if(null != transaction) {
                transaction.rollback();
            }
            throw new CustomException("Unable to delete the given movie");
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
     * Method to update the detail of movie 
     * @param get the detail of movie  used to update the value 
     */
    public void updateMovieDetail(Movie movie) throws CustomException {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession(); 
            transaction = session.beginTransaction();
            session.saveOrUpdate(movie);
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
}
