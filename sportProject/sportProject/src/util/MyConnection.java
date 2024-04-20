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
public class MyConnection {
     //DB Credentials
    final String URL = "jdbc:mysql://localhost:3306/sportproject1";
    final String USR = "root";
    final String PWD = "";
 //var
    Connection cnx;
    static MyConnection instance;

    private MyConnection() {
       try {
            cnx = DriverManager.getConnection(URL, USR, PWD);
            System.out.println("Connexion etablie avec succes!");
        } catch (SQLException ex) {
           Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);

             
        }
      System.out.println("Connexion etablie avec succes!");   
      
    }
       public static MyConnection getInstance() {
        if(instance == null)
            instance = new MyConnection();
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    MyConnection m=new MyConnection();
      
    }

