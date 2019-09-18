package com.i2i.cinemax.util;

import com.i2i.cinemax.exception.CustomException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * This is a utility class for getting the hibernate session object.
 * @author javawithease
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();    
            System.out.println(sessionFactory);  
        }
        catch (Exception e) {
          System.out.println("Unable to build session factory");
        }
        return sessionFactory;
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
