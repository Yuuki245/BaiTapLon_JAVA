package nhanvien;

import java.sql.*;
import java.util.*;

public class NhanVienDAO {

    // Lấy danh sách
    public List<Nhanvien> getAll() throws Exception {
        List<Nhanvien> list = new ArrayList<>();
        String sql = "SELECT * FROM nhanvien";

        try (Connection con = Connection_Isolf.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String ma = rs.getString("maNV");
                String ten = rs.getString("hoTen");
                String pb = rs.getString("phongBan");
                double lcb = rs.getDouble("luongCoBan");
                String loai = rs.getString("loaiNV");

                if ("hanhchinh".equalsIgnoreCase(loai)) {
                    list.add(new NhanVienHanhChinh(ma, ten, pb, lcb));
                } else if ("tiepthi".equalsIgnoreCase(loai)) {
                    double ds = rs.getDouble("doanhSo");
                    double hh = rs.getDouble("hoaHong");
                    list.add(new NhanVienTiepThi(ma, ten, pb, lcb, ds, hh));
                } else if ("truongphong".equalsIgnoreCase(loai)) {
                    double tn = rs.getDouble("luongTrachNhiem");
                    list.add(new TruongPhong(ma, ten, pb, lcb, tn));
                }
            }
        }

        return list;
    }

    // Thêm
    public void insert(Nhanvien nv) throws Exception {
        String sql = "INSERT INTO nhanvien VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Connection_Isolf.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, nv.maNV);
            stmt.setString(2, nv.hoTen);
            stmt.setString(3, nv.phongBan);
            stmt.setDouble(4, nv.luongCoBan);

            if (nv instanceof NhanVienHanhChinh) {
                stmt.setString(5, "hanhchinh");
                stmt.setNull(6, Types.DOUBLE);
                stmt.setNull(7, Types.DOUBLE);
                stmt.setNull(8, Types.DOUBLE);
            } else if (nv instanceof NhanVienTiepThi) {
                NhanVienTiepThi tt = (NhanVienTiepThi) nv;
                stmt.setString(5, "tiepthi");
                stmt.setDouble(6, tt.getDoanhSo());
                stmt.setDouble(7, tt.getHoaHong());
                stmt.setNull(8, Types.DOUBLE);
            } else if (nv instanceof TruongPhong) {
                TruongPhong tp = (TruongPhong) nv;
                stmt.setString(5, "truongphong");
                stmt.setNull(6, Types.DOUBLE);
                stmt.setNull(7, Types.DOUBLE);
                stmt.setDouble(8, tp.getLuongTrachNhiem());
            }

            stmt.executeUpdate();
        }
    }

    // Xoá
    public boolean delete(String maNV) throws Exception {
        String sql = "DELETE FROM nhanvien WHERE maNV=?";
        try (Connection con = Connection_Isolf.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, maNV);
            return stmt.executeUpdate() > 0;
        }
    }

    // Tìm theo mã
    public Nhanvien findById(String maNV) throws Exception {
        String sql = "SELECT * FROM nhanvien WHERE maNV=?";
        try (Connection con = Connection_Isolf.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, maNV);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String ten = rs.getString("hoTen");
                String pb = rs.getString("phongBan");
                double lcb = rs.getDouble("luongCoBan");
                String loai = rs.getString("loaiNV");

                if ("hanhchinh".equalsIgnoreCase(loai)) {
                    return new NhanVienHanhChinh(maNV, ten, pb, lcb);
                } else if ("tiepthi".equalsIgnoreCase(loai)) {
                    double ds = rs.getDouble("doanhSo");
                    double hh = rs.getDouble("hoaHong");
                    return new NhanVienTiepThi(maNV, ten, pb, lcb, ds, hh);
                } else if ("truongphong".equalsIgnoreCase(loai)) {
                    double tn = rs.getDouble("luongTrachNhiem");
                    return new TruongPhong(maNV, ten, pb, lcb, tn);
                }
            }
        }
        return null;
    }

    // Cập nhật
    public boolean update(Nhanvien nv) throws Exception {
        String sql = "UPDATE nhanvien SET hoTen=?, phongBan=?, luongCoBan=?, loaiNV=?, doanhSo=?, hoaHong=?, luongTrachNhiem=? WHERE maNV=?";

        try (Connection con = Connection_Isolf.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, nv.hoTen);
            stmt.setString(2, nv.phongBan);
            stmt.setDouble(3, nv.luongCoBan);

            if (nv instanceof NhanVienHanhChinh) {
                stmt.setString(4, "hanhchinh");
                stmt.setNull(5, Types.DOUBLE);
                stmt.setNull(6, Types.DOUBLE);
                stmt.setNull(7, Types.DOUBLE);
            } else if (nv instanceof NhanVienTiepThi) {
                NhanVienTiepThi tt = (NhanVienTiepThi) nv;
                stmt.setString(4, "tiepthi");
                stmt.setDouble(5, tt.getDoanhSo());
                stmt.setDouble(6, tt.getHoaHong());
                stmt.setNull(7, Types.DOUBLE);
            } else if (nv instanceof TruongPhong) {
                TruongPhong tp = (TruongPhong) nv;
                stmt.setString(4, "truongphong");
                stmt.setNull(5, Types.DOUBLE);
                stmt.setNull(6, Types.DOUBLE);
                stmt.setDouble(7, tp.getLuongTrachNhiem());
            }

            stmt.setString(8, nv.maNV);
            return stmt.executeUpdate() > 0;
        }
    }
}
