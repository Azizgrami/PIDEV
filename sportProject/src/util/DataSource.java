/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ayedi
 */
public class DataSource {
     //DB Credentials
    //final String URL = "jdbc:mysql://localhost:3306/pidev4secrud";
    
    final String URL = "jdbc:mysql://localhost:3306/ironfit2024";
    final String USR = "root";
    final String PWD = "";
 //var
    Connection cnx;
    static DataSource instance;

   private DataSource() {
       try {
            cnx = DriverManager.getConnection(URL, USR, PWD);
            System.out.println("Connexion etablie avec succes!");
        } catch (SQLException ex) {
           Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);

         
        }
        
      
    }
       public static DataSource getInstance() {
        if(instance == null)
            instance = new DataSource();
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
  
      
    }

