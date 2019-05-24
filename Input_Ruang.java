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
public class Input_Ruang extends javax.swing.JFrame {
    
    private String user = "root";
    private String pwd = "";
    private String host = "localhost";
    private String db = "Proyek1";
    private String urlValue = "";
    private Connection conn = null;
    private JTable table = null;
    private String Alih = null;  
    
    public Input_Ruang() {
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
            ResultSet rs = st.executeQuery("Select * from ruang");
            
            rs.last();
            int rowCount=rs.getRow();
            rs.beforeFirst();
            data1 = new Object[rowCount][3];
  
            int no= -1;
            while(rs.next()){
                no=no+1;
                data1[no][0]=rs.getString("Kode_Ruang");
                data1[no][1]=rs.getString("Gedung");
                data1[no][2]=rs.getString("Lantai");
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
        String[] columnNames = {"Kode Ruang","Gedung","Lantai"};
        table = new JTable(getData(),columnNames);
        jScrollPane.setViewportView(table);       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelData_Ruang = new javax.swing.JLabel();
        jLabelGaris = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jLabelGedung = new javax.swing.JLabel();
        jTextFieldGedung = new javax.swing.JTextField();
        jLabelTambah_Data = new javax.swing.JLabel();
        jButtonTambah = new javax.swing.JButton();
        jLabelEdit_Data = new javax.swing.JLabel();
        jLabelKode_Ruang3 = new javax.swing.JLabel();
        jLabelHapus_Data = new javax.swing.JLabel();
        jTextFieldKode_Ruang3 = new javax.swing.JTextField();
        jButtonHapus = new javax.swing.JButton();
        jLabelKode_Ruang = new javax.swing.JLabel();
        jTextFieldKode_Ruang = new javax.swing.JTextField();
        jLabelLantai = new javax.swing.JLabel();
        jTextFieldLantai = new javax.swing.JTextField();
        jButtonCek = new javax.swing.JButton();
        jLabelKode_Ruang2 = new javax.swing.JLabel();
        jTextFieldKode_Ruang2 = new javax.swing.JTextField();
        jLabelLantai2 = new javax.swing.JLabel();
        jTextFieldLantai2 = new javax.swing.JTextField();
        jLabelGedung2 = new javax.swing.JLabel();
        jTextFieldGedung2 = new javax.swing.JTextField();
        jButtonSimpan = new javax.swing.JButton();
        jLabelKembali = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Input Ruang");
        setResizable(false);

        jLabelData_Ruang.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelData_Ruang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelData_Ruang.setText("INPUT DATA RUANG");

        jLabelGaris.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelGaris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGaris.setText("=======================================================================================================");

        jLabelGedung.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelGedung.setText("GEDUNG");

        jLabelTambah_Data.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTambah_Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTambah_Data.setText("TAMBAH DATA");

        jButtonTambah.setText("TAMBAH");
        jButtonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTambahActionPerformed(evt);
            }
        });

        jLabelEdit_Data.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEdit_Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEdit_Data.setText("EDIT DATA");

        jLabelKode_Ruang3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelKode_Ruang3.setText("KODE RUANG");

        jLabelHapus_Data.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHapus_Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHapus_Data.setText("HAPUS DATA");

        jButtonHapus.setText("HAPUS DATA YANG DIPILIH");
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusActionPerformed(evt);
            }
        });

        jLabelKode_Ruang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelKode_Ruang.setText("kODE RUANG");

        jLabelLantai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLantai.setText("LANTAI");

        jButtonCek.setText("CEK");
        jButtonCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCekActionPerformed(evt);
            }
        });

        jLabelKode_Ruang2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelKode_Ruang2.setText("kODE RUANG");

        jLabelLantai2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLantai2.setText("LANTAI");

        jTextFieldLantai2.setEnabled(false);

        jLabelGedung2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelGedung2.setText("GEDUNG");

        jTextFieldGedung2.setEnabled(false);

        jButtonSimpan.setText("SIMPAN");
        jButtonSimpan.setEnabled(false);
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelData_Ruang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabelGedung, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelKode_Ruang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelLantai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldGedung, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldLantai, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldKode_Ruang, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelTambah_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelEdit_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabelGedung2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelLantai2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelKode_Ruang2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldKode_Ruang2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonCek, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldLantai2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldGedung2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelKode_Ruang3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldKode_Ruang3))
                            .addComponent(jButtonHapus, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                            .addComponent(jLabelHapus_Data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelKembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelGaris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelData_Ruang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGaris)
                    .addComponent(jLabelKembali))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTambah_Data)
                    .addComponent(jLabelEdit_Data)
                    .addComponent(jLabelHapus_Data))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldKode_Ruang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelKode_Ruang2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldGedung2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelGedung2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldLantai2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelLantai2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonCek)
                                    .addComponent(jLabelKode_Ruang3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldKode_Ruang3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonHapus)
                                        .addGap(0, 20, Short.MAX_VALUE))
                                    .addComponent(jButtonSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldKode_Ruang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKode_Ruang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldGedung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelGedung))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldLantai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLantai))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Tambah(){
        try{
            PreparedStatement pStatement = null;
            String sql = "insert into ruang (Gedung,Lantai,Kode_Ruang) Values (?,?,?)";
            if(!(jTextFieldKode_Ruang.getText().isEmpty() || jTextFieldGedung.getText().isEmpty() || jTextFieldLantai.getText().isEmpty())){
                pStatement = conn.prepareStatement(sql);
                pStatement.setString(1, jTextFieldGedung.getText());
                pStatement.setString(2, jTextFieldLantai.getText());
                pStatement.setString(3, jTextFieldKode_Ruang.getText());

                int intTambah= pStatement.executeUpdate();
                if(intTambah>0){
                    JOptionPane.showMessageDialog(this, "Penambahan Sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);               
                }else{
                    JOptionPane.showMessageDialog(this, "Penambahan gagal","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }

                pStatement.close();

                jTextFieldGedung.setText("");
                jTextFieldLantai.setText("");
                jTextFieldKode_Ruang.setText("");

                tampilTabel();
            }else{
                JOptionPane.showMessageDialog(this, "Terdapat Data Yang Kosong","Informasi",JOptionPane.INFORMATION_MESSAGE);
            }   
        }
               
        catch(SQLException e){
            System.out.println("Koneksi gagal "+e.toString());
            JOptionPane.showMessageDialog(this,e.toString(),"Informasi",JOptionPane.INFORMATION_MESSAGE);
            jTextFieldGedung.setText("");
            jTextFieldLantai.setText("");
            jTextFieldKode_Ruang.setText("");
        }
    }
    
    private void jButtonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTambahActionPerformed
        Tambah();
    }//GEN-LAST:event_jButtonTambahActionPerformed

    private void Hapus(){
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from ruang where Kode_Ruang='"+jTextFieldKode_Ruang3.getText()+"'");
            if(rs.next()){;
                PreparedStatement pStatement = null;
                String sql = "delete from ruang where Kode_Ruang=?";
                pStatement = conn.prepareStatement(sql);
                pStatement.setString(1, jTextFieldKode_Ruang3.getText());
                int intHapus = pStatement.executeUpdate();  
              
                if(intHapus>0){
                    JOptionPane.showMessageDialog(this,"Berhasil Menghapus","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this,"Gagal Menghapus","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }   

                pStatement.close();
                jTextFieldKode_Ruang3.setText("");
                tampilTabel();
            }else{
                JOptionPane.showMessageDialog(this, "Data tidak ada", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                jTextFieldKode_Ruang3.setText("");
                jTextFieldKode_Ruang3.requestFocus();
            }
        }
        catch(SQLException e){
            System.out.println("Koneksi gagal "+e.toString());
        } 
    }
    
    private void jButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusActionPerformed
        Hapus();
    }//GEN-LAST:event_jButtonHapusActionPerformed

    private void Cek(){
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from ruang where Kode_Ruang='"+jTextFieldKode_Ruang2.getText()+"'");
            if(rs.next()){
                JOptionPane.showMessageDialog(this, "Silahkan Edit Data", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                
                jTextFieldKode_Ruang2.setText(rs.getString("Kode_Ruang"));
                jTextFieldGedung2.setText(rs.getString("Gedung"));
                jTextFieldLantai2.setText(rs.getString("Lantai"));
                
                Alih = jTextFieldKode_Ruang2.getText();
                
                jTextFieldKode_Ruang.setEnabled(false);
                jTextFieldKode_Ruang3.setEnabled(false);
                jTextFieldGedung.setEnabled(false);
                jTextFieldLantai.setEnabled(false);
                jButtonTambah.setEnabled(false);
                jButtonHapus.setEnabled(false);
                
                jTextFieldGedung2.setEnabled(true);
                jTextFieldLantai2.setEnabled(true);
                jButtonSimpan.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(this, "Data tidak ada", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                jTextFieldKode_Ruang2.setText("");
                jTextFieldGedung2.setText("");
                jTextFieldLantai2.setText("");
                jTextFieldKode_Ruang2.requestFocus();
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
            if(!(jTextFieldKode_Ruang2.getText().isEmpty() || jTextFieldGedung2.getText().isEmpty() || jTextFieldLantai2.getText().isEmpty())){
                PreparedStatement pStatement = null;
                String sql = "update ruang set Kode_Ruang=?, Gedung=?, Lantai=? where Kode_Ruang='"+Alih+"'";
                pStatement = conn.prepareStatement(sql);

                pStatement.setString(1, jTextFieldKode_Ruang2.getText());
                pStatement.setString(2, jTextFieldGedung2.getText());
                pStatement.setString(3, jTextFieldLantai2.getText());


                int intTambah = pStatement.executeUpdate();
                if(intTambah>0){
                    JOptionPane.showMessageDialog(this,"Edit Sukses","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this,"Edit Gagal","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }

                pStatement.close();
                jTextFieldKode_Ruang2.setText("");
                jTextFieldGedung2.setText("");
                jTextFieldLantai2.setText("");

                jTextFieldGedung2.setEnabled(false);
                jTextFieldLantai2.setEnabled(false);
                jButtonSimpan.setEnabled(false);
                jTextFieldGedung.setEnabled(true);
                jTextFieldKode_Ruang.setEnabled(true);
                jTextFieldKode_Ruang3.setEnabled(true);
                jTextFieldLantai.setEnabled(true);
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
            java.util.logging.Logger.getLogger(Input_Ruang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Input_Ruang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Input_Ruang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Input_Ruang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Input_Ruang().setVisible(true);
            }
        });
    }

    //<editor-fold defaultstate="collapsed" desc=" Variable Declaration ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCek;
    private javax.swing.JButton jButtonHapus;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JButton jButtonTambah;
    private javax.swing.JLabel jLabelData_Ruang;
    private javax.swing.JLabel jLabelEdit_Data;
    private javax.swing.JLabel jLabelGaris;
    private javax.swing.JLabel jLabelGedung;
    private javax.swing.JLabel jLabelGedung2;
    private javax.swing.JLabel jLabelHapus_Data;
    private javax.swing.JLabel jLabelKembali;
    private javax.swing.JLabel jLabelKode_Ruang;
    private javax.swing.JLabel jLabelKode_Ruang2;
    private javax.swing.JLabel jLabelKode_Ruang3;
    private javax.swing.JLabel jLabelLantai;
    private javax.swing.JLabel jLabelLantai2;
    private javax.swing.JLabel jLabelTambah_Data;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTextField jTextFieldGedung;
    private javax.swing.JTextField jTextFieldGedung2;
    private javax.swing.JTextField jTextFieldKode_Ruang;
    private javax.swing.JTextField jTextFieldKode_Ruang2;
    private javax.swing.JTextField jTextFieldKode_Ruang3;
    private javax.swing.JTextField jTextFieldLantai;
    private javax.swing.JTextField jTextFieldLantai2;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}