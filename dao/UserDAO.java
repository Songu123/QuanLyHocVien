/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pxuni.qlhv.dao;

import com.pxuni.qlhv.model.HocVien;
import com.pxuni.qlhv.model.User;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface UserDAO {

    public List<User> getList();

    public User findUser(User user);

    public User findHocVien(int id);
}
