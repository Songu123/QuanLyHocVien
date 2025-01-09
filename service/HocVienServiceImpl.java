/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pxuni.qlhv.service;

import com.pxuni.qlhv.dao.HocVienDAO;
import com.pxuni.qlhv.dao.HocVienDAOImpl;
import com.pxuni.qlhv.model.HocVien;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HocVienServiceImpl implements HocVienService {

    private HocVienDAO hocVienDao = null;

    public HocVienServiceImpl() {
        this.hocVienDao = new HocVienDAOImpl();
    }

    @Override
    public List<HocVien> getList() {
        return hocVienDao.getList();
    }

    @Override
    public List<HocVien> findName(String hoten) {
        return hocVienDao.findName(hoten);
    }

    @Override
    public boolean insert(HocVien hv) {
        return hocVienDao.insert(hv);
    }

    @Override
    public boolean update(HocVien hv) {
        return hocVienDao.update(hv);
    }

    @Override
    public boolean delete(HocVien hv) {
        return hocVienDao.delete(hv);
    }

    @Override
    public HocVien findHocVien(String id) {
        return hocVienDao.findHocVien(Integer.parseInt(id));
    }

}
