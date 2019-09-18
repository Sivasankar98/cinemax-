package com.i2i.cinemax.dbconnection;

import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * DBConnection class is used to connect our bigcine application with Mysql
 * Database and close the already opened connection
 */
public class DataBaseConnection {
        
        private static DataBaseConnection dbconnection = null;
        private  DataBaseConnection() {}
        private final static String url = "jdbc:mysql://localhost:3306/cinemax?useSSL=false";
        private final static String user = "root";
        private final static String password = "i2iubuntu";
        public static DataBaseConnection getInstance() {
            if(dbconnection == null) {
                dbconnection = new DataBaseConnection();
            } 
            return dbconnection;
        }
        public Connection getConnection(Connection connection) {
            if(connection == null ) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection(url,user,password);
                } catch(ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return connection;
        }
     
        public void closeConnection(Connection connection) {
            try {    
               connection.close();
            } catch(Exception ex) {
                System.out.println("Connection is not closed" + ex);
            }
        }
    
}
