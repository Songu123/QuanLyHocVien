/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pxuni.qlhv.dao;

import com.pxuni.qlhv.model.HocVien;
import com.pxuni.qlhv.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public List<User> getList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public User findUser(User user) {
        User us = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Data.getData(); 
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword()); 

            rs = stmt.executeQuery(); 

            if (rs.next()) { 
                us = new User();
                us.setId(rs.getInt("user_id"));
                us.setUsername(rs.getString("username"));
                us.setPassword(rs.getString("password"));
                us.setEmail(rs.getString("email"));
                us.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return us; 
    }

    @Override
    public User findHocVien(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
