package DAO;

import Model.PhongBan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongBanDAO {

    // Lấy tất cả phòng ban
    public List<PhongBan> getAllPhongBan() throws SQLException {
        List<PhongBan> list = new ArrayList<>();
        String sql = "SELECT * FROM phongban";

        try (Connection conn = Connection_Isolf.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new PhongBan(
                    rs.getString("maPB"),
                    rs.getString("tenPB"),
                    rs.getString("moTa")
                ));
            }
        }

        return list;
    }

    // Thêm phòng ban
    public void addPhongBan(PhongBan pb) throws SQLException {
        String sql = "INSERT INTO phongban (maPB, tenPB, moTa) VALUES (?, ?, ?)";

        try (Connection conn = Connection_Isolf.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pb.getMaPB());
            stmt.setString(2, pb.getTenPB());
            stmt.setString(3, pb.getMoTa());
            stmt.executeUpdate();
        }
    }

    // Xoá phòng ban
    public void deletePhongBan(String maPB) throws SQLException {
        String sql = "DELETE FROM phongban WHERE maPB = ?";

        try (Connection conn = Connection_Isolf.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, maPB);
            stmt.executeUpdate();
        }
    }

    // Cập nhật phòng ban
    public void updatePhongBan(PhongBan pb) throws SQLException {
        String sql = "UPDATE phongban SET tenPB=?, moTa=? WHERE maPB=?";

        try (Connection conn = Connection_Isolf.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pb.getTenPB());
            stmt.setString(2, pb.getMoTa());
            stmt.setString(3, pb.getMaPB());
            stmt.executeUpdate();
        }
    }
}
