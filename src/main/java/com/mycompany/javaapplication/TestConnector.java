/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaapplication;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author loena
 */
public class TestConnector {
    
    
    
    public static void main(String[]args){
        
    }
            
    public static void reservation(){
       // Insert new user
            try (Connection conn = DatabaseConnector.getConnection()) {
                String insertQuery = "INSERT INTO reservations (name,surname, contacts, return_date, equipments) VALUES (?,?,?,?,?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, "LOen");
                insertStmt.setString(2, "Acuna");
                insertStmt.setString(3, "0967267");
                insertStmt.setString(4, "2023-jan-23");
                
                int executeUpdate = insertStmt.executeUpdate();
            
    } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("reservation Failed");
    }
    }
    
}
