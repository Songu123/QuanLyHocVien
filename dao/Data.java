/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pxuni.qlhv.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class Data {
    
    private static String url = "jdbc:mysql://localhost:3306/qlhv";
    private static String username = "root";
    private static String password = "";

    public static Connection getData() {
        Connection conn = null;
        try {
            conn = getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static Connection getConnection(String dbURL, String userName,
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("Ket noi MySql thanh cong!");
        } catch (Exception ex) {
            System.out.println("Loi ket noi MySql!");
            ex.printStackTrace();
        }
        return conn;
    }
    
    public static void main(String[] args) {
        Connection conn = Data.getData();
    }
}
