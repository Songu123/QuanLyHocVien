/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pxuni.qlhv.dao;

import com.pxuni.qlhv.model.HocVien;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Admin
 */
public class HocVienDAOImpl implements HocVienDAO {

    @Override
    public List<HocVien> getList() {
        ArrayList<HocVien> list = new ArrayList<>();
        Connection conn = Data.getData();
        try {
            Statement stmt = conn.createStatement();
            // get data from table  
            String sql = "select * from hoc_vien";
            ResultSet rs = stmt.executeQuery(sql);
            //show data 
            while (rs.next()) {
                HocVien hocVien = new HocVien();
                hocVien.setMa_hoc_vien(rs.getInt("ma_hoc_vien"));
                hocVien.setHo_ten(rs.getString("ho_ten"));
                hocVien.setSo_dien_thoai(rs.getString("so_dien_thoai"));
                hocVien.setDia_chi(rs.getString("dia_chi"));
                hocVien.setNgay_sinh(rs.getDate("ngay_sinh"));
                hocVien.setGioi_tinh(rs.getBoolean("gioi_tinh"));
                hocVien.setTinh_trang(rs.getBoolean("tinh_trang"));
                list.add(hocVien);
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public List<HocVien> findName(String hoten) {
        HocVien hocVien = null; // Đặt ban đầu là null
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<HocVien> list = null;
        try {
            list = new ArrayList<HocVien>();
            conn = Data.getData(); // Lấy kết nối
            String sql = "SELECT * FROM hoc_vien WHERE ho_ten LIKE ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + hoten + "%"); // Gắn giá trị tham số

            rs = stmt.executeQuery(); // Thực thi truy vấn

            while (rs.next()) { // Nếu có kết quả
                hocVien = new HocVien(); // Tạo đối tượng HocVien
                hocVien.setMa_hoc_vien(rs.getInt("ma_hoc_vien"));
                hocVien.setHo_ten(rs.getString("ho_ten"));
                hocVien.setSo_dien_thoai(rs.getString("so_dien_thoai"));
                hocVien.setDia_chi(rs.getString("dia_chi"));
                hocVien.setNgay_sinh(rs.getDate("ngay_sinh"));
                hocVien.setGioi_tinh(rs.getBoolean("gioi_tinh"));
                hocVien.setTinh_trang(rs.getBoolean("tinh_trang"));
                list.add(hocVien);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In lỗi ra console
        } finally {
            // Đảm bảo đóng tài nguyên
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
        return list; // Trả về null nếu không tìm thấy học viên
    }

    @Override
    public boolean insert(HocVien hv
    ) {
        Connection conn = Data.getData();
        try {
            // get data from table  
            String sql = "INSERT INTO `hoc_vien` (`ho_ten`, `ngay_sinh`, `gioi_tinh`, `so_dien_thoai`, `dia_chi`, `tinh_trang`) \n"
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, hv.getHo_ten());

            // Convert java.util.Date to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(hv.getNgay_sinh().getTime());
            stmt.setDate(2, sqlDate);

            stmt.setBoolean(3, hv.isGioi_tinh());
            stmt.setString(4, hv.getSo_dien_thoai());
            stmt.setString(5, hv.getDia_chi()); // Bổ sung tham số dia_chi
            stmt.setBoolean(6, hv.isTinh_trang()); // Đảm bảo kiểu của cột tinh_trang là boolean

            int rowInsert = stmt.executeUpdate();
            return rowInsert > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean update(HocVien hv
    ) {
        Connection conn = Data.getData();
        try {
            // get data from table  
            String sql = "UPDATE hoc_vien SET `ho_ten` = ?, `ngay_sinh` = ?, `gioi_tinh` = ?, `so_dien_thoai` = ?, `dia_chi` = ?, `tinh_trang` = ? WHERE `ma_hoc_vien` = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, hv.getHo_ten());
            // Convert java.util.Date to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(hv.getNgay_sinh().getTime());
            stmt.setDate(2, sqlDate);

            stmt.setBoolean(3, hv.isGioi_tinh());
            stmt.setString(4, hv.getSo_dien_thoai());
            stmt.setString(5, hv.getDia_chi()); // Bổ sung tham số dia_chi
            stmt.setBoolean(6, hv.isTinh_trang()); // Đảm bảo kiểu của cột tinh_trang là boolean
            stmt.setInt(7, hv.getMa_hoc_vien()); // Đảm bảo kiểu của cột tinh_trang là boolean

            int rowInsert = stmt.executeUpdate();
            return rowInsert > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(HocVien hv
    ) {
        Connection conn = Data.getData();
        try {
            conn = Data.getData(); // Lấy kết nối
            String sql = "DELETE FROM hoc_vien WHERE ma_hoc_vien = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, hv.getMa_hoc_vien()); // Gắn giá trị tham số

            int rowInsert = stmt.executeUpdate();
            return rowInsert > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // In lỗi ra console
        }
        return false;
    }

    @Override
    public HocVien findHocVien(int id
    ) {
        HocVien hocVien = null; // Đặt ban đầu là null
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Data.getData(); // Lấy kết nối
            String sql = "SELECT * FROM hoc_vien WHERE ma_hoc_vien = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id); // Gắn giá trị tham số

            rs = stmt.executeQuery(); // Thực thi truy vấn

            if (rs.next()) { // Nếu có kết quả
                hocVien = new HocVien(); // Tạo đối tượng HocVien
                hocVien.setMa_hoc_vien(rs.getInt("ma_hoc_vien"));
                hocVien.setHo_ten(rs.getString("ho_ten"));
                hocVien.setSo_dien_thoai(rs.getString("so_dien_thoai"));
                hocVien.setDia_chi(rs.getString("dia_chi"));
                hocVien.setNgay_sinh(rs.getDate("ngay_sinh"));
                hocVien.setGioi_tinh(rs.getBoolean("gioi_tinh"));
                hocVien.setTinh_trang(rs.getBoolean("tinh_trang"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In lỗi ra console
        } finally {
            // Đảm bảo đóng tài nguyên
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
        return hocVien; // Trả về null nếu không tìm thấy học viên
    }

}
