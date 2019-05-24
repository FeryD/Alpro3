package Proyek1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Hidayat
 */
public class Input_Dosen extends javax.swing.JFrame {
    
    private String user = "root";
    private String pwd = "";
    private String host = "localhost";
    private String db = "Proyek1";
    private String urlValue = "";
    private Connection conn = null;
    private JTable table = null;
    private String Alih = null;                                                 // simpan sementara saat edit (nama lama)

    public Input_Dosen() {
        initComponents();    
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            urlValue = "jdbc:mysql://"+ host +"/"+ db +"?user="+ user +"&password="+ pwd;
            conn = DriverManager.getConnection(urlValue);
            
            tampilTabel();
        }
        catch(ClassNotFoundException e){
            System.out.println("Driver tidak ditemukan");
        }
        catch(SQLException e){
            System.out.println("Koneksi gagal "+e.toString());
        }
    }

    private Object[][] getData(){
        
        Object[][] data1 = null;
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from dosen");
            
            rs.last();
            int rowCount=rs.getRow();
            rs.beforeFirst();
            data1 = new Object[rowCount][2];
  
            int no= -1;
            while(rs.next()){
                no=no+1;
                data1[no][0]=rs.getString("Nama_Dosen");
                data1[no][1]=rs.getString("Kode_Dosen");
            }
            
            st.close();
            //conn.close();                                                     6 Jan 2019,12:00, sempat error di penghapusan karena conn.close()
        }
        
        catch(SQLException e){
            System.out.println("Koneksi gagal "+ e.toString());
        }
        
        return data1;
    }
    
    private void tampilTabel(){
        String[] columnNames = {"Nama Dosen","Kode Dosen"};
        table = new JTable(getData(),columnNames);
        jScrollPane.setViewportView(table);       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelData_Dosen = new javax.swing.JLabel();
        jLabelNama_Dosen = new javax.swing.JLabel();
        jLabelKode_Dosen = new javax.swing.JLabel();
        jTextFieldNama_Dosen = new javax.swing.JTextField();
        jTextFieldKode_Dosen = new javax.swing.JTextField();
        jButtonTambah = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jLabelTambah_Data = new javax.swing.JLabel();
        jLabelEdit_Data = new javax.swing.JLabel();
        jTextFieldNama_Dosen2 = new javax.swing.JTextField();
        jTextFieldKode_Dosen2 = new javax.swing.JTextField();
        jLabelNama_Dosen2 = new javax.swing.JLabel();
        jLabelKode_Dosen2 = new javax.swing.JLabel();
        jButtonCek = new javax.swing.JButton();
        jLabelHapus_Data = new javax.swing.JLabel();
        jButtonHapus = new javax.swing.JButton();
        jButtonSimpan = new javax.swing.JButton();
        jTextFieldKode_Dosen3 = new javax.swing.JTextField();
        jLabelKode_Dosen3 = new javax.swing.JLabel();
        jLabelGaris = new javax.swing.JLabel();
        jLabelKembali = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Input Dosen");
        setResizable(false);

        jLabelData_Dosen.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelData_Dosen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelData_Dosen.setText("INPUT DATA DOSEN");

        jLabelNama_Dosen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNama_Dosen.setText("NAMA DOSEN");

        jLabelKode_Dosen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelKode_Dosen.setText("KODE DOSEN");

        jButtonTambah.setText("TAMBAH");
        jButtonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTambahActionPerformed(evt);
            }
        });

        jLabelTambah_Data.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTambah_Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTambah_Data.setText("TAMBAH DATA");

        jLabelEdit_Data.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEdit_Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEdit_Data.setText("EDIT DATA");

        jTextFieldNama_Dosen2.setEnabled(false);

        jLabelNama_Dosen2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNama_Dosen2.setText("NAMA DOSEN");

        jLabelKode_Dosen2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelKode_Dosen2.setText("KODE DOSEN");

        jButtonCek.setText("CEK");
        jButtonCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCekActionPerformed(evt);
            }
        });

        jLabelHapus_Data.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHapus_Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHapus_Data.setText("HAPUS DATA");

        jButtonHapus.setText("HAPUS DATA YANG DIPILIH");
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusActionPerformed(evt);
            }
        });

        jButtonSimpan.setText("SIMPAN");
        jButtonSimpan.setEnabled(false);
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });

        jLabelKode_Dosen3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelKode_Dosen3.setText("KODE DOSEN");

        jLabelGaris.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelGaris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGaris.setText("========================================================================================================");

        jLabelKembali.setText("Kembali");
        jLabelKembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelKembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelKembaliMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane)
                    .addComponent(jLabelData_Dosen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelNama_Dosen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldNama_Dosen, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelKode_Dosen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldKode_Dosen, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelTambah_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelKode_Dosen2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldKode_Dosen2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelNama_Dosen2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldNama_Dosen2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonSimpan)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelKode_Dosen3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldKode_Dosen3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonCek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelEdit_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelHapus_Data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelKembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelGaris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelData_Dosen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGaris)
                    .addComponent(jLabelKembali))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTambah_Data)
                    .addComponent(jLabelEdit_Data)
                    .addComponent(jLabelHapus_Data))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNama_Dosen)
                            .addComponent(jTextFieldNama_Dosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldKode_Dosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKode_Dosen)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldKode_Dosen3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelKode_Dosen3)
                        .addComponent(jButtonSimpan))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNama_Dosen2)
                            .addComponent(jTextFieldNama_Dosen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldKode_Dosen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKode_Dosen2)
                            .addComponent(jButtonCek)
                            .addComponent(jButtonHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Hapus(){
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from dosen where Kode_Dosen='"+jTextFieldKode_Dosen3.getText()+"'");
            if(rs.next()){;
                PreparedStatement pStatement = null;
                String sql = "delete from dosen where Kode_Dosen=?";
                pStatement = conn.prepareStatement(sql);
                pStatement.setString(1, jTextFieldKode_Dosen3.getText());
                int intHapus = pStatement.executeUpdate();  
              
                if(intHapus>0){
                    JOptionPane.showMessageDialog(this,"Berhasil Menghapus","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this,"Gagal Menghapus","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }   

                pStatement.close();
                jTextFieldKode_Dosen3.setText("");
                tampilTabel();
            }else{
                JOptionPane.showMessageDialog(this, "Data tidak ada", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                jTextFieldKode_Dosen3.setText("");
                jTextFieldKode_Dosen3.requestFocus();
            }
        }
        catch(SQLException e){
            System.out.println("Koneksi gagal "+e.toString());
        }
    }
    
    private void jButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusActionPerformed
        //<editor-fold defaultstate="collapsed" desc="=============Code ini untuk hapus data dgn cara select pada table=============">
        /*String usrId = table.getValueAt(table.getSelectedRow(),0).toString();
        // usrId akan berisi nama dari table yang di select, kenapa nama? karna kolom indeks 0
        
        try{
            PreparedStatement pStatement = null;
            String sql = "delete from dosen where Nama_Dosen=?";
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, usrId);
            
            int intHapus = pStatement.executeUpdate();
            if(intHapus>0){
                JOptionPane.showMessageDialog(this, "Hapus data sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Hapus data gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
            pStatement.close();
            tampilTabel();
        }
        
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("gagal "+e.toString());
        }
        
        catch(SQLException e){
            System.out.println("Koneksi gagal "+e.toString());
        }
        =============Code ini untuk hapus data dgn cara select pada table=============
        */
        //</editor-fold>
        
        Hapus();
    }//GEN-LAST:event_jButtonHapusActionPerformed

    private void Tambah(){
        try{
            PreparedStatement pStatement = null;
            String sql = "insert into dosen (Nama_Dosen,Kode_Dosen) Values (?,?)";
            if(!(jTextFieldKode_Dosen.getText().isEmpty() || jTextFieldNama_Dosen.getText().isEmpty())){
                pStatement = conn.prepareStatement(sql);
                pStatement.setString(1, jTextFieldNama_Dosen.getText());
                pStatement.setString(2, jTextFieldKode_Dosen.getText());

                int intTambah= pStatement.executeUpdate();
                if(intTambah>0){
                    JOptionPane.showMessageDialog(this, "Penambahan Sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);               
                }else{
                    JOptionPane.showMessageDialog(this, "Penambahan gagal","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }

                pStatement.close();

                jTextFieldNama_Dosen.setText("");
                jTextFieldKode_Dosen.setText("");

                tampilTabel();
            }else{
                JOptionPane.showMessageDialog(this, "Terdapat Data Yang Kosong","Informasi",JOptionPane.INFORMATION_MESSAGE);
            }   
        }
               
        catch(SQLException e){
            System.out.println("Koneksi gagal "+e.toString());
            JOptionPane.showMessageDialog(this,e.toString(),"Informasi",JOptionPane.INFORMATION_MESSAGE);
            jTextFieldNama_Dosen.setText("");
            jTextFieldKode_Dosen.setText("");
        }
    }
    
    private void jButtonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTambahActionPerformed
        Tambah();
    }//GEN-LAST:event_jButtonTambahActionPerformed

    private void Cek(){
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from dosen where Kode_Dosen='"+jTextFieldKode_Dosen2.getText()+"'");
            if(rs.next()){
                JOptionPane.showMessageDialog(this, "Silahkan Edit Data", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                jButtonSimpan.setEnabled(true);
                jTextFieldNama_Dosen2.setText(rs.getString("Nama_Dosen"));
                Alih = jTextFieldKode_Dosen2.getText();
                jTextFieldNama_Dosen.setEnabled(false);
                jTextFieldKode_Dosen.setEnabled(false);
                jTextFieldKode_Dosen3.setEnabled(false);
                jButtonTambah.setEnabled(false);
                jButtonHapus.setEnabled(false);
                jTextFieldNama_Dosen2.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(this, "Data tidak ada", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                jTextFieldNama_Dosen2.setText("");
                jTextFieldKode_Dosen2.setText("");
                jTextFieldKode_Dosen2.requestFocus();
            }
        }
        catch(SQLException e){
            System.out.println("Koneksi gagal "+e.toString());
        }
    }
    
    private void jButtonCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCekActionPerformed
        Cek();
    }//GEN-LAST:event_jButtonCekActionPerformed

    private void Simpan(){
        try{
            if(!(jTextFieldKode_Dosen2.getText().isEmpty() || jTextFieldNama_Dosen2.getText().isEmpty())){
                PreparedStatement pStatement = null;
                String sql = "update dosen set Kode_Dosen=?, Nama_Dosen=? where Kode_Dosen='"+Alih+"'";
                pStatement = conn.prepareStatement(sql);

                pStatement.setString(1, jTextFieldKode_Dosen2.getText());
                pStatement.setString(2, jTextFieldNama_Dosen2.getText());


                int intTambah = pStatement.executeUpdate();
                if(intTambah>0){
                    JOptionPane.showMessageDialog(this,"Edit Sukses","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this,"Edit Gagal","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }

                pStatement.close();
                jTextFieldNama_Dosen2.setText("");
                jTextFieldKode_Dosen2.setText("");

                jTextFieldNama_Dosen2.setEnabled(false);
                jButtonSimpan.setEnabled(false);
                jTextFieldNama_Dosen.setEnabled(true);
                jTextFieldKode_Dosen3.setEnabled(true);
                jTextFieldKode_Dosen.setEnabled(true);
                jButtonTambah.setEnabled(true);
                jButtonHapus.setEnabled(true);
                tampilTabel();
            }else{
                JOptionPane.showMessageDialog(this,"Terdapat Data Yang Kosong","Informasi",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        catch(SQLException e){
            System.out.println("Koneksi gagal"+e.toString());
            JOptionPane.showMessageDialog(this,e.toString(),"Informasi",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed
        Simpan();
    }//GEN-LAST:event_jButtonSimpanActionPerformed

    private void Kembali(){
        Menu_Utama_Admin a = new Menu_Utama_Admin();
        a.setVisible(true);

        this.dispose();
    }
    
    private void jLabelKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelKembaliMouseClicked
        Kembali();
    }//GEN-LAST:event_jLabelKembaliMouseClicked

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Input_Dosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Input_Dosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Input_Dosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Input_Dosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
                
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Input_Dosen().setVisible(true);
            }
        });
    }

    //<editor-fold defaultstate="collapsed" desc=" Variable Declaration ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCek;
    private javax.swing.JButton jButtonHapus;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JButton jButtonTambah;
    private javax.swing.JLabel jLabelData_Dosen;
    private javax.swing.JLabel jLabelEdit_Data;
    private javax.swing.JLabel jLabelGaris;
    private javax.swing.JLabel jLabelHapus_Data;
    private javax.swing.JLabel jLabelKembali;
    private javax.swing.JLabel jLabelKode_Dosen;
    private javax.swing.JLabel jLabelKode_Dosen2;
    private javax.swing.JLabel jLabelKode_Dosen3;
    private javax.swing.JLabel jLabelNama_Dosen;
    private javax.swing.JLabel jLabelNama_Dosen2;
    private javax.swing.JLabel jLabelTambah_Data;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTextField jTextFieldKode_Dosen;
    private javax.swing.JTextField jTextFieldKode_Dosen2;
    private javax.swing.JTextField jTextFieldKode_Dosen3;
    private javax.swing.JTextField jTextFieldNama_Dosen;
    private javax.swing.JTextField jTextFieldNama_Dosen2;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}