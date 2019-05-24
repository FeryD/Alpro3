package Proyek1;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Hidayat
 */
public class Laman_Login extends javax.swing.JFrame {
    
    public Laman_Login() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLogin = new javax.swing.JButton();
        jButtonKembali = new javax.swing.JButton();
        jTextFieldUserName = new javax.swing.JTextField();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jLabelPassword = new javax.swing.JLabel();
        jLabellUserName = new javax.swing.JLabel();
        Logo_ITK = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Laman Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        jButtonLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonLoginKeyPressed(evt);
            }
        });
        getContentPane().add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 110, -1));

        jButtonKembali.setText("Kembali");
        jButtonKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKembaliActionPerformed(evt);
            }
        });
        jButtonKembali.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonKembaliKeyPressed(evt);
            }
        });
        getContentPane().add(jButtonKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 340, 110, -1));

        jTextFieldUserName.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(jTextFieldUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 240, -1));

        jPasswordFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldPasswordKeyPressed(evt);
            }
        });
        getContentPane().add(jPasswordFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, 240, -1));

        jLabelPassword.setBackground(new java.awt.Color(204, 204, 255));
        jLabelPassword.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(255, 51, 102));
        jLabelPassword.setText("Password");
        getContentPane().add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        jLabellUserName.setBackground(new java.awt.Color(255, 255, 255));
        jLabellUserName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabellUserName.setForeground(new java.awt.Color(255, 51, 102));
        jLabellUserName.setText("User Name");
        jLabellUserName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(jLabellUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, -1, -1));

        Logo_ITK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyek1/Institut_Teknologi_Kalimantan.png"))); // NOI18N
        getContentPane().add(Logo_ITK, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 320, 230));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyek1/Institut-Teknlogi-Kalimantan-730x355 - Salin.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1000, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Login(){
        if(jTextFieldUserName.getText().equals("Hidayat") && jPasswordFieldPassword.getText().equals("10171036")){
            Menu_Utama_Admin a = new Menu_Utama_Admin();
            a.setVisible(true);
        
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this, "Maaf Data Salah", "Gagal", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        Login();
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void Kembali(){
        Lihat_Jadwal a = new Lihat_Jadwal();
        a.setVisible(true);
        
        this.dispose();
    }
    
    private void jButtonKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKembaliActionPerformed
        Kembali();
    }//GEN-LAST:event_jButtonKembaliActionPerformed

    private void jPasswordFieldPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordKeyPressed
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            Login();
        }
    }//GEN-LAST:event_jPasswordFieldPasswordKeyPressed

    private void jButtonLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonLoginKeyPressed
        Login();
    }//GEN-LAST:event_jButtonLoginKeyPressed

    private void jButtonKembaliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonKembaliKeyPressed
        Kembali();
    }//GEN-LAST:event_jButtonKembaliKeyPressed

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
            java.util.logging.Logger.getLogger(Laman_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laman_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laman_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laman_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laman_Login().setVisible(true);
            }
        });
    }
n
    //<editor-fold defaultstate="collapsed" desc=" Variable Declaration ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Logo_ITK;
    private javax.swing.JButton jButtonKembali;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabellUserName;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JTextField jTextFieldUserName;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}