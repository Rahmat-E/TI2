package Form;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Search {
    private Connection conn;
    
    public Search(Connection conn) {
        this.conn = conn;
    }
    
   public List<Data> searchData(String keyword) {
        List<Data> dataList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM mahasiswa WHERE nomor LIKE ? OR deadline LIKE ? OR kegiatan LIKE ? OR deskripsi LIKE ?";
            PreparedStatement st = conn.prepareStatement(sql);
            String searchKeyword = "%" + keyword + "%";
            st.setString(1, searchKeyword);
            st.setString(2, searchKeyword);
            st.setString(3, searchKeyword);
            st.setString(4, searchKeyword);

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
} 

