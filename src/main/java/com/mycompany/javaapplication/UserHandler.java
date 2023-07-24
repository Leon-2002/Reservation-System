/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaapplication;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author loena
 */
public class UserHandler {
    // For sign up
    
    public static boolean registerUser(String fname, String lname, String uname, String pass, String role) {

        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if username exists
            String checkQuery = "SELECT * FROM users1 WHERE username = ? ";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, uname);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                // Insert new user
                String insertQuery = "INSERT INTO users1 (firstname, lastname, username, password, role) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, fname);
                insertStmt.setString(2, lname);
                insertStmt.setString(3, uname);
                insertStmt.setString(4, pass);
                insertStmt.setString(5, role);
                insertStmt.executeUpdate();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // for login
    public static boolean loginUser(String uname, String pass) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM users1 WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, uname);
            pstmt.setString(2, pass);   
            ResultSet rs = pstmt.executeQuery();
              

            if (rs.next()) {
                // User exists with the provided username and password
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // No user found with the provided username and password
        return false;
    }
    
    /**
     *
     * @param name
     * @param surname
     * @param contacts
     * @param person
     * @param date
     * @param equipments
     */
    public static void reservation(String name, String surname, String contacts, Date date, String equipments, int quantity){
       // Insert new reservation to database
            try (Connection conn = DatabaseConnector.getConnection()) {
                String insertQuery = "INSERT INTO reservation (name,surname, contacts, return_date, equipment, quantity) VALUES (?,?,?,?,?,?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, name);
                insertStmt.setString(2, surname);
                insertStmt.setString(3, contacts);
                insertStmt.setDate(4, date);
                insertStmt.setString(5, equipments);
                insertStmt.setInt(6, quantity);
                insertStmt.executeUpdate();
            
    } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("reservation Failed");
    }
    }
    
    public static void updateReservation(int id, String name, String surname, String contacts, Date date, String equipments, int quantity){
       // Insert new reservation to database
            try (Connection conn = DatabaseConnector.getConnection()) {
            String updateQuery = "UPDATE reservation SET name=?, surname=?, contacts=?, return_date=?, equipment=?, quantity=? WHERE reservation_id = ?"; 
             PreparedStatement insertStmt = conn.prepareStatement(updateQuery);
                insertStmt.setString(1, name);
                insertStmt.setString(2, surname);
                insertStmt.setString(3, contacts);
                insertStmt.setDate(4, date);
                insertStmt.setString(5, equipments);
                insertStmt.setInt(6, quantity);
                insertStmt.setInt(7, id);
                insertStmt.executeUpdate();
             
            
    } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("update Failed");
    }
    }
    
     // for reservation validation
    public static boolean reservationValid(String name, String surname, String contacts, Date date, String equipments, int quantity) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM reservation WHERE name=? and surname=? and contacts=? and return_date=? and equipment=? and quantity=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, surname);
            pstmt.setString(3, contacts);
            pstmt.setDate(4, date);
            pstmt.setString(5, equipments);
            pstmt.setInt(6, quantity);
            
            ResultSet rs = pstmt.executeQuery();
              

            if (rs.next()) {
                // User exists with the provided username and password
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // No user found with the provided username and password
        return false;
    }
 
}

