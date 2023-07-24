/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaapplication;
import java.sql.*;

/**
 *
 * @author loena
 */
public class UserCredentials {
    private static String name;
    private static String role;
    public static void main(String []args){
//        UserCredentials userCredentials = new UserCredentials();
//        userCredentials.GetCredentials();
           System.out.println( UserCredentials.getName());
    }

    public static String getName() {
        return name;
    }
     public static String getRole() {
        return role;
    }
    
    
    
    public static String GetFirstName( String user1){
    
     String username = user1;
     try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM users1 WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
             pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            

           if (rs.next()) {
                // User exists with the provided username and password
                UserCredentials.getName();
                 String name = rs.getString("firstname");  
                 
                 return name;
            }
           return "NO user";
        } catch (SQLException e) {
            e.printStackTrace();
           return "NO user";
        }
        // No user found with the provided username and password
        

}
    
    public static String GetLastName( String user1){
    
     String username = user1;
     try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM users1 WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
             pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            

           if (rs.next()) {
                // User exists with the provided username and password
                UserCredentials.getName();
                 String name = rs.getString("lastname");  
                 
                 return name;
            }
           return "NO user";
        } catch (SQLException e) {
            e.printStackTrace();
           return "NO user";
        }
        // No user found with the provided username and password
        

}
    // TO CHECK IF THE USER IS STUDENT OR ADMIN
    public static String GetRoleUser(String user){
        
         String username = user;
         
         
         try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT role FROM users1 WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
             pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            

           if (rs.next()) {
                // User exists with the provided username and password
                UserCredentials.getRole();
                String role = rs.getString("role");  
                 
                 return role;
            }
           return "NO user";
        } catch (SQLException e) {
            e.printStackTrace();
           return "NO user";
        }
    }
}
