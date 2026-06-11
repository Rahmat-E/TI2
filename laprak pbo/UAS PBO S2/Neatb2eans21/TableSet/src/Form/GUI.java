package Form;
import Config.Koneksi;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUI extends javax.swing.JFrame {

    private final Connection conn;
    private final Search search;
    private final CRUD crud;
  
    public GUI() {
        initComponents();
        conn = Koneksi.getConnection();
        crud = new CRUD(conn);
        search = new Search(conn);
        getData();
        nonActiveButton();
        activeButton();
    }
    
    private void getData() {
        DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
        model.setRowCount(0);
        
        // Menggunakan metode getAllData dari kelas CRUD
        List<Data> dataList = crud.getAllData();
        
        for (Data data : dataList) {
            Object[] rowData = {data.getNomor(), data.getDeadline(), data.getKegiatan(), data.getDeskripsi()};
            model.addRow(rowData);
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
        t_nomor = new javax.swing.JTextField();
        dmfsd = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dmfsd1 = new javax.swing.JLabel();
        dmfsd2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_tambah1 = new javax.swing.JButton();
        dmfsd3 = new javax.swing.JLabel();
        dmfsd4 = new javax.swing.JLabel();
        dmfsd5 = new javax.swing.JLabel();
        dmfsd6 = new javax.swing.JLabel();
        dmfsd7 = new javax.swing.JLabel();
        dmfsd8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Deadline : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        t_deadline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_deadlineActionPerformed(evt);
            }
        });
        jPanel1.add(t_deadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 240, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Kegiatan : ");
        jLabel2.setAutoscrolls(true);
        jLabel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(), javax.swing.BorderFactory.createCompoundBorder()));
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.setInheritsPopupMenu(false);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Deskripsi : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 80, -1));

        t_deskripsi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_deskripsiKeyReleased(evt);
            }
        });
        jPanel1.add(t_deskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 320, -1));

        t_kegiatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_kegiatanActionPerformed(evt);
            }
        });
        jPanel1.add(t_kegiatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 240, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 90, 664, 277));

        t_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_cariMouseClicked(evt);
            }
        });
        t_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cariActionPerformed(evt);
            }
        });
        t_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_cariKeyTyped(evt);
            }
        });
        jPanel1.add(t_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 257, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("pencarian : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 64, 80, -1));

        btn_tambah.setText("tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        jPanel1.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        btn_update.setText("update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel1.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, -1));

        btn_batal.setText("batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        jPanel1.add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, -1, -1));

        btn_hapus.setText("hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel1.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        t_nomor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nomorActionPerformed(evt);
            }
        });
        jPanel1.add(t_nomor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 240, -1));

        dmfsd.setBackground(new java.awt.Color(0, 0, 0));
        dmfsd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dmfsd.setText("Nomor : ");
        dmfsd.setAutoscrolls(true);
        jPanel1.add(dmfsd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("To Do LIST");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 240, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/summer1.jpg"))); // NOI18N
        jLabel6.setText(" ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1030, 410));

        dmfsd1.setBackground(new java.awt.Color(0, 0, 0));
        dmfsd1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dmfsd1.setText("Nomor : ");
        dmfsd1.setAutoscrolls(true);
        jPanel1.add(dmfsd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        dmfsd2.setBackground(new java.awt.Color(0, 0, 0));
        dmfsd2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dmfsd2.setText("Nomor : ");
        dmfsd2.setAutoscrolls(true);
        jPanel1.add(dmfsd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Deadline : ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        btn_tambah1.setText("tambah");
        btn_tambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_tambah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        dmfsd3.setBackground(new java.awt.Color(0, 0, 0));
        dmfsd3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dmfsd3.setText("Nomor : ");
        dmfsd3.setAutoscrolls(true);
        jPanel1.add(dmfsd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        dmfsd4.setBackground(new java.awt.Color(0, 0, 0));
        dmfsd4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dmfsd4.setText("Nomor : ");
        dmfsd4.setAutoscrolls(true);
        jPanel1.add(dmfsd4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        dmfsd5.setBackground(new java.awt.Color(0, 0, 0));
        dmfsd5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dmfsd5.setText("Nomor : ");
        dmfsd5.setAutoscrolls(true);
        jPanel1.add(dmfsd5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        dmfsd6.setBackground(new java.awt.Color(0, 0, 0));
        dmfsd6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dmfsd6.setText("Nomor : ");
        dmfsd6.setAutoscrolls(true);
        jPanel1.add(dmfsd6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        dmfsd7.setBackground(new java.awt.Color(0, 0, 0));
        dmfsd7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dmfsd7.setText("Nomor : ");
        dmfsd7.setAutoscrolls(true);
        jPanel1.add(dmfsd7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        dmfsd8.setBackground(new java.awt.Color(0, 0, 0));
        dmfsd8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dmfsd8.setText("Nomor : ");
        dmfsd8.setAutoscrolls(true);
        jPanel1.add(dmfsd8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin diperbarui");
            return;
        }

        // Mengambil data dari field
        int nomor = Integer.parseInt(t_nomor.getText());
        String deadline = t_deadline.getText();
        String kegiatan = t_kegiatan.getText();
        String deskripsi = t_deskripsi.getText();

        // Validasi
        if (deadline.isEmpty() || kegiatan.isEmpty() || deskripsi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Memperbarui data menggunakan metode updateData dari kelas CRUD
        Data data = new Data(nomor, deadline, kegiatan, deskripsi);
        if (crud.updateData(data)) {
            JOptionPane.showMessageDialog(this, "Data berhasil diperbarui");
            resetForm();
            getData();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal memperbarui data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        resetForm();
        activeButton();
        nonActiveButton();
        
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        int nomor = Integer.parseInt(t_nomor.getText());
        String deadline = t_deadline.getText();
        String kegiatan = t_kegiatan.getText();
        String deskripsi = t_deskripsi.getText();

        // Validasi
        if (deadline.isEmpty() || kegiatan.isEmpty() || deskripsi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Menambahkan data menggunakan metode addData dari kelas CRUD
        Data data = new Data(nomor, deadline, kegiatan, deskripsi);
        if (crud.addData(data)) {
            JOptionPane.showMessageDialog(this, "Tugas bertambah, segera dikerjakan!");
            resetForm();
            getData(); 
       } else {
            JOptionPane.showMessageDialog(this, "Gagal menambahkan data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        
        int selectedRow=tbl_data.getSelectedRow();
        if(selectedRow != -1){
            int nomor =Integer.parseInt(tbl_data.getValueAt(selectedRow,0).toString());
            String deadline=tbl_data.getValueAt(selectedRow,1).toString();
            String kegiatan=tbl_data.getValueAt(selectedRow,2).toString();
            String deskripsi=tbl_data.getValueAt(selectedRow,3).toString();
            
            t_nomor.setText(String.valueOf(nomor));
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
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Mengambil nomor dari baris yang dipilih
            int nomor = (int) tbl_data.getValueAt(selectedRow, 0);

            // Menghapus data menggunakan metode deleteData dari kelas CRUD
            if (crud.deleteData(nomor)) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
                resetForm();
                getData();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void t_kegiatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_kegiatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_kegiatanActionPerformed

    private void t_nomorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nomorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nomorActionPerformed

    private void t_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_cariKeyTyped
        DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
        model.setRowCount(0);
        
        // Mendapatkan kata kunci pencarian
        String keyword = t_cari.getText();

        // Mencari data menggunakan metode searchData dari kelas CRUD
        List<Data> dataList = search.searchData(keyword);

        // Mengisi tabel dengan hasil pencarian
        for (Data data : dataList) {
            Object[] rowData = {data.getNomor(), data.getDeadline(), data.getKegiatan(), data.getDeskripsi()};
            model.addRow(rowData);
        }
    }//GEN-LAST:event_t_cariKeyTyped

    private void t_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_cariMouseClicked
        t_cari.setText("");
    }//GEN-LAST:event_t_cariMouseClicked

    private void btn_tambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tambah1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_tambah1;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel dmfsd;
    private javax.swing.JLabel dmfsd1;
    private javax.swing.JLabel dmfsd2;
    private javax.swing.JLabel dmfsd3;
    private javax.swing.JLabel dmfsd4;
    private javax.swing.JLabel dmfsd5;
    private javax.swing.JLabel dmfsd6;
    private javax.swing.JLabel dmfsd7;
    private javax.swing.JLabel dmfsd8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTextField t_deadline;
    private javax.swing.JTextField t_deskripsi;
    private javax.swing.JTextField t_kegiatan;
    private javax.swing.JTextField t_nomor;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
        t_nomor.setText("");
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
//    private String t_nomor_getText() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }  
}
