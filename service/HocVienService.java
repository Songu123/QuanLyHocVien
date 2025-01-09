/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pxuni.qlhv.service;

import com.pxuni.qlhv.model.HocVien;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface HocVienService {

    public List<HocVien> getList();

    public List<HocVien> findName(String hoten);

    public HocVien findHocVien(String id);

    public boolean insert(HocVien hv);

    public boolean update(HocVien hv);

    public boolean delete(HocVien hv);

}
