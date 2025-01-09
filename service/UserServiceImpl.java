/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pxuni.qlhv.service;

import com.pxuni.qlhv.dao.HocVienDAO;
import com.pxuni.qlhv.dao.HocVienDAOImpl;
import com.pxuni.qlhv.dao.UserDAO;
import com.pxuni.qlhv.dao.UserDAOImpl;
import com.pxuni.qlhv.model.User;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDao = null;

    public UserServiceImpl() {
        this.userDao = new UserDAOImpl();
    }

    @Override
    public List<User> getList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User findUser(User user) {
        return userDao.findUser(user);
    }

    @Override
    public User findHocVien(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
