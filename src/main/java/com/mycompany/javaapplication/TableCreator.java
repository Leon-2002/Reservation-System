/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaapplication;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author loena
 */
public class TableCreator {
    
    
    public static void main(String [] args){
    try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement()) {

            // Create the table
            String sql = "CREATE TABLE users1 (user_id SERIAL PRIMARY KEY, firstname VARCHAR(50) NOT NULL, lastname VARCHAR(50) NOT NULL, username VARCHAR(50) NOT NULL, password VARCHAR(50) NOT NULL, role VARCHAR(50) NOT NULL)";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully!");
            // Insert default user
            String insertQuery = "INSERT INTO users1 (firstname, lastname, username, password, role) VALUES ('Leon', 'Acuna','admin1', 'admin1', 'admin')";
            stmt.executeUpdate(insertQuery);

            System.out.println("Table created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
       
    reservationTable();
    
    
    }
    
    public static void reservationTable(){
         try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement()) {

            // Create the table
            String sql = "CREATE TABLE reservation (reservation_id SERIAL PRIMARY KEY, name VARCHAR(50) NOT NULL, surname VARCHAR(50) NOT NULL, contacts VARCHAR(50) NOT NULL, return_date DATE NOT NULL, equipment VARCHAR(50) NOT NULL, quantity bigint NOT NULL )";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully!");
            // Insert default user
            String insertQuery = "INSERT INTO reservation (name, surname, contacts, return_date, equipment, quantity ) VALUES ('Leon','Acuna','09672676490','2023-june-23', 'Tv',1)";
            stmt.executeUpdate(insertQuery);

            System.out.println(" reservation Table created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
