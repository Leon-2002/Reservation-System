/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaapplication;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author loena
 */
public class UserUpdate {
    public static void CreateUser(String firstname, String lname, String username , String password, String role){
       // Insert new reservation to database
            try (Connection conn = DatabaseConnector.getConnection()) {
                String insertQuery = "INSERT INTO users1 (firstname, lastname ,usrname, password, role) VALUES (?,?,?,?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
               insertStmt.setString(1, firstname);
                insertStmt.setString(2, lname);
                insertStmt.setString(3, username);
                insertStmt.setString(4, password);
                insertStmt.setString(5, role);
                insertStmt.executeUpdate();
            
    } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("reservation Failed");
    }
    }
    
    public static void updateUser(int id, String firstname,String lname, String username, String password,  String role){
       // Insert new reservation to database
            try (Connection conn = DatabaseConnector.getConnection()) {
            String updateQuery = "UPDATE users SET firstname=?, lastname=?, username=?, password=?, role=?, WHERE user_id = ?"; 
             PreparedStatement insertStmt = conn.prepareStatement(updateQuery);
          
                insertStmt.setString(1, firstname);
                insertStmt.setString(2, lname);
                insertStmt.setString(3, username);
                insertStmt.setString(4, password);
                insertStmt.setString(5, role);
                insertStmt.setInt(6,id );
                insertStmt.executeUpdate();
             
            
    } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("update Failed");
    }
    }

    static void UpdateUser(int user_id, String fullname, String username, String password, String role) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static void UpdateUsser(int user_id, String fullname, String username, String password, String role) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
