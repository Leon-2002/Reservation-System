/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaapplication;

/**
 *
 * @author loena
 */
public class ChecksUser {
     public static boolean checkInput(String uname, String pass) {
        if (uname.equals("admin") && pass.equals("pass123")) {
            return true;
        } else {
            return false;
        }
    }
}
