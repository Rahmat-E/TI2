
package Form;
import Config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUI extends javax.swing.JFrame {

    private Connection conn;
    public GUI() {
        initComponents();
        conn =Koneksi.getConnection();
        getData();
        nonActiveButton();
        activeButton();
    }
    
    private void getData() {
        DefaultTableModel model =(DefaultTableModel) tbl_data.getModel();
        model.setRowCount(0);
        
        try {
            String sql="Select * From mahasiswa";
            PreparedStatement st =conn.prepareStatement(sql);
            ResultSet rs =st.executeQuery();
            
            while(rs.next()){
                int nomor          =rs.getInt("nomor");
                String deadline =rs.getString("deadline");
                String kegiatan =rs.getString("kegiatan");
                String deskripsi =rs.getString("deskripsi");
                
                Object[] rowData={nomor,deadline,kegiatan,deskripsi};
                model.addRow(rowData);
            }
            
            rs.close();
            st.close();
                
        } catch (Exception e) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        t_deadline = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        t_deskripsi = new javax.swing.JTextField();
        t_kegiatan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        t_cari = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Deadline");

        t_deadline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_deadlineActionPerformed(evt);
            }
        });

        jLabel2.setText("Kegiatan");

        jLabel3.setText("Deskripsi Kegiatan");

        t_deskripsi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_deskripsiKeyReleased(evt);
            }
        });

        tbl_data.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nomor", "DeadLine", "Kegiatan", "Deskripsi"
            }
        ));
        tbl_data.setRowHeight(30);
        tbl_data.setShowGrid(true);
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);
        tbl_data.getAccessibleContext().setAccessibleName("");

        t_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cariActionPerformed(evt);
            }
        });

        jLabel4.setText("pencarian : ");

        btn_tambah.setText("tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_update.setText("update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_batal.setText("batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        btn_hapus.setText("hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(t_deadline))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_deskripsi)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(19, 19, 19)
                                .addComponent(t_kegiatan))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_tambah)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_update)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_batal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_hapus)))
                                .addGap(0, 6, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_deadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(t_kegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addGap(14, 14, 14)
                .addComponent(t_deskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah)
                    .addComponent(btn_update)
                    .addComponent(btn_batal)
                    .addComponent(btn_hapus))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void t_deadlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_deadlineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_deadlineActionPerformed

    private void t_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_cariActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        int selectedRow = tbl_data.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this,"pilih baris yang ingin di perbarui");
            return;
        }

            String nomor = tbl_data.getValueAt(selectedRow,0).toString();
            String deadline = t_deadline.getText();
            String kegiatan=t_kegiatan.getText();
            String deskripsi =t_deskripsi.getText();
            
            if(deadline.isEmpty() ||kegiatan.isEmpty() || deskripsi.isEmpty()){
            JOptionPane.showMessageDialog(this,"semua kolom harus di isi !","Validasi",JOptionPane.ERROR_MESSAGE);
            return;
        }
            
            try {
                String sql="UPDATE mahasiswa SET deadline=?,kegiatan=?,deskripsi=? WHERE nomor=?";
            PreparedStatement st =conn.prepareStatement(sql);
            st.setString(1,deadline);
            st.setString(2,kegiatan);
            st.setString(3,deskripsi);
            st.setString(4,nomor);
            
            int rowUpdate=st.executeUpdate();
            
            if(rowUpdate>0){
                JOptionPane.showMessageDialog(this,"data berhasi di perbarui");
                resetForm();
                getData();
            }
            
            st.close();
            } catch (Exception e) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, e);
            }
            
            
    
        
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        resetForm();
        activeButton();
        nonActiveButton();
        
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        String deadline =t_deadline.getText();
        String kegiatan=t_kegiatan.getText();
        String deskripsi=t_deskripsi.getText();
        
        //validasi
        
        if(deadline.isEmpty() ||kegiatan.isEmpty() || deskripsi.isEmpty()){
            JOptionPane.showMessageDialog(this,"semua kolom harus di isi !","Validasi",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            String sql="INSERT INTO mahasiswa (deadline,kegiatan,deskripsi) VALUES (?,?,?)";
            PreparedStatement st =conn.prepareStatement(sql);
            st.setString(1,deadline);
            st.setString(2,kegiatan);
            st.setString(3,deskripsi);
            
            int rowInserted=st.executeUpdate();
            
            if(rowInserted>0){
                JOptionPane.showMessageDialog(this,"Tugas bertambah, segera di kerjakan!");
                resetForm();
                getData();
            }
            
            st.close();
            
        } catch (Exception e) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        
        int selectedRow=tbl_data.getSelectedRow();
        if(selectedRow != -1){
            String deadline=tbl_data.getValueAt(selectedRow,1).toString();
            String kegiatan=tbl_data.getValueAt(selectedRow,2).toString();
            String deskripsi=tbl_data.getValueAt(selectedRow,3).toString();
            
            t_deadline.setText(deadline);
            t_kegiatan.setText(kegiatan);
            t_deskripsi.setText(deskripsi);
        }
        
        btn_tambah.setEnabled(false);
        btn_update.setEnabled(true);
        btn_hapus.setEnabled(true);
        
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void t_deskripsiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_deskripsiKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_deskripsiKeyReleased

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int selectedRow = tbl_data.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this,"pilih baris yang ingin di perbarui");
            return;
        }
        
        int confirm=JOptionPane.showConfirmDialog(this,"apakah anda yakin ingin  menghapus data?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if(confirm==JOptionPane.YES_OPTION){
            String nomor =tbl_data.getValueAt(selectedRow,0).toString();
            
            try {
                String sql="DELETE FROM mahasiswa WHERE nomor=?";
                PreparedStatement st=conn.prepareStatement(sql);
                st.setString(1,nomor);
                
                int rowDelete =st.executeUpdate();
                if(rowDelete>0){
                    JOptionPane.showMessageDialog(this,"data berhasil dihapus");
                    
                }
                
                st.close();
                
                
            } catch (Exception e) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, e);
            }
            
        }
        resetForm();
        getData();
        activeButton();
        nonActiveButton();
    }//GEN-LAST:event_btn_hapusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTextField t_deadline;
    private javax.swing.JTextField t_deskripsi;
    private javax.swing.JTextField t_kegiatan;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
        t_deadline.setText("");
        t_kegiatan.setText("");
        t_deskripsi.setText("");
    }

    private void nonActiveButton() {
        btn_update.setEnabled(false);
//        btn_batal.setEnabled(false);
        btn_hapus.setEnabled(false);
    }

    private void activeButton() {
        btn_tambah.setEnabled(true);
        btn_batal.setEnabled(true);
    }

    
}
