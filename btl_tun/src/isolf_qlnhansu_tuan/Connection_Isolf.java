package isolf_qlnhansu_tuan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_Isolf {
    private Connection conn;
    public Connection_Isolf() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/ql_nhansu_isolf";
        this.conn = DriverManager.getConnection(url, "root", "");
        if(this.conn != null)
            System.out.println("Kết nối thành công !");
        else System.out.println("Kết nối thất bại !");
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        Connection_Isolf kn = new Connection_Isolf();
        
    }
}
