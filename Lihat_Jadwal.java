package Proyek1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;

/**
 *
 * @author Hidayat
 */
public class Lihat_Jadwal extends javax.swing.JFrame {
    
    private String user = "root";
    private String pwd = "";
    private String host = "localhost";
    private String db = "Proyek1";
    private String urlValue = "";
    private Connection conn = null;
    private JTable table = null;    
    
    public Lihat_Jadwal() {
        initComponents();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            urlValue = "jdbc:mysql://"+ host +"/"+ db +"?user="+ user +"&password="+ pwd;
            conn = DriverManager.getConnection(urlValue);
            
            Statement st = conn.createStatement();
            ResultSet rs = null;
            
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
            ResultSet rs = st.executeQuery("select A.Hari, A.Sesi, A.Kode_Ruang, B.Nama_Matkul, B.Nama_Dosen from (select Kode_Waktu,Hari,Sesi,Kode_Ruang from waktu cross join ruang order by Kode_Waktu asc) A left join (select Hari,Sesi,Kode_Ruang,Nama_Matkul,Nama_Dosen from matkul M inner join (select Hari,Sesi,Kode_Ruang,Kode_Matkul,Nama_Dosen from jadwal J inner join dosen D on J.Kode_Dosen = D.Kode_Dosen) A on M.Kode_Matkul = A.Kode_Matkul) B on A.Hari = B.Hari and A.Sesi = B.Sesi and A.Kode_Ruang = B.Kode_Ruang order by A.Kode_Waktu,A.Kode_Ruang asc;");
            
            rs.last();
            int rowCount=rs.getRow();
            rs.beforeFirst();
            data1 = new Object[rowCount][5];
  
            int no= -1;
            while(rs.next()){
                no=no+1;
                data1[no][0]=rs.getString("Hari");
                data1[no][1]=rs.getString("Sesi");
                data1[no][2]=rs.getString("Kode_Ruang");
                data1[no][3]=rs.getString("Nama_Matkul");
                data1[no][4]=rs.getString("Nama_Dosen");
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
        String[] columnNames = {"Hari", "Sesi", "Kode Ruang", "Nama Matkul", "Nama Dosen"};
        table = new JTable(getData(),columnNames);
        jScrollPane.setViewportView(table);       
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Method Filter ">
    
    private Object[][] Filter(String Nama_Tabel,String Nama_Field, String Nilai){
        
        Object[][] data1 = null;
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from matkul");
            
            rs.last();
            int rowCount=rs.getRow();
            rs.beforeFirst();
            data1 = new Object[rowCount][5];
  
            int no= -1;
            while(rs.next()){
                no=no+1;
                data1[no][0]=rs.getString("Hari");
                data1[no][1]=rs.getString("Sesi");
                data1[no][2]=rs.getString("Kode_Ruang");
                data1[no][3]=rs.getString("Nama_Matkul");
                data1[no][4]=rs.getString("Nama_Dosen");
            }
            
            st.close();
            //conn.close();                                                     6 Jan 2019,12:00, sempat error di penghapusan karena conn.close()
        }
        
        catch(SQLException e){
            System.out.println("Koneksi gagal "+ e.toString());
        }
        
        return data1;
    }
    private void TampilFilter(String Nama_Tabel,String Nama_Field, String Nilai){
        String[] columnNames = {"Hari", "Sesi", "Kode Ruang", "Nama Matkul", "Nama Dosen"};
        table = new JTable(Filter(Nama_Tabel, Nama_Field, Nilai),columnNames);
        jScrollPane.setViewportView(table);       
    }
    
    //</editor-fold>
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelGaris = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jLabelData_Jadwal = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();
        jLabelPencarian = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Jadwal");
        setResizable(false);

        jLabelGaris.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelGaris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGaris.setText("==========================================================================================");

        jLabelData_Jadwal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelData_Jadwal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelData_Jadwal.setText("DATA JADWAL");

        jLabelLogin.setText("Login Administrator");
        jLabelLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLoginMouseClicked(evt);
            }
        });

        jLabelPencarian.setText("Pencarian");
        jLabelPencarian.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelPencarian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPencarianMouseClicked(evt);
            }
        });

        jLabel2.setText("|");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane)
                    .addComponent(jLabelData_Jadwal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPencarian)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelGaris, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelData_Jadwal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGaris)
                    .addComponent(jLabelLogin)
                    .addComponent(jLabelPencarian)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Login(){
        Laman_Login a = new Laman_Login();
        a.setVisible(true);
        
        this.dispose();
    }
    
    private void jLabelLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLoginMouseClicked
        Login();
    }//GEN-LAST:event_jLabelLoginMouseClicked

    private void Pencarian(){
        Pencarian a = new Pencarian();
        a.setVisible(true);
        
        this.dispose(); 
    }
    
    private void jLabelPencarianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPencarianMouseClicked
        Pencarian();
    }//GEN-LAST:event_jLabelPencarianMouseClicked
    
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
            java.util.logging.Logger.getLogger(Lihat_Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lihat_Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lihat_Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lihat_Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lihat_Jadwal().setVisible(true);
            }
        });
    }

    //<editor-fold defaultstate="collapsed" desc=" Variable Declaration ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelData_Jadwal;
    private javax.swing.JLabel jLabelGaris;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelPencarian;
    private javax.swing.JScrollPane jScrollPane;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}