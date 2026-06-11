
package Form;
import Config.Koneksi;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUI extends javax.swing.JFrame {

    private Connection conn;
    private Search search;
    private CRUD crud;
    
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Deadline : ");

        t_deadline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_deadlineActionPerformed(evt);
            }
        });

        jLabel2.setText("Kegiatan : ");

        jLabel3.setText("Deskripsi : ");

        t_deskripsi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_deskripsiKeyReleased(evt);
            }
        });

        t_kegiatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_kegiatanActionPerformed(evt);
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

        t_nomor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nomorActionPerformed(evt);
            }
        });

        dmfsd.setText("Nomor : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_batal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_hapus)
                        .addGap(18, 30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(dmfsd))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_deskripsi)
                            .addComponent(t_deadline, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(t_kegiatan)
                            .addComponent(t_nomor, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_nomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dmfsd))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_deadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(t_kegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_deskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tambah)
                            .addComponent(btn_update)
                            .addComponent(btn_batal)
                            .addComponent(btn_hapus))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel dmfsd;
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

    private String t_nomor_getText() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
