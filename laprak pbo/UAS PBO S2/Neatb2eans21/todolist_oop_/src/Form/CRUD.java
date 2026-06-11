package Form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUD {
    private Connection conn;

    public CRUD(Connection conn) {
        this.conn = conn;
    }

    CRUD() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Data> getAllData() {
        List<Data> dataList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM mahasiswa";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int nomor = rs.getInt("nomor");
                String deadline = rs.getString("deadline");
                String kegiatan = rs.getString("kegiatan");
                String deskripsi = rs.getString("deskripsi");
                Data data = new Data(nomor, deadline, kegiatan, deskripsi);
                dataList.add(data);
            }

            rs.close();
            st.close();
        } catch (Exception e) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
        }
        return dataList;
    }

    public boolean addData(Data data) {
        try {
            String sql = "INSERT INTO mahasiswa (nomor, deadline, kegiatan, deskripsi) VALUES (?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, data.getNomor());
            st.setString(2, data.getDeadline());
            st.setString(3, data.getKegiatan());
            st.setString(4, data.getDeskripsi());

            int rowInserted = st.executeUpdate();
            st.close();
            return rowInserted > 0;
        } catch (Exception e) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public boolean updateData(Data data) {
        try {
            String sql = "UPDATE mahasiswa SET deadline = ?, kegiatan = ?, deskripsi = ? WHERE nomor = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, data.getDeadline());
            st.setString(2, data.getKegiatan());
            st.setString(3, data.getDeskripsi());
            st.setInt(4, data.getNomor());

            int rowUpdated = st.executeUpdate();
            st.close();
            return rowUpdated > 0;
        } catch (Exception e) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public boolean deleteData(int nomor) {
        try {
            String sql = "DELETE FROM mahasiswa WHERE nomor = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, nomor);

            int rowDeleted = st.executeUpdate();
            st.close();
            return rowDeleted > 0;
        } catch (Exception e) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    List<Data> searchData(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
