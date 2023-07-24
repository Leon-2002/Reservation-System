/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author loena
 */
public class ShowTable {
    
    public static void main(String[] args){
        
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
 
            ResultSet rs = pstmt.executeQuery();
            

           if (rs.next()) {
                // User exists with the provided username and password
                UserCredentials.getName();
                 String name = rs.getString("name");
                 String surname = rs.getString("surname");
                 
                
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
    }
}
