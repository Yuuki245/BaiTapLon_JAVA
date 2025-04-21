/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isolf_qlnhansu_tuan;

import com.isolf.qlnhansu.model.SinhVien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LTuan
 */
public class SinhVienDAO {
//Thêm sinh viên
    public void addSinhVien(SinhVien sv) throws SQLException {
        String sql = "INSERT INTO sinhvien (maSV, hoTen, email, sdt, cmnd, phongThucTap, diemDanhGia) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sv.getMaSV());
            stmt.setString(2, sv.getHoTen());
            stmt.setString(3, sv.getEmail());
            stmt.setString(4, sv.getSdt());
            stmt.setString(5, sv.getCmnd());
            stmt.setString(6, sv.getPhongThucTap());
            stmt.setDouble(7, sv.getDiemDanhGia());
            stmt.executeUpdate();
        }
    }
//Sửa sinh viên
    public void updateSinhVien(SinhVien sv) throws SQLException {
        String sql = "UPDATE sinhvien SET hoTen = ?, email = ?, sdt = ?, cmnd = ?, phongThucTap = ?, diemDanhGia = ? WHERE maSV = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sv.getHoTen());
            stmt.setString(2, sv.getEmail());
            stmt.setString(3, sv.getSdt());
            stmt.setString(4, sv.getCmnd());
            stmt.setString(5, sv.getPhongThucTap());
            stmt.setDouble(6, sv.getDiemDanhGia());
            stmt.setString(7, sv.getMaSV());
            stmt.executeUpdate();
        }
    }
//Xóa sinh viên   
    public void deleteSinhVien(String maSV) throws SQLException {
        String sql = "DELETE FROM sinhvien WHERE maSV = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maSV);
            stmt.executeUpdate();
        }
    }
//Tìm kiếm sinh viên theo mã sv hoặc tên   
    public List<SinhVien> searchSinhVien(String keyword) throws SQLException {
        List<SinhVien> result = new ArrayList<>();
        String sql = "SELECT * FROM sinhvien WHERE maSV LIKE ? OR hoTen LIKE ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(new SinhVien(
                    rs.getString("maSV"),
                    rs.getString("hoTen"),
                    rs.getString("email"),
                    rs.getString("sdt"),
                    rs.getString("cmnd"),
                    rs.getString("phongThucTap"),
                    rs.getDouble("diemDanhGia")
                ));
            }
        }
        return result;
    }
//Lấy danh sách tất cả sinh viên    
    public List<SinhVien> getAllSinhVien() throws SQLException {
        List<SinhVien> result = new ArrayList<>();
        String sql = "SELECT * FROM sinhvien";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(new SinhVien(
                    rs.getString("maSV"),
                    rs.getString("hoTen"),
                    rs.getString("email"),
                    rs.getString("sdt"),
                    rs.getString("cmnd"),
                    rs.getString("phongThucTap"),
                    rs.getDouble("diemDanhGia")
                ));
            }
        }
        return result;
    }
//Sắp xếp sinh viên
    public List<SinhVien> sortSinhVien(List<SinhVien> list, String criteria) {
        if (criteria.equals("diemDanhGia")) {
            list.sort((sv1, sv2) -> Double.compare(sv2.getDiemDanhGia(), sv1.getDiemDanhGia())); // Sắp xếp giảm dần
        } else if (criteria.equals("hoTen")) {
            list.sort((sv1, sv2) -> sv1.getHoTen().compareTo(sv2.getHoTen())); // Sắp xếp theo chữ cái
        }
        return list;
    }
}
