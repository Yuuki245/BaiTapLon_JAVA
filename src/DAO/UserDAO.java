package DAO;

import Model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public User checkLogin(String username, String password) throws Exception {
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        try (Connection conn = Connection_Isolf.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(username, password, rs.getString("role"));
            }
        }
        return null;
    }
    // Lấy tất cả user

    public List<User> getAllUsers() throws SQLException {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = Connection_Isolf.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                ));
            }
        }

        return list;
    }

    // Xoá user
    public void deleteUser(String username) throws SQLException {
        String sql = "DELETE FROM users WHERE username = ?";

        try (Connection conn = Connection_Isolf.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.executeUpdate();
        }
    }

    // Cập nhật role hoặc mật khẩu
    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET password = ?, role = ? WHERE username = ?";

        try (Connection conn = Connection_Isolf.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getRole());
            stmt.setString(3, user.getUsername());
            stmt.executeUpdate();
        }
    }
}
