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
public class Input_Jadwal extends javax.swing.JFrame {

    private String user = "root";
    private String pwd = "";
    private String host = "localhost";
    private String db = "Proyek1";
    private String urlValue = "";
    private Connection conn = null;
    private JTable table = null;
    private String Alih = null;
    
    public Input_Jadwal() {
        initComponents();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            urlValue = "jdbc:mysql://"+ host +"/"+ db +"?user="+ user +"&password="+ pwd;
            conn = DriverManager.getConnection(urlValue);
            
            Statement st = conn.createStatement();
            ResultSet rs = null;

            rs = st.executeQuery("Select distinct Hari from waktu");
            while(rs.next()){
                jComboBoxHari.addItem(rs.getString("Hari"));
                jComboBoxHari2.addItem(rs.getString("Hari"));
            }
            
            rs = st.executeQuery("Select distinct Sesi from waktu");
            while(rs.next()){
                jComboBoxSesi.addItem(rs.getString("Sesi"));
                jComboBoxSesi2.addItem(rs.getString("Sesi"));
            }
            
            rs = st.executeQuery("Select distinct Kode_Ruang from ruang");
            while(rs.next()){
                jComboBoxKode_Ruang.addItem(rs.getString("Kode_Ruang"));
                jComboBoxKode_Ruang2.addItem(rs.getString("Kode_Ruang"));
            }
            
            rs = st.executeQuery("Select distinct Kode_Matkul from matkul");
            while(rs.next()){
                jComboBoxKode_Matkul.addItem(rs.getString("Kode_Matkul"));
                jComboBoxKode_Matkul2.addItem(rs.getString("Kode_Matkul"));
            }
            
            rs = st.executeQuery("Select distinct Kode_Dosen from dosen");
            while(rs.next()){
                jComboBoxKode_Dosen.addItem(rs.getString("Kode_Dosen"));
                jComboBoxKode_Dosen2.addItem(rs.getString("Kode_Dosen"));
            }
            
            jTextFieldKode_Jadwal.setText("Akan Terisi Otomatis");
            
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
            ResultSet rs = st.executeQuery("Select * from jadwal");
            
            rs.last();
            int rowCount=rs.getRow();
            rs.beforeFirst();
            data1 = new Object[rowCount][6];
  
            int no= -1;
            while(rs.next()){
                no=no+1;
                data1[no][0]=rs.getString("Kode_Jadwal");
                data1[no][1]=rs.getString("Hari");
                data1[no][2]=rs.getString("Sesi");
                data1[no][3]=rs.getString("Kode_Ruang");
                data1[no][4]=rs.getString("Kode_Matkul");
                data1[no][5]=rs.getString("Kode_Dosen");
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
        String[] columnNames = {"Kode Jadwal","Hari","Sesi","Kode Ruang","Kode Matkul","Kode Dosen"};
        table = new JTable(getData(),columnNames);
        jScrollPane.setViewportView(table);       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelKembali = new javax.swing.JLabel();
        jLabelKode_Jadwal = new javax.swing.JLabel();
        jLabelHapus_Data = new javax.swing.JLabel();
        jButtonSimpan = new javax.swing.JButton();
        jButtonHapus = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTextFieldKode_Jadwal = new javax.swing.JTextField();
        jLabelTambah_Data = new javax.swing.JLabel();
        jLabelInput_Data_Matkul = new javax.swing.JLabel();
        jLabelGaris = new javax.swing.JLabel();
        jTextFieldKode_Jadwal3 = new javax.swing.JTextField();
        jLabelKode_Jadwal3 = new javax.swing.JLabel();
        jButtonCek = new javax.swing.JButton();
        jLabelEdit_Data = new javax.swing.JLabel();
        jComboBoxHari = new javax.swing.JComboBox<>();
        jComboBoxSesi = new javax.swing.JComboBox<>();
        jComboBoxKode_Ruang = new javax.swing.JComboBox<>();
        jComboBoxKode_Matkul = new javax.swing.JComboBox<>();
        jComboBoxKode_Dosen = new javax.swing.JComboBox<>();
        jTextFieldNama_Matkul = new javax.swing.JTextField();
        jTextFieldNama_Dosen = new javax.swing.JTextField();
        jLabelHari = new javax.swing.JLabel();
        jLabelSesi = new javax.swing.JLabel();
        jLabelKode_Ruang = new javax.swing.JLabel();
        jLabelKode_Matkul = new javax.swing.JLabel();
        jLabelNama_Matkul = new javax.swing.JLabel();
        jLabelKode_Dosen = new javax.swing.JLabel();
        jLabelNama_Dosen = new javax.swing.JLabel();
        jButtonTambah = new javax.swing.JButton();
        jComboBoxKode_Ruang2 = new javax.swing.JComboBox<>();
        jComboBoxKode_Matkul2 = new javax.swing.JComboBox<>();
        jLabelKode_Jadwal2 = new javax.swing.JLabel();
        jComboBoxKode_Dosen2 = new javax.swing.JComboBox<>();
        jTextFieldNama_Matkul2 = new javax.swing.JTextField();
        jTextFieldKode_Jadwal2 = new javax.swing.JTextField();
        jTextFieldNama_Dosen2 = new javax.swing.JTextField();
        jLabelHari2 = new javax.swing.JLabel();
        jLabelSesi2 = new javax.swing.JLabel();
        jLabelKode_Ruang2 = new javax.swing.JLabel();
        jLabelKode_Matkul2 = new javax.swing.JLabel();
        jLabelNama_Matkul2 = new javax.swing.JLabel();
        jComboBoxHari2 = new javax.swing.JComboBox<>();
        jLabelKode_Dosen2 = new javax.swing.JLabel();
        jLabelNama_Dosen2 = new javax.swing.JLabel();
        jComboBoxSesi2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Input Jadwal");
        setResizable(false);

        jLabelKembali.setText("Kembali");
        jLabelKembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelKembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelKembaliMouseClicked(evt);
            }
        });

        jLabelKode_Jadwal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelKode_Jadwal.setText("KODE JADWAL");

        jLabelHapus_Data.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHapus_Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHapus_Data.setText("HAPUS DATA");

        jButtonSimpan.setText("SIMPAN");
        jButtonSimpan.setEnabled(false);
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });

        jButtonHapus.setText("HAPUS DATA YANG DIPILIH");
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusActionPerformed(evt);
            }
        });

        jTextFieldKode_Jadwal.setEnabled(false);

        jLabelTambah_Data.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTambah_Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTambah_Data.setText("TAMBAH DATA");

        jLabelInput_Data_Matkul.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelInput_Data_Matkul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInput_Data_Matkul.setText("INPUT DATA JADWAL");

        jLabelGaris.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelGaris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGaris.setText("===========================================================================================================");

        jLabelKode_Jadwal3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelKode_Jadwal3.setText("KODE JADWAL");

        jButtonCek.setText("CEK");
        jButtonCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCekActionPerformed(evt);
            }
        });

        jLabelEdit_Data.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEdit_Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEdit_Data.setText("EDIT DATA");

        jComboBoxKode_Matkul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxKode_MatkulActionPerformed(evt);
            }
        });

        jComboBoxKode_Dosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxKode_DosenActionPerformed(evt);
            }
        });

        jTextFieldNama_Matkul.setEnabled(false);

        jTextFieldNama_Dosen.setEnabled(false);

        jLabelHari.setText("HARI");

        jLabelSesi.setText("SESI");

        jLabelKode_Ruang.setText("KODE RUANG");

        jLabelKode_Matkul.setText("KODE MATKUL");

        jLabelNama_Matkul.setText("NAMA MATKUL");

        jLabelKode_Dosen.setText("KODE DOSEN");

        jLabelNama_Dosen.setText("NAMA DOSEN");

        jButtonTambah.setText("TAMBAH");
        jButtonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTambahActionPerformed(evt);
            }
        });

        jComboBoxKode_Ruang2.setEnabled(false);

        jComboBoxKode_Matkul2.setEnabled(false);
        jComboBoxKode_Matkul2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxKode_Matkul2ActionPerformed(evt);
            }
        });

        jLabelKode_Jadwal2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelKode_Jadwal2.setText("KODE JADWAL");

        jComboBoxKode_Dosen2.setEnabled(false);
        jComboBoxKode_Dosen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxKode_Dosen2ActionPerformed(evt);
            }
        });

        jTextFieldNama_Matkul2.setEnabled(false);

        jTextFieldNama_Dosen2.setEnabled(false);

        jLabelHari2.setText("HARI");

        jLabelSesi2.setText("SESI");

        jLabelKode_Ruang2.setText("KODE RUANG");

        jLabelKode_Matkul2.setText("KODE MATKUL");

        jLabelNama_Matkul2.setText("NAMA MATKUL");

        jComboBoxHari2.setEnabled(false);

        jLabelKode_Dosen2.setText("KODE DOSEN");

        jLabelNama_Dosen2.setText("NAMA DOSEN");

        jComboBoxSesi2.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane)
                    .addComponent(jLabelInput_Data_Matkul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabelSesi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelHari, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelNama_Dosen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelKode_Matkul, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelNama_Matkul, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelKode_Dosen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelKode_Ruang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelKode_Jadwal, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonTambah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNama_Dosen, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBoxHari, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldKode_Jadwal, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBoxSesi, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxKode_Ruang, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxKode_Dosen, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNama_Matkul, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBoxKode_Matkul, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelTambah_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelEdit_Data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabelKode_Matkul2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabelNama_Matkul2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabelKode_Jadwal2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabelSesi2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabelHari2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabelKode_Ruang2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabelKode_Dosen2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabelNama_Dosen2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonCek, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNama_Dosen2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBoxKode_Dosen2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxHari2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxSesi2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxKode_Ruang2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxKode_Matkul2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNama_Matkul2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                    .addComponent(jTextFieldKode_Jadwal2, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelKode_Jadwal3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldKode_Jadwal3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelHapus_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addComponent(jLabelInput_Data_Matkul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGaris)
                    .addComponent(jLabelKembali))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTambah_Data)
                    .addComponent(jLabelEdit_Data)
                    .addComponent(jLabelHapus_Data))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelKode_Jadwal)
                            .addComponent(jTextFieldKode_Jadwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHari))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxSesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSesi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxKode_Ruang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKode_Ruang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxKode_Matkul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKode_Matkul))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNama_Matkul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNama_Matkul))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxKode_Dosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKode_Dosen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNama_Dosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNama_Dosen)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelKode_Jadwal2)
                            .addComponent(jTextFieldKode_Jadwal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxHari2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHari2))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxSesi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSesi2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxKode_Ruang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKode_Ruang2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxKode_Matkul2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKode_Matkul2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNama_Matkul2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNama_Matkul2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxKode_Dosen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKode_Dosen2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNama_Dosen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNama_Dosen2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldKode_Jadwal3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKode_Jadwal3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonHapus)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonTambah, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSimpan)
                        .addComponent(jButtonCek)))
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Hapus(){
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from jadwal where Kode_Jadwal='"+jTextFieldKode_Jadwal3.getText()+"'");
            if(rs.next()){
                PreparedStatement pStatement = null;
                String sql = "delete from jadwal where Kode_Jadwal=?";
                pStatement = conn.prepareStatement(sql);
                pStatement.setString(1, jTextFieldKode_Jadwal3.getText());
                int intHapus = pStatement.executeUpdate();

                if(intHapus>0){
                    JOptionPane.showMessageDialog(this,"Berhasil Menghapus","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this,"Gagal Menghapus","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }

                pStatement.close();
                jTextFieldKode_Jadwal3.setText("");
                tampilTabel();
            }else{
                JOptionPane.showMessageDialog(this, "Data tidak ada", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                jTextFieldKode_Jadwal3.setText("");
                jTextFieldKode_Jadwal3.requestFocus();
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

    private void Cek(){
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from jadwal where Kode_Jadwal='"+jTextFieldKode_Jadwal2.getText()+"'");
            if(rs.next()){
                JOptionPane.showMessageDialog(this, "Silahkan Edit Data", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                Alih = jTextFieldKode_Jadwal2.getText();
                
                jTextFieldKode_Jadwal.setEnabled(false);
                jTextFieldKode_Jadwal3.setEnabled(false);
                jComboBoxHari.setEnabled(false);
                jComboBoxSesi.setEnabled(false);
                jComboBoxKode_Ruang.setEnabled(false);
                jComboBoxKode_Matkul.setEnabled(false);
                jTextFieldNama_Matkul.setEnabled(false);
                jComboBoxKode_Dosen.setEnabled(false);
                jTextFieldNama_Dosen.setEnabled(false);
                jButtonTambah.setEnabled(false);
                jButtonHapus.setEnabled(false);
                jButtonCek.setEnabled(false);
                jTextFieldKode_Jadwal2.setEnabled(false);
                jTextFieldKode_Jadwal2.setText("Akan terisi Otomatis");
                
                jComboBoxHari2.setEnabled(true);
                jComboBoxSesi2.setEnabled(true);
                jComboBoxKode_Ruang2.setEnabled(true);
                jComboBoxKode_Matkul2.setEnabled(true);
                jComboBoxKode_Dosen2.setEnabled(true);
                jButtonSimpan.setEnabled(true);
                
                
                jComboBoxHari2.setSelectedItem(rs.getString("Hari"));
                jComboBoxSesi2.setSelectedItem(rs.getString("Sesi"));
                jComboBoxKode_Ruang2.setSelectedItem(rs.getString("Kode_Ruang"));
                jComboBoxKode_Matkul2.setSelectedItem(rs.getString("Kode_Matkul"));
                jComboBoxKode_Dosen2.setSelectedItem(rs.getString("Kode_Dosen"));
                
            }else{
                JOptionPane.showMessageDialog(this, "Data tidak ada", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                jTextFieldNama_Matkul2.setText("");
                jTextFieldKode_Jadwal2.setText("");
                jTextFieldKode_Jadwal2.requestFocus();
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
            PreparedStatement pStatement = null;
            String sql = "update jadwal set Kode_Jadwal=?, Hari=?, Sesi=?, Kode_Ruang=?, Kode_Matkul=?, Kode_Dosen=?, DosenSatuTempat=? where Kode_Jadwal='"+Alih+"'";
            pStatement = conn.prepareStatement(sql);
            
            jTextFieldKode_Jadwal2.setText(jComboBoxKode_Ruang2.getSelectedItem().toString()+
                                            jComboBoxHari2.getSelectedItem().toString()+
                                            jComboBoxSesi2.getSelectedItem().toString());
            String dosensatutempat = jComboBoxKode_Dosen2.getSelectedItem().toString()+
                                    jComboBoxHari2.getSelectedItem().toString()+
                                    jComboBoxSesi2.getSelectedItem().toString();
            
            pStatement.setString(1, jTextFieldKode_Jadwal2.getText());
            pStatement.setString(2, jComboBoxHari2.getSelectedItem().toString());
            pStatement.setString(3, jComboBoxSesi2.getSelectedItem().toString());
            pStatement.setString(4, jComboBoxKode_Ruang2.getSelectedItem().toString());
            pStatement.setString(5, jComboBoxKode_Matkul2.getSelectedItem().toString());
            pStatement.setString(6, jComboBoxKode_Dosen2.getSelectedItem().toString());
            pStatement.setString(7, dosensatutempat);

            int intTambah = pStatement.executeUpdate();
            if(intTambah>0){
                JOptionPane.showMessageDialog(this,"Edit Sukses","Informasi",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Edit Gagal","Informasi",JOptionPane.INFORMATION_MESSAGE);
            }

            pStatement.close();
            jTextFieldKode_Jadwal2.setText("");
            jComboBoxHari2.setSelectedIndex(0);
            jComboBoxSesi2.setSelectedIndex(0);
            jComboBoxKode_Ruang2.setSelectedIndex(0);
            jComboBoxKode_Matkul2.setSelectedIndex(0);
            jComboBoxKode_Dosen2.setSelectedIndex(0);

            jTextFieldKode_Jadwal.setEnabled(true);
            jTextFieldKode_Jadwal3.setEnabled(true);
            jComboBoxHari.setEnabled(true);
            jComboBoxSesi.setEnabled(true);
            jComboBoxKode_Ruang.setEnabled(true);
            jComboBoxKode_Matkul.setEnabled(true);
            jTextFieldNama_Matkul.setEnabled(true);
            jComboBoxKode_Dosen.setEnabled(true);
            jTextFieldNama_Dosen.setEnabled(true);
            jButtonTambah.setEnabled(true);
            jButtonHapus.setEnabled(true);
            jTextFieldKode_Jadwal2.setEnabled(true);
            jButtonCek.setEnabled(true);
            jTextFieldKode_Jadwal2.setText("");
                
            jComboBoxHari2.setEnabled(false);
            jComboBoxSesi2.setEnabled(false);
            jComboBoxKode_Ruang2.setEnabled(false);
            jComboBoxKode_Matkul2.setEnabled(false);
            jComboBoxKode_Dosen2.setEnabled(false);
            jButtonSimpan.setEnabled(false);
               
            tampilTabel();
        }

        catch(SQLException e){
            System.out.println("Koneksi gagal"+e.toString());
            JOptionPane.showMessageDialog(this,e.toString(),"Informasi",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed
        Simpan();
    }//GEN-LAST:event_jButtonSimpanActionPerformed

    private void Tambah(){
        jTextFieldKode_Jadwal.setText(jComboBoxKode_Ruang.getSelectedItem().toString()+jComboBoxHari.getSelectedItem().toString()+jComboBoxSesi.getSelectedItem().toString());
        
        try{
            PreparedStatement pStatement = null;
            String sql = "insert into Jadwal (Kode_Jadwal,Hari,Sesi,Kode_Ruang,Kode_Matkul,Kode_Dosen,DosenSatuTempat) Values (?,?,?,?,?,?,?)";
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, jTextFieldKode_Jadwal.getText());
            pStatement.setString(2, jComboBoxHari.getSelectedItem().toString());
            pStatement.setString(3, jComboBoxSesi.getSelectedItem().toString());
            pStatement.setString(4, jComboBoxKode_Ruang.getSelectedItem().toString());
            pStatement.setString(5, jComboBoxKode_Matkul.getSelectedItem().toString());
            pStatement.setString(6, jComboBoxKode_Dosen.getSelectedItem().toString());
            pStatement.setString(7, jComboBoxKode_Dosen.getSelectedItem().toString()+jComboBoxHari.getSelectedItem().toString()+jComboBoxSesi.getSelectedItem().toString());

            int intTambah= pStatement.executeUpdate();
            if(intTambah>0){
                JOptionPane.showMessageDialog(this, "Penambahan Sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }else{
                 JOptionPane.showMessageDialog(this, "Penambahan gagal","Informasi",JOptionPane.INFORMATION_MESSAGE);
            }

            pStatement.close();
                
            jComboBoxHari.setSelectedIndex(0);
            jComboBoxSesi.setSelectedIndex(0);
            jComboBoxKode_Ruang.setSelectedIndex(0);
            jComboBoxKode_Matkul.setSelectedIndex(0);
            jComboBoxKode_Dosen.setSelectedIndex(0);

            tampilTabel();
        }

        catch(SQLException e){
            System.out.println("Koneksi gagal "+e.toString());
            JOptionPane.showMessageDialog(this,e.getMessage(),"Informasi",JOptionPane.INFORMATION_MESSAGE);
        }
        
        jTextFieldKode_Jadwal.setText("Akan Terisi Otomatis");
    }
    
    private void jButtonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTambahActionPerformed
        Tambah();
    }//GEN-LAST:event_jButtonTambahActionPerformed

    private void jComboBoxKode_MatkulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxKode_MatkulActionPerformed
        String Kode_Matkul = (String) jComboBoxKode_Matkul.getSelectedItem();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Nama_Matkul from matkul where Kode_Matkul='"+Kode_Matkul+"'");
            
            while(rs.next()){
                jTextFieldNama_Matkul.setText(rs.getString("Nama_Matkul"));
            }
        }
        
        catch(SQLException e){
            System.out.println("Koneksi gagal "+ e.toString());
        }
    }//GEN-LAST:event_jComboBoxKode_MatkulActionPerformed

    private void jComboBoxKode_DosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxKode_DosenActionPerformed
        String Kode_Dosen = (String) jComboBoxKode_Dosen.getSelectedItem();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Nama_Dosen from Dosen where Kode_Dosen='"+Kode_Dosen+"'");
            
            while(rs.next()){
                jTextFieldNama_Dosen.setText(rs.getString("Nama_Dosen"));
            }
        }
        
        catch(SQLException e){
            System.out.println("Koneksi gagal "+ e.toString());
        }
    }//GEN-LAST:event_jComboBoxKode_DosenActionPerformed

    private void Kembali(){
        Menu_Utama_Admin a = new Menu_Utama_Admin();
        a.setVisible(true);

        this.dispose();
    }
    
    private void jLabelKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelKembaliMouseClicked
        Kembali();
    }//GEN-LAST:event_jLabelKembaliMouseClicked

    private void jComboBoxKode_Matkul2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxKode_Matkul2ActionPerformed
        String Kode_Matkul2 = (String) jComboBoxKode_Matkul2.getSelectedItem();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Nama_Matkul from matkul where Kode_Matkul='"+Kode_Matkul2+"'");
            
            while(rs.next()){
                jTextFieldNama_Matkul2.setText(rs.getString("Nama_Matkul"));
            }
        }
        
        catch(SQLException e){
            System.out.println("Koneksi gagal "+ e.toString());
        }
    }//GEN-LAST:event_jComboBoxKode_Matkul2ActionPerformed

    private void jComboBoxKode_Dosen2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxKode_Dosen2ActionPerformed
        String Kode_Dosen2 = (String) jComboBoxKode_Dosen2.getSelectedItem();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select Nama_Dosen from Dosen where Kode_Dosen='"+Kode_Dosen2+"'");
            
            while(rs.next()){
                jTextFieldNama_Dosen2.setText(rs.getString("Nama_Dosen"));
            }
        }
        
        catch(SQLException e){
            System.out.println("Koneksi gagal "+ e.toString());
        }
    }//GEN-LAST:event_jComboBoxKode_Dosen2ActionPerformed

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
            java.util.logging.Logger.getLogger(Input_Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Input_Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Input_Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Input_Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Input_Jadwal().setVisible(true);
            }
        });
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Variable Declaration ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCek;
    private javax.swing.JButton jButtonHapus;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JButton jButtonTambah;
    private javax.swing.JComboBox<String> jComboBoxHari;
    private javax.swing.JComboBox<String> jComboBoxHari2;
    private javax.swing.JComboBox<String> jComboBoxKode_Dosen;
    private javax.swing.JComboBox<String> jComboBoxKode_Dosen2;
    private javax.swing.JComboBox<String> jComboBoxKode_Matkul;
    private javax.swing.JComboBox<String> jComboBoxKode_Matkul2;
    private javax.swing.JComboBox<String> jComboBoxKode_Ruang;
    private javax.swing.JComboBox<String> jComboBoxKode_Ruang2;
    private javax.swing.JComboBox<String> jComboBoxSesi;
    private javax.swing.JComboBox<String> jComboBoxSesi2;
    private javax.swing.JLabel jLabelEdit_Data;
    private javax.swing.JLabel jLabelGaris;
    private javax.swing.JLabel jLabelHapus_Data;
    private javax.swing.JLabel jLabelHari;
    private javax.swing.JLabel jLabelHari2;
    private javax.swing.JLabel jLabelInput_Data_Matkul;
    private javax.swing.JLabel jLabelKembali;
    private javax.swing.JLabel jLabelKode_Dosen;
    private javax.swing.JLabel jLabelKode_Dosen2;
    private javax.swing.JLabel jLabelKode_Jadwal;
    private javax.swing.JLabel jLabelKode_Jadwal2;
    private javax.swing.JLabel jLabelKode_Jadwal3;
    private javax.swing.JLabel jLabelKode_Matkul;
    private javax.swing.JLabel jLabelKode_Matkul2;
    private javax.swing.JLabel jLabelKode_Ruang;
    private javax.swing.JLabel jLabelKode_Ruang2;
    private javax.swing.JLabel jLabelNama_Dosen;
    private javax.swing.JLabel jLabelNama_Dosen2;
    private javax.swing.JLabel jLabelNama_Matkul;
    private javax.swing.JLabel jLabelNama_Matkul2;
    private javax.swing.JLabel jLabelSesi;
    private javax.swing.JLabel jLabelSesi2;
    private javax.swing.JLabel jLabelTambah_Data;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTextField jTextFieldKode_Jadwal;
    private javax.swing.JTextField jTextFieldKode_Jadwal2;
    private javax.swing.JTextField jTextFieldKode_Jadwal3;
    private javax.swing.JTextField jTextFieldNama_Dosen;
    private javax.swing.JTextField jTextFieldNama_Dosen2;
    private javax.swing.JTextField jTextFieldNama_Matkul;
    private javax.swing.JTextField jTextFieldNama_Matkul2;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}