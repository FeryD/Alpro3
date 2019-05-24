package Proyek1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Hidayat
 */
public class Pencarian extends javax.swing.JFrame {

    private String user = "root";
    private String pwd = "";
    private String host = "localhost";
    private String db = "Proyek1";
    private String urlValue = "";
    private Connection conn = null;
    
    public Pencarian() {
        initComponents();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            urlValue = "jdbc:mysql://"+ host +"/"+ db +"?user="+ user +"&password="+ pwd;
            conn = DriverManager.getConnection(urlValue);
            
            Statement st = conn.createStatement();
            ResultSet rs = null;

            rs = st.executeQuery("select distinct Nama_Dosen from dosen");
            while(rs.next()){
                jComboBoxNama_Dosen.addItem(rs.getString("Nama_Dosen"));
            }
            
            rs = st.executeQuery("select distinct Kode_Ruang from ruang");
            while(rs.next()){
                jComboBoxKode_Ruang.addItem(rs.getString("Kode_Ruang"));
            }
        }
        catch(ClassNotFoundException e){
            System.out.println("Driver tidak ditemukan");
        }
        catch(SQLException e){
            System.out.println("Koneksi gagal "+e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxNama_Dosen = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonCari = new javax.swing.JButton();
        jComboBoxHari = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxKode_Ruang = new javax.swing.JComboBox<>();
        jButtonCari2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxSesi = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabelKembali = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pencarian");
        setResizable(false);

        jLabel1.setText("Nama Dosen");

        jLabel5.setText("==================================================================");

        jLabel6.setText("==================================================================");

        jButtonCari.setText("Cari");
        jButtonCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCariActionPerformed(evt);
            }
        });

        jComboBoxHari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu" }));

        jLabel7.setText("Hari");

        jButtonCari2.setText("Cari");
        jButtonCari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCari2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Kode Ruang");

        jComboBoxSesi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        jLabel8.setText("Sesi");

        jLabelKembali.setText("< Kembali");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxNama_Dosen, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonCari)
                                        .addGap(19, 19, 19)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxKode_Ruang, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCari2)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel7)
                        .addGap(27, 27, 27)
                        .addComponent(jComboBoxHari, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel8)
                        .addGap(29, 29, 29)
                        .addComponent(jComboBoxSesi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelKembali)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabelKembali)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxSesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxNama_Dosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCari))
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxKode_Ruang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCari2))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Cari2(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            urlValue = "jdbc:mysql://"+ host +"/"+ db +"?user="+ user +"&password="+ pwd;
            conn = DriverManager.getConnection(urlValue);
            
            Statement st = conn.createStatement();
            ResultSet rs = null;

            String Kode_Jadwal = (String) jComboBoxKode_Ruang.getSelectedItem()+
                                (String) jComboBoxHari.getSelectedItem()+
                                (String) jComboBoxSesi.getSelectedItem();
            rs = st.executeQuery("select * from jadwal where Kode_Jadwal='"+Kode_Jadwal+"'");

            String Pesan1="";
            String Kode_Dosen="";
            String Kode_Matkul="";
            String Kode_Ruang=jComboBoxKode_Ruang.getSelectedItem().toString();
            String Hari=jComboBoxHari.getSelectedItem().toString();
            String Sesi=jComboBoxSesi.getSelectedItem().toString();
            while(rs.next()){
                Kode_Dosen = rs.getString("Kode_Dosen");
                Kode_Matkul = rs.getString("Kode_Matkul");
            }
            
            rs = st.executeQuery("select Nama_Dosen from dosen where Kode_Dosen='"+Kode_Dosen+"'");
            String Nama_Dosen="";
            while(rs.next()){
                Nama_Dosen = rs.getString("Nama_Dosen");
            }
            
            rs = st.executeQuery("select Nama_Matkul from matkul where Kode_Matkul='"+Kode_Matkul+"'");
            String Nama_Matkul="";
            while(rs.next()){
                Nama_Matkul = rs.getString("Nama_Matkul");
            }
            
            if(Kode_Dosen.equals("") && Kode_Matkul.equals("")){
                Pesan1= "Ruang : "+Kode_Ruang+
                        "\nHari : "+Hari+
                        "\nSesi : "+Sesi+
                        "\nKeterangan : Sedang Kosong";
                JOptionPane.showMessageDialog(this, Pesan1 ,"Pencarian",JOptionPane.PLAIN_MESSAGE);
            }else{
                Pesan1= "Ruang : "+Kode_Ruang+
                        "\nHari : "+Hari+
                        "\nSesi : "+Sesi+
                        "\nKeterangan : Sedang Ada Mata Kuliah "+Nama_Matkul+" Oleh "+Nama_Dosen;
                JOptionPane.showMessageDialog(this, Pesan1 ,"Pencarian",JOptionPane.PLAIN_MESSAGE);
            }
                
        }
        catch(ClassNotFoundException e){
            System.out.println("Driver tidak ditemukan");
        }
        catch(SQLException e){
            System.out.println("Koneksi gagal "+e.toString());
        }
    }
    
    private void jButtonCari2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCari2ActionPerformed
        Cari2();
    }//GEN-LAST:event_jButtonCari2ActionPerformed

    private void Kembali(){
        Lihat_Jadwal a = new Lihat_Jadwal();
        a.setVisible(true);
        
        this.dispose();
    }
    
    private void jLabelKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelKembaliMouseClicked
        Kembali();
    }//GEN-LAST:event_jLabelKembaliMouseClicked

    private void Cari(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            urlValue = "jdbc:mysql://"+ host +"/"+ db +"?user="+ user +"&password="+ pwd;
            conn = DriverManager.getConnection(urlValue);
            
            Statement st = conn.createStatement();
            ResultSet rs = null;
            
            String Nama_Dosen = jComboBoxNama_Dosen.getSelectedItem().toString();
            rs = st.executeQuery("select * from dosen where Nama_Dosen='"+Nama_Dosen+"'");
            
            String Pesan1="";
            String Kode_Dosen="";
            String Hari=jComboBoxHari.getSelectedItem().toString();
            String Sesi=jComboBoxSesi.getSelectedItem().toString();
            while(rs.next()){
                Kode_Dosen = rs.getString("Kode_Dosen");
            }
            
            String DosenSatuTempat=Kode_Dosen+Hari+Sesi;
            rs = st.executeQuery("select * from jadwal where DosenSatuTempat='"+DosenSatuTempat+"'");
            
            String Kode_Matkul="";
            String Kode_Ruang="";
            
            while(rs.next()){
                Kode_Ruang = rs.getString("Kode_Ruang");
                Kode_Matkul = rs.getString("Kode_Matkul");
            }
            
            rs = st.executeQuery("select Nama_Matkul from matkul where Kode_Matkul='"+Kode_Matkul+"'");
            String Nama_Matkul="";
            while(rs.next()){
                Nama_Matkul = rs.getString("Nama_Matkul");
            }
            
            if(Kode_Ruang.equals("") && Kode_Matkul.equals("")){
                Pesan1= "Nama : "+Nama_Dosen+
                        "\nHari : "+Hari+
                        "\nSesi : "+Sesi+
                        "\nKegiatan : Sedang Tidak Mengajar";
                JOptionPane.showMessageDialog(this, Pesan1 ,"Pencarian",JOptionPane.PLAIN_MESSAGE);
            }else{
                Pesan1= "Nama : "+Nama_Dosen+
                        "\nHari : "+Hari+
                        "\nSesi : "+Sesi+
                        "\nKegiatan : Mengajar "+Nama_Matkul+" di "+Kode_Ruang;
                JOptionPane.showMessageDialog(this, Pesan1 ,"Pencarian",JOptionPane.PLAIN_MESSAGE);
            }
                
        }
        catch(ClassNotFoundException e){
            System.out.println("Driver tidak ditemukan");
        }
        catch(SQLException e){
            System.out.println("Koneksi gagal "+e.toString());
        }
    }
    
    private void jButtonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCariActionPerformed
        Cari();
    }//GEN-LAST:event_jButtonCariActionPerformed

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
            java.util.logging.Logger.getLogger(Pencarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pencarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pencarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pencarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pencarian().setVisible(true);
            }
        });
    }

    //<editor-fold defaultstate="collapsed" desc=" Variable Declaration ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCari;
    private javax.swing.JButton jButtonCari2;
    private javax.swing.JComboBox<String> jComboBoxHari;
    private javax.swing.JComboBox<String> jComboBoxKode_Ruang;
    private javax.swing.JComboBox<String> jComboBoxNama_Dosen;
    private javax.swing.JComboBox<String> jComboBoxSesi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelKembali;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}