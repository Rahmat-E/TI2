package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Koneksi {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_data";
                String user = "root";
                String pass = "";
                // Memuat driver JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Membuat koneksi ke database
                conn = DriverManager.getConnection(url, user, pass);
            } catch (ClassNotFoundException | SQLException e) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return conn;
    }
}
