package Form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectorApp extends JFrame {
    private JButton connectButton;

    public DatabaseConnectorApp() {
        // Set judul window
        setTitle("Database Connector");
        
        // Set ukuran window
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Menempatkan window di tengah layar
        
        // Inisialisasi tombol
        connectButton = new JButton("Connect to Database");
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToDatabase();
            }
        });

        // Menambahkan tombol ke window
        add(connectButton);
    }

    // Fungsi untuk menghubungkan ke database
    private void connectToDatabase() {
        Connection conn = null;
        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Koneksi ke database MySQL
            String url = "jdbc:mysql://localhost:3306/db_kampus";
            String user = "root"; // ganti dengan username Anda
            String password = ""; // ganti dengan password Anda
            conn = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(this, "Terhubung ke Database");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal terhubung ke database. Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Driver JDBC tidak ditemukan. Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menutup koneksi. Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DatabaseConnectorApp().setVisible(true);
            }
        });
    }
}
